package kg.laptopshop.demo.controller;

import kg.laptopshop.demo.entity.Product;
import kg.laptopshop.demo.service.ShopService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Controller
@RequestMapping("/shop")
public class ShopController {

    private final ShopService shopService;

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @GetMapping
    public String getShop(Model model) {
        List<Product> productList = shopService.findAll();
        model.addAttribute("productList", productList);
        model.addAttribute("imgUtil", new ImageUtil());
        return "shop";
    }

    public class ImageUtil {
        public String getImgData(byte[] byteData) {
            return Base64.getMimeEncoder().encodeToString(byteData);
        }
    }
}
