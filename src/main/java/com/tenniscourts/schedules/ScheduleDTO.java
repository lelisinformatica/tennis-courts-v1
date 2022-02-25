package com.tenniscourts.schedules;

import com.tenniscourts.tenniscourts.TennisCourtDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@ApiModel(value = "Schedule", description = "\n" +
        "Consists of the entity that represents the tennis court booking Schedule.")
public class ScheduleDTO {

    private Long id;

    private TennisCourtDTO tennisCourt;

    @NotNull
    private Long tennisCourtId;

    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm")
    @NotNull
    private LocalDateTime startDateTime;

    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm")
    private LocalDateTime endDateTime;

}
