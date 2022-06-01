package pe.edu.upc.qualificationapi.EasyJobs.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.qualificationapi.EasyJobs.entity.AppointmentHistory;

import java.util.List;

@Qualifier("appointmentHistoryRepository")
@Repository
public interface AppointmentHistoryRepository extends JpaRepository<AppointmentHistory, Long> {
    @Query(value ="SELECT ah FROM AppointmentHistory ah join fetch ah.appointment a WHERE a.technician.id = ?1")
    List<AppointmentHistory> findAppointmentHistoryByTechnicianId(Long id);


}
