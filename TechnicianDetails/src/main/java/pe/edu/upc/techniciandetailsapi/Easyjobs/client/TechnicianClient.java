package pe.edu.upc.techniciandetailsapi.Easyjobs.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.edu.upc.techniciandetailsapi.Easyjobs.Entity.Technician;
import pe.edu.upc.techniciandetailsapi.Easyjobs.resource.TechnicianResource;

import java.util.List;

@FeignClient(name = "localhost:8091", path = "/technicians")
//@RequestMapping("/technicians")
public interface TechnicianClient {
    @GetMapping(value = "/findTechnicianById/{technicianId}")
    public TechnicianResource getTechnician(@PathVariable("technicianId") Long id);

    @GetMapping(value = "/findAllTechnicians")
    public List<TechnicianResource> getTechnicians();

    @GetMapping(value = "/getTechnicianResponse/{id}")
    public ResponseEntity<Technician> getTechnicianResponse(@PathVariable("id") Long id);
}
