package uz.example.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

/**
 * Me: muhammadqodir
 * Project: Doctor-report-app/IntelliJ IDEA
 * Date:Sun 23/10/22 21:18
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class RegisterDTO {


    @NotBlank(message = "To'liq ism sharifingizni kiriting")
    private String fullname;

    @NotBlank(message = "Username kiritish majburiy")
    private String username;

    @NotBlank(message = " Parol kiritish majburiy")
    private String password;

}
