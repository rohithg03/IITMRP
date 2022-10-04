package com.zomato.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zomato.bean.Restaurant;
import com.zomato.repository.RestaurantRepository;

import java.util.List;

@Service
@Transactional
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantRepository productRepository;

    @Override
    public List<Restaurant> getAllRestaurant() {
        return productRepository.findAll();
    }

    @Override
    public List<Restaurant> getAllRestaurantByLocation(String location) {
        return productRepository.findAllByLocation(location);
    }
    @Override
    public List<Restaurant> getAllRestaurantByRating(double rating) {
        return productRepository.findAllByRating(rating);
    }
    @Override
    public List<Restaurant> getAllRestaurantByType(String type) {
        return productRepository.findAllByType(type);
    }

    @Override
    public Restaurant getRestaurantById(Long id) {
        return productRepository.getOne(id);
    }

    @Override
    public List<Restaurant> getAllRestaurantsByName(String restaurantName) {
        return productRepository.findAllByRestaurantName(restaurantName);
    }

    @Override
    public Restaurant addRestaurant(Restaurant product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteRestaurant(Long restaurantId) {
        productRepository.deleteById(restaurantId);
    }
}