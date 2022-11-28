package uz.example.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.example.entity.Address;
import uz.example.entity.Patient;

/**
 * Me: muhammadqodir
 * Project: SpringMyProject/IntelliJ IDEA
 * Date:Mon 24/10/22 00:43
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PatientDTO {

    private Long id;

    private String fullname;

    private String address;

    public PatientDTO(Patient patient) {
        this.fullname = patient.getFullname();
        Address address1 = patient.getAddress();
        this.address = address1.getRegion() + ", " +
                address1.getDistrict() + ", " +
                address1.getCity() + ", " +
                address1.getStreet();
    }
}
