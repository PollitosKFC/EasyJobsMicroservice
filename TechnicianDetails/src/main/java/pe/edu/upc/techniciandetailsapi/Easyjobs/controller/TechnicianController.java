package pe.edu.upc.techniciandetailsapi.Easyjobs.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.techniciandetailsapi.Easyjobs.Entity.Technician;
import pe.edu.upc.techniciandetailsapi.Easyjobs.resource.SaveTechnician;
import pe.edu.upc.techniciandetailsapi.Easyjobs.resource.TechnicianResource;
import pe.edu.upc.techniciandetailsapi.Easyjobs.service.TechnicianService;

import java.util.List;
import java.util.stream.Collectors;


@Controller
@RestController
@CrossOrigin(origins = "http://localhost:3306")
@RequestMapping("/technicians")
public class TechnicianController {
    @Autowired
    private TechnicianService technicianService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping(value = "/createTechnician")
    @ResponseBody
    public TechnicianResource createTechnician(@RequestBody SaveTechnician resource) {
        Technician technicianCreated = technicianService.createTechnician(convertToEntity(resource));
        return convertToResource(technicianCreated);
    }

    @GetMapping(value = "/findAllTechnician")
    public List<TechnicianResource> findAllTechnician() {
        List<Technician> technicianList = technicianService.findAllTechnician();
        List<TechnicianResource> technicianResourceList = technicianList.
                stream().map(technician -> {
                    return convertToResource(technician);
                }).
                collect(Collectors.toList());
        return technicianResourceList;
    }

    private Technician convertToEntity(SaveTechnician resource) {
        return modelMapper.map(resource, Technician.class);
    }
    private TechnicianResource convertToResource(Technician entity) {
        return modelMapper.map(entity, TechnicianResource.class);
    }
}
