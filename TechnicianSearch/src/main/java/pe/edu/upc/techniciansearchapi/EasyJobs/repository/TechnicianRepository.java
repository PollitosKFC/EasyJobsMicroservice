package pe.edu.upc.techniciansearchapi.EasyJobs.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.techniciansearchapi.EasyJobs.entity.Technician;

import java.util.List;

@Qualifier("technicianRepository")
@Repository
public interface TechnicianRepository extends JpaRepository<Technician, Long> {
    @Query(value ="SELECT td FROM Technician td")
    List<Technician> findAllTechnician();
}
