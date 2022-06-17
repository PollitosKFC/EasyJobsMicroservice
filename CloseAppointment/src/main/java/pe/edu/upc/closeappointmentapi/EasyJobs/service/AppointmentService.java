package pe.edu.upc.closeappointmentapi.EasyJobs.service;

import org.springframework.stereotype.Service;
import pe.edu.upc.closeappointmentapi.EasyJobs.entity.Appointment;
import pe.edu.upc.closeappointmentapi.EasyJobs.entity.Customer;
import pe.edu.upc.closeappointmentapi.EasyJobs.entity.Technician;

import java.util.List;

@Service
public interface AppointmentService {
    Appointment createAppointment(Appointment appointment, Long customerId, Long technicianId);
    Appointment getAppointmentById(Long id);
    List<Appointment> getAllAppointments();

    Technician createTechnician(Technician technician);
    Technician getTechnicianById(Long id);
    List<Technician> getAllTechnicians();

    Customer createCustomer(Customer customer);
    Customer getCustomerById(Long id);
    List< Customer> getAllCustomers();
}
