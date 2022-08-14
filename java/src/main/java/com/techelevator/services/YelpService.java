package com.techelevator.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.techelevator.model.RestaurantDetails;
import com.techelevator.model.Restaurants;
import com.techelevator.model.ReviewUser;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Component
public class YelpService {

    private String apiURL = "https://api.yelp.com/v3/businesses/search?&limit=20";
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
                String address = root.path(i).path("location").path("address1").asText();
                String state = root.path(i).path("location").path("state").asText();
                String zipCode = root.path(i).path("location").path("zip_code").asText();
                String imgUrl = root.path(i).path("image_url").asText();
                String city = root.path(i).path("location").path("city").asText();
                String yelpId = root.path(i).path("id").asText();
                String[] catArr = new String[root.path(i).path("categories").size()];
                for (int j = 0; j < catArr.length; j++) {
                    catArr[j] = root.path(i).path("categories").get(j).path("title").asText();
                }
                String categoryName = Arrays.toString(catArr).replace("[","").replace("]", "");

                Restaurants restaurants = new Restaurants(name, address, city, state, zipCode, rating, imgUrl, yelpId, categoryName);
                restaurantsList.add(restaurants);
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return restaurantsList;
    }

    public Restaurants getRandomRestaurant(List<Restaurants> restaurantsList) {
        Random random = new Random();
        return restaurantsList.get(random.nextInt(restaurantsList.size()));
    }

    public RestaurantDetails getRestaurantDetails(String id) {
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
        RestaurantDetails restaurantDetails = new RestaurantDetails();
        try {
            jsonNode = objectMapper.readTree(responseEntity.getBody());
            String restaurantName = jsonNode.path("name").asText();
            String phoneNumber = jsonNode.path("display_phone").asText();
            String address = jsonNode.path("location").path("address1").asText();
            String city = jsonNode.path("location").path("city").asText();
            String state = jsonNode.path("location").path("state").asText();
            String zipCode = jsonNode.path("location").path("zip_code").asText();
            String rating = jsonNode.path("rating").asText();
            List<String> transactions = new ArrayList<>();
            List<String> pictureURLs = new ArrayList<>();
            List<String> reviews = new ArrayList<>();
            for(int j = 0; j < jsonNode.path("photos").size(); j++) {
                pictureURLs.add(jsonNode.path("photos").path(j).asText());
            }
            for(int j = 0; j < jsonNode.path("transactions").size(); j++) {
                transactions.add(jsonNode.path("transactions").path(j).asText());
            }

            String price = jsonNode.path("price").asText();
            String imgUrl = jsonNode.path("image_url").asText();
            String category = jsonNode.path("categories").path("title").asText();
            //weekly hours
            //String address = jsonNode.path("location").path("display_address").asText();
            boolean isOpenNow = jsonNode.path("hours").path("is_open_now").asBoolean();
            String yelpId = jsonNode.path("id").asText();

            restaurantDetails = new RestaurantDetails(restaurantName, phoneNumber, address, city, state, zipCode, rating,
                                pictureURLs, transactions, price, imgUrl, category, isOpenNow, yelpId);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return restaurantDetails;
    }


    public List<ReviewUser> getReview(String id) {
        String url = detailsURL + id + "/reviews";

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
        List<ReviewUser> reviewsList = new ArrayList<>();

        try {
            jsonNode = objectMapper.readTree(responseEntity.getBody());
            JsonNode root = jsonNode.path("reviews");

            for(int j = 0; j < root.size(); j++) {
                String rating = root.path(j).path("rating").asText();
                String reviewId = root.path(j).path("id").asText();
                String text = root.path(j).path("text").asText();
                String reviewerName = root.path(j).path("user").path("name").asText();
                String reviewerImg = root.path(j).path("user").path("image_url").asText();

                ReviewUser reviewUser = new ReviewUser(reviewId, text, rating, reviewerImg, reviewerName);
                reviewsList.add(reviewUser);
            }


        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return reviewsList;
    }



}
