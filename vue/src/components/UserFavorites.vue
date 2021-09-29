<template>
  <div>

<h1> Your Previously Favorited Restaurants</h1>
    <div v-for="restaurant in $store.state.likedRestaurants" v-bind:key="restaurant.yelpId"> 
      <img v-bind:src=restaurant.imgUrl width="250" />
      <h2 class="restaurant-name">{{ restaurant.restaurantName }}</h2>
      <h3 class="restaurant-zip">{{ restaurant.zipCode }}</h3>
      <h4 class="restaurant-rating">{{restaurant.rating}}</h4>  
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
</style>