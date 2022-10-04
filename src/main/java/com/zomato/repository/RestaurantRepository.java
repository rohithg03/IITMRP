package com.zomato.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zomato.bean.Restaurant;

import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    public List<Restaurant> findAllByLocation(String location);
    public List<Restaurant> findAllByRestaurantName(String restaurantName);
	public List<Restaurant> findAllByRating(double rating);
	public List<Restaurant> findAllByType(String type);
}