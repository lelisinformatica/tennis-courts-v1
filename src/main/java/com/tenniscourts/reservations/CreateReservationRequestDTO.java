package com.tenniscourts.reservations;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Data
@ApiModel(value = "CreateReservation", description = "\n" +
        "Consists of the entity to create a new tennis court reservation.")
public class CreateReservationRequestDTO {

    @NotNull
    private Long guestId;

    @NotNull
    private Long scheduleId;

}
