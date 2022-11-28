package uz.example.service.contract;

import uz.example.payload.*;

import java.util.List;

/**
 * Me: muhammadqodir
 * Project: SpringMyProject/IntelliJ IDEA
 * Date:Mon 24/10/22 00:34
 */
public interface ReportService {

    ReportDTO add(ReportAddDTO reportAddDTO);


    List<ReportDTO> getAllByDoctor(Long currentDoctorId);

    List<ReportDTO> getAllByDoctorAndDates(ReportGetDTO reportGetDTO);
}
