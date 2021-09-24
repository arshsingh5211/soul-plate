<template>
  <div class="search-page">
        <table class='table-container'>
            <thead class="table-headers">
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
    <div class = "search-bar">
      <label for="category">What are you in the mood for?</label>
      <input v-model="preference" type="text" name="test" id="" placeholder="Pizza"/>
      <label for="zip-code"><br>Which zip code?</label>
      <input v-model="location" type="text" placeholder="19210"/>
      <button v-on:click="startSearch" >Search</button>
    </div>
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
    margin: 0;
    position: absolute;
    top: 15%;
    left: 60%;
    font-family: 'Montserrat', serif;
    font-size: 12px;
    background:whitesmoke;
    padding: 10px 40px 20px 40px;
    text-align: center;
    box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);
    border-radius: 10px;
    -ms-transform: translate(-50%, -50%);
    transform: translate(-50%, -50%);
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

.table-headers {
    font-family: 'Cormorant Garamond', serif;
    text-transform: uppercase;
}

.restaurant-phone {
    font-family: 'Montserrat', serif;
    color: #42403ff1;
}

.table-container {
    display: flex;
    flex-direction: row;
    flex-wrap: wrap;
    justify-content: center;
    align-items: center;
    margin: 0;
    position: absolute;
    top: 30%;
    left: 20%;
    border: 1px solid black;
    background: whitesmoke;
    border-radius: 10px;
    padding: 20px;
    max-height: 30%;
    overflow-y: scroll;
}

</style>