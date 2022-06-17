package pe.edu.upc.closeappointmentapi.EasyJobs.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pe.edu.upc.closeappointmentapi.EasyJobs.entity.Technician;

@FeignClient(contextId = "Technician",name = "Appointment", path = "/appointmentTechnicians", fallback = TechnicianHystrixFallbackFactory.class)
//@RequestMapping("/technicians")
public interface TechnicianClient {
    @GetMapping(value = "/technicians/getTechnicianResponse/{id}")
    public ResponseEntity<Technician> getTechnicianResponse(@PathVariable("id") Long id);
}
