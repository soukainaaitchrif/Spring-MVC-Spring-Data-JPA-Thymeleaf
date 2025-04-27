package ma.enset.tpspringmvcspringdatajpathymeleaf.security.service;

import ma.enset.tpspringmvcspringdatajpathymeleaf.security.Repo.AppUserRepository;
import ma.enset.tpspringmvcspringdatajpathymeleaf.security.entities.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.stream.Collectors;

public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private AppUserRepository appUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = appUserRepository.findByUsername(username);
        if (appUser == null) {
            throw new UsernameNotFoundException("User not found");}
        UserDetails userDetails = User.withUsername(username)
                .password(appUser.getPassword())
                .roles(appUser.getRoles().stream()
                        .map(role -> role.getRole())
                        .toArray(String[]::new))
                .authorities(appUser.getRoles().stream()
                        .map(role -> new SimpleGrantedAuthority(role.getRole()))
                        .collect(Collectors.toList()))
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(false)
                .build();

        return new User(appUser.getUsername(), appUser.getPassword(), appUser.getRoles());
    }
}