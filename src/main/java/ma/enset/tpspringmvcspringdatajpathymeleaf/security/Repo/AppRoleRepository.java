package ma.enset.tpspringmvcspringdatajpathymeleaf.security.Repo;


import ma.enset.tpspringmvcspringdatajpathymeleaf.security.entities.AppRole;
import ma.enset.tpspringmvcspringdatajpathymeleaf.security.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository  extends JpaRepository<AppRole, String> {

    AppUser findByUsername(String username);
}