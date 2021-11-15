package ru.grNiko.htmlParser.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@Entity
@org.hibernate.annotations.Cache(
        usage = CacheConcurrencyStrategy.READ_ONLY)
@Cacheable
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = 0L;
    private Integer position;
    private String rating;
    private String name;
    @Column(name = "vote_count")
    private String voteCount;
    @Getter
    private LocalDate date = LocalDate.now();

    public Rating(Integer position, String rating, String name, String voteCount) {
        this.position = position;
        this.rating = rating;
        this.name = name;
        this.voteCount = voteCount;
    }

    @Override
    public String toString() {
        return "Rating{" +

                ", position=" + position +
                ", rating='" + rating + '\'' +
                ", name='" + name + '\'' +
                ", voteCount='" + voteCount + '\'' +
                '}';
    }
}
