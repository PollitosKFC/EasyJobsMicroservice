package pe.edu.upc.techniciandetailsapi.Easyjobs.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name ="tbl_technicianDetail")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TechnicianDetail {
    @Id
    @Column(unique = true)
    private Long id;

    @NotNull
    @Column(name="presentation",length = 200)
    private String presentation;

    @NotNull
    @Column(name="yearsExperience")
    private Integer yearsExperience;

    @NotNull
    @Column(name = "maritalStatus",length = 200)
    private String maritalStatus;

    @NotNull
    @Column(name = "educationLevel",length = 200)
    private String educationLevel;

    @NotNull
    @Column(name="englishLevel",length = 200)
    private String englishLevel;

    @NotNull
    @Column(name = "nationality",length = 200)
    private String nationality;
    @JsonBackReference
    @OneToOne(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    @JoinColumn(name = "technician_id",unique = true)
    private Technician technician;
}
