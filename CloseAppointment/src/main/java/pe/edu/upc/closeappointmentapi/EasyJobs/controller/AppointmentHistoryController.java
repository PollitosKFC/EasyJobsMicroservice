package pe.edu.upc.closeappointmentapi.EasyJobs.controller;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.closeappointmentapi.EasyJobs.entity.AppointmentHistory;
import pe.edu.upc.closeappointmentapi.EasyJobs.resource.AppointmentHistoryResource;
import pe.edu.upc.closeappointmentapi.EasyJobs.resource.SaveAppointmentHistoryResource;
import pe.edu.upc.closeappointmentapi.EasyJobs.service.AppointmentCloseService;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RestController
@RequestMapping(value ="/AppointmentHistories")
public class AppointmentHistoryController {

    @Autowired
    private AppointmentCloseService appointmentCloseService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping(value = "/createAppointmentHistory")
    public AppointmentHistoryResource createAppointmentHistory(@RequestBody SaveAppointmentHistoryResource resource, @RequestParam Long AppointmentId) {
        AppointmentHistory appointmentHistory = appointmentCloseService.createAppointmentHistory(convertToEntityAppointmentHistory(resource),AppointmentId);
        return convertToResourceAppointmentHistory(appointmentHistory);
    }
    @GetMapping("/findAppointmentHistoryByAppointmentId/")
    public List<AppointmentHistoryResource> listAppointmentHistoryByAppointmentId(@RequestParam Long AppointmentId) {
        List<AppointmentHistory> appointmentHistoryList = appointmentCloseService.findAppointmentHistoriesByAppointmentId(AppointmentId);
        List<AppointmentHistoryResource> appointmentHistoryResourceList = appointmentHistoryList.
                stream().map(appointmentHistory -> {
                    return convertToResourceAppointmentHistory(appointmentHistory);
                }).
                collect(Collectors.toList());
        return appointmentHistoryResourceList;
    }

    @GetMapping("/findAppointmentHistoriesByTechnicianId/")
    public List<AppointmentHistoryResource> listAppointmentHistoriesByTechnicianId(@RequestParam Long TechnicianId) {
        List<AppointmentHistory> appointmentHistoryList = appointmentCloseService.findAppointmentHistoriesByTechnicianId(TechnicianId);
        List<AppointmentHistoryResource> appointmentHistoryResourceList = appointmentHistoryList.
                stream().map(appointmentHistory -> {
                    return convertToResourceAppointmentHistory(appointmentHistory);
                }).
                collect(Collectors.toList());
        return appointmentHistoryResourceList;
    }

    @GetMapping("/listAppointmentHistoryByCustomerId/")
    public List<AppointmentHistoryResource> listAppointmentHistoryByCustomerId(@RequestParam Long CustomerId) {
        List<AppointmentHistory> appointmentHistoryList = appointmentCloseService.findAppointmentHistoriesByCustomerId(CustomerId);
        List<AppointmentHistoryResource> appointmentHistoryResourceList = appointmentHistoryList.
                stream().map(appointmentHistory -> {
                    return convertToResourceAppointmentHistory(appointmentHistory);
                }).
                collect(Collectors.toList());
        return appointmentHistoryResourceList;
    }

    @GetMapping("/listAppointmentHistoryByTechnicianIdAndCustomerId/")
    public List<AppointmentHistoryResource> ListAppointmentHistoriesByTechnicianIdAndCustomerId (
            @RequestParam(name = "technicianId") Long technicianId,
            @RequestParam(name = "customerId") Long customerId) {
        List<AppointmentHistory> appointmentHistoryList = appointmentCloseService.findAppointmentHistoriesByTechnicianIdAndCustomerId(customerId,technicianId);
        List<AppointmentHistoryResource> appointmentHistoryResourceList = appointmentHistoryList.
                stream().map(appointmentHistory -> {
                    return convertToResourceAppointmentHistory(appointmentHistory);
                }).
                collect(Collectors.toList());
        return appointmentHistoryResourceList;
    }

    @GetMapping("/findAppointmentHistoryById/")
    public AppointmentHistoryResource findAppointmentHistoryById(@RequestParam Long id)
    {
        AppointmentHistory appointmentHistory = appointmentCloseService.findAppointmentHistoryById(id);
        return convertToResourceAppointmentHistory(appointmentHistory);
    }

    @GetMapping("/listAllAppointmentHistories/")
    public List<AppointmentHistoryResource> listAllAppointmentHistories() {
        List<AppointmentHistory> appointmentHistoryList = appointmentCloseService.findAllAppointmentHistories();
        List<AppointmentHistoryResource> appointmentHistoryResourceList = appointmentHistoryList.
                stream().map(appointmentHistory -> {
                    return convertToResourceAppointmentHistory(appointmentHistory);
                }).
                collect(Collectors.toList());
        return appointmentHistoryResourceList;
    }

    private AppointmentHistory convertToEntityAppointmentHistory(SaveAppointmentHistoryResource resource) {
        return modelMapper.map(resource, AppointmentHistory.class);
    }
    private AppointmentHistoryResource convertToResourceAppointmentHistory(AppointmentHistory entity) {
        return modelMapper.map(entity, AppointmentHistoryResource.class);
    }
}
