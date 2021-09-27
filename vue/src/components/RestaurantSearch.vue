<template>
  <div class="search-page">
        <!-- <table class='table-container'>
            <thead class="table-headers">
                <tr >
                    <th class="name-header">Restaurant Name  </th>
                    <th class="number-header">Phone Number  </th>
                    <th class="rating-header">Rating</th>
                </tr>
            </thead>
              <tbody>
                  <tr v-for="restaurant in restaurants" v-bind:key="restaurant.id">
                      <td class="restaurant-name">{{restaurant.restaurantName}}</td>
                      <td class="restaurant-phone"> {{restaurant.phoneNumber}}</td>
                      <td class="restaurant-rating">{{restaurant.rating}}</td>
                  </tr>
              </tbody>
        </table> -->

        <a
      id="show-form-button"
      href="#"
      v-on:click.prevent="showForm = true"
      v-if="showForm === false"
      >Change Preferences</a
    >
    <form v-if="showForm === true">
    <div class = "search-bar" >
        <h1 class="search-bar-header"> What are you in the mood for? </h1>
      <input v-model="newPreferences.foodPref" type="text" name="test" id="" placeholder="ex: Pizza"/> 
      <br>
      <input v-model="newPreferences.homeZip" type="text" placeholder="Enter your zipcode"/>
      <br>
      <button class="search-button" v-on:click="startSearch" >Search</button>
    </div>
    </form>
  </div>
</template>

<script>
import YelpService from "../services/YelpService.js"
export default {
    data(){

    return{
        restaurants: [],
        newPreferences: {
                zipCode: "",
                foodPref: ""
            },
        showForm: true
    }},
    methods: {
        startSearch() {
            let info = {category: this.foodPref, zipCode: this.zipCode}
            YelpService.getSearchResults(info)
            .then(
                response => this.restaurants = response.data

            )
            this.showForm = false;
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
    top: 20%;
    left: 50%;
    font-family: 'Montserrat', serif;
    font-size: 12px;
    background:whitesmoke;
    padding: 5px 40px 5px 40px;
    text-align: center;
    box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);
    border-radius: 10px;
    -ms-transform: translate(-50%, -50%);
    transform: translate(-50%, -50%);
    line-height: 30px;
    
}


.restaurant-name {
    font-family: 'Cormorant Garamond', serif;
    font-weight: bold;
    text-transform: uppercase;
    margin-left: auto;
    margin-right: auto;
    width: 45%;
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
    background: rgb(243, 231, 226);
}

.restaurant-phone {
    font-family: 'Montserrat', serif;
    color: #42403ff1;
}
.table-container th {
    padding: 10px 45px;
    
}
.table-container td {
    padding: 10px 20px ;
}

.table-container {
    display: flex;
    flex-direction: row;
    flex-wrap: wrap;
    text-align: center;
    justify-content: space-between;
    align-items: center;
    position: absolute;
    top: 50%;
    left: 25%;
    right: 25%;
    border: 1px solid black;
    background: whitesmoke;
    border-radius: 10px;
    padding: 20px;
    max-height: 40%;
    overflow-y: scroll;
    
}

.search-button {
    text-transform: uppercase;
    outline: 0;
    background: #fc931af1;
    width: 100%;
    border: 0;
    padding: 15px;
    margin-bottom: 20px;
    color: #FFFFFF;
    font-size: 14px;
    -webkit-transition: all 0.3 ease;
    transition: all 0.3 ease;
    cursor: pointer;
}
.search-bar-header {
    font-family: 'Montserrat', serif;
    color: #cf740cf1;;
    text-align: center;
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
    background: rgb(243, 231, 226);
    align-items: center;
    color: black;
    text-align: center;
    box-sizing: border-box;
    font-size: 20px;
}


</style>