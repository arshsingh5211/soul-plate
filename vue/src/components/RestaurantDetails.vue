<template>
  <div>
      restuaraunt details
      <img v-bind:src=restaurant.imgUrl width="200" />
      <h1 class="restaurant-name">{{ restaurant.restaurantName }}></h1>
      <h2 class="phoneNumber">{{restaurant.display_phone}}</h2>
      <h3 class="rating">{{restaurant.rating}}</h3>
      <h4 class="reviews"></h4>
      <h5 class="price">{{restaurant.price}}</h5>
      <div class="reviews container">
        <!-- <review-card v-bind:review="review" v-for="review in reviews" v-bind:key="review.id"> </review-card> -->
      </div>
      <div class="photo-container">
        //add the 3 photos from the backend call
      </div>
      <!-- 
Phone Number
Rating
Reviews -->
  </div>
</template>

<script>
import yelpService from "../services/YelpService"
export default {
  data() {
    return {restaurant: {}, reviews: [], transactions: []}
  },

  created() {
    let id = this.$route.params.id
    yelpService
    .getBusinessDetails(id)
    .then((response) => {
      this.restaurant = response.data;
      this.transactions = this.restaurant.transactions;
    }),
    yelpService
    .getBusinessReviews(this.restaurant.yelpId)
    .then((response) => {
      this.reviews = response.data;
    })
  }
};
</script>

<style>
</style>