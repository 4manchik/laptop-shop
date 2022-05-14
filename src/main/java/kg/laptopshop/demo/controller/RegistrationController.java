package kg.laptopshop.demo.controller;

import kg.laptopshop.demo.entity.ApplicationUser;
import kg.laptopshop.demo.service.RegistrationServiceUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    private final RegistrationServiceUser registrationServiceUser;

    public RegistrationController(RegistrationServiceUser registrationServiceUser) {
        this.registrationServiceUser = registrationServiceUser;
    }

    @GetMapping
    public String getFormRegister(Model model) {
        model.addAttribute("applicationUser", new ApplicationUser());
        return "user_form_register";
    }

    @PostMapping
    public String addNewUser(@ModelAttribute ApplicationUser applicationUser) {
        try {
            registrationServiceUser.saveApplicationUser(applicationUser);
        } catch (Exception e) {
            return "error_registration";
        }
        return "redirect:/user_form_register";
    }
}
