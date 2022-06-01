package pe.com.easyjobs.accountsapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pe.com.easyjobs.accountsapi.entity.Customer;
import pe.com.easyjobs.accountsapi.entity.Technician;
import pe.com.easyjobs.accountsapi.repository.TechnicianRepository;

import java.util.Date;
import java.util.List;
@Service
@RequiredArgsConstructor
public class TechnicianServiceImpl implements TechnicianService{

    @Autowired
    private TechnicianRepository technicianRepository;

    @Override
    public Technician getByTechnicianId(Long id) {
        Technician technician = technicianRepository.findTechnicianById(id);
        if (technician == null || technician.getActivated() == false) {
            throw new RuntimeException("No se encontró el técnico con id: " + id);
        }
        return technicianRepository.findTechnicianById(id);
    }

    @Override
    public Technician createTechnician(Technician technician) {
        Technician newTechnician = new Technician();
        newTechnician.setUserName(technician.getUserName());
        newTechnician.setRegisterDate(new Date());
        newTechnician.setUpdatedDate(new Date());
        newTechnician.setFirstName(technician.getFirstName());
        newTechnician.setLastName(technician.getLastName());
        newTechnician.setEmail(technician.getEmail());
        newTechnician.setVerified(technician.getVerified());
        newTechnician.setPassword(technician.getPassword());
        newTechnician.setPhoneNumber(technician.getPhoneNumber());
        newTechnician.setAddress(technician.getAddress());
        newTechnician.setCity(technician.getCity());
        newTechnician.setDistrict(technician.getDistrict());
        newTechnician.setGender(technician.getGender());
        newTechnician.setType("TECHNICIAN");
        newTechnician.setVerified(false);
        newTechnician.setActivated(true);
        newTechnician.setIdentificationType(technician.getIdentificationType());
        newTechnician.setIdentificationNumber(technician.getIdentificationNumber());
        return technicianRepository.save(newTechnician);
    }

    @Override
    public Technician updateTechnician(Long id, Technician technician) {
        Technician technicianToUpdate = technicianRepository.getById(id);
        if(technicianToUpdate == null || technicianToUpdate.getActivated() == false){
            return null;
        }
        technicianToUpdate.setUpdatedDate(new Date());
        technicianToUpdate.setUserName(technician.getUserName());
        technicianToUpdate.setEmail(technician.getEmail());
        technicianToUpdate.setPassword(technician.getPassword());
        technicianToUpdate.setFirstName(technician.getFirstName());
        technicianToUpdate.setLastName(technician.getLastName());
        technicianToUpdate.setPhoneNumber(technician.getPhoneNumber());
        technicianToUpdate.setAddress(technician.getAddress());
        technicianToUpdate.setCity(technician.getCity());
        technicianToUpdate.setDistrict(technician.getDistrict());
        technicianToUpdate.setGender(technician.getGender());
        technicianToUpdate.setIdentificationType(technician.getIdentificationType());
        technicianToUpdate.setIdentificationNumber(technician.getIdentificationNumber());
        return technicianRepository.save(technicianToUpdate);
    }

    @Override
    public Technician deleteTechnician(Long id) {
        Technician technicianToDeactivate = technicianRepository.getById(id);
        if(technicianToDeactivate == null|| technicianToDeactivate.getActivated() == false){
            return null;
        }
        technicianToDeactivate.setActivated(false);
        return technicianRepository.save(technicianToDeactivate);
    }

    @Override
    public List<Technician> getAllTechnicians() {
        return technicianRepository.getAllTechnicians();
    }
}
