package kg.laptopshop.demo.security;

//import jdk.internal.jmod.JmodFile;
import kg.laptopshop.demo.service.RegistrationServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

import static kg.laptopshop.demo.security.ApplicationUserRole.ADMIN;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurity extends WebSecurityConfigurerAdapter {

//    private final PasswordEncoder passwordEncoder;
//    private final RegistrationServiceUser registrationServiceUser;
//
//    //@Autowired
//    public ApplicationSecurity(PasswordEncoder passwordEncoder,
//                               RegistrationServiceUser registrationServiceUser) {
//        this.passwordEncoder = passwordEncoder;
//        this.registrationServiceUser = registrationServiceUser;
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/shop/**", "/register", "/img/**", "/css/**", "/js/**", "/style.css").permitAll()
//                .antMatchers(HttpMethod.GET,"/api/**").hasAnyRole(ADMIN.name())
//                .antMatchers(HttpMethod.POST,"/api/**").hasAnyRole(ADMIN.name())
                .antMatchers("/api/management/shop/product").hasAnyRole(ADMIN.name())
                .anyRequest()
                .authenticated()
                .and()
                .formLogin().loginPage("/login").permitAll()
        ;
    }

    @Autowired
    public void initialize(
                    AuthenticationManagerBuilder auth,
                    DataSource dataSource) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource);
    }

//    @Bean
//    public DaoAuthenticationProvider daoAuthenticationProvider() {
//        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//        provider.setPasswordEncoder(passwordEncoder);
//        //provider.setUserDetailsService(registrationServiceUser);
//        return provider;
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }
}
