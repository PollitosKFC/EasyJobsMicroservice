package pe.edu.upc.techniciansearchapi.EasyJobs.resource;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class SaveTechnicianSpecialtyResource {
    @NotBlank
    @NotNull
    @Size(max = 250)
    private String Name;
}
