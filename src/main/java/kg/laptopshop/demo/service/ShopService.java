package kg.laptopshop.demo.service;

import kg.laptopshop.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShopService extends JpaRepository<Product, Long> {
//    Product findByDescription(String description);
    Optional<Product> findById(Long id);
}
