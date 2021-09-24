<template>
  <div class="home">
    <!-- <h1>Home</h1> -->
    <restaurant-search></restaurant-search>
    <!-- <p>You must be authenticated to see this</p> -->
    <restaurant-card></restaurant-card>
  </div>
</template>

<script>
import RestaurantCard from '../components/RestaurantCard.vue';
import RestaurantSearch from '../components/RestaurantSearch.vue';
import YelpService from '../services/YelpService';
export default {
  components: { RestaurantSearch, RestaurantCard},
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
