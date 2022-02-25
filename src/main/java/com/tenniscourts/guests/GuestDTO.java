package com.tenniscourts.guests;

import io.swagger.annotations.ApiModel;
import lombok.*;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Data
@ApiModel(value = "Guest", description = "\n" +
        "Consists of the entity representing the Guest.")
public class GuestDTO {

    @NotNull
    private Long id;

    @NotNull
    private String name;

}
