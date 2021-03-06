package pe.edu.upc.appointmentapi.EasyJobs.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pe.edu.upc.appointmentapi.EasyJobs.entity.Technician;

@FeignClient(contextId = "Technician",name = "Accounts", path = "/accounts", fallback = TechnicianHystrixFallbackFactory.class)
//@RequestMapping("/technicians")
public interface TechnicianClient {
    @GetMapping(value = "/technicians/getTechnicianResponse/{id}")
    public ResponseEntity<Technician> getTechnicianResponse(@PathVariable("id") Long id);
}
