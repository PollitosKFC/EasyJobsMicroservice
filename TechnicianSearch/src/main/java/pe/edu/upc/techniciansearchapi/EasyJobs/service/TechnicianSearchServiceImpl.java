package pe.edu.upc.techniciansearchapi.EasyJobs.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.techniciansearchapi.EasyJobs.entity.Technician;

import pe.edu.upc.techniciansearchapi.EasyJobs.entity.TechnicianQualification;
import pe.edu.upc.techniciansearchapi.EasyJobs.entity.TechnicianSpecialty;
import pe.edu.upc.techniciansearchapi.EasyJobs.repository.TechnicianQualificationRepository;
import pe.edu.upc.techniciansearchapi.EasyJobs.repository.TechnicianSearchRepository;
import pe.edu.upc.techniciansearchapi.EasyJobs.repository.TechnicianSpecialtyRepository;

import java.util.List;
@Service
@RequiredArgsConstructor
public class TechnicianSearchServiceImpl implements TechnicianSearchService {
    @Autowired
    private final TechnicianSearchRepository technicianSearchRepository;

    @Autowired
    private final TechnicianSpecialtyRepository technicianSpecialtyRepository;

    @Autowired
    private final TechnicianQualificationRepository technicianQualificationRepository;
    @Override
    public TechnicianSpecialty createTechnicianSpecialty(TechnicianSpecialty technicianSpecialty, Long id) {
        if (technicianSearchRepository.findById(id).orElse(null) == null) {
            return null;
        }
        TechnicianSpecialty newTechnicianSpecialty = new TechnicianSpecialty();
        newTechnicianSpecialty.setName(technicianSpecialty.getName());
        newTechnicianSpecialty.setTechnician(technicianSearchRepository.findById(id).orElse(null));
        return technicianSpecialtyRepository.save(newTechnicianSpecialty);
    }

    @Override
    public TechnicianQualification createTechnicianQualification(TechnicianQualification technicianQualification, Long id) {
        Technician technician = technicianSearchRepository.getById(id);
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
    public List<TechnicianQualification> ListTechnicianQualificationByTechnicianId(Long id) {
        return technicianQualificationRepository.findByTechnicianId(id);
    }

    @Override
    public List<Technician> ListTechniciansBySpecialty(String specialty) {
        return technicianSearchRepository.findBySpecialty(specialty);
    }
    @Override
    public List<Technician> ListTechniciansByQualification(Double qualificationAverage) {
        return technicianSearchRepository.findByQualification(qualificationAverage);
    }
    @Override
    public List<Technician> ListTechniciansByName(String firstName, String lastName) {

        return technicianSearchRepository.findByFirstNameOrLastName(firstName, lastName);
    }
    @Override
    public List<Technician> ListTechniciansByLocation(String city, String district) {
        return technicianSearchRepository.findByCityOrDistrict(city, district);
    }

}
