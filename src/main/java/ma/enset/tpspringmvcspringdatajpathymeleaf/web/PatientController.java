package ma.enset.tpspringmvcspringdatajpathymeleaf.web;


import lombok.AllArgsConstructor;
import ma.enset.tpspringmvcspringdatajpathymeleaf.entitites.Patient;
import ma.enset.tpspringmvcspringdatajpathymeleaf.repository.PatientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller @AllArgsConstructor
public class PatientController {
    private PatientRepository patientRepository;


    @GetMapping("/index")
    public String index(Model model, @RequestParam(name="page",defaultValue = "0") int page ,
                        @RequestParam(name="size",defaultValue = "4") int size) {
       // List<Patient> patients = patientRepository.findAll();
        Page<Patient> patients = patientRepository.findAll(PageRequest.of(page,size));

        model.addAttribute("Listpatients", patients.getContent());
        model.addAttribute("pages",new int[patients.getTotalPages()]);
        return "patients";
    }
}
