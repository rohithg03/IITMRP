package com.zomato.service;
import java.util.List;

import com.zomato.bean.Restaurant;





public interface RestaurantService {
    public List<Restaurant> getAllRestaurant();
    public List<Restaurant> getAllRestaurantByLocation(String location);
    public List<Restaurant> getAllRestaurantByRating(double rating);
    
    public Restaurant getRestaurantById(Long id);
    public List<Restaurant> getAllRestaurantsByName(String restaurantName);
    public Restaurant addRestaurant(Restaurant Restaurant);
    public void deleteRestaurant(Long restaurantId);
	List<Restaurant> getAllRestaurantByType(String type);
}