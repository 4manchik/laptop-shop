package kg.laptopshop.demo.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class ApplicationUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "username", unique=true)
    private String userName;
    @Column(name = "password")
    private String password;
    @Column(name = "enabled")
    private Boolean enabled;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_authority", referencedColumnName = "id")
    private ApplicationUserAuthority authority;

    @ElementCollection(targetClass = SimpleGrantedAuthority.class, fetch = FetchType.EAGER)
    private Set<? extends GrantedAuthority> grantedAuthorities;

    public ApplicationUser() {
    }

    public ApplicationUser(String userName,
                           String password,
                           Boolean enabled,
                           String firstName,
                           String lastName,
                           String phoneNumber,
                           Set<? extends GrantedAuthority> grantedAuthorities) {
        this.userName = userName;
        this.password = password;
        this.enabled = enabled;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.grantedAuthorities = grantedAuthorities;
    }

    public Set<? extends GrantedAuthority> getGrantedAuthorities() {
        return grantedAuthorities;
    }

    public void setGrantedAuthorities(Set<? extends GrantedAuthority> grantedAuthorities) {
        this.grantedAuthorities = grantedAuthorities;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public ApplicationUserAuthority getAuthority() {
        return authority;
    }

    public void setAuthority(ApplicationUserAuthority authority) {
        this.authority = authority;
    }

    @Override
    public String toString() {
        return "ApplicationUser{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
