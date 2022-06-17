package pe.edu.upc.closeappointmentapi.EasyJobs.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.closeappointmentapi.EasyJobs.entity.Technician;
import pe.edu.upc.closeappointmentapi.EasyJobs.resource.SaveTechnicianResource;
import pe.edu.upc.closeappointmentapi.EasyJobs.resource.TechnicianResource;
import pe.edu.upc.closeappointmentapi.EasyJobs.service.AppointmentService;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RestController
@CrossOrigin(origins = "http://localhost:3306")
@RequestMapping("/technicians")
public class TechnicianController {

    @Autowired
    private AppointmentService appointmentService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping(value = "/createTechnician")
    public TechnicianResource createTechnician(@RequestBody SaveTechnicianResource resource) {
        Technician technicianCreated = appointmentService.createTechnician(convertToEntity(resource));
        return convertToResource(technicianCreated);
    }

    @GetMapping(value = "/findTechnicianById/{technicianId}")
    public TechnicianResource getTechnician(@PathVariable("technicianId") Long id){
        Technician technician = appointmentService.getTechnicianById(id);
        if (technician == null) {
            return null;
        }
        return convertToResource(technician);
    }
    @GetMapping(value = "/findAllTechnicians")
    public List<TechnicianResource> getTechnicians(){
        List<Technician> technicians = appointmentService.getAllTechnicians();
        if (technicians == null) {
            return null;
        }
        List<TechnicianResource> technicianResourceList = technicians.stream().map(technician -> {
            return convertToResource(technician);
        }).collect(Collectors.toList());
        return technicianResourceList;
    }

    private Technician convertToEntity(SaveTechnicianResource resource){
        return modelMapper.map(resource, Technician.class);
    }
    private TechnicianResource convertToResource(Technician entity) {
        return modelMapper.map(entity, TechnicianResource.class);
    }
}
