package uz.example.controller;

import javax.validation.Valid;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.example.payload.*;
import uz.example.service.contract.DoctorService;


/**
 * Me: muhammadqodir
 * Project: Doctor-report-app/IntelliJ IDEA
 * Date:Sun 23/10/22 21:09
 */

@Controller
@RequiredArgsConstructor
public class AuthController {

    private final DoctorService doctorService;

    @GetMapping(value = "/register")
    public String registerPage(Model model) {
        model.addAttribute("registerDTO", new RegisterDTO());
        return "register";
    }

    @GetMapping(value = "/login")
    public String loginPage(Model model) {
        model.addAttribute("loginDTO", new LoginDTO());
        return "login";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/register")
    public String register(@Valid RegisterDTO registerDTO, Model model) {
        doctorService.register(registerDTO);
        return "redirect:" + "login";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public String login(@Valid LoginDTO loginDTO) {
        DoctorDTO login = doctorService.login(loginDTO);
        return "redirect:" + "/home/" + login.getId();
    }
}
