package ma.enset.tpspringmvcspringdatajpathymeleaf.security.service;

import ma.enset.tpspringmvcspringdatajpathymeleaf.security.entities.AppRole;
import ma.enset.tpspringmvcspringdatajpathymeleaf.security.entities.AppUser;

public interface AccountService {
    AppUser addNewUser(String username, String password, String confirmedPassword);
    AppRole addNewRole(String role);
    void addRoleToUser(String username, String roleName);
    void removeRoleFromUser(String username, String roleName);
    AppUser loadUserByUsername(String username);

}