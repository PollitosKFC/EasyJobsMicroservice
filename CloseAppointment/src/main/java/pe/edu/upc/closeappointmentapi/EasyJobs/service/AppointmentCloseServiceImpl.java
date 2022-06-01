package pe.edu.upc.closeappointmentapi.EasyJobs.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.closeappointmentapi.EasyJobs.entity.AppointmentHistory;
import pe.edu.upc.closeappointmentapi.EasyJobs.repository.AppointmentHistoryRepository;
import pe.edu.upc.closeappointmentapi.EasyJobs.repository.AppointmentRepository;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentCloseServiceImpl implements AppointmentCloseService {
    @Autowired
    private final AppointmentRepository appointmentRepository;

    @Autowired
    private final AppointmentHistoryRepository appointmentHistoryRepository;

    @Override
    public AppointmentHistory createAppointmentHistory(AppointmentHistory appointmentHistory, Long appointmentId) {
        AppointmentHistory newAppointmentHistory = new AppointmentHistory();
        newAppointmentHistory.setId(appointmentId);
        newAppointmentHistory.setAppointment(appointmentRepository.findById(appointmentId).orElse(null));
        newAppointmentHistory.setFinishDate(new Date());
        newAppointmentHistory.setQualification(appointmentHistory.getQualification());
        newAppointmentHistory.setQualificationComment(appointmentHistory.getQualificationComment());
        return appointmentHistoryRepository.save(newAppointmentHistory);
    }

    @Override
    public List<AppointmentHistory> findAppointmentHistoriesByAppointmentId(Long appointmentId) {
        return appointmentHistoryRepository.findAppointmentHistoriesByAppointmentId(appointmentId);
    }

    @Override
    public List<AppointmentHistory> findAppointmentHistoriesByTechnicianId(Long technicianId) {
        return appointmentHistoryRepository.findAppointmentHistoriesByTechnicianId(technicianId);
    }

    @Override
    public List<AppointmentHistory> findAppointmentHistoriesByCustomerId(Long customerId) {
        return appointmentHistoryRepository.findAppointmentHistoriesByCustomerId(customerId);
    }

    @Override
    public List<AppointmentHistory> findAppointmentHistoriesByTechnicianIdAndCustomerId(Long technicianId, Long customerId) {
        return appointmentHistoryRepository.findAppointmentHistoriesByTechnicianIdAndCustomerId(technicianId, customerId);
    }

    @Override
    public AppointmentHistory findAppointmentHistoryById(Long id) {
        return appointmentHistoryRepository.findById(id).orElse(null);
    }

    @Override
    public List<AppointmentHistory> findAllAppointmentHistories() {
        return appointmentHistoryRepository.findAll();
    }
}
