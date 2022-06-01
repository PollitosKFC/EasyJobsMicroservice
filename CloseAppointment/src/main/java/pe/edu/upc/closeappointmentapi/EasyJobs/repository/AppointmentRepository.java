package pe.edu.upc.closeappointmentapi.EasyJobs.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.closeappointmentapi.EasyJobs.entity.Appointment;
import pe.edu.upc.closeappointmentapi.EasyJobs.entity.AppointmentHistory;

@Qualifier("appointmentRepository")
@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    @Query(value ="SELECT a FROM Appointment a WHERE a.technician.id = ?1 AND a.customer.id = ?2")
    Appointment findByCustomerIdAndTechnicianId(Long customerId, Long technicianId);

}
