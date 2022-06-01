package pe.edu.upc.closeappointmentapi.EasyJobs.service;

import org.springframework.stereotype.Service;
import pe.edu.upc.closeappointmentapi.EasyJobs.entity.Appointment;
import pe.edu.upc.closeappointmentapi.EasyJobs.entity.AppointmentHistory;

import java.util.List;

@Service
public interface AppointmentCloseService {
    AppointmentHistory createAppointmentHistory(AppointmentHistory appointmentHistory, Long appointmentId);
    //Appointment updateStatusLevel2(Long appointmentId, Long technicianId);
    //Appointment updateStatusLevel3(Long appointmentId, Long customerId);
    List<AppointmentHistory> findAppointmentHistoriesByAppointmentId(Long appointmentId);
    List<AppointmentHistory> findAppointmentHistoriesByTechnicianId(Long technicianId);
    List<AppointmentHistory> findAppointmentHistoriesByCustomerId(Long customerId);
    List<AppointmentHistory> findAppointmentHistoriesByTechnicianIdAndCustomerId(Long technicianId, Long customerId);
    AppointmentHistory findAppointmentHistoryById(Long id);
    List<AppointmentHistory> findAllAppointmentHistories();
}
