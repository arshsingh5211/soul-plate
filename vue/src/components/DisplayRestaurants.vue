<template>
  <div id="main">
    <div class="restaurant-container">
      <div class="search-page">
        <a
          id="show-form-button"
          href="#"
          v-on:click.prevent="resetSearch"
          v-if="showForm === false"
          >Change Preferences</a
        >

        <form v-if="showForm === true">
          <div class="search-bar">
            <h1 class="search-bar-header">What are you in the mood for?</h1>
            <input
              v-model="newPreferences.foodPref"
              type="text"
              name="test"
              id=""
              placeholder="ex: Pizza"
            />
            <br />
            <input
              v-model="newPreferences.zipCode"
              type="text"
              placeholder="Zip Code"
            />
            <br />
            <button class="search-button" v-on:click.prevent="startSearch">
              Search
            </button>
          </div>
        </form>
      </div>
  

      <div
        class="card"
        v-for="restaurant in restaurants.slice().reverse()"
        v-bind:key="restaurant.yelpId"
      >
        <img class="restaurant-img" v-bind:src="restaurant.imgUrl" />
        <h2 class="restaurant-name">{{ restaurant.restaurantName }}</h2>
        <h3 class="restaurant-address">
          {{ restaurant.address }} <br />
          {{ restaurant.city }}, {{ restaurant.state }}
          {{ restaurant.zipCode }}
        </h3>
        <h4 class="restaurant-rating">Rating: {{restaurant.rating}}</h4>
        <h5 class="restaurant-review">{{ restaurant.review }}</h5>
        <h6 class="restaurant-price">{{ restaurant.price }}</h6>
        <div class="restaurant-transactions">{{ restaurant.transactions }}</div>

        <button class="dislike" v-on:click.prevent="removeRestaurant">
          Dislike this restaurant
        </button>
        <button
          class="like"
          v-on:click.prevent="addToLikedRestaurants(restaurant)"
        >
          Like this Restaurant
        </button>

        <br />
                <button v-on:click.prevent="saveCurrentRestaurants(restaurant)">
          View Details
        </button>
      </div>
    </div>
  </div>
</template>

<script>

import yelpService from "../services/YelpService";


export default {
  name: "display-restaurants",
  components: {},
  data() {
    return {
      newPreferences: {
        foodPref: "",
        zipCode: "",
      },
      showForm: true,
      
      restaurants: [],
    };
  },

   created() {
    if (this.$route.params.showForm != null) {
      this.showForm = this.$route.params.showForm;
    } else {
      this.showForm = true;
    }
    this.restaurants = this.$store.state.currentRestaurants
    this.$store.commit('RESET_CURRENT_RESTAURANTS')
  },
  methods: {
        saveCurrentRestaurants(restaurant) {
      this.$store.commit('ADD_CURRENT_RESTAURANTS', this.restaurants);
      this.$router.push({
        name: "restaurant-details",
        params: { id: `${restaurant.yelpId}` },
      });
    },
    resetSearch() {
      this.restaurants = []
      this.showForm = true

    },
    startSearch() {

      yelpService
        .getSearchResults(this.newPreferences)
        .then((response) => (this.restaurants = response.data));
        
      this.showForm = false;
    },
    removeRestaurant() {
      this.restaurants.shift();
    },

    addUserPref() {
      let preferenceObject = {
        category: this.newPreferences.foodPref,
        zipCode: this.newPreferences.zipCode,
      };
      console.log("debug");
      console.log(preferenceObject);

      this.$store.commit("ADD_USER_PREF", preferenceObject);
    },
    addToLikedRestaurants(restaurant) {
      this.restaurants.shift();
      this.$store.commit('ADD_LIKED_RESTAURANT', restaurant)

      // yelpService
      //   .addLikedRestaurant(restaurant)
      //   .then((response) => {
          
      //     if (response.status === 201) {
      //       // this.$router.push(`/`);
            
      //     }
      //   })
      //   .catch((error) => {
      //     this.handleErrorResponse(error, "adding");
      //   });
    },
  },

  addToLikedRestaurants() {
    yelpService
      .addLikedRestaurant(this.restaurant)
      .then((response) => {
        alert("restaurant added!");
        if (response.status === 201) {
          this.$store.commit("ADD_LIKED_RESTSTAURANT", this.restaurant);
        }
      })
      .catch((error) => {
        this.handleErrorResponse(error, "adding");
      });
  },


};
</script>

<style>
@import url("https://fonts.googleapis.com/css2?family=Cormorant+Garamond&family=Montserrat&family=Roboto:wght@300&display=swap");

.search-page {
  width: 100%;
  height: 100%;
  margin-left: auto;
  margin-right: auto;

  display: flex;
}

.search-bar label {
  align-content: center;
  padding: 0 0 100px 0;
}

.search-bar {
  display: block;
  margin-top: 5%;
  position: absolute;
  top: 20%;
  left: 50%;
  font-family: "Montserrat", serif;
  font-size: 12px;
  background: whitesmoke;
  padding: 5px 40px 5px 40px;
  text-align: center;
  box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);
  border-radius: 10px;
  -ms-transform: translate(-50%, -50%);
  transform: translate(-50%, -50%);
  line-height: 30px;
}

h1.search-bar-header {
  font-family: "Montserrat", serif;
  color: #cf740cf1;
  text-align: center;
  width: 100%;
  margin-left: -1%;
  background: whitesmoke;
}

.search-button {
  text-transform: uppercase;
  outline: 0;
  background: #fc931af1;
  width: 100%;
  border: 0;
  padding: 15px;
  margin-bottom: 20px;
  color: #ffffff;
  font-size: 14px;
  -webkit-transition: all 0.3 ease;
  transition: all 0.3 ease;
  cursor: pointer;
}


input {
  text-align: center;
  background: rgb(243, 231, 226);
  width: 75%;
  border: 0;
  margin: 0 0 15px;
  padding: 15px;
  box-sizing: border-box;
  font-size: 14px;
}

#show-form-button {
  background: cornsilk;
  align-items: center;
  color: black;
  text-align: center;
  box-sizing: border-box;
  font-size: 20px;
}
.card-orientation {
  align-items: center;
  justify-content: center;
  position: relative;
  display: grid;
}
.card {
  font-family: "Cormorant Garamond", serif;
  box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);
  border-radius: 10px;
  -ms-transform: translate(-50%, -50%);
  transform: translate(-50%, -50%);
  width: 425px;
  height: 650px;
  margin-top: 25%;
  margin-left: 5%;
  background: rgb(243, 231, 226);
  text-align: center;
  position: absolute;
  align-items: center;
  align-content: center;
}
h3 {
  width: 200px;
  align-content: center;
  text-align: center;
}

.restaurant-img {
  max-width: 400px;
  height: 275px;
}

button.like {
  text-transform: uppercase;
  margin-left: 15px;
  margin-bottom: 10px;
}
button.like:hover {
  background: chartreuse;
}
button.dislike {
  text-transform: uppercase;
}
button.dislike:hover {
  background: red;
}
.card .restaurant-name {
  font-size: 1.8rem;
}

.card .restaurant-zip {
  font-size: 1rem;
}
button {
  vertical-align: baseline;
}
.restaurant-address {
  display: inline;
  align-items: center;
  font-family: "Roboto", sans-serif;
}
</style>
