package pe.edu.upc.appointmentapi.EasyJobs.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.appointmentapi.EasyJobs.entity.Technician;
import pe.edu.upc.appointmentapi.EasyJobs.resource.SaveTechnicianResource;
import pe.edu.upc.appointmentapi.EasyJobs.resource.TechnicianResource;
import pe.edu.upc.appointmentapi.EasyJobs.service.TechnicianService;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RestController
@CrossOrigin(origins = "http://localhost:3306")
@RequestMapping("/appointmentTechnicians")
public class TechnicianController {

    @Autowired
    private TechnicianService technicianService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping(value = "/technicians/createTechnician")
    public TechnicianResource createTechnician(@RequestBody SaveTechnicianResource resource) {
        Technician technicianCreated = technicianService.createTechnician(convertToEntity(resource));
        return convertToResource(technicianCreated);
    }

    @GetMapping(value = "/technicians/findTechnicianById/{technicianId}")
    public TechnicianResource getTechnician(@PathVariable("technicianId") Long id){
        Technician technician = technicianService.findTechnicianById(id);
        if (technician == null) {
            return null;
        }
        return convertToResource(technician);
    }

    @GetMapping(value = "/technicians/getTechnicianResponse/{id}")
    public ResponseEntity<Technician> getTechnicianResponse(@PathVariable("id") Long id){
        Technician technician = technicianService.findTechnicianById(id);
        return ResponseEntity.ok(technician);
    }
    @GetMapping(value = "/technicians/findAllTechnicians")
    public List<TechnicianResource> getTechnicians(){
        List<Technician> technicians = technicianService.getAllTechnicians();
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
