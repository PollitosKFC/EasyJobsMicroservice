package pe.com.easyjobs.accountsapi.service;

import org.springframework.stereotype.Service;
import pe.com.easyjobs.accountsapi.entity.Customer;
import pe.com.easyjobs.accountsapi.entity.Technician;

import java.util.List;
@Service
public interface TechnicianService {
    List<Technician> getAllTechnicians();
    Technician getByTechnicianId(Long id);
    Technician updateTechnician(Long id, Technician technician);
    Technician createTechnician(Technician technician);
    Technician deleteTechnician(Long id);
}
