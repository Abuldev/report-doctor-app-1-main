package uz.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.example.entity.Doctor;

import java.util.Optional;

/**
 * Me: muhammadqodir
 * Project: Doctor-report-app/IntelliJ IDEA
 * Date:Sun 23/10/22 21:26
 */

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    Optional<Doctor> findByUsernameAndPassword(String username, String password);

}
