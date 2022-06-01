package pe.edu.upc.closeappointmentapi.EasyJobs.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.closeappointmentapi.EasyJobs.entity.Customer;


@Qualifier("customerRepository")
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
