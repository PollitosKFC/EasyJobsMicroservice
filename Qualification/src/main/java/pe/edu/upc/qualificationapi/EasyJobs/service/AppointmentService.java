package pe.edu.upc.qualificationapi.EasyJobs.service;

import org.springframework.stereotype.Service;
import pe.edu.upc.qualificationapi.EasyJobs.entity.Appointment;
import pe.edu.upc.qualificationapi.EasyJobs.entity.Customer;
import pe.edu.upc.qualificationapi.EasyJobs.entity.Technician;

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
