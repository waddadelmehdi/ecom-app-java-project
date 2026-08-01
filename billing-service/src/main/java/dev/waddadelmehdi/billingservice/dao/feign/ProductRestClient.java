package dev.waddadelmehdi.billingservice.dao.feign;

import dev.waddadelmehdi.billingservice.dao.model.HalPage;
import dev.waddadelmehdi.billingservice.dao.model.PageResponse;
import dev.waddadelmehdi.billingservice.dao.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.web.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "product-service")
public interface ProductRestClient {

    @GetMapping("/api/products/{id}")
    Product getProductById(@PathVariable String id);

    @GetMapping("/api/products")
    HalPage<Product> getAllProducts();
}