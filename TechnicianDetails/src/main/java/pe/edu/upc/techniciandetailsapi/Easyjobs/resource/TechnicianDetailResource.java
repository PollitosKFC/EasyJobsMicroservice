package pe.edu.upc.techniciandetailsapi.Easyjobs.resource;

import lombok.Data;

@Data
public class TechnicianDetailResource {
    private Long id;
    private String presentation;
    private Integer yearsExperience;
    private String maritalStatus;
    private String educationLevel;
    private String englishLevel;
    private String nationality;
}
