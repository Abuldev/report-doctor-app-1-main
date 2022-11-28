package uz.example.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.example.payload.ReportAddDTO;
import uz.example.service.contract.ReportService;

import javax.validation.Valid;

/**
 * Me: muhammadqodir
 * Project: SpringMyProject/IntelliJ IDEA
 * Date:Mon 24/10/22 00:35
 */

@Controller
@RequiredArgsConstructor
public class ReportController {

    private final ReportService reportService;

    @RequestMapping(method = RequestMethod.POST, value = "/report/add/{from}")
    public String add(@Valid ReportAddDTO reportAddDTO, @PathVariable Long from) {
        reportAddDTO.setFromDoctorId(from);
        reportService.add(reportAddDTO);
        return "redirect:" + "/home/" + from;
    }




}
