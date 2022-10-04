package com.zomato.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.zomato.bean.Restaurant;
import com.zomato.http.HeaderGenerator;
import com.zomato.service.RestaurantService;

import java.util.List;

@RestController
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;
    
    @Autowired
    private HeaderGenerator headerGenerator;

    @GetMapping (value = "/restaurants") // To get all the restaurant provided by admin
    public ResponseEntity<List<Restaurant>> getAllRestaurants(){
        List<Restaurant> restaurants =  restaurantService.getAllRestaurant();
        if(!restaurants.isEmpty()) {
        	return new ResponseEntity<List<Restaurant>>(
        			restaurants,
        			headerGenerator.getHeadersForSuccessGetMethod(),
        			HttpStatus.OK);
        }
        return new ResponseEntity<List<Restaurant>>(
        		headerGenerator.getHeadersForError(),
        		HttpStatus.NOT_FOUND);       
    }

    @GetMapping(value = "/restaurants", params = "location") // To get all the restaurant in a location provided by admin
    public ResponseEntity<List<Restaurant>> getAllRestaurantByLocation(@RequestParam ("location") String location){
        List<Restaurant> restaurants = restaurantService.getAllRestaurantByLocation(location);
        if(!restaurants.isEmpty()) {
        	return new ResponseEntity<List<Restaurant>>(
        			restaurants,
        			headerGenerator.getHeadersForSuccessGetMethod(),
        			HttpStatus.OK);
        }
        return new ResponseEntity<List<Restaurant>>(
        		headerGenerator.getHeadersForError(),
        		HttpStatus.NOT_FOUND);
    }
    @GetMapping(value = "/restaurants", params = "type")// To get all the restaurant as per type provided by admin
    public ResponseEntity<List<Restaurant>> getAllRestaurantByType(@RequestParam ("type") String type){
        List<Restaurant> restaurants = restaurantService.getAllRestaurantByType(type);
        if(!restaurants.isEmpty()) {
        	return new ResponseEntity<List<Restaurant>>(
        			restaurants,
        			headerGenerator.getHeadersForSuccessGetMethod(),
        			HttpStatus.OK);
        }
        return new ResponseEntity<List<Restaurant>>(
        		headerGenerator.getHeadersForError(),
        		HttpStatus.NOT_FOUND);
    }
    @GetMapping(value = "/restaurants", params = "rating") // To get the restaurant as per rating provided by admin
    public ResponseEntity<List<Restaurant>> getAllRestaurantByRating(@RequestParam ("rating") double rating){
        List<Restaurant> restaurants = restaurantService.getAllRestaurantByRating(rating);
        if(!restaurants.isEmpty()) {
        	return new ResponseEntity<List<Restaurant>>(
        			restaurants,
        			headerGenerator.getHeadersForSuccessGetMethod(),
        			HttpStatus.OK);
        }
        return new ResponseEntity<List<Restaurant>>(
        		headerGenerator.getHeadersForError(),
        		HttpStatus.NOT_FOUND);
    }
    @GetMapping (value = "/restaurants/{id}") // To get the restaurant as per id provided by admin
    public ResponseEntity<Restaurant> getOneRestaurantById(@PathVariable ("id") long id){
        Restaurant restaurant =  restaurantService.getRestaurantById(id);
        if(restaurant != null) {
        	return new ResponseEntity<Restaurant>(
        			restaurant,
        			headerGenerator.getHeadersForSuccessGetMethod(),
        			HttpStatus.OK);
        }
        return new ResponseEntity<Restaurant>(
        		headerGenerator.getHeadersForError(),
        		HttpStatus.NOT_FOUND);
    }

    @GetMapping (value = "/restaurants", params = "name") // To get the restaurant as per name provided by admin
    public ResponseEntity<List<Restaurant>> getAllRestaurantsByName(@RequestParam ("name") String name){
        List<Restaurant> restaurants =  restaurantService.getAllRestaurantsByName(name);
        if(!restaurants.isEmpty()) {
        	return new ResponseEntity<List<Restaurant>>(
        			restaurants,
        			headerGenerator.getHeadersForSuccessGetMethod(),
        			HttpStatus.OK);
        }
        return 
new ResponseEntity<List<Restaurant>>(
        		headerGenerator.getHeadersForError(),
        		HttpStatus.NOT_FOUND);
    }
}