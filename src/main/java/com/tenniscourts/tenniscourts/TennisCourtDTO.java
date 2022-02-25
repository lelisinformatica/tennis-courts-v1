package com.tenniscourts.tenniscourts;

import com.tenniscourts.schedules.ScheduleDTO;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Tennis Court", description = "\n" +
        "Consists of the entity representing the tennis court.")
public class TennisCourtDTO {

    private Long id;

    @NotNull
    private String name;

    private List<ScheduleDTO> tennisCourtSchedules;

}
