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
    <button class="like" v-on:click.prevent="addToLikedRestaurants(restaurant)">Like this Restaurant</button> <br>
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
@import url('https://fonts.googleapis.com/css2?family=Cormorant+Garamond&family=Montserrat&family=Roboto:wght@300&display=swap');

.card-orientation {
    align-items: center;
    justify-content: center;
    position: relative;
    display: grid;
    
}
.card {
    font-family: 'Cormorant Garamond', serif;
    box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);
    border-radius: 10px;
    -ms-transform: translate(-50%, -50%);
    transform: translate(-50%, -50%);
    width: 250px;
    height: 550px;
    margin: 20px;
    background: gray;
    text-align: center;
    position: absolute;
}

.card.like {
    text-transform: uppercase;
  outline: 0;
  background: #fc931af1;
  width: 30%;
  margin: 10px;
  border: 0;
  padding: 5px;
  margin-bottom: 20px;
  color: #FFFFFF;
  font-size: 14px;
  -webkit-transition: all 0.3 ease;
  transition: all 0.3 ease;
  cursor: pointer;
}

.card .restaurant-name {
    font-size: 1.5rem;
}

.card .restaurant-zip {
    font-size: 1rem;
}
</style>