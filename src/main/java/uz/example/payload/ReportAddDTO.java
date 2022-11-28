package uz.example.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Me: muhammadqodir
 * Project: SpringMyProject/IntelliJ IDEA
 * Date:Mon 24/10/22 00:37
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReportAddDTO {

    private Long fromDoctorId;

    private String toDoctorName;

    private String patientFullname;

    private String patientRegion;

    private String patientDistrict;

    private String patientCity;

    private String patientStreet;

}
