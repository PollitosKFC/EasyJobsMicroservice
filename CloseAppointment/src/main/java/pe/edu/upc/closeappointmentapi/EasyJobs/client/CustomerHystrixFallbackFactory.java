package pe.edu.upc.closeappointmentapi.EasyJobs.client;

import org.springframework.http.ResponseEntity;
import pe.edu.upc.closeappointmentapi.EasyJobs.entity.Customer;

import java.util.Date;

public class CustomerHystrixFallbackFactory implements CustomerClient {
    @Override
    public ResponseEntity<Customer> getCustomerResponse(Long id) {
        Customer customer = Customer.builder()
                .firstName("no-name")
                .lastName("no-last-name")
                .email("no-email")
                .customer_appointment(null)
                .activated(true)
                .address("no-address")
                .gender("no-gender")
                .district("no-district")
                .city("no-city")
                .identificationNumber(0)
                .userName("none")
                .updatedDate(new Date())
                .registerDate(new Date())
                .identificationType("no-identification-type")
                .phoneNumber(1L)
                .build();
        return ResponseEntity.ok(customer);
    }
}