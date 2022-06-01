package pe.edu.upc.qualificationapi.EasyJobs.controller;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.qualificationapi.EasyJobs.entity.Appointment;
import pe.edu.upc.qualificationapi.EasyJobs.resource.AppointmentResource;
import pe.edu.upc.qualificationapi.EasyJobs.resource.SaveAppointmentResource;
import pe.edu.upc.qualificationapi.EasyJobs.service.AppointmentService;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RestController
@CrossOrigin(origins = "http://localhost:3306")
@RequestMapping(value ="/Appointment")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private ModelMapper modelMapper;


    @PostMapping("/createAppointmentBy/{technicianId}And/{customerId}")
    public AppointmentResource createAppointment(@RequestBody SaveAppointmentResource appointment,
                                                 @RequestParam(name = "customerId") Long customerId,
                                                 @RequestParam(name = "technicianId") Long technicianId) {
        Appointment appointmentCreated = appointmentService.createAppointment(convertToEntity(appointment), customerId, technicianId);
        return convertToResource(appointmentCreated);
    }

    @GetMapping("/listAppointments/")
    public List<AppointmentResource> listAppointments() {
        List<Appointment> appointments = appointmentService.getAllAppointments();
        if (appointments == null) {
            return null;
        }
        List<AppointmentResource> appointmentResourceList = appointments.stream().map(appointment -> {
            return convertToResource(appointment);
        }).collect(Collectors.toList());
        return appointmentResourceList;
    }

    private Appointment convertToEntity(SaveAppointmentResource resource){
        return modelMapper.map(resource, Appointment.class);
    }
    private AppointmentResource convertToResource(Appointment entity) {
        return modelMapper.map(entity, AppointmentResource.class);
    }
}
