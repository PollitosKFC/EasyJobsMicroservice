package pe.edu.upc.closeappointmentapi.EasyJobs.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pe.edu.upc.closeappointmentapi.EasyJobs.entity.Appointment;

@FeignClient(contextId = "Appointment",name = "Appointment", path = "/Appointment", fallback = AppointmentHystrixFallbackFactory.class)
public interface AppointmentClient {
    @GetMapping(value = "/findAppointmentById/{id}")
    public ResponseEntity<Appointment> getAppointmentResponse(@PathVariable("id") Long id);
}
