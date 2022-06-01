package pe.edu.upc.qualificationapi.EasyJobs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.qualificationapi.EasyJobs.entity.Appointment;



public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
