package pe.edu.upc.techniciansearchapi.EasyJobs.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.techniciansearchapi.EasyJobs.entity.Technician;
import pe.edu.upc.techniciansearchapi.EasyJobs.repository.TechnicianRepository;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TechnicianServiceImpl implements TechnicianService {

    @Autowired
    private TechnicianRepository technicianRepository;

    @Override
    public Technician createTechnician(Technician technician) {
        Technician newTechnician = new Technician();
        newTechnician.setRegisterDate(new Date());
        newTechnician.setUpdatedDate(new Date());
        newTechnician.setUserName(technician.getUserName());
        newTechnician.setFirstName(technician.getFirstName());
        newTechnician.setLastName(technician.getLastName());
        newTechnician.setEmail(technician.getEmail());
        newTechnician.setVerified(false);
        newTechnician.setPassword(technician.getPassword());
        newTechnician.setPhoneNumber(technician.getPhoneNumber());
        newTechnician.setAddress(technician.getAddress());
        newTechnician.setCity(technician.getCity());
        newTechnician.setDistrict(technician.getDistrict());
        newTechnician.setGender(technician.getGender());
        newTechnician.setType("TECHNICIAN");
        newTechnician.setIdentificationType(technician.getIdentificationType());
        newTechnician.setIdentificationNumber(technician.getIdentificationNumber());
        newTechnician.setTechnician_qualification(null);
        newTechnician.setTechnician_specialties(null);
        return technicianRepository.save(newTechnician);
    }

    @Override
    public List<Technician> findAllTechnician() {
        return technicianRepository.findAllTechnician();
    }

}
