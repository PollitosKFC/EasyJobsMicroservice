package pe.edu.upc.closeappointmentapi.EasyJobs.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.closeappointmentapi.EasyJobs.entity.Customer;
import pe.edu.upc.closeappointmentapi.EasyJobs.resource.CustomerResource;
import pe.edu.upc.closeappointmentapi.EasyJobs.resource.SaveCustomerResource;
import pe.edu.upc.closeappointmentapi.EasyJobs.service.AppointmentService;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RestController
@CrossOrigin(origins = "http://localhost:3306")
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping(value = "/createCustomer")
    public CustomerResource createCustomer(@RequestBody SaveCustomerResource customer){
        Customer customerCreated = appointmentService.createCustomer(convertToEntity(customer));
        return convertToResource(customerCreated);
    }

    @GetMapping(value = "/getAllCustomers")
    public List<CustomerResource> getAllCustomers(){
        List<Customer> customers = appointmentService.getAllCustomers();
        if (customers == null) {
            return null;
        }
        List<CustomerResource> customerResourceList = customers.stream().map(customer -> {
            return convertToResource(customer);
        }).collect(Collectors.toList());
        return customerResourceList;
    }
    @GetMapping(value = "/findCustomerById/{id}")
    public CustomerResource getCustomerById(@PathVariable("id") Long id){
        Customer customer = appointmentService.getCustomerById(id);
        if (customer == null) {
            return null;
        }
        return convertToResource(customer);
    }
    private Customer convertToEntity(SaveCustomerResource resource){
        return modelMapper.map(resource, Customer.class);
    }
    private CustomerResource convertToResource(Customer entity) {
        return modelMapper.map(entity, CustomerResource.class);
    }
}
