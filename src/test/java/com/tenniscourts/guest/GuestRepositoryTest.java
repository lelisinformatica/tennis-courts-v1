package com.tenniscourts.guest;

import static org.assertj.core.api.Java6Assertions.assertThat;

import com.tenniscourts.guests.Guest;
import com.tenniscourts.guests.GuestRepository;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class GuestRepositoryTest {

    @Autowired
    private GuestRepository guestRepository;

    @BeforeEach
    void initUseCase() {
        List<Guest> guestList =
                List.of(
                        Guest.builder()
                                .name("Roger Federer")
                                .build(),
                        Guest.builder()
                                .name("Rafael Nadal")
                                .build()
        );
        guestRepository.saveAll(guestList);
    }

    @AfterEach
    public void destroyAll(){
        guestRepository.deleteAll();
    }

    @Test
    public void save(){
        Guest guest = Guest.builder().name("Novak Djokovic").build();

        guestRepository.save(guest);

        assertThat(guest.getId()).isEqualTo(3l);
    }

    @Test
    public void findGuestByName(){

        List<Guest> guest = guestRepository.findByName("Roger Federer");

        assertThat(guest.get(0).getName()).isEqualTo("Roger Federer");
    }

}
