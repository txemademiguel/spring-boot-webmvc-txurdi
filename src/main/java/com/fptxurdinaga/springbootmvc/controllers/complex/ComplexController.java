package com.fptxurdinaga.springbootmvc.controllers.complex;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fptxurdinaga.springbootmvc.domain.complex.Group;
import com.fptxurdinaga.springbootmvc.domain.complex.User;
import com.fptxurdinaga.springbootmvc.domain.complex.UserGroup;
import com.fptxurdinaga.springbootmvc.repositories.complex.GroupRepository;
import com.fptxurdinaga.springbootmvc.repositories.complex.UserGroupRepository;
import com.fptxurdinaga.springbootmvc.repositories.complex.UserRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/complex")
public class ComplexController {
    Logger logger = LoggerFactory.getLogger(ComplexController.class);
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private UserGroupRepository userGroupRepository;
    private List<User> listado;
    ComplexController(){
        this.listado = new ArrayList<>();
    }
    @GetMapping()
    public String lista(Model modelo) {
        this.listado = userRepository.findAll();
        modelo.addAttribute("listado", listado);
        return "complex/listado";

    }

    @GetMapping("/insertar")
    public String insertar(Model modelo) {

        Long actualSize=userRepository.count();
        if (actualSize.equals(0L)){
        	// si no hay datos
        	// creo los usuarios
            User user1 = new User("usuario1","password1","usuario1@fptxurdinaga.com");
            userRepository.save(user1);
            User user2 = new User("usuario2","password2","usuario2@fptxurdinaga.com");
            userRepository.save(user2);
            User user3 = new User("usuario3","password3","usuario3@fptxurdinaga.com");
            userRepository.save(user3);
            User user4 = new User("usuario4","password4","usuario4@fptxurdinaga.com");
            userRepository.save(user4);
            // creo los grupos
            Group group1 = new Group("grupo1");
            groupRepository.save(group1);
            Group group2 = new Group("grupo2");
            groupRepository.save(group2);
            Group group3 = new Group("grupo3");
            groupRepository.save(group3);
            
            // inserto registros en la tabla que relaciona User y Group
            UserGroup userGroup1 = new UserGroup();
            userGroup1.setUser(user1);
            userGroup1.setGroup(group1);
            userGroup1.setActivated(true);
            userGroup1.setRegisteredDate(new Date());
            userGroupRepository.save(userGroup1);
            UserGroup userGroup2 = new UserGroup();
            userGroup2.setUser(user2);
            userGroup2.setGroup(group3);
            userGroup2.setActivated(true);
            userGroup2.setRegisteredDate(new Date());
            userGroupRepository.save(userGroup2);
            UserGroup userGroup3 = new UserGroup();
            userGroup3.setUser(user3);
            userGroup3.setGroup(group2);
            userGroup3.setActivated(true);
            userGroup3.setRegisteredDate(new Date());
            userGroupRepository.save(userGroup3);
            UserGroup userGroup4 = new UserGroup();
            userGroup4.setUser(user4);
            userGroup4.setGroup(group1);
            userGroup4.setActivated(true);
            userGroup4.setRegisteredDate(new Date());
            userGroupRepository.save(userGroup4);
        }
        List<User> usuarios = userRepository.findAll();
        modelo.addAttribute("listado", usuarios);
        return "complex/listado";
    }
    @GetMapping("/borrar")
    public String borrar(Model modelo) {
    	Integer actualSize;
    	// borro UserGroup
        actualSize = userGroupRepository.findAll().size();
        if (actualSize > 0){
        	// si hay datos
        	// borro todos
        	userGroupRepository.deleteAll();
        }
        // borro User
        actualSize = userRepository.findAll().size();
        if (actualSize > 0){
        	// si hay datos
        	// borro todos
        	userRepository.deleteAll();
        }
        // borro Group
        actualSize = groupRepository.findAll().size();
        if (actualSize > 0){
        	// si hay datos
        	// borro todos
        	groupRepository.deleteAll();
        }
        // cargo los datos de los alumnos en el modelo
        List<User> listado = userRepository.findAll();
        modelo.addAttribute("usuarios", listado);
        // muestro el listado
        return "complex/listado";
    }
}
