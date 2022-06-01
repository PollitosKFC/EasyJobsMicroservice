package pe.edu.upc.qualificationapi.EasyJobs.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.qualificationapi.EasyJobs.entity.Appointment;
import pe.edu.upc.qualificationapi.EasyJobs.entity.AppointmentHistory;
import pe.edu.upc.qualificationapi.EasyJobs.entity.Technician;
import pe.edu.upc.qualificationapi.EasyJobs.entity.TechnicianQualification;
import pe.edu.upc.qualificationapi.EasyJobs.repository.AppointmentHistoryRepository;
import pe.edu.upc.qualificationapi.EasyJobs.repository.AppointmentRepository;
import pe.edu.upc.qualificationapi.EasyJobs.repository.TechnicianQualificationRepository;
import pe.edu.upc.qualificationapi.EasyJobs.repository.TechnicianRepository;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TechnicianQualificationServiceImpl implements TechnicianQualificationService {

    @Autowired
    private final TechnicianQualificationRepository technicianQualificationRepository;

    @Autowired
    private final AppointmentHistoryRepository appointmentHistoryRepository;

    @Autowired
    private final TechnicianRepository technicianRepository;

    @Autowired
    private final AppointmentRepository appointmentRepository;


    @Override
    public TechnicianQualification createTechnicianQualification(TechnicianQualification technicianQualification, Long id) {
        Technician technician = technicianRepository.getById(id);
        if (technician == null) {
            return null;
        }
        else if(technician.getTechnician_qualification() == null) {
            TechnicianQualification newTechnicianQualification = new TechnicianQualification();
            newTechnicianQualification.setId(id);
            newTechnicianQualification.setQualificationAverage(technicianQualification.getQualificationAverage());
            newTechnicianQualification.setNumberOfReviews(1);
            newTechnicianQualification.setCurrentQualification(technicianQualification.getQualificationAverage());
            newTechnicianQualification.setTechnician(technician);
            return technicianQualificationRepository.save(newTechnicianQualification);
        }
        TechnicianQualification newTechnicianQualification = technicianQualificationRepository.findAverageByTechnicianId(id);
        Double newQualificationAverage = (newTechnicianQualification.getCurrentQualification()+ technicianQualification.getQualificationAverage()) / (technician.getTechnician_qualification().getNumberOfReviews() + 1);
        newTechnicianQualification.setQualificationAverage(newQualificationAverage);
        newTechnicianQualification.setCurrentQualification(technicianQualification.getQualificationAverage()+newTechnicianQualification.getCurrentQualification());
        newTechnicianQualification.setNumberOfReviews(technician.getTechnician_qualification().getNumberOfReviews() + 1);
        return technicianQualificationRepository.save(newTechnicianQualification);
    }

    @Override
    public List<AppointmentHistory> findAppointmentHistoryByTechnicianId(Long id) {
        return appointmentHistoryRepository.findAppointmentHistoryByTechnicianId(id);
    }

    @Override
    public AppointmentHistory createAppointmentHistory(AppointmentHistory appointmentHistory, Long AppointmentId) {
        Appointment appointment = appointmentRepository.getById(AppointmentId);
        if (appointment == null) {
            return null;
        }
        AppointmentHistory appointmentHistory1 = new AppointmentHistory();
        appointmentHistory1.setId(AppointmentId);
        appointmentHistory1.setAppointment(appointment);
        appointmentHistory1.setQualificationComment(appointmentHistory.getQualificationComment());
        appointmentHistory1.setQualification(appointmentHistory.getQualification());
        appointmentHistory1.setFinishDate(new Date());

        return appointmentHistoryRepository.save(appointmentHistory1);
    }
    @Override
    public List<Technician> ListTechniciansByQualification(Double qualification) {
        return technicianQualificationRepository.findByQualification(qualification);
    }


}
