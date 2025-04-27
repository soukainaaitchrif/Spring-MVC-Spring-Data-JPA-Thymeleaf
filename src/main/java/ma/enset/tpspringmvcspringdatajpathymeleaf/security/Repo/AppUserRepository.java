package ma.enset.tpspringmvcspringdatajpathymeleaf.security.Repo;

import ma.enset.tpspringmvcspringdatajpathymeleaf.security.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    // This interface is empty because it extends JpaRepository
    // which provides all the necessary CRUD operations.
    // You can add custom query methods if needed.
    AppUser findByUsername(String username);

}
