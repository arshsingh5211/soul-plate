<template>
  <div class="home">
    <!-- <h1>Home</h1> -->
    <display-restaurants />
    <!-- <restaurant-card/> -->
    <!-- <restaurant-search></restaurant-search>  -->
  </div>
</template>

<script>
// import RestaurantCard from '../components/RestaurantCard.vue';
// import RestaurantSearch from '../components/RestaurantSearch.vue';
// import YelpService from '../services/YelpService';
import DisplayRestaurants from "../components/DisplayRestaurants";
export default {
  components: { DisplayRestaurants },
  name: "home",
  // methods: {
  //   getRestaurants() {
  //     YelpService.getSearchResults
  //   }
  // }
};
</script>

<style scoped>
.home {
  display: flex;
  justify-content: space-evenly;
  flex-wrap: wrap;
}
</style>
