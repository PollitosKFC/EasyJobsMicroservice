package pe.edu.upc.qualificationapi.EasyJobs.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.qualificationapi.EasyJobs.entity.Technician;
import pe.edu.upc.qualificationapi.EasyJobs.entity.TechnicianQualification;

import java.util.List;

@Qualifier("technicianQualificationRepository")
@Repository
public interface TechnicianQualificationRepository extends JpaRepository<TechnicianQualification, Long> {
    @Query(value ="SELECT tq FROM TechnicianQualification tq WHERE tq.technician.id = ?1")
    TechnicianQualification findTechnicianQualificationByTechnicianId(Long id);

    @Query(value ="SELECT q FROM TechnicianQualification q WHERE q.technician.id = ?1")
    TechnicianQualification findAverageByTechnicianId(Long id);

    @Query(value ="SELECT p FROM Technician p JOIN fetch p.technician_qualification q WHERE q.qualificationAverage >= ?1")
    List<Technician> findByQualification(Double qualificationAverage);
}
