package pe.com.easyjobs.accountsapi.controller;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pe.com.easyjobs.accountsapi.entity.Technician;
import pe.com.easyjobs.accountsapi.resource.SaveTechnicianResource;
import pe.com.easyjobs.accountsapi.resource.TechnicianResource;
import pe.com.easyjobs.accountsapi.service.TechnicianService;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RestController
@RequestMapping("/accounts")
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
        Technician technician = technicianService.getByTechnicianId(id);
        if (technician == null) {
            return null;
        }
        return convertToResource(technician);
    }

    @GetMapping(value = "/technicians/getTechnicianResponse/{id}")
    public ResponseEntity<Technician> getTechnicianResponse(@PathVariable("id") Long id){
        Technician technician = technicianService.getByTechnicianId(id);
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

    @PutMapping(value = "/technicians/updateTechnician/{id}")
    public TechnicianResource updateTechnician(@PathVariable("id") Long id, @RequestBody SaveTechnicianResource technician){
        Technician technicianUpdated = technicianService.updateTechnician(id, convertToEntity(technician));
        return convertToResource(technicianUpdated);
    }

    @DeleteMapping(value = "/technicians/deleteTechnician/{id}")
    public TechnicianResource deleteTechnician(@PathVariable("id") Long id){
        Technician technicianDeleted = technicianService.deleteTechnician(id);
        return convertToResource(technicianDeleted);
    }
    private Technician convertToEntity(SaveTechnicianResource resource){
    return modelMapper.map(resource, Technician.class);
    }
    private TechnicianResource convertToResource(Technician entity) {
        return modelMapper.map(entity, TechnicianResource.class);
    }
}

