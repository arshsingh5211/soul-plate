<template>
  <div>
    <h1>{{ restaurant.restaurantName }} Details</h1>
    <div class="restaurant-details" style="white-space: nowrap">
      <img v-bind:src="restaurant.imgUrl" width="200" style="float:left;" />
      <!-- <h1 class="restaurant-name" >{{ restaurant.restaurantName }}</h1> -->
      <br/>
      <h2 class="phoneNumber">Phone Number: {{ restaurant.phoneNumber }}</h2>
      
      <star-rating class="avg-restaurant-review"/>
      

      <h4 class="price">Price: {{ restaurant.price }}</h4>
      <h5>Service Options: </h5>
      <h5
        class="transactions"
        v-bind:transaction="transaction"
        v-for="transaction in transactions"
        v-bind:key="transaction.id"
      >
       &emsp; | {{ transaction }} 
      </h5>
    </div>
    <div class="reviews-container">
      <review-card
        v-bind:review="review"
        v-for="review in reviews"
        v-bind:key="review.id"
      >
     <!-- <img v-bind:src="review.imageUrl" width="50" />  -->
      <div class="reivewer-name">{{ review.name }}</div>
        <div class="review-text">Review: {{ review.reviewText }}</div>
        <div class="review-rating">Rating: {{restaurant.rating}} <star-rating class="individual-review"/></div>
        
      </review-card>
      
    </div>
     
    <div
      class="photo-container"
      v-bind:photo="photo"
      v-for="photo in restaurant.photos"
      v-bind:key="photo.id"
    >
      <!-- <img class="review-photo" v-bind:src="photo" /> -->
    </div>
    <!-- 
Phone Number
Rating
Reviews -->
  </div>
</template>

<script>
import yelpService from "../services/YelpService";
import StarRating from './StarRating.vue';

export default {
  components: { StarRating },
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
@import url("https://fonts.googleapis.com/css2?family=Cormorant+Garamond&family=Montserrat&family=Roboto:wght@300&display=swap");

.rating{
 
}
.individual-review{
  width: 350px;
}
.avg-restaurant-review{
  
  width:  350px;
}
.restaurant-details {
  font-family: "Cormorant Garamond", serif;
  box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);
  border-radius: 10px;
  -ms-transform: translate(-50%, -50%);
  transform: translate(-50%, -50%);
  width: 700px;
  height: 300px;
  margin-top: 10%;
  margin-left: 40%;
  background: rgb(243, 231, 226);
  display: inline-block;
  position: absolute;
  align-items: center;
  align-content: center;
}

h1 {
  color: #cf740cf1;
  background: transparent;
}

h5 {
  display: inline-block;
  font-size: medium;
}

.price {
  font-size: 20px;
}

.reviews-container {
  margin-top: 25%;
  background: rgb(243, 231, 226);
  display: inline-block;
  position: absolute;
  margin-left: 10%;
  margin-right: auto;
  
}

.photo-container {
 display:flex;
 flex-wrap: wrap;
 flex-direction: row;
 margin-left: 80%;
}
.review-photo {
  
 width: 50%;

}
</style>