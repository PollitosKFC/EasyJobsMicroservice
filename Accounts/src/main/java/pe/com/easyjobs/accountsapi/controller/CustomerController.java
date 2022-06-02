package pe.com.easyjobs.accountsapi.controller;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pe.com.easyjobs.accountsapi.entity.Customer;
import pe.com.easyjobs.accountsapi.resource.CustomerResource;
import pe.com.easyjobs.accountsapi.resource.SaveCustomerResource;
import pe.com.easyjobs.accountsapi.service.CustomerService;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping(value = "/createCustomer")
    public CustomerResource createCustomer(@RequestBody SaveCustomerResource customer){
        Customer customerCreated = customerService.createCustomer(convertToEntity(customer));
        return convertToResource(customerCreated);
    }

    @GetMapping(value = "/getAllCustomers")
    public List<CustomerResource> getAllCustomers(){
        List<Customer> customers = customerService.getAllCustomers();
        if (customers == null) {
            return null;
        }
        List<CustomerResource> customerResourceList = customers.stream().map(customer -> {
            return convertToResource(customer);
        }).collect(Collectors.toList());
        return customerResourceList;
    }

    @GetMapping(value = "/getCustomerById/{id}")
    public CustomerResource getCustomerById(@PathVariable("id") Long id){
        Customer customer = customerService.getByCustomerId(id);
        if (customer == null) {
            return null;
        }
        return convertToResource(customer);
    }

    @PutMapping(value = "/updateCustomer/{id}")
    public CustomerResource updateCustomer(@PathVariable("id") Long id, @RequestBody SaveCustomerResource customer){
        Customer customerUpdated = customerService.updateCustomer(id, convertToEntity(customer));
        return convertToResource(customerUpdated);
    }

    @DeleteMapping(value = "/deleteCustomer/{id}")
    public CustomerResource deleteCustomer(@PathVariable("id") Long id){
        Customer customerDeleted = customerService.deleteCustomer(id);
        return convertToResource(customerDeleted);
    }

    private Customer convertToEntity(SaveCustomerResource resource){
        return modelMapper.map(resource, Customer.class);
    }
    private CustomerResource convertToResource(Customer entity) {
        return modelMapper.map(entity, CustomerResource.class);
    }

}

