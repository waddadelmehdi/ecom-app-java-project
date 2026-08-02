package dev.waddadelmehdi.customerservice;

import dev.waddadelmehdi.customerservice.dao.entities.Customer;
import dev.waddadelmehdi.customerservice.dao.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
        return args -> {
            customerRepository.save(Customer.builder()
                    .name("James Anderson").email("james.anderson@gmail.com")
                    .build());
            customerRepository.save(Customer.builder()
                    .name("Emily Johnson").email("emily.johnson@gmail.com")
                    .build());
            customerRepository.save(Customer.builder()
                    .name("Michael Williams").email("michael.williams@gmail.com")
                    .build());
            customerRepository.findAll().forEach(c -> {
                System.out.println("=========================");
                System.out.println(c.getId());
                System.out.println(c.getName());
                System.out.println(c.getEmail());
                System.out.println("=========================");
            });
        };
    }

}
