package ma.enset.tpspringmvcspringdatajpathymeleaf;

import ma.enset.tpspringmvcspringdatajpathymeleaf.entitites.Patient;
import ma.enset.tpspringmvcspringdatajpathymeleaf.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;


import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class TpSpringMvcSpringDataJpaThymeleafApplication implements CommandLineRunner {
	@Autowired
	PatientRepository patientRepository;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	public static void main(String[] args) {
		SpringApplication.run(TpSpringMvcSpringDataJpaThymeleafApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// patientRepository.save(new Patient(null,"aitchrif",sdf.parse("2005-02-16"),true,16));
		//
		// patientRepository.save(new Patient(null,"aitchrif2",sdf.parse("2005-03-16"),false,20));
		// patientRepository.save(new Patient(null,"lucas",sdf.parse("2005-04-16"),false,30));
	}

	@Bean
	CommandLineRunner commandLineRunner(JdbcUserDetailsManager userDetailsManager) {
		return args -> {
			userDetailsManager.createUser(
					org.springframework.security.core.userdetails.User.withUsername("user")
							.password(passwordEncoder().encode("1234"))
							.roles("USER")
							.build()
			);
			userDetailsManager.createUser(
					org.springframework.security.core.userdetails.User.withUsername("admin")
							.password(passwordEncoder().encode("1234"))
							.roles("USER", "ADMIN")
							.build()
			);
		};


	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}