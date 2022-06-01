package pe.com.easyjobs.accountsapi.service;

import org.springframework.stereotype.Service;
import pe.com.easyjobs.accountsapi.entity.Customer;

import java.util.List;
import java.util.Optional;
@Service
public interface CustomerService {
    Customer getByCustomerId(Long id);
    Customer updateCustomer(Long id, Customer customer);
    Customer createCustomer(Customer customer);
    Customer deleteCustomer(Long id);
    List<Customer> getAllCustomers();
}
