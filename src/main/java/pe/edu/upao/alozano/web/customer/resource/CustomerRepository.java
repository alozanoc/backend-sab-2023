package pe.edu.upao.alozano.web.customer.resource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upao.alozano.web.customer.domain.Customer;


public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
