package uz.example.service.contract;

import uz.example.payload.DoctorDTO;
import uz.example.payload.LoginDTO;
import uz.example.payload.RegisterDTO;
import uz.example.payload.ReportDTO;

import java.util.List;

/**
 * Me: muhammadqodir
 * Project: Doctor-report-app/IntelliJ IDEA
 * Date:Sun 23/10/22 21:20
 */


public interface DoctorService {

    DoctorDTO register(RegisterDTO registerDTO);

    DoctorDTO login(LoginDTO loginDTO);

    DoctorDTO getDoctorById(Long currentDoctorId);
}
