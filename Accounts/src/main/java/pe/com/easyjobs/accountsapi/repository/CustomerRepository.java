package pe.com.easyjobs.accountsapi.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.com.easyjobs.accountsapi.entity.Customer;

import java.util.List;
@Qualifier("customerRepository")
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    //Customer listCustomerbyId(Long id);
    //List<Customer> listAllCustomers();
    Customer findCustomerById(Long id);

    @Query(value ="SELECT c FROM Customer c WHERE c.activated = true")
    List<Customer> findAllCustomer();
}
