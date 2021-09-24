<template>
  <div id="main">
      <div class="RestaurantInfo">
          <!-- <div class="restaurants" v-for="restaurant in restaurants" :key="restaurant.id">
              Restaurant Name: {{restaurant.name}}
              <br />
              Restaurant Ratings: {{restaurant.rating}}  
              <br />
              Categories: {{restaurant.categories}}
              <br />
              Is it open?: {{restaurant.isOpen}}
              <br />
              1 Review: {{restaurant.review}} 
              <br />
              Services: {{restaurant.transactions}} 
              <br />
              <img v-bind:src=restaurant.image width="200" />
          </div> -->
      </div>
  </div>
</template>

<script>
import yelpService from "../services/YelpService"
export default {
    data() {
        return { restaurants: []};
    },

    created() {
        yelpService
        .getSearchResults(newPreferences)
        .then((response) => {
            this.restaurants = response.data;
        })
    }

}
</script>

<style>

</style>