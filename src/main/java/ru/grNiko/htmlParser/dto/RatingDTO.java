package ru.grNiko.htmlParser.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RatingDTO implements Serializable {

    private Integer position;
    private String rating;
    private String name;
    private String voteCount;
    private LocalDate date;
}
