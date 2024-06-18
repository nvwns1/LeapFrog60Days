package org.suman.flightreservation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.suman.flightreservation.entities.DTO.LoginDTO;
import org.suman.flightreservation.entities.User;
import org.suman.flightreservation.repos.UserRepository;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @RequestMapping("/showReg")
    public String showRegistrationPage() {
        LOGGER.info("Inside showRegistrationPage()");
        return "login/registerUser";
    }

    @RequestMapping(value = "/registerUser", method = RequestMethod.POST)
    public String registerUser(@ModelAttribute("user") User user) {
        LOGGER.info("Inside registerUser()" + user);
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
        LOGGER.info("Inside login() and the email is "+loginDTO.getEmail());

        //Logging level
//        LOGGER.error("ERROR");
//        LOGGER.warn("WARN");
//        LOGGER.info("INFO");
//        LOGGER.debug("DEBUG");
//        LOGGER.trace("TRACE");
        User user = userRepository.findByEmail(loginDTO.getEmail());
        if (user.getPassword().equals(loginDTO.getPassword())) {
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
