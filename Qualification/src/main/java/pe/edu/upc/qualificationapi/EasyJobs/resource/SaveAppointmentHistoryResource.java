package pe.edu.upc.qualificationapi.EasyJobs.resource;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
public class SaveAppointmentHistoryResource {

    @NotBlank
    @NotNull
    @Min(0)
    private Double qualification;

    @NotBlank
    @NotNull
    @Size(max = 1000)
    private String qualificationComment;
}
