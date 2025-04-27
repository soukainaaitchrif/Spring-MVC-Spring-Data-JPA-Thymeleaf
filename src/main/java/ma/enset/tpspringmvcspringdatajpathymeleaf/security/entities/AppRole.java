package ma.enset.tpspringmvcspringdatajpathymeleaf.security.entities;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class AppRole {
    private String role;
}