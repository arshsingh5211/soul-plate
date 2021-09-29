<template>
  <div>
    restuaraunt details
    <img v-bind:src="restaurant.imgUrl" width="200" />
    <h1 class="restaurant-name">{{ restaurant.restaurantName }}></h1>
    <h2 class="phoneNumber">{{ restaurant.phoneNumber }}</h2>
    <h3 class="rating">{{ restaurant.rating }}</h3>
    <h4 class="price">{{ restaurant.price }}</h4>
    <h5
      class="transactions"
      v-bind:transaction="transaction"
      v-for="transaction in transactions"
      v-bind:key="transaction.id"
    >
      {{ transaction }}
    </h5>
    <div class="reviews container">
      <review-card
        v-bind:review="review"
        v-for="review in reviews"
        v-bind:key="review.id"
      >
        <div class="review-text">{{ review.reviewText }}</div>
        <div class="review-rating">{{ review.rating }}</div>
        <div class="reivewer-name">{{ review.name }}</div>
        <img v-bind:src="review.imageUrl" width="250" />
      </review-card>
    </div>
    <div
      class="photo-container"
      v-bind:photo="photo"
      v-for="photo in restaurant.photos"
      v-bind:key="photo.id"
    >
      <img v-bind:src="photo" />
    </div>
    <!-- 
Phone Number
Rating
Reviews -->
  </div>
</template>

<script>
import yelpService from "../services/YelpService";
export default {
  data() {
    return { restaurant: {}, reviews: [], transactions: [] };
  },

  created() {
    let id = this.$route.params.id;
    yelpService.getBusinessDetails(id).then((response) => {
      this.restaurant = response.data;
      this.transactions = this.restaurant.transactions;
    }),
      yelpService.getBusinessReviews(id).then((response) => {
        this.reviews = response.data;
      });
  },
};
</script>

<style>
</style>