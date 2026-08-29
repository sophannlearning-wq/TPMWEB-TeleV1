package com.company.tpm.user;
import com.company.tpm.authorization.*; import java.util.*; import org.springframework.security.crypto.password.PasswordEncoder; import org.springframework.stereotype.Service; import org.springframework.transaction.annotation.Transactional;
@Service public class UserAdministrationService { private final AppUserRepository users; private final RoleRepository roles; private final PasswordEncoder passwords; public UserAdministrationService(AppUserRepository u,RoleRepository r,PasswordEncoder p){users=u;roles=r;passwords=p;}
 @Transactional public void changePassword(String username,String raw){if(raw==null||raw.length()<12)throw new IllegalArgumentException("Password must contain at least 12 characters");var u=users.findByUsernameIgnoreCase(username).orElseThrow(()->new IllegalArgumentException("User not found"));u.changePassword(passwords.encode(raw));}
}
