package uz.example.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import uz.example.entity.Report;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Me: muhammadqodir
 * Project: Doctor-report-app/IntelliJ IDEA
 * Date:Sun 23/10/22 21:30
 */
public interface ReportRepository extends JpaRepository<Report, Long> {

    List<Report> findAllByDoctorFrom_IdOrderByCreatedAtDesc(Long doctorFrom_id);

    List<Report> findAllByDoctorFrom_IdAndCreatedAtBetweenOrderByCreatedAtDesc(Long doctorFrom_id, LocalDateTime from, LocalDateTime to);

}
