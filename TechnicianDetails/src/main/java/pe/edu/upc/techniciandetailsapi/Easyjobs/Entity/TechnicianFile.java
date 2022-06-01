package pe.edu.upc.techniciandetailsapi.Easyjobs.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name ="tbl_technicianFile")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TechnicianFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Long id;

    @Column(name = "type", length = 200)
    private String type;

    @Column(name = "nameFile", length = 200)
    private String nameFile;

    @Column(name = "urlFile", length = 200)
    private String urlFile;

    @Column(name = "Active", length = 200)
    private boolean Active;
    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "technician_id")
    private Technician technician;
}
