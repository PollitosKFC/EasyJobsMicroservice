package pe.edu.upc.closeappointmentapi.EasyJobs.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name ="tbl_appointment_history")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppointmentHistory {
    @Id
    private Long id;

    @Column(name="finishDate")
    private Date finishDate;

    @Column(name="qualification")
    private Double qualification;

    @Column(name="qualificationComment", length = 1000)
    private String qualificationComment;
    @JsonBackReference
    @OneToOne(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    @JoinColumn(name = "appointment_id",unique = true)
    private Appointment appointment;

}
