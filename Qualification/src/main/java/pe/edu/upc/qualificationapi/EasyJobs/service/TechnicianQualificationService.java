package pe.edu.upc.qualificationapi.EasyJobs.service;

import org.springframework.stereotype.Service;
import pe.edu.upc.qualificationapi.EasyJobs.entity.AppointmentHistory;
import pe.edu.upc.qualificationapi.EasyJobs.entity.Technician;
import pe.edu.upc.qualificationapi.EasyJobs.entity.TechnicianQualification;

import java.util.List;

@Service
public interface TechnicianQualificationService {
    List<Technician> ListTechniciansByQualification(Double qualificationAverage);

    TechnicianQualification createTechnicianQualification(TechnicianQualification technicianQualification, Long id);

    List<AppointmentHistory> findAppointmentHistoryByTechnicianId(Long id);
    AppointmentHistory createAppointmentHistory(AppointmentHistory appointmentHistory, Long AppointmentId);

}
