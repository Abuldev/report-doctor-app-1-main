package uz.example.service.implementations;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.example.entity.Doctor;
import uz.example.exception.DoctorNotFoundException;
import uz.example.payload.DoctorDTO;
import uz.example.payload.LoginDTO;
import uz.example.payload.RegisterDTO;
import uz.example.repository.DoctorRepository;
import uz.example.repository.ReportRepository;
import uz.example.service.contract.DoctorService;

/**
 * Me: muhammadqodir
 * Project: Doctor-report-app/IntelliJ IDEA
 * Date:Sun 23/10/22 21:20
 */

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;
    private final ReportRepository reportRepository;

    @Override
    public DoctorDTO register(RegisterDTO registerDTO) {
        Doctor doctor = new Doctor(
                registerDTO.getFullname(),
                registerDTO.getPassword(),
                registerDTO.getUsername()
        );
        doctor = doctorRepository.save(doctor);
        return new DoctorDTO(doctor);
    }

    @Override
    public DoctorDTO login(LoginDTO loginDTO) {
        Doctor doctor = doctorRepository.findByUsernameAndPassword(loginDTO.getUsername(), loginDTO.getPassword())
                .orElseThrow(() -> new DoctorNotFoundException("DOCTOR NOT FOUND"));
        return new DoctorDTO(doctor);
    }

    @Override
    public DoctorDTO getDoctorById(Long currentDoctorId) {
        Doctor doctor = doctorRepository.findById(currentDoctorId)
                .orElseThrow(() -> new DoctorNotFoundException("DOCTOR NOT FOUND"));
        return new DoctorDTO(doctor);
    }


}
