package com.amigos;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerApi {

    private final CustomerRepository customerRepository;

    public CustomerApi(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @PostMapping
    public void postNewCustomer(@RequestBody AddNewCustomer addNewCustomer) {
        Customer customer = new Customer();
        customer.setAge(addNewCustomer.age()); // Use getters instead of method calls
        customer.setEmail(addNewCustomer.email());
        customer.setSavings(addNewCustomer.savings());
        customer.setName(addNewCustomer.name());
        customerRepository.saveAndFlush(customer);
    }

    @DeleteMapping("{customerId}")
    public void deleteCustomer(@PathVariable("customerId") Integer id) {
        customerRepository.deleteById(id);
    }

    @PutMapping("{customerId}") // Use @PutMapping for updates
    public void updateCustomer(@RequestBody AddNewCustomer addNewCustomer, @PathVariable("customerId") Integer id) {
        Customer existingCustomer = customerRepository.findById(id).orElseThrow();
        existingCustomer.setAge(addNewCustomer.age());
        existingCustomer.setEmail(addNewCustomer.email());
        existingCustomer.setSavings(addNewCustomer.savings());
        existingCustomer.setName(addNewCustomer.name());
        customerRepository.saveAndFlush(existingCustomer);
    }

    record AddNewCustomer(
            String name,
            int age,
            String email,
            double savings
    ) {}
}
