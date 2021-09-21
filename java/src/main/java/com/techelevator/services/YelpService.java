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

                Restaurants restaurants = new Restaurants(name, address, phoneNumber, Integer.valueOf(rating));

                restaurantsList.add(restaurants);

            }

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return restaurantsList;


    }
}
