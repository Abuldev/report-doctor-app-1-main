package uz.example.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * Me: muhammadqodir
 * Project: SpringMyProject/IntelliJ IDEA
 * Date:Tue 25/10/22 06:51
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MyPage {
    private List<ReportDTO> content;
    private int totalPages;
    private int currentPage;


}
