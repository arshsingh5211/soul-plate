package com.techelevator.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.techelevator.model.Restaurants;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class YelpService {

    private String apiURL = "https://api.yelp.com/v3/businesses/search?&limit=10";
    private String detailsURL = "https://api.yelp.com/v3/businesses/";
    private String key = "tQwuuShqwMO3BEamfFGjLbnQPezsb1pzpP-4bKMgVTNs-2UbgL504SZzaaq-IsbfuGa2mqblP7JRmDXMtB5djryRSwCXhem46zgyEtQmBwLiAqROiEcscRycmBJGYXYx";

    public List<Restaurants> getSearchResults(String foodPref, String location) {
        String url = apiURL + "&term=" + foodPref + "&location=" + location;


        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(key);
        HttpEntity<String> httpEntity = new HttpEntity<>("", headers);

        RestTemplate restTemplate = new RestTemplate();

        ObjectMapper objectMapper = new ObjectMapper();
        ResponseEntity<String> responseEntity = restTemplate.exchange(url,
                HttpMethod.GET,
                httpEntity,
                String.class);

        JsonNode jsonNode;
        List<Restaurants> restaurantsList = new ArrayList<>();
        try {
            jsonNode = objectMapper.readTree(responseEntity.getBody());
            JsonNode root = jsonNode.path("businesses");
            for (int i = 0; i < root.size(); i++) {
                String name = root.path(i).path("name").asText();
                String rating = root.path(i).path("rating").asText();
                String phoneNumber = root.path(i).path("phone").asText();
                String address = root.path(i).path("location").path("display_address").asText();

                List<String> transactions = new ArrayList<>();

                for(int j = 0; j < root.path(i).path("transactions").size(); j++) {
                 transactions.add(root.path(i).path("transactions").path(j).asText());   ; // you can add this to a list?
                }

                Restaurants restaurants = new Restaurants(name, phoneNumber, address, rating, transactions);
                restaurantsList.add(restaurants);
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return restaurantsList;
    }

    public Restaurants getRestaurantDetails(String id) {
        String url = detailsURL + id;

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(key);
        HttpEntity<String> httpEntity = new HttpEntity<>("", headers);

        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper objectMapper = new ObjectMapper();
        ResponseEntity<String> responseEntity = restTemplate.exchange(url,
                HttpMethod.GET,
                httpEntity,
                String.class);

        JsonNode jsonNode;
        Restaurants restaurant = new Restaurants();
        try {
            jsonNode = objectMapper.readTree(responseEntity.getBody());
            String name = jsonNode.path("name").asText();
            String phoneNumber = jsonNode.path("display_phone").asText();
            String address = jsonNode.path("location").path("address1").asText();
            String city = jsonNode.path("location").path("city").asText();
            String state = jsonNode.path("location").path("state").asText();
            String zipCode = jsonNode.path("location").path("zip_code").asText();
            String rating = jsonNode.path("rating").asText();
            List<String> transactions = new ArrayList<>();
            JsonNode root = jsonNode.path("");

            for(int j = 0; j < root.path("transactions").size(); j++) {
                transactions.add(root.path("transactions").path(j).asText());   ; // you can add this to a list?
            }

            String price = jsonNode.path("price").asText();
            String imgUrl = jsonNode.path("image_url").asText();
            String category = jsonNode.path("categories").path("title").asText();
            //weekly hours
            //String address = jsonNode.path("location").path("display_address").asText();
            //String weeklyHours = jsonNode.path("hours").path("open").asText();
            String yelpId = id;



            //  this.restaurantName = restaurantName;
//        this.phoneNumber = phoneNumber;
//        this.address = address;
//        this.city = city;
//        this.state = state;
//        this.zipCode = zipCode;
//        this.rating = rating;
//        this.transactions = transactions;
//        this.price = price;
//        this.imgUrl = imgUrl;
//        this.category = category;
//        this.weeklyHours = weeklyHours;
//        this.restaurantId = restaurantId;

            //TODO: null on transaction
            restaurant = new Restaurants(name, phoneNumber, address, city, state, zipCode,
                    rating, transactions, price, imgUrl, category, null, id);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return  restaurant;
    }



}
