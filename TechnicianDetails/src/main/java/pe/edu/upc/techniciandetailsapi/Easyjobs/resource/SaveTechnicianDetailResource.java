package pe.edu.upc.techniciandetailsapi.Easyjobs.resource;


import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class SaveTechnicianDetailResource {

    @NotBlank
    @NotNull
    @Size(max = 25)
    private String presentation;

    @NotBlank
    @NotNull
    @Min(1)
    private Integer yearsExperience;

    @NotBlank
    @NotNull
    @Size(max = 25)
    private String maritalStatus;

    @NotBlank
    @NotNull
    @Size(max = 25)
    private String educationLevel;

    @NotBlank
    @NotNull
    @Size(max = 25)
    private String englishLevel;

    @NotBlank
    @NotNull
    @Size(max = 25)
    private String nationality;
}
