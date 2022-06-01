package pe.edu.upc.techniciandetailsapi.Easyjobs.resource;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class SaveTechnicianFileResource {
    @NotBlank
    @NotNull
    @Size(max = 50)
    private String type;

    @NotBlank
    @NotNull
    @Size(max = 50)
    private String nameFile;

    @NotBlank
    @NotNull
    @Size(max = 200)
    private String urlFile;
}
