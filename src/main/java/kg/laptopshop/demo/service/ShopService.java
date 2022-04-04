package kg.laptopshop.demo.service;

import kg.laptopshop.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopService
        extends JpaRepository<Product, Integer> {
    Product findByDescription(String description);
}
