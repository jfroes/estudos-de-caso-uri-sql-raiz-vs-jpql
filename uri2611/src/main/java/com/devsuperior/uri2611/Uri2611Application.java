package com.devsuperior.uri2611;

import com.devsuperior.uri2611.dtos.MovieMinDTO;
import com.devsuperior.uri2611.projections.MovieMinProjection;
import com.devsuperior.uri2611.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class Uri2611Application implements CommandLineRunner {
	@Autowired
	private MovieRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2611Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<MovieMinProjection> list = repository.search1("Action");
		List<MovieMinDTO> result1 = list.stream().map(projection -> new MovieMinDTO(projection)).collect(Collectors.toList());

		for (MovieMinDTO dto : result1) {
			System.out.println(dto);
		}

	}
}
