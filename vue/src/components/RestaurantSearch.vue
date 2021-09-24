<template>
  <div>

      <div class='container'>
      <!-- <div class='restaurant-card' v-for="restaurant in restaurants" v-bind:key="restaurant.id"> -->
        <table>
            <thead>
                <tr>
                    <th>Restaurant Name</th>
                    <th>Phone Number</th>
                    <th>Rating</th>
                </tr>
              </thead>
              <tbody>
                  <tr v-for="restaurant in restaurants" v-bind:key="restaurant.id">
                      <td class="restaurant-name">{{restaurant.restaurantName}}</td>
                      <td class="restaurant-phone"> {{restaurant.phoneNumber}}</td>
                      <td class="restaurant-rating">{{restaurant.rating}}</td>
                  </tr>
              </tbody>
          </table>
      </div>

      <input v-model="preference" type="text" name="test" id="">
      <input v-model="location" type="text">
      <button v-on:click="startSearch" >Search</button>
  </div>
</template>

<script>
import YelpService from "../services/YelpService.js"
export default {
    data(){

    return{
        restaurants: [],
        preference: "",
        location: ""
    }},
    methods: {
        startSearch() {
            let info = {category: this.preference, zipCode: this.location}
            YelpService.getSearchResults(info)
            .then(
                response => this.restaurants = response.data

            )
        }
    }

}
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Cormorant+Garamond&family=Montserrat&family=Roboto:wght@300&display=swap');

.restaurant-card {
    border: 1px solid black;
    background: whitesmoke;
    border-radius: 10px;
    width: 250px;
    height: 200px;
    margin: 20px;
    padding-left: 10px;
}

.restaurant-name {
    font-family: 'Cormorant Garamond', serif;
    font-weight: bold;
    display: block;
    text-transform: uppercase;
    margin-left: auto;
    margin-right: auto;
    width: 100%;
    height: auto;
    color: #cf740cf1;
    letter-spacing: 2px;
    max-width: 100%;
    min-width: 0px;
    opacity: 1;
    word-break: keep-all;
    padding: 10px 0px 10px 0px;
    line-height: 27.2px;
}

.restaurant-phone {
    font-family: 'Montserrat', serif;

}

.container {
    display: flex;
    flex-direction: row;
    flex-wrap: wrap;
    margin: 0;
    position: absolute;
    top: 40%;
    left: 30%;
    border: 1px solid black;
    background: whitesmoke;
    border-radius: 10px;
    padding: 20px;
    height: 60%;
    overflow-y: scroll;
}

</style>