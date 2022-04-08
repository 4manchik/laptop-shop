package kg.laptopshop.demo;

import kg.laptopshop.demo.entity.Product;
import kg.laptopshop.demo.service.ShopService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.File;
import java.nio.file.Files;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(ShopService shopService) {
        return args -> {
            for(int i = 1; i <= 6; i++) {
                Product product = new Product();
                product.setDescription("description " + i);
                product.setPrice(new Double(i));
                File file = new File("./images/product-" + i + ".jpg");
                byte[] fileContent = Files.readAllBytes(file.toPath());
                product.setImage(fileContent);
                shopService.save(product);
            }
        };
    }

}
