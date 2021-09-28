<template>
  <div id="main">
    <div class="restaurant-container">
      <!-- <restaurant-card v-bind:restaurant="restaurant" v-for="restaurant in restaurants" v-bind:key="restaurant.yelpId"/> -->
      <!-- <restaurant-card v-bind:restaurant="restaurants[currentRestaurantIndex]"></restaurant-card> -->

      <div>
        <img v-bind:src="restaurant.imgUrl" width="250" />
        <h2 class="restaurant-name">{{ restaurant.restaurantName }}</h2>
        <h3 class="restaurant-zip">{{ restaurant.zipCode }}</h3>
        <h4 class="restaurant-rating">{{ restaurant.rating }}</h4>
        <h5 class="restaurant-review">{{ restaurant.review }}</h5>
        <h4 class="restaurant-price">{{ restaurant.price }}</h4>
        <h7 class="restaurant-transactions">{{ restaurant.transactions }}</h7>
        <button
          class="like"
          v-on:click.prevent="addToLikedRestaurants(restaurant)"
        >
          Like this Restaurant
        </button>
        <br />
        <button class="dislike" v-on:click.prevent="removeRestaurant">
          Dislike this restaurant
        </button>
      </div>
    </div>
  </div>
</template>

<script>
// import RestaurantCard from "./RestaurantCard.vue";
import yelpService from "../services/YelpService";
export default {
  name: "display-restaurants",
  data() {
    return {
      restaurants: [],
      currentRestaurantIndex: 0,
    };
  },
  computed: {
    restaurant() {
      return this.restaurants[0];
    },
  },
  methods: {
    removeRestaurant() {
      this.restaurants.shift();
    },

    addToLikedRestaurants() {
      yelpService
        .addLikedRestaurant(this.restaurant)
        .then((response) => {
          if (response.status === 201) {
            this.$router.push(`/`);
          }
        })
        .catch((error) => {
          this.handleErrorResponse(error, "adding");
        });
      //this.$store.commit('ADD_LIKED_RESTAURANT', restaurant)
    },
  },
  created() {
    this.$store.searchedRestaurants = []; //set array to empty everytime you search?
    yelpService
      .getSearchResults(this.$store.state.userPreferences[0])
      .then((response) => {
        this.restaurants = response.data;
        for (this.restaurant in this.restaurants) {
          this.$store.commit("ADD_SEARCHED_RESTAURANT", this.restaurant);
        }
      });
  },
};
</script>

<style>
.restaurant-container {
  align-items: center;
  border-radius: 50%;
  display: flex;
  height: 300px;
  justify-content: center;
  position: absolute;
  top: 90%;
  left: 35%;
  width: 300px;
}
restaurant-card {
  width: 150px;
  height: 150px;
  border-radius: 50%;
}
</style>
