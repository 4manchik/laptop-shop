package kg.laptopshop.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "authorities")
public class ApplicationUserAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    private String userName;
    @Column(name = "authority")
    private String authority;

    @OneToOne(mappedBy = "authority")
    private ApplicationUser user;


    public ApplicationUserAuthority() {
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

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public ApplicationUser getUser() {
        return user;
    }

    public void setUser(ApplicationUser user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "ApplicationUserAuthority{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", authority='" + authority + '\'' +
                ", user=" + user +
                '}';
    }
}
