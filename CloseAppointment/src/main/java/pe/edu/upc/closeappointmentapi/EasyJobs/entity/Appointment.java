package pe.edu.upc.closeappointmentapi.EasyJobs.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name ="tbl_appointment")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 200)
    private String name;

    @Column(name = "createdDate")
    private Date createdDate;

    @Column(name = "updateDate")
    private Date updateDate;

    @Column(name = "status", length = 200)
    private String status;

    @Column(name = "startDate")
    private Date startDate;

    @Column(name = "delete")
    private Boolean delete;

    @JsonIdentityInfo(
            scope = Technician.class,
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id")
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "technician_id")
    private Technician technician;

    @JsonIdentityInfo(
            scope = Technician.class,
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id")
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @JsonBackReference
    @OneToOne(mappedBy = "appointment",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private AppointmentHistory appointment_history;

}