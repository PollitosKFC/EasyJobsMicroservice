package pe.edu.upc.techniciansearchapi.EasyJobs.controller;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.techniciansearchapi.EasyJobs.entity.Technician;
import pe.edu.upc.techniciansearchapi.EasyJobs.entity.TechnicianQualification;
import pe.edu.upc.techniciansearchapi.EasyJobs.entity.TechnicianSpecialty;
import pe.edu.upc.techniciansearchapi.EasyJobs.resource.*;
import pe.edu.upc.techniciansearchapi.EasyJobs.service.TechnicianSearchService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RestController
@CrossOrigin(origins = "http://localhost:3306")
@RequestMapping(value ="/technicianSearch")
public class TechnicianSearchController {

    @Autowired
    private TechnicianSearchService technicianSearchService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/specialty/{specialty}")
    public List<TechnicianResource> listTechniciansBySpecialty(
            @RequestParam(name = "specialty") String specialty) {
        List<Technician> technicianList = technicianSearchService.ListTechniciansBySpecialty(specialty);
        List<TechnicianResource> technicianResourceList = technicianList.
                stream().map(technician -> {
                    return convertToResource(technician);
                }).
                collect(Collectors.toList());
        return technicianResourceList;
    }

    @PostMapping(value = "/createTechnicianSpecialty")
    public TechnicianSpecialtyResource createTechnicianSpecialty(@RequestBody SaveTechnicianSpecialtyResource resource, @RequestParam Long id) {
        TechnicianSpecialty technicianSpecialty = technicianSearchService.createTechnicianSpecialty(convertToEntitySpecialty(resource),id);
        return convertToResourceSpecialty(technicianSpecialty);
    }

    @PostMapping(value = "/createTechnicianQualification")
    public TechnicianQualificationResource createTechnicianQualification(@RequestBody SaveTechnicianQualificationResource resource, @RequestParam Long id) {
        TechnicianQualification technicianQualification = technicianSearchService.createTechnicianQualification(convertToEntityQualification(resource),id);
        return convertToResourceQualification(technicianQualification);
    }

    @GetMapping("/qualification/{qualificationAverage}")
    public List<TechnicianResource> listTechniciansByQualification(
            @RequestParam(name = "qualificationAverage") Double qualificationAverage) {
        List<Technician> technicianList = technicianSearchService.ListTechniciansByQualification(qualificationAverage);
        List<TechnicianResource> technicianResourceList = technicianList.
                stream().map(technician -> {
                    return convertToResource(technician);
                }).
                collect(Collectors.toList());
        return technicianResourceList;
    }

    @GetMapping("/qualificationByTechnicianId/{technicianId}")
    public List<TechnicianQualificationResource> listTechnicianQualification(
            @RequestParam(name = "technicianId") Long technicianId) {
        List<TechnicianQualification> technicianQualificationList = technicianSearchService.ListTechnicianQualificationByTechnicianId(technicianId);
        List<TechnicianQualificationResource> technicianQualificationResourceList = technicianQualificationList.
                stream().map(technicianQualification -> {
                    return convertToResourceQualification(technicianQualification);
                }).
                collect(Collectors.toList());
        return technicianQualificationResourceList;
    }

    @GetMapping("/name/{firstName}/{lastName}")
   public List<TechnicianResource> ListTechniciansByName(
            @RequestParam(name = "firstName",required = false) String firstName,
            @RequestParam(name = "lastName") String lastName) {
        List<Technician> technicianList = technicianSearchService.ListTechniciansByName(firstName,lastName);
        List<TechnicianResource> technicianResourceList = technicianList.
                stream().map(technician -> {
                    return convertToResource(technician);
                }).
                collect(Collectors.toList());
        return technicianResourceList;
    }


    @GetMapping("/location/{city}/{district}")
    public List<TechnicianResource> ListTechniciansByLocation(
            @RequestParam(name = "city") String city,
            @RequestParam(name = "district",required = false) String district) {
        List<Technician> technicianList = technicianSearchService.ListTechniciansByLocation(city,district);
        List<TechnicianResource> technicianResourceList = technicianList.
                stream().map(technician -> {
                    return convertToResource(technician);
                }).
                collect(Collectors.toList());
        return technicianResourceList;
    }

    // Resource Conversion
    private TechnicianSpecialty convertToEntitySpecialty(SaveTechnicianSpecialtyResource resource) {
        return modelMapper.map(resource, TechnicianSpecialty.class);
    }
    private TechnicianSpecialtyResource convertToResourceSpecialty(TechnicianSpecialty entity) {
        return modelMapper.map(entity, TechnicianSpecialtyResource.class);
    }

    private TechnicianQualification convertToEntityQualification(SaveTechnicianQualificationResource resource) {
        return modelMapper.map(resource, TechnicianQualification.class);
    }
    private TechnicianQualificationResource convertToResourceQualification(TechnicianQualification entity) {
        return modelMapper.map(entity, TechnicianQualificationResource.class);
    }
    private Technician convertToEntity(SaveTechnicianResource resource) {
        return modelMapper.map(resource, Technician.class);
    }
    private TechnicianResource convertToResource(Technician entity) {
        return modelMapper.map(entity, TechnicianResource.class);
    }
}