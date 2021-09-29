<template>
  <div id="main">
      <div class="restaurant-container">
        
          <!-- <restaurant-card v-bind:restaurant="restaurant" v-for="restaurant in restaurants" v-bind:key="restaurant.yelpId"/> -->
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
          <div class="card-orientation">
  <div class="card" v-for="restaurant in restaurants" v-bind:key="restaurant.yelpId">
    
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
      </div>
  </div>
</template>

<script>
// import RestaurantCard from "./RestaurantCard.vue";
import yelpService from "../services/YelpService";
export default {
    name: 'display-restaurants',
  components: { },
    data() {
        return { restaurants: []};
    },
  methods: {
        addToLikedRestaurants(restaurant) {
          this.restaurants.pop()
            yelpService.addLikedRestaurant(restaurant).then(response => {
                if (response.status === 201) {
                    // this.$router.push(`/`);
                    
                }
            })
            .catch(error => {
                this.handleErrorResponse(error, "adding");
            });
            // this.$store.commit('ADD_LIKED_RESTAURANT', this.restaurant)
        }
    },
    // created() { //up to 3 yelp calls if 3 preferences set
    // //let pref1 = this.$store.state.userpreferences[0]
    // //let pref2 = this.$store.state.userpreferences[1]
    // //let pref3 = this.$store.state.userpreferences[2]
    
    // this.$store.searchedRestaurants = [] //set array to empty everytime you search?
    //     yelpService
    //     .getSearchResults(this.$store.state.userPreferences[0])
    //     .then((response) => {
    //         this.restaurants = response.data;
    //         for(this.restaurant in this.restaurants){
    //             this.$store.commit('ADD_SEARCHED_RESTAURANT', this.restaurant)
    //         }
            
    //     })
    // }

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
    height: 650px;
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