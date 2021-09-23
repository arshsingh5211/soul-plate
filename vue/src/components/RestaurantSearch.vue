<template>
  <div>

      <div class='container'>
      <div class='restaurant-card' v-for="restaurant in restaurants" v-bind:key="restaurant.id">
          {{restaurant.restaurant_name}}
      </div>

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

    .restaurant-card {
        background-color: coral;
        margin: 10px;
        padding: 10px;
        width: 200px;
    }

    .container {
        display: flex;
        flex-direction: row;
        flex-wrap: wrap;
    }

</style>