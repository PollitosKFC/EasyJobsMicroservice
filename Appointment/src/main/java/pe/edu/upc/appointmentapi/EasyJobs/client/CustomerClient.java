package pe.edu.upc.appointmentapi.EasyJobs.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pe.edu.upc.appointmentapi.EasyJobs.entity.Customer;

@FeignClient(contextId = "Customer",name = "Accounts", path = "/customers", fallback = CustomerHystrixFallbackFactory.class)
public interface CustomerClient {
    @GetMapping(value = "/getCustomerResponse/{id}")
    public ResponseEntity<Customer> getCustomerResponse(@PathVariable("id") Long id);
}
