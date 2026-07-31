package dev.waddadelmehdi.productservice.dao.repositories;



import dev.waddadelmehdi.productservice.dao.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product, String> {
}