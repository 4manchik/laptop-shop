package kg.laptopshop.demo.service.impl;

import kg.laptopshop.demo.entity.ApplicationUser;
import kg.laptopshop.demo.entity.ApplicationUserAuthority;
import kg.laptopshop.demo.service.RegistrationService;
import kg.laptopshop.demo.service.RegistrationServiceUser;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegistrationServiceUserImpl implements RegistrationServiceUser {

    private final RegistrationService registrationService;
    private final PasswordEncoder passwordEncoder;

    public RegistrationServiceUserImpl(RegistrationService registrationService, PasswordEncoder passwordEncoder) {
        this.registrationService = registrationService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public ApplicationUser saveApplicationUser(ApplicationUser user) {

        if(user.getAuthority() == null) {
            ApplicationUserAuthority authority = new ApplicationUserAuthority();
            authority.setUserName(user.getUserName());
            // надо переделать
            authority.setAuthority("USER_ROLE");

            String password = passwordEncoder.encode(user.getPassword());

            user.setPassword(password);
            user.setEnabled(true);
            user.setAuthority(authority);
        }

        return registrationService.save(user);
    }
}
