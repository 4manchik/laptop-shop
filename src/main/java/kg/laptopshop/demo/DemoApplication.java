package kg.laptopshop.demo;

import kg.laptopshop.demo.entity.ApplicationUser;
import kg.laptopshop.demo.entity.Product;
import kg.laptopshop.demo.service.RegistrationService;
import kg.laptopshop.demo.service.ShopService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.File;
import java.nio.file.Files;

import static kg.laptopshop.demo.security.ApplicationUserRole.ADMIN;
import static kg.laptopshop.demo.security.ApplicationUserRole.USER;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    //@Bean
    public CommandLineRunner run(RegistrationService registrationService,
                                 ShopService shopService,
                                 PasswordEncoder passwordEncoder) {
        return args -> {
            for(int i = 1; i <= 6; i++) {
                Product product = new Product();
                product.setModelLaptop("model " + i);
                product.setCompany("Company " + i);
                product.setDiagonal(new Double(i));
                product.setCpu("CPU " + i);
                product.setHardDiskType("SSD " + i);
                product.setOperatingSystem("Windows " + i);
                product.setAmountRam(new Long(i));
                product.setStorageCapacity(new Long(i));
                product.setPrice(new Double(i));
                File file = new File("./images/product-" + i + ".jpg");
                byte[] fileContent = Files.readAllBytes(file.toPath());
                product.setImage(fileContent);
                shopService.save(product);
            }

            ApplicationUser userAdmin = new ApplicationUser(
                    "admin",
                    passwordEncoder.encode("456"),
                    true,
                    "Admin1",
                    "Admin1",
                    "+996000123456",
                    ADMIN.getGrantedAuthority()
            );

            ApplicationUser user1 = new ApplicationUser(
                    "user",
                    passwordEncoder.encode("789"),
                    true,
                    "User1",
                    "User1",
                    "+996123456789",
                    USER.getGrantedAuthority()
            );

            registrationService.save(userAdmin);
            registrationService.save(user1);
        };
    }

}
