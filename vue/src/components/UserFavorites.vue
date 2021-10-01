<template>
  <div>

<h1> Your Previously Favorited Restaurants</h1>
  <div class="liked-card">
    <div class="item" v-for="restaurant in $store.state.likedRestaurants" v-bind:key="restaurant.yelpId"> 
      <img class="fav-img" v-bind:src=restaurant.imgUrl  />
      <h2 class="fav-name">{{ restaurant.restaurantName }}</h2>
      <h3 class="fav-address">
          {{ restaurant.address }} <br />
          {{ restaurant.city }}, {{ restaurant.state }}
          {{ restaurant.zipCode }}
        </h3>
      <h4 class="fav-rating">Rating: {{restaurant.rating}}</h4>  
      <router-link class="fav-details"
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
  align-items: center;
  text-align: center;
  display:flex;
  flex-wrap: wrap;
}

.item {
  box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);
  margin: 10px;
  background: rgb(243, 231, 226);
  align-items: center;
  justify-content: center;
  position: relative;
  display: grid;
  width: 250px;
  height: 500px;
  text-align: center;
}

.fav-img {
 max-width: 250px;
 max-height: 225px;
 align-content: center;
}
.fav-details {
  margin-bottom: 15px;
  width: 100px;
  align-items: center;
  text-align: center;
}
.fav-rating {
  text-align: center;
}
.fav-name {
  text-align: center;
}
.fav-address {
  text-align: center;
}
</style>