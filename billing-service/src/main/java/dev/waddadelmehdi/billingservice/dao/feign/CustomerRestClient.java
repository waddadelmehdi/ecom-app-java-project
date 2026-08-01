package dev.waddadelmehdi.billingservice.dao.feign;

import dev.waddadelmehdi.billingservice.dao.model.Customer;
import dev.waddadelmehdi.billingservice.dao.model.HalPage;
import dev.waddadelmehdi.billingservice.dao.model.PageResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.web.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "customer-service")
public interface CustomerRestClient {

    @GetMapping("/api/customers/{id}")
    Customer getCustomerById(@PathVariable Long id);

    @GetMapping("/api/customers")
    HalPage<Customer> getAllCustomers();
}