package dev.waddadelmehdi.billingservice;

import dev.waddadelmehdi.billingservice.dao.entities.Bill;
import dev.waddadelmehdi.billingservice.dao.entities.ProductItem;
import dev.waddadelmehdi.billingservice.dao.feign.CustomerRestClient;
import dev.waddadelmehdi.billingservice.dao.feign.ProductRestClient;
import dev.waddadelmehdi.billingservice.dao.model.Customer;
import dev.waddadelmehdi.billingservice.dao.model.Product;
import dev.waddadelmehdi.billingservice.dao.repositories.BillRepository;
import dev.waddadelmehdi.billingservice.dao.repositories.ProductItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Collection;
import java.util.Date;
import java.util.Random;

@EnableFeignClients
@SpringBootApplication
public class BillingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(BillRepository  billRepository, ProductItemRepository  productItemRepository, CustomerRestClient customerRestClient,
                                        ProductRestClient  productRestClient) {

        return args -> {
            Collection<Customer> customers = customerRestClient.getAllCustomers().content();
            Collection<Product> products = productRestClient.getAllProducts().content();


            customers.forEach(customer -> {
                Bill bill = Bill.builder()
                        .billingDate(new Date())
                        .customerId(customer.getId())
                        .build();
                billRepository.save(bill);
                products.forEach(product -> {
                    ProductItem productItem = ProductItem.builder()
                            .bill(bill)
                            .productId(product.getId())
                            .quantity(new Random().nextInt(10))
                            .unitPrice(product.getPrice())
                            .build();
                    productItemRepository.save(productItem);
                });
            });
        };
    }

}
