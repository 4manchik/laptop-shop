package kg.laptopshop.demo.security;

import com.google.common.collect.Sets;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static kg.laptopshop.demo.security.ApplicationUserPermission.ADMIN_READ;
import static kg.laptopshop.demo.security.ApplicationUserPermission.ADMIN_WRITE;
import static kg.laptopshop.demo.security.ApplicationUserPermission.USER_READ;
import static kg.laptopshop.demo.security.ApplicationUserPermission.USER_WRITE;

public enum ApplicationUserRole  implements GrantedAuthority {

    ADMIN(Sets.newHashSet(ADMIN_READ, ADMIN_WRITE)),
    USER(Sets.newHashSet(USER_READ, USER_WRITE));

    private final Set<ApplicationUserPermission> permissions;

    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<ApplicationUserPermission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthority() {
        Set<SimpleGrantedAuthority> permissions = getPermissions()
                .stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());

        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return permissions;
    }

    @Override
    public String getAuthority() {
        return name();
    }
}
