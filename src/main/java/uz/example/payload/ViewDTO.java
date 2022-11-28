package uz.example.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * Me: muhammadqodir
 * Project: SpringMyProject/IntelliJ IDEA
 * Date:Mon 24/10/22 00:46
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ViewDTO {

    private LocalDateTime fromDate;
    private LocalDateTime toDate;

}
