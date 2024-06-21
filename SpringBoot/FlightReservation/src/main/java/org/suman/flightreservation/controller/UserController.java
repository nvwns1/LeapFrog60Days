package org.suman.flightreservation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.suman.flightreservation.entities.DTO.LoginDTO;
import org.suman.flightreservation.entities.User;
import org.suman.flightreservation.repos.UserRepository;
import org.suman.flightreservation.services.SecurityService;

@CrossOrigin(origins = "http://localhost:8080") // Replace with your frontend URL

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private SecurityService securityService;

    @Autowired
    private BCryptPasswordEncoder encoder;

//    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @RequestMapping("/showReg")
    public String showRegistrationPage() {
        LOGGER.info("Inside showRegistrationPage()");
        return "login/registerUser";
    }

    @RequestMapping(value = "/registerUser", method = RequestMethod.POST)
    public String registerUser(@ModelAttribute("user") User user) {
        LOGGER.info("Inside registerUser()" + user);
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
        return "login/login";
    }

    @RequestMapping(value = "/showLogin", method = RequestMethod.GET)
    public String registerUser() {
        LOGGER.info("Inside showLoginPage()");
        return "login/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute("loginData") LoginDTO loginDTO, Model model) {
        LOGGER.info("Inside login() and the email is " + loginDTO.getEmail());

        //Logging level
//        LOGGER.error("ERROR");
//        LOGGER.warn("WARN");
//        LOGGER.info("INFO");
//        LOGGER.debug("DEBUG");
//        LOGGER.trace("TRACE");

        boolean loginResponse = securityService.login(loginDTO.getEmail(), loginDTO.getPassword());

        if (loginResponse) {
            return "/findFlights";
        } else {
            model.addAttribute("msg", "Wrong email or password");
        }
        return "login/login";
    }


//    @RequestMapping("/")
//    public String greet(){
//        return "greet";
//    }
}
