<template>
  <div class="home">
    <!-- <h1>Home</h1> -->
    <restaurant-search></restaurant-search> 
    
    <display-restaurants></display-restaurants>
    <!-- <p>You must be authenticated to see this</p> -->
    <!-- <restaurant-card></restaurant-card> -->
  </div>
</template>

<script>
// import RestaurantCard from '../components/RestaurantCard.vue';
import RestaurantSearch from '../components/RestaurantSearch.vue';
import YelpService from '../services/YelpService';
import DisplayRestaurants from '../components/DisplayRestaurants.vue';
export default {
  components: {RestaurantSearch, DisplayRestaurants},
  name: "home",
  methods: {
    getRestaurants() {
      YelpService.getSearchResults
    }
  }
};
</script>

<style scoped>
.home {
    display:flex;
    justify-content: space-evenly;
    flex-wrap: wrap;
}

</style>
