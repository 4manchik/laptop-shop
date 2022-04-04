package kg.laptopshop.demo.controller;

import kg.laptopshop.demo.entity.Product;
import kg.laptopshop.demo.service.ShopService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping("/api/management/shop/product")
public class AdminShopProduct {

    private final ShopService shopService;

    public AdminShopProduct(ShopService shopService) {
        this.shopService = shopService;
    }

    @GetMapping
    public String getShopProduct() {
        return "product_shop";
    }

    @PostMapping
    @ResponseBody
    public void saveDeveloper(
            @RequestParam MultipartFile file,
            @RequestParam Map<String, String> data) throws IOException {
        System.out.println(data);
        System.out.println(file.getSize());

        Product product = new Product();
        product.setDescription(data.get("description"));
        product.setPrice(Double.parseDouble(data.get("price")));
        product.setImage(file.getBytes());
        shopService.save(product);
    }
}
