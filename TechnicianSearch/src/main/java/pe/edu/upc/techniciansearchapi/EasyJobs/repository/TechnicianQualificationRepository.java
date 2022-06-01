package pe.edu.upc.techniciansearchapi.EasyJobs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.edu.upc.techniciansearchapi.EasyJobs.entity.TechnicianQualification;

import java.util.List;

public interface TechnicianQualificationRepository extends JpaRepository<TechnicianQualification, Long> {
    @Query(value ="SELECT q FROM TechnicianQualification q WHERE q.technician.id = ?1")
    List<TechnicianQualification> findByTechnicianId(Long id);

    @Query(value ="SELECT q FROM TechnicianQualification q WHERE q.technician.id = ?1")
    TechnicianQualification findAverageByTechnicianId(Long id);
}
