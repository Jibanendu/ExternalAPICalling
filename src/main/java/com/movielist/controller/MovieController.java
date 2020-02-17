package com.movielist.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.movielist.model.Movie;
import com.movielist.model.Result;

@RestController
public class MovieController {
	
	@GetMapping("/List")
	public List<Result> getMovieYear(@RequestParam int year) throws JsonMappingException, JsonProcessingException
	{
		RestTemplate restTemplate = new RestTemplate(); 
		String url ="http://api.themoviedb.org/3/discover/movie?with_genres=18&primary_release_year="+String.valueOf(year)+"&api_key=bf75268dab5e27d77dec5faa8fe2a28b";
		ResponseEntity<String> response= restTemplate.getForEntity(url, String.class);
		ObjectMapper mapper = new ObjectMapper();
		JsonNode root = mapper.readTree(response.getBody());
		JsonNode name = root.path("results");
		
	    List<Result> liResult = mapper.convertValue(name, new TypeReference<List<Result>>() { });
		return liResult;
	}

}
