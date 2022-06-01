package pe.edu.upc.techniciansearchapi.EasyJobs.resource;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class SaveTechnicianQualificationResource {
    @NotBlank
    @NotNull
    @Min(0)
    private Double qualificationAverage;

}
