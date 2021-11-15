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
    @Column
    private Integer position;
    @Column
    private String rating;
    @Column
    private String name;
    @Column
    private String voteCount;
    @Column(updatable = true)
    private @Getter LocalDate date = LocalDate.now();

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
