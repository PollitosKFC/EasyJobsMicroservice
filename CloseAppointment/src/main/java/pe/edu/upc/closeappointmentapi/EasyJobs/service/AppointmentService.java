package pe.edu.upc.closeappointmentapi.EasyJobs.service;

import org.springframework.stereotype.Service;
import pe.edu.upc.closeappointmentapi.EasyJobs.entity.Appointment;
import pe.edu.upc.closeappointmentapi.EasyJobs.entity.Customer;
import pe.edu.upc.closeappointmentapi.EasyJobs.entity.Technician;

import java.util.List;

@Service
public interface AppointmentService {
    Appointment createAppointment(Appointment appointment, Long customerId, Long technicianId);
    List<Appointment> getAllAppointments();

    Technician createTechnician(Technician technician);
    List<Technician> getAllTechnicians();

    Customer createCustomer(Customer customer);
    List< Customer> getAllCustomers();
}
