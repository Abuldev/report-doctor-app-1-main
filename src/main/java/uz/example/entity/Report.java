package uz.example.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.example.entity.abs.AbsLongTimestampEntity;

import javax.persistence.*;

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
public class Report extends AbsLongTimestampEntity {

    @ManyToOne
    @JoinColumn(nullable = false)
    private Doctor doctorFrom;

    @Column(nullable = false)
    private String doctorTo;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(nullable = false)
    private Patient patient;

}
