package pe.edu.upc.techniciandetailsapi.Easyjobs.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pe.edu.upc.techniciandetailsapi.Easyjobs.Entity.Technician;
import pe.edu.upc.techniciandetailsapi.Easyjobs.client.TechnicianClient;
import pe.edu.upc.techniciandetailsapi.Easyjobs.repository.TechnicianRepository;
import pe.edu.upc.techniciandetailsapi.Easyjobs.resource.SaveTechnician;
import pe.edu.upc.techniciandetailsapi.Easyjobs.resource.TechnicianResource;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TechnicianServiceImpl implements TechnicianService {
    @Autowired
    private TechnicianRepository technicianRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private final TechnicianClient technicianClient;

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
        newTechnician.setTechnician_files(null);
        newTechnician.setTechnician_detail(null);
        return technicianRepository.save(newTechnician);
    }

    @Override
    public List<Technician> findAllTechnician() {
        return technicianRepository.findAllTechnician();
    }

    @Override
    public Technician getByTechnicianId(Long id) {
        ResponseEntity<Technician> existingTechnician = technicianClient.getTechnicianResponse(id);
        if (existingTechnician==null) {
            return null;
        }
        return existingTechnician.getBody();
    }

    @Override
     public Technician convertToEntityTechnician(TechnicianResource resource) {
        return modelMapper.map(resource, Technician.class);
    }
}
