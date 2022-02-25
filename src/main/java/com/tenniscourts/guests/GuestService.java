package com.tenniscourts.guests;

import com.tenniscourts.exceptions.AlreadyExistsEntityException;
import com.tenniscourts.exceptions.BusinessException;
import com.tenniscourts.exceptions.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GuestService {

    private final GuestRepository guestRepository;

    private final GuestMapper guestMapper;

    public GuestDTO createGuest(GuestDTO dto){
        guestRepository.findByName(dto.getName())
                .stream()
                .findAny()
                .ifPresent( s -> {
                    throw new AlreadyExistsEntityException("Guest already registered.");
                });

        return guestMapper.map(guestRepository.save(guestMapper.map(dto)));
    }

    public GuestDTO updateGuest(Long id, GuestDTO dto){
        return guestRepository.findById(id)
                .map(guest -> {
                    guest.setName(dto.getName());
                    Guest guestUpdate = guestRepository.save(guest);
                    return guestMapper.map(guestUpdate);
                })
                .orElseThrow(() -> {
                    throw new EntityNotFoundException("Guest not found.");
                });
    }

    public Void deleteGuest(Long id){
        guestRepository.delete(
                guestRepository.findById(id).orElseThrow(() -> {
                    throw new EntityNotFoundException("Guest not found.");
                })
        );
        return null;
    }

    public List<GuestDTO> getAll(){
        return guestMapper.map(guestRepository.findAll());
    }

    public GuestDTO findByName(String name){
        return guestRepository.findByName(name)
                .stream()
                .findFirst()
                .map(guestMapper::map).orElseThrow(() -> {
            throw new EntityNotFoundException("Guest not found.");
        });
    }

    public GuestDTO findById(Long id){
        return guestRepository.findById(id).map(guestMapper::map).orElseThrow(() -> {
            throw new EntityNotFoundException("Guest not found.");
        });
    }

}
