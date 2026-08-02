package dev.waddadelmehdi.billingservice.web;

import dev.waddadelmehdi.billingservice.dao.entities.Bill;
import dev.waddadelmehdi.billingservice.dao.feign.CustomerRestClient;
import dev.waddadelmehdi.billingservice.dao.feign.ProductRestClient;
import dev.waddadelmehdi.billingservice.dao.repositories.BillRepository;
import dev.waddadelmehdi.billingservice.dao.repositories.ProductItemRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillRestController {


    private CustomerRestClient customerRestClient;
    private ProductRestClient productRestClient;
    private BillRepository billRepository;
    private ProductItemRepository productItemRepository;

    public BillRestController(BillRepository billRepository, ProductItemRepository productItemRepository, CustomerRestClient customerRestClient, ProductRestClient productRestClient) {
        this.billRepository = billRepository;
        this.productItemRepository = productItemRepository;
        this.customerRestClient = customerRestClient;
        this.productRestClient = productRestClient;
    }


    @GetMapping(path = "/bills/{id}")
    public Bill getBill(@PathVariable Long id){
        Bill bill = billRepository.findById(id).get();
        bill.setCustomer(customerRestClient.getCustomerById(bill.getCustomerId()));
        bill.getProductItems().forEach(productItem -> {
            productItem.setProduct(productRestClient.getProductById(productItem.getProductId()));
        });
        return bill;

    };
    @GetMapping(path = "/bills")
    public Iterable<Bill> getBills() {

        Iterable<Bill> bills = billRepository.findAll();

        bills.forEach(bill -> {

            bill.setCustomer(
                    customerRestClient.getCustomerById(
                            bill.getCustomerId()
                    )
            );

            bill.getProductItems().forEach(productItem -> {

                productItem.setProduct(
                        productRestClient.getProductById(
                                productItem.getProductId()
                        )
                );
            });
        });

        return bills;
    }
}