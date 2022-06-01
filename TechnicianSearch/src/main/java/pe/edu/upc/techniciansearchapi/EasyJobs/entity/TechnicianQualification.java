package pe.edu.upc.techniciansearchapi.EasyJobs.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tbl_technician_qualification")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TechnicianQualification{
    @Id
    private Long id;

    @NotNull
    @Column(name = "numberOfReviews", length = 40)
    private Integer numberOfReviews;

    @NotNull
    @Column(name = "qualificationAverage", length = 40)
    private Double qualificationAverage;

    @NotNull
    @Column(name = "CurrentQualification", length = 40)
    private Double CurrentQualification;
    @JsonBackReference
    @OneToOne(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    @JoinColumn(name = "technician_id",unique = true)
    private Technician technician;
}
