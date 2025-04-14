package ma.enset.tpspringmvcspringdatajpathymeleaf.repository;

import ma.enset.tpspringmvcspringdatajpathymeleaf.entitites.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {

}
