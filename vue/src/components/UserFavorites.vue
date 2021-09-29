<template>
  <div>

<h1> Your Previously Favorited Restaurants</h1>
  <div class="liked-card">
    <div class="item" v-for="restaurant in $store.state.likedRestaurants" v-bind:key="restaurant.yelpId"> 
      <img v-bind:src=restaurant.imgUrl width="250" />
      <h2 class="restaurant-name">{{ restaurant.restaurantName }}</h2>
      <h3 class="restaurant-address">
          {{ restaurant.address }} <br />
          {{ restaurant.city }}, {{ restaurant.state }}
          {{ restaurant.zipCode }}
        </h3>
      <h4 class="restaurant-rating">Rating: {{restaurant.rating}}</h4>  
      <router-link
          v-bind:to="{
            name: 'restaurant-details',
            params: { id: restaurant.yelpId },
          }"
          tag="button"
          >View Details</router-link>
    </div>
  </div>
  </div>
</template>

<script>
// import DisplayRestaurants from './DisplayRestaurants.vue'
// import restaurantCards from "/RestaurantCard.vue"
export default {
  data(){
    return {
      restaurants: []

    }
  },
  components: {  },

}
</script>

<style>
h1 {
  text-align: center;
  background: rgb(243, 231, 226);
  width: 40%;
  margin-left: 30%;
}

.liked-card {
  
  display:flex;
  flex-wrap: wrap;
}

.item {
  width: 20%;
  margin: 10px;
 background: rgb(243, 231, 226);
}
</style>