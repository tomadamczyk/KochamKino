package com.example.kochamkino.services;

import com.example.kochamkino.models.Director;
import com.example.kochamkino.models.Grade;
import com.example.kochamkino.models.Movie;
import com.example.kochamkino.models.User;
import com.example.kochamkino.repositories.DirectorRepo;
import com.example.kochamkino.repositories.GradeRepo;
import com.example.kochamkino.repositories.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RecommendationsService {

    @Autowired
    private GradeRepo gradeRepo;

    @Autowired
    private MovieRepo movieRepo;

    @Autowired
    private DirectorRepo directorRepo;

    private UserService userService;

    public RecommendationsService(GradeRepo gradeRepo, MovieRepo movieRepo, UserService userService, DirectorRepo directorRepo) {

        this.gradeRepo = gradeRepo;
        this.movieRepo = movieRepo;
        this.userService = userService;
        this.directorRepo = directorRepo;

    }

    private static <T> T mostCommon(List<T> list) {
        Map<T, Integer> map = new HashMap<>();

        for (T t : list) {
            Integer val = map.get(t);
            map.put(t, val == null ? 1 : val + 1);
        }

        Map.Entry<T, Integer> max = null;

        for (Map.Entry<T, Integer> e : map.entrySet()) {
            if (max == null || e.getValue() > max.getValue())
                max = e;
        }

        return max.getKey();
    }

    public List<Movie> getRecommendations() {

        List<Grade> ratings = gradeRepo.findByValueBetween(7, 10);
        List<String> directors = new ArrayList<>();
        List<String> genres = new ArrayList<>();
        List<Movie> recommended = new ArrayList<>();

        for (Grade grade : ratings) {

            directors.add(grade.getMovie().getDirector().getLastName());
            genres.add(grade.getMovie().getGenre());

        }

        String mostCommonDirector = mostCommon(directors);
        String mostCommonGenre = mostCommon(genres);

        Director director = directorRepo.findByLastName(mostCommonDirector);

        List<Movie> recommendedByGenre = movieRepo.findByGenre(mostCommonGenre);
        List<Movie> recommendedByDirector = movieRepo.findByDirector(director);

        recommended.addAll(recommendedByGenre);

        for (Movie movie : recommendedByDirector) {
            if (recommended.contains(movie)) {
                continue;
            }
            else {
                recommended.add(movie);
            }
        }

        return recommended;
    }


}
