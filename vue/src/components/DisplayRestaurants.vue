<template>
  <div id="main">
      <div class="restaurant-container">
          <restaurant-card v-bind:restaurant="restaurant" v-for="restaurant in restaurants" v-bind:key="restaurant.yelpId"/>
          <!-- <div class="restaurants" v-for="restaurant in restaurants" :key="restaurant.id">
              Restaurant Name: {{restaurant.name}}
              <br />
              Restaurant Ratings: {{restaurant.rating}}  
              <br />
              Categories: {{restaurant.categories}}
              <br />
              Is it open?: {{restaurant.isOpen}}
              <br />
              1 Review: {{restaurant.review}} 
              <br />
              Services: {{restaurant.transactions}} 
              <br />
              <img v-bind:src=restaurant.image width="200" />
          </div> -->
      </div>
  </div>
</template>

<script>
import RestaurantCard from "./RestaurantCard.vue";
import yelpService from "../services/YelpService";
export default {
    name: 'display-restaurants',
  components: { RestaurantCard },
    data() {
        return { restaurants: []};
    },

    created() { //up to 3 yelp calls if 3 preferences set
    //? for(this.$store.state.userPreferences.size???)
    //let pref1 = this.$store.state.userpreferences[0]
    //let pref2 = this.$store.state.userpreferences[1]
    //let pref3 = this.$store.state.userpreferences[2]
    
    this.$store.searchedRestaurants = [] //set array to empty everytime you search?
        yelpService
        .getSearchResults(this.$store.state.userPreferences[0])
        .then((response) => {
            this.restaurants = response.data;
            for(this.restaurant in this.restaurants){
                this.$store.commit('ADD_SEARCHED_RESTAURANT', this.restaurant)
            }
            
        })
    }

}
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