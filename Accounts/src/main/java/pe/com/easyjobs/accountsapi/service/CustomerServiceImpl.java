package pe.com.easyjobs.accountsapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pe.com.easyjobs.accountsapi.entity.Customer;
import pe.com.easyjobs.accountsapi.repository.CustomerRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer getByCustomerId(Long id) {
        Customer customer = customerRepository.findCustomerById(id);
        if (customer == null|| customer.getActivated() == false) {
            throw new RuntimeException("Customer not found");
        }
        return customerRepository.findCustomerById(id);
    }

    @Override
    public Customer createCustomer(Customer customer) {
        Customer newCustomer = new Customer();
        newCustomer.setUserName(customer.getUserName());
        newCustomer.setRegisterDate(new Date());
        newCustomer.setUpdatedDate(new Date());
        newCustomer.setFirstName(customer.getFirstName());
        newCustomer.setLastName(customer.getLastName());
        newCustomer.setEmail(customer.getEmail());
        newCustomer.setPassword(customer.getPassword());
        newCustomer.setPhoneNumber(customer.getPhoneNumber());
        newCustomer.setAddress(customer.getAddress());
        newCustomer.setCity(customer.getCity());
        newCustomer.setDistrict(customer.getDistrict());
        newCustomer.setGender(customer.getGender());
        newCustomer.setType("CUSTOMER");
        newCustomer.setActivated(true);
        return customerRepository.save(newCustomer);
    }

    @Override
    public Customer updateCustomer(Long id, Customer customer) {
        Customer customerToUpdate = customerRepository.findCustomerById(id);
        if(customerToUpdate == null || customerToUpdate.getActivated() == false){
            return null;
        }
        customerToUpdate.setUpdatedDate(new Date());
        customerToUpdate.setEmail(customer.getEmail());
        customerToUpdate.setPassword(customer.getPassword());
        customerToUpdate.setFirstName(customer.getFirstName());
        customerToUpdate.setUserName(customer.getUserName());
        customerToUpdate.setLastName(customer.getLastName());
        customerToUpdate.setPhoneNumber(customer.getPhoneNumber());
        customerToUpdate.setAddress(customer.getAddress());
        customerToUpdate.setCity(customer.getCity());
        customerToUpdate.setDistrict(customer.getDistrict());
        customerToUpdate.setGender(customer.getGender());
        return customerRepository.save(customerToUpdate);
    }

    @Override
    public Customer deleteCustomer(Long id) {
        Customer customerToDeactivate = customerRepository.getById(id);
        if(customerToDeactivate == null|| customerToDeactivate.getActivated() == false) {
            return null;
        }
        customerToDeactivate.setActivated(false);
        return customerRepository.save(customerToDeactivate);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAllCustomer();
    }

}
