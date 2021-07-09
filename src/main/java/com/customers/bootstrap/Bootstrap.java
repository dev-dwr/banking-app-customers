package com.customers.bootstrap;

import com.customers.domain.Customer;
import com.customers.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Bootstrap implements CommandLineRunner {

    private final CustomerRepository customerRepository;

    @Override
    public void run(String... args) throws Exception {
        loadCustomers();
    }
    private void loadCustomers(){
        Customer customer1 = new Customer();
        customer1.setCustomerId(2121L);
        customer1.setFirstName("Jakub");
        customer1.setLastName("White");
        customerRepository.save(customer1);

        Customer customer2 = new Customer();
        customer2.setCustomerId(1234L);
        customer2.setFirstName("Julian");
        customer2.setLastName("Black");
        customerRepository.save(customer2);


        Customer customer3 = new Customer();
        customer3.setCustomerId(321L);
        customer3.setFirstName("Kate");
        customer3.setLastName("Green");
        customerRepository.save(customer3);

        System.out.println("Customers Loaded: " + customerRepository.count());
    }
}
