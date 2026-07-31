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
                    .name("Computer")
                    .price(3200)
                    .quantity(11)
                    .build());
            productRepository.save(Product.builder()
                    .id(UUID.randomUUID().toString())
                    .name("Printer")
                    .price(1299)
                    .quantity(10)
                    .build());
            productRepository.save(Product.builder()
                    .id(UUID.randomUUID().toString())
                    .name("Smart Phone")
                    .price(5400)
                    .quantity(8)
                    .build());

            productRepository.findAll().forEach(p -> {
                System.out.println(p.getName());
                System.out.println(p.getPrice());
                System.out.println("--------------");
            });
        };
    }

}
