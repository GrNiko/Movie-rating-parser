package ru.grNiko.htmlParser.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.grNiko.htmlParser.entity.Rating;
import ru.grNiko.htmlParser.service.RatingService;

@AllArgsConstructor
@Controller
public class MainController {

    private RatingService ratingService;

    @GetMapping("/")
    public String root() {
        return "main";
    }

    @PostMapping
    public String inputResult(Model model,
                              @RequestParam(required = false, defaultValue = "") String filter ) {
        Iterable<Rating> movies;
        if (filter != null && !filter.isEmpty()) {
            movies = ratingService.findByDate(filter);
        } else {
            return "main";
        }
        model.addAttribute("movies", movies);
        model.addAttribute("filter", filter);
        return "main";
    }
}
