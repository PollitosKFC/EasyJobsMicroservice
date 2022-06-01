package pe.edu.upc.closeappointmentapi.EasyJobs.repository;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.closeappointmentapi.EasyJobs.entity.Appointment;
import pe.edu.upc.closeappointmentapi.EasyJobs.entity.AppointmentHistory;

import java.util.List;


@Qualifier("appointmentHistoryRepository")
@Repository
public interface AppointmentHistoryRepository extends JpaRepository<AppointmentHistory, Long> {

    @Query(value ="SELECT ah FROM AppointmentHistory ah join fetch  ah.appointment a WHERE a.technician.id = ?2 AND a.customer.id = ?1")
    List<AppointmentHistory> findAppointmentHistoriesByTechnicianIdAndCustomerId(Long customerId, Long technicianId);

    @Query(value ="SELECT a FROM AppointmentHistory a WHERE a.appointment.id = ?1")
    List<AppointmentHistory> findAppointmentHistoriesByAppointmentId(Long appointmentId);

    @Query(value ="SELECT ah FROM AppointmentHistory ah JOIN fetch ah.appointment a WHERE a.technician.id = ?1 ")
    List<AppointmentHistory>  findAppointmentHistoriesByTechnicianId(Long technicianId);

    @Query(value ="SELECT ah FROM AppointmentHistory ah JOIN fetch ah.appointment a WHERE a.customer.id = ?1 ")
    List<AppointmentHistory>  findAppointmentHistoriesByCustomerId(Long customerId);
}
