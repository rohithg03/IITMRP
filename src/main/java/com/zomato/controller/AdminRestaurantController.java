package com.zomato.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.zomato.bean.Restaurant;
import com.zomato.http.HeaderGenerator;
import com.zomato.service.RestaurantService;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/admin")
public class AdminRestaurantController {

    @Autowired
    private RestaurantService restaurantService;
    
    @Autowired
    private HeaderGenerator headerGenerator;

    @PostMapping(value = "/restaurants") // To Add Restaurants by the admin
    private ResponseEntity<Restaurant> addRestaurant(@RequestBody Restaurant restaurant, HttpServletRequest request){
    	if(restaurant != null) {
    		try {
    			restaurantService.addRestaurant(restaurant);
    	        return new ResponseEntity<Restaurant>(
    	        		restaurant,
    	        		headerGenerator.getHeadersForSuccessPostMethod(request, restaurant.getId()),
    	        		HttpStatus.CREATED);
    		}catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<Restaurant>(
						headerGenerator.getHeadersForError(),
						HttpStatus.INTERNAL_SERVER_ERROR);
			}
    	}
    	return new ResponseEntity<Restaurant>(
    			headerGenerator.getHeadersForError(),
    			HttpStatus.BAD_REQUEST);       
    }
    


    
    @DeleteMapping(value = "/restaurants/{id}") // To  Delete the Restaurant only by admin
    private ResponseEntity<Void> deleteRestaurant(@PathVariable("id") Long id){
    	Restaurant restaurant = restaurantService.getRestaurantById(id);
    	if(restaurant != null) {
    		try {
    			restaurantService.deleteRestaurant(id);
    	        return new ResponseEntity<Void>(
    	        		headerGenerator.getHeadersForSuccessGetMethod(),
    	        		HttpStatus.OK);
    		}catch (Exception e) {
				e.printStackTrace();
    	        return new ResponseEntity<Void>(
    	        		headerGenerator.getHeadersForError(),
    	        		HttpStatus.INTERNAL_SERVER_ERROR);
			}
    	}
    	return new ResponseEntity<Void>(headerGenerator.getHeadersForError(), HttpStatus.NOT_FOUND);      
    }
}
