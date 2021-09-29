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
// import RestaurantSearch from '../components/RestaurantSearch.vue';
import YelpService from '../services/YelpService';
import DisplayRestaurants from '../components/DisplayRestaurants.vue';
export default {
<<<<<<< HEAD
  components: {DisplayRestaurants},
=======
  components: {RestaurantSearch, DisplayRestaurants},
>>>>>>> 32bb183b6cdb233bcaddd127e3c557f8f07639f7
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
