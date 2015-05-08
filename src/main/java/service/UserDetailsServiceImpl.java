package service;

import dao.UserRepository;
import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by macbookpro on 5/7/15.
 */
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        return buildUserDetails(user);
    }

    private org.springframework.security.core.userdetails.User buildUserDetails(User user) {
        boolean enabled = user.getEnabled() == 1;
        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        String userRole = user.getRole();
        if (userRole.toLowerCase().equals("user")) {
            authorities.add(new SimpleGrantedAuthority(
                    "ROLE_USER"));
        } else if (userRole.toLowerCase().equals("admin")) {
            authorities.add(new SimpleGrantedAuthority(
                    "ROLE_USER"));
            authorities.add(new SimpleGrantedAuthority(
                    "ROLE_ADMIN"));
        }

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                enabled, true, true, true, authorities);
    }
}
