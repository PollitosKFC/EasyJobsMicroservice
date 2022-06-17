package pe.edu.upc.closeappointmentapi.EasyJobs.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pe.edu.upc.closeappointmentapi.EasyJobs.entity.Customer;

@FeignClient(contextId = "Customer",name = "Appointment", path = "/appointmentCustomers", fallback = CustomerHystrixFallbackFactory.class)
public interface CustomerClient {
    @GetMapping(value = "/customers/getCustomerResponse/{id}")
    public ResponseEntity<Customer> getCustomerResponse(@PathVariable("id") Long id);
}
