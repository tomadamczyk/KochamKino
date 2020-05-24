package com.example.kochamkino.DaoImplementation;

import com.example.kochamkino.DaoInterfaces.MovieDao;
import com.example.kochamkino.models.Movie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MovieDaoImp implements MovieDao {

    private JdbcTemplate jdbcTemplate;


    public MovieDaoImp(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Movie> movieList(){

        return jdbcTemplate.query("SELECT * FROM movie;", (resultSet, i) -> {
            Movie movie = new Movie();

            movie.setMovieId(resultSet.getLong("movie_id"));
            movie.setTitle(resultSet.getString("title"));
            movie.setGenre(resultSet.getString("genre"));
            movie.setGrade(resultSet.getFloat("grade"));

            return movie;
        });
    }







}
