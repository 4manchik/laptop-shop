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
    private List<Product> listRowProduct;
    private List<List<Product>> mainList;

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
        listRowProduct = new ArrayList<>();
        mainList = new ArrayList<>();
    }

    @GetMapping
    public String getShop(Model model) {
        Product product = shopService.findByDescription("s");
        System.out.println(product);
        model.addAttribute("product", product);
        model.addAttribute("imgUtil", new ImageUtil());

//        List<Product> allProductsFromDatabase = shopService.findAll();
        // Далее из allProductsFromDatabase сформировать List<List<Product>> mainList ??

//        model.addAttribute("allProducts", mainList);

//        List<List<Product>>

        return "shop";
    }

    public class ImageUtil {
        public String getImgData(byte[] byteData) {
            return Base64.getMimeEncoder().encodeToString(byteData);
        }
    }
}
