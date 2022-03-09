package com.fptxurdinaga.springbootmvc.controllers.onetoone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fptxurdinaga.springbootmvc.domain.onetoone.Phone;
import com.fptxurdinaga.springbootmvc.domain.onetoone.PhoneDetails;
import com.fptxurdinaga.springbootmvc.repositories.onetoone.PhoneDetailsRepository;
import com.fptxurdinaga.springbootmvc.repositories.onetoone.PhoneRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/phones")
public class PhoneController {

    Logger logger = LoggerFactory.getLogger(PhoneController.class);
    List<Phone> phones;
    @Autowired
    private PhoneRepository phoneRepository;
    @Autowired
    private PhoneDetailsRepository phoneDetailsRepository;

    PhoneController(){
        this.phones = new ArrayList<>();
    }

    @GetMapping()
    public String lista(Model modelo) {
        List<Phone> phones = phoneRepository.findAll();
        modelo.addAttribute("phones", phones);
        return "listadophone";

    }

    @GetMapping("/insert")
    public String insert(Model modelo) {
        Integer actualSize= phoneRepository.findAll().size();
        logger.trace("/mvchola/insert: actualSize="+actualSize);
        if ( actualSize.equals(0)){

            Phone phone = new Phone();
            phone.setNumber("923123456");
            PhoneDetails phoneDetails = new PhoneDetails();
            phoneDetails.setProvider("VodaPhone");
            phoneDetailsRepository.save(phoneDetails);
            phone.setDetails(phoneDetails);
            phoneRepository.save(phone);
            System.out.println("/mvchola/insert: phone="+phone);
        }
        List<Phone> listado = phoneRepository.findAll();
        modelo.addAttribute("phones", listado);
        return "listadophone";

    }

    @GetMapping("/show/{id}")
    public String insert(Model modelo, @PathVariable("id") Long id) {
        Optional<Phone> phone = this.phoneRepository.findById(id);
        if (phone.isPresent()){
            Phone phoneRegistry = phone.get();
            logger.trace(phoneRegistry.toString());
            modelo.addAttribute("phone", phone.get());
        }else{
            modelo.addAttribute("phone", new Phone());
        }

        return "phones/show";

    }

    @GetMapping("/update/{id}")
    public String udpate(Model modelo, @PathVariable("id") Long id) {
        Optional<Phone> phone = this.phoneRepository.findById(id);
        if (phone.isPresent()){
            Phone phoneRegistry = phone.get();
            logger.trace(phoneRegistry.toString());
            phoneRegistry.setNumber("945123456");
            phoneRegistry.getDetails().setProvider("Movistar");
            phoneRepository.save(phoneRegistry);
            modelo.addAttribute("phone", phoneRegistry);
        }else{
            modelo.addAttribute("phone", new Phone());
        }
        return "phones/show";

    }

    @GetMapping("/delete/{id}")
    public String delete(Model modelo, @PathVariable("id") Long id) {
        Optional<Phone> phone = this.phoneRepository.findById(id);
        if (phone.isPresent()){
            Phone phoneRegistry = phone.get();
            logger.trace(phoneRegistry.toString());
            phoneRepository.delete(phoneRegistry);
            modelo.addAttribute("phone", phoneRegistry);
        }else{
            modelo.addAttribute("phone", new Phone());
        }

        return "phones/show";

    }



}
