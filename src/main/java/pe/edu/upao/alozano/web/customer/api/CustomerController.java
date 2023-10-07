package pe.edu.upao.alozano.web.customer.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upao.alozano.web.customer.domain.Customer;
import pe.edu.upao.alozano.web.customer.mappers.CustomerSaveRequest;
import pe.edu.upao.alozano.web.customer.mappers.CustomSaveResponse;
import pe.edu.upao.alozano.web.customer.mappers.CustomerSerializer;
import pe.edu.upao.alozano.web.customer.resource.CustomerRepository;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "https://sabado-2023.netlify.app"})
public class CustomerController {

    @Autowired private CustomerRepository customerRepository;

    @GetMapping("/customer")
    List<CustomerSerializer> list() {
        return customerRepository.findAll().stream().map(
                (it) -> new CustomerSerializer(it.getId(), it.getName()))
                .toList();
    }

    @PostMapping("/customer")
    CustomSaveResponse save(@RequestBody CustomerSaveRequest customerSaveRequest) {
        Customer customer = new Customer(null, customerSaveRequest.getName());
        customerRepository.save(customer);
        return new CustomSaveResponse(customer.getId(), customer.getName());
    }
}
