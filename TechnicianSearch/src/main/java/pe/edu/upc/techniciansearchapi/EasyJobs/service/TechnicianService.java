package pe.edu.upc.techniciansearchapi.EasyJobs.service;

import org.springframework.stereotype.Service;
import pe.edu.upc.techniciansearchapi.EasyJobs.entity.Technician;

import java.util.List;

@Service
public interface TechnicianService {
    Technician createTechnician(Technician technician);
    List<Technician> findAllTechnician();
}
