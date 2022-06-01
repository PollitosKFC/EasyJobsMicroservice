package pe.edu.upc.techniciansearchapi.EasyJobs.service;

import org.springframework.stereotype.Service;
import pe.edu.upc.techniciansearchapi.EasyJobs.entity.Technician;
import pe.edu.upc.techniciansearchapi.EasyJobs.entity.TechnicianQualification;
import pe.edu.upc.techniciansearchapi.EasyJobs.entity.TechnicianSpecialty;

import java.util.List;
@Service
public interface TechnicianSearchService {

    TechnicianSpecialty createTechnicianSpecialty(TechnicianSpecialty technicianSpecialty, Long id);

    TechnicianQualification createTechnicianQualification(TechnicianQualification technicianQualification, Long id);
    List<Technician> ListTechniciansBySpecialty(String specialty);

    List<TechnicianQualification> ListTechnicianQualificationByTechnicianId(Long id);
    List<Technician> ListTechniciansByQualification(Double qualificationAverage);

    List<Technician> ListTechniciansByName(String firstName, String lastName);

    List<Technician> ListTechniciansByLocation(String city, String district);
}
