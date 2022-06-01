package pe.edu.upc.techniciandetailsapi.Easyjobs.service;

import org.springframework.stereotype.Service;
import pe.edu.upc.techniciandetailsapi.Easyjobs.Entity.Technician;

import java.util.List;

@Service
public interface TechnicianService {
    Technician createTechnician(Technician technician);
    List<Technician> findAllTechnician();
}
