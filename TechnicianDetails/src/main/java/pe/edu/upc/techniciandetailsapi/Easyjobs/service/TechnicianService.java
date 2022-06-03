package pe.edu.upc.techniciandetailsapi.Easyjobs.service;

import org.springframework.stereotype.Service;
import pe.edu.upc.techniciandetailsapi.Easyjobs.Entity.Technician;
import pe.edu.upc.techniciandetailsapi.Easyjobs.resource.TechnicianResource;

import java.util.List;

@Service
public interface TechnicianService {
    Technician createTechnician(Technician technician);
    List<Technician> findAllTechnician();
    Technician convertToEntityTechnician(TechnicianResource resource);
    Technician getByTechnicianId(Long id);
}
