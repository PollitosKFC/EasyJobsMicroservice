package pe.edu.upc.techniciandetailsapi.Easyjobs.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.techniciandetailsapi.Easyjobs.Entity.TechnicianDetail;

@Qualifier("technicianDetailRepository")
@Repository
public interface TechnicianDetailRepository extends JpaRepository<TechnicianDetail, Long> {
    @Query(value ="SELECT td FROM TechnicianDetail td WHERE td.technician.id = ?1")
    TechnicianDetail findTechnicianDetailById(Long id);
}
