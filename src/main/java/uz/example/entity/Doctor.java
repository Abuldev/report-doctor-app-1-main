package uz.example.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Me: muhammadqodir
 * Project: Doctor-report-app/IntelliJ IDEA
 * Date:Sun 23/10/22 21:10
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullname;

    @Column(unique = true)
    private String username;

    private String password;


    public Doctor(String fullname, String password, String username) {
        this.fullname = fullname;
        this.password = password;
        this.username = username;
    }
}
