package pe.edu.upc.qualificationapi.EasyJobs.controller;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.qualificationapi.EasyJobs.entity.AppointmentHistory;
import pe.edu.upc.qualificationapi.EasyJobs.entity.Technician;
import pe.edu.upc.qualificationapi.EasyJobs.entity.TechnicianQualification;
import pe.edu.upc.qualificationapi.EasyJobs.resource.*;
import pe.edu.upc.qualificationapi.EasyJobs.service.TechnicianQualificationService;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RestController
@CrossOrigin(origins = "http://localhost:3306")
@RequestMapping(value="/Qualification")
public class QualificationController {

    @Autowired
    private TechnicianQualificationService technicianQualificationService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping(value = "/createTechnicianQualification")
    public TechnicianQualificationResource createTechnicianQualification(@RequestBody SaveTechnicianQualificationResource resource, @RequestParam Long id) {
        TechnicianQualification technicianQualification = technicianQualificationService.createTechnicianQualification(convertToEntityQualification(resource),id);
        return convertToResourceQualification(technicianQualification);
    }

    @PostMapping(value = "/createAppointmentHistory")
    public AppointmentHistoryResource createAppointmentHistory(@RequestBody SaveAppointmentHistoryResource resource, @RequestParam Long AppointmentId) {
        AppointmentHistory appointmentHistory = technicianQualificationService.createAppointmentHistory(convertToEntityAppointmentHistory(resource),AppointmentId);
        return convertToResourceAppointmentHistory(appointmentHistory);
    }

    @GetMapping("/qualification/{qualificationAverage}")
    public List<TechnicianResource> listTechniciansByQualification(
            @RequestParam(name = "qualificationAverage") Double qualificationAverage) {
        List<Technician> technicianList = technicianQualificationService.ListTechniciansByQualification(qualificationAverage);
        List<TechnicianResource> technicianResourceList = technicianList.
                stream().map(technician -> {
                    return convertToResource(technician);
                }).
                collect(Collectors.toList());
        return technicianResourceList;
    }

    @GetMapping("/appointmentHistory/findAppointmentHistoryByTechnicianId/{id}")
    public List<AppointmentHistoryResource> findAppointmentHistoryByTechnicianId(@PathVariable Long id) {
        List<AppointmentHistory> appointmentHistoryList = technicianQualificationService.findAppointmentHistoryByTechnicianId(id);
        List<AppointmentHistoryResource> appointmentHistoryResourceList = appointmentHistoryList.
                stream().map(appointmentHistory -> {
                    return convertToResourceAppointmentHistory(appointmentHistory);
                }).
                collect(Collectors.toList());
        return appointmentHistoryResourceList;
    }

    private TechnicianQualification convertToEntityQualification(SaveTechnicianQualificationResource resource) {
        return modelMapper.map(resource, TechnicianQualification.class);
    }
    private TechnicianQualificationResource convertToResourceQualification(TechnicianQualification entity) {
        return modelMapper.map(entity, TechnicianQualificationResource.class);
    }

    private AppointmentHistory convertToEntityAppointmentHistory(SaveAppointmentHistoryResource resource) {
        return modelMapper.map(resource, AppointmentHistory.class);
    }
    private AppointmentHistoryResource convertToResourceAppointmentHistory(AppointmentHistory entity) {
        return modelMapper.map(entity, AppointmentHistoryResource.class);
    }
    private TechnicianResource convertToResource(Technician entity) {
        return modelMapper.map(entity, TechnicianResource.class);
    }
}
