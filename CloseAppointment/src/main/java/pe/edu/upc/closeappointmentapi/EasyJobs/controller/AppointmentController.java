package pe.edu.upc.closeappointmentapi.EasyJobs.controller;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.closeappointmentapi.EasyJobs.entity.Appointment;
import pe.edu.upc.closeappointmentapi.EasyJobs.entity.Technician;
import pe.edu.upc.closeappointmentapi.EasyJobs.resource.AppointmentResource;
import pe.edu.upc.closeappointmentapi.EasyJobs.resource.SaveAppointmentResource;
import pe.edu.upc.closeappointmentapi.EasyJobs.resource.TechnicianResource;
import pe.edu.upc.closeappointmentapi.EasyJobs.service.AppointmentService;

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
    @GetMapping("/findAppointmentById/{id}")
    public AppointmentResource getAppointment(@PathVariable("id") Long id) {
        Appointment appointment = appointmentService.getAppointmentById(id);
        if (appointment == null) {
            return null;
        }
        return convertToResource(appointment);
    }
    @GetMapping("/findAppointmentByIdResponse/{id}")
    public ResponseEntity<Appointment> getAppointmentResponse(@PathVariable("id") Long id) {
        Appointment appointment = appointmentService.getAppointmentById(id);
        if (appointment == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(appointment);
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
