package uz.example.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.example.payload.*;
import uz.example.service.contract.DoctorService;
import uz.example.service.contract.ReportService;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequiredArgsConstructor
public class HomeController {

    private final DoctorService doctorService;
    private final ReportService reportService;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String homePage(Model model) {
        model.addAttribute("loginDTO", new LoginDTO());
        return "login";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/home/{currentDoctorId}")
    public String home(Model model, @PathVariable Long currentDoctorId) {
        DoctorDTO doctor = doctorService.getDoctorById(currentDoctorId);
        model.addAttribute("doctor", doctor);
        model.addAttribute("reportAddDTO", new ReportAddDTO());
        ArrayList<ReportDTO> list = new ArrayList<>();
        model.addAttribute("reports", list);
        model.addAttribute("reportGet", new ReportGetDTO());
        return "home";
    }


}
