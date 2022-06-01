package pe.edu.upc.qualificationapi.EasyJobs.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import pe.edu.upc.qualificationapi.EasyJobs.entity.Technician;



@Qualifier("technicianRepository")
@Repository
public interface TechnicianRepository  extends JpaRepository<Technician, Long> {
}
