package com.tenniscourts.guest;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.when;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;

import com.tenniscourts.exceptions.EntityNotFoundException;

import com.tenniscourts.guests.*;

import org.junit.*;
import org.junit.rules.ErrorCollector;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;



import java.util.List;

@SpringBootTest
@ContextConfiguration(classes = GuestService.class)
public class GuestServiceTest {


    @InjectMocks
    private GuestService guestService;

    @Mock
    private GuestRepository guestRepository;

    @Mock
    private GuestMapper guestMapper;

    private List<GuestDTO> guestDTOList;

    private List<Guest> guestList;

    @Rule
    public ErrorCollector error = new ErrorCollector();

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void setup() {

        MockitoAnnotations.initMocks(this);

        createGuestDTOList();
        createGuestList();
    }

    private void createGuestDTOList() {
        guestDTOList = List.of(
                        GuestDTO.builder()
                                .id(1L)
                                .name("Roger Federer")
                                .build(),
                        GuestDTO.builder()
                                .id(2L)
                                .name("Rafael Nadal")
                                .build()
        );
    }

    private void createGuestList() {
        guestList = List.of(
                Guest.builder()
                        .name("Roger Federer")
                        .build(),
                Guest.builder()
                        .name("Rafael Nadal")
                        .build()
        );
    }

    @Test
    public void getAllGuest_returnAll(){

        when(guestMapper.map(guestRepository.findAll())).thenReturn(guestDTOList);

        // test
        error.checkThat(2, equalTo(guestDTOList.size()));
        error.checkThat(guestDTOList.get(0).getName(), containsString("Roger Federer"));

    }

    @Test
    public void getGuestById(){

        when(guestRepository.findById(1L)).thenReturn(guestList.stream().findFirst());

        // test
       assertEquals("Roger Federer", guestList.stream().findFirst().get().getName());

    }

    @Test
    public void getGuestById_mostThrows_EntityNotFoundException(){
        // scenery

        // The exception expect must come before the action
        exception.expect(EntityNotFoundException.class);

        // action
        guestService.findById(3L);
    }

}
