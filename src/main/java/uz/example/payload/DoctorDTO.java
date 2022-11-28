package uz.example.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.example.entity.Doctor;

/**
 * Me: muhammadqodir
 * Project: Doctor-report-app/IntelliJ IDEA
 * Date:Sun 23/10/22 21:22
 */


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DoctorDTO {

    private Long id;

    private String fullname;

    private String username;

    public DoctorDTO(Doctor doctor) {
        this.id = doctor.getId();
        this.username = doctor.getUsername();
        this.fullname = doctor.getFullname();
    }
}
