package kg.laptopshop.demo.service;

import kg.laptopshop.demo.entity.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationService
        extends JpaRepository<ApplicationUser, Long> {

}
