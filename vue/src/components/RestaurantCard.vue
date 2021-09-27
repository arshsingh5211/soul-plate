<template>
  <div class="card-orientation">
  <div class="card">

      <img v-bind:src=restaurant.imgUrl width="250" />
    <h2 class="restaurant-name">{{ restaurant.restaurantName }}</h2>
    <h3 class="restaurant-zip">{{ restaurant.zipCode }}</h3>
    <h4 class="restaurant-rating">{{restaurant.rating}}</h4>
    <h5 class="restaurant-review">{{restaurant.review}}</h5>
    <h4 class="restaurant-price">{{restaurant.price}}</h4>
    <h7 class="restaurant-transactions">{{restaurant.transactions}}</h7>
    <button v-on:click.prevent="addToLikedRestaurants(restaurant)">Like this Restaurant</button> <br>
    <router-link v-bind:to="{name: 'restaurant-details', params: {id: restaurant.yelpId}}" tag="button">View Details</router-link>
  </div>
  </div>
</template>

<script>
import YelpService from '../services/YelpService'
export default {
    name: 'restaurant-card',
    props: ["restaurant"],
    restaurant: Object,
    methods: {
        addToLikedRestaurants() {
            YelpService.addLikedRestaurant(this.restaurant).then(response => {
                if (response.status === 201) {
                    this.$router.push(`/`);
                }
            })
            .catch(error => {
                this.handleErrorResponse(error, "adding");
            });
            //this.$store.commit('ADD_LIKED_RESTAURANT', restaurant)
        }
    }
}
</script>

<style>
.card-orientation {
    display: flex;
    flex-wrap: wrap;
    flex-direction: row;
}
.card {
    border: 2px solid black;
    border-radius: 10px;
    width: 250px;
    height: 550px;
    margin: 20px;
    background: gray;
    text-align: center;
    
}

.card.like {
    background-color: lightgray;
}

.card .restaurant-name {
    font-size: 1.5rem;
}

.card .restaurant-zip {
    font-size: 1rem;
}
</style>