package pe.edu.upc.appointmentapi.EasyJobs.client;

import org.springframework.http.ResponseEntity;
import pe.edu.upc.appointmentapi.EasyJobs.entity.Technician;

import java.util.Date;

public class TechnicianHystrixFallbackFactory implements TechnicianClient {

    @Override
    public ResponseEntity<Technician> getTechnicianResponse(Long id) {
        Technician technician = Technician.builder()
                .firstName("no-name")
                .lastName("no-last-name")
                .email("no-email")
                .technician_appointment(null)
                .activated(true)
                .address("no-address")
                .gender("no-gender")
                .district("no-district")
                .city("no-city")
                .identificationNumber(0)
                .userName("none")
                .verified(false)
                .updatedDate(new Date())
                .registerDate(new Date())
                .identificationType("no-identification-type")
                .phoneNumber(1L)
                .build();
        return ResponseEntity.ok(technician);
    }
}
