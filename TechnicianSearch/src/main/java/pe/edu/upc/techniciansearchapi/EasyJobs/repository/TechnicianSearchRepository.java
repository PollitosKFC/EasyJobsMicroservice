package pe.edu.upc.techniciansearchapi.EasyJobs.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.techniciansearchapi.EasyJobs.entity.Technician;

import java.util.List;
@Qualifier("technicianRepository")
@Repository
public interface TechnicianSearchRepository  extends JpaRepository<Technician, Long> {
   @Query(value ="SELECT p FROM Technician p JOIN fetch p.technician_qualification q WHERE q.qualificationAverage > ?1")
   List<Technician> findByQualification(Double qualificationAverage);
   @Query(value = "SELECT p FROM Technician p JOIN fetch p.technician_specialties s WHERE s.Name = ?1")
   List<Technician> findBySpecialty(String specialty);
   List<Technician> findByFirstNameOrLastName(String firstName, String lastName);
   List<Technician> findByCityOrDistrict(String city, String district);

}