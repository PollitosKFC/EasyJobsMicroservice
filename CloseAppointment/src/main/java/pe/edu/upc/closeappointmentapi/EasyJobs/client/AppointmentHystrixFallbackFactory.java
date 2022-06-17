package pe.edu.upc.closeappointmentapi.EasyJobs.client;

import org.springframework.http.ResponseEntity;
import pe.edu.upc.closeappointmentapi.EasyJobs.entity.Appointment;

import java.util.Date;

public class AppointmentHystrixFallbackFactory implements AppointmentClient {

    @Override
    public ResponseEntity<Appointment> getAppointmentResponse(Long id) {
        Appointment appointment = Appointment.builder()
                .appointment_history(null)
                .customer(null)
                .createdDate(new Date())
                .name("no-name")
                .startDate(new Date())
                .status("no-status")
                .delete(false)
                .technician(null)
                .updateDate(new Date())
                .build();
        return ResponseEntity.ok(appointment);
    }
}
