package dev.waddadelmehdi.productservice;

import dev.waddadelmehdi.productservice.dao.entities.Product;
import dev.waddadelmehdi.productservice.dao.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class ProductServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ProductRepository productRepository) {
        return args -> {
            productRepository.save(Product.builder()
                    .id(UUID.randomUUID().toString())
                    .name("Laptop")
                    .price(8999)
                    .quantity(15)
                    .build());
            productRepository.save(Product.builder()
                    .id(UUID.randomUUID().toString())
                    .name("Smartwatch")
                    .price(1899)
                    .quantity(20)
                    .build());
            productRepository.save(Product.builder()
                    .id(UUID.randomUUID().toString())
                    .name("4K Monitor")
                    .price(5400)
                    .quantity(12)
                    .build());

            productRepository.findAll().forEach(p -> {
                System.out.println(p.getName());
                System.out.println(p.getPrice());
                System.out.println("--------------");
            });
        };
    }

}
