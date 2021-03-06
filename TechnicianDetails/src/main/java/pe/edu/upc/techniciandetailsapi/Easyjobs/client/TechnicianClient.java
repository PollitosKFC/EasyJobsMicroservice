package pe.edu.upc.techniciandetailsapi.Easyjobs.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import pe.edu.upc.techniciandetailsapi.Easyjobs.Entity.Technician;

@FeignClient(name = "Accounts", path = "/technicians")
//@RequestMapping("/technicians")
public interface TechnicianClient {
    @GetMapping(value = "/getTechnicianResponse/{id}")
    public ResponseEntity<Technician> getTechnicianResponse(@PathVariable("id") Long id);
}
