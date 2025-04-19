package ma.enset.tpspringmvcspringdatajpathymeleaf.entitites;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Data  @Builder
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    @Size(min = 4, max = 50)
    private String nom;
 //@Temporal(TemporalType.DATE)
 //@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateNaissance;
    private Boolean malade;
    @DecimalMin("10")
    private int score;


    public Patient(Long id, String nom, Date dateNaissance, Boolean malade, int score) {
        this.score = score;
        this.malade = malade;
        this.dateNaissance = dateNaissance;
        this.nom = nom;
        this.id = id;
    }

    public Patient() {
    }
    public String toString(){
        System.out.println("Nom: " + nom);
        System.out.println("Date Naissance: " + dateNaissance);
        System.out.println("Malade: " + malade);
        System.out.println("Score: " + score);


        return null;
    }
}
