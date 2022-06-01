package pe.edu.upc.techniciandetailsapi.Easyjobs.resource;

import lombok.Data;

@Data
public class TechnicianFileResource {
    private Long id;
    private String type;
    private String nameFile;
    private String urlFile;
    private boolean Active;
}
