package uz.example.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Me: muhammadqodir
 * Project: SpringMyProject/IntelliJ IDEA
 * Date:Mon 24/10/22 23:20
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReportGetDTO {

//    @NotBlank(message = "doctorId bo'sh bo'lishi mumkin emas")
    private Long doctorId;

//    @Past(message="Vaqt bugundan oldingi kun bo'lishi kerak")
//    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
    private String fromDate;

//    @Past(message="Vaqt bugundan oldingi kun bo'lishi kerak")
//    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
    private String toDate;

}
