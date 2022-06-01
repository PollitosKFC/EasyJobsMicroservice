package pe.edu.upc.techniciandetailsapi.Easyjobs.resource;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class TechnicianResource {
    private Long id;
    private String userName;
    private String password;
    private String email;
    private String identificationType;
    private Long identificationNumber;
    private Long phoneNumber;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String district;
    private Boolean verified;
    private String gender;
}
