package ru.grNiko.htmlParser.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = 0L;
    private Integer position;
    private String rating;
    private String name;
    @Column(name = "vote_count")
    private String voteCount;
    private LocalDate date = LocalDate.now();

    public Rating(Integer position, String rating, String name, String voteCount) {
        this.position = position;
        this.rating = rating;
        this.name = name;
        this.voteCount = voteCount;
    }


}
