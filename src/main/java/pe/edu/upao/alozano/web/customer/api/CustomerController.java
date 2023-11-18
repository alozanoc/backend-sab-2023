package pe.edu.upao.alozano.web.customer.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import pe.edu.upao.alozano.web.config.JwtRequestFilter;
import pe.edu.upao.alozano.web.customer.domain.Customer;
import pe.edu.upao.alozano.web.customer.mappers.CustomerSaveRequest;
import pe.edu.upao.alozano.web.customer.mappers.CustomSaveResponse;
import pe.edu.upao.alozano.web.customer.mappers.CustomerSerializer;
import pe.edu.upao.alozano.web.customer.resource.CustomerRepository;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "https://sabado-2023.netlify.app"})
public class CustomerController {

    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);


    @Autowired private CustomerRepository customerRepository;

    @GetMapping("/customer")
    List<CustomerSerializer> list() {
        logger.debug("Usuario que hace la peticion: " + SecurityContextHolder.getContext().getAuthentication().getPrincipal());
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
