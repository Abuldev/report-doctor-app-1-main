package uz.example.service.implementations;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.example.entity.Address;
import uz.example.entity.Doctor;
import uz.example.entity.Patient;
import uz.example.entity.Report;
import uz.example.exception.DoctorNotFoundException;
import uz.example.payload.ReportAddDTO;
import uz.example.payload.ReportDTO;
import uz.example.payload.ReportGetDTO;
import uz.example.repository.DoctorRepository;
import uz.example.repository.ReportRepository;
import uz.example.service.contract.ReportService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Me: muhammadqodir
 * Project: SpringMyProject/IntelliJ IDEA
 * Date:Mon 24/10/22 00:34
 */
@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {

    private final ReportRepository repository;
    private final DoctorRepository doctorRepository;

    @Override
    public ReportDTO add(ReportAddDTO reportAddDTO) {
        Report report = new Report();
        fromReportDTOToReport(reportAddDTO, report);
        report = repository.save(report);
        return new ReportDTO(report);
    }

    private void fromReportDTOToReport(ReportAddDTO reportAddDTO, Report report) {
        Long fromDoctorId = reportAddDTO.getFromDoctorId();
        String toDoctorName = reportAddDTO.getToDoctorName();
        Doctor doctorFrom = doctorRepository.findById(fromDoctorId)
                .orElseThrow(() -> new DoctorNotFoundException("DOCTOR NOT FOUND"));

        String patientCity = reportAddDTO.getPatientCity();
        String patientFullname = reportAddDTO.getPatientFullname();
        String patientDistrict = reportAddDTO.getPatientDistrict();
        String patientStreet = reportAddDTO.getPatientStreet();
        String patientRegion = reportAddDTO.getPatientRegion();

        Address address = new Address(patientRegion, patientDistrict,
                patientCity, patientStreet);
        Patient patient = new Patient(patientFullname, address);

        report.setDoctorFrom(doctorFrom);
        report.setDoctorTo(toDoctorName);
        report.setPatient(patient);
    }

    @Override
    public List<ReportDTO> getAllByDoctor(Long fromId) {

        return repository.findAllByDoctorFrom_IdOrderByCreatedAtDesc(fromId)
                .stream()
                .map(ReportDTO::new)
                .toList();
    }

    @Override
    public List<ReportDTO> getAllByDoctorAndDates(ReportGetDTO reportGetDTO) {

        if (!doctorRepository.existsById(reportGetDTO.getDoctorId())) {
            throw new DoctorNotFoundException("DOCTOR NOT FOUND");
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String fromDate = reportGetDTO.getFromDate();
        fromDate = fromDate.replace("T", " ");

        String toDate = reportGetDTO.getToDate();
        toDate = toDate.replace("T", " ");

        LocalDateTime from = LocalDateTime.parse(fromDate, formatter);
        LocalDateTime to = LocalDateTime.parse(toDate, formatter);

        return repository
                .findAllByDoctorFrom_IdAndCreatedAtBetweenOrderByCreatedAtDesc(
                        reportGetDTO.getDoctorId(), from, to)
                .stream()
                .map(ReportDTO::new)
                .toList();

    }
}
