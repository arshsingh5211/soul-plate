
<template>
  <div class="search-page">

    <a
      id="show-form-button"
      href="#"
      v-on:click.prevent="showForm = true"
      v-if="showForm === false"
      >Change Preferences</a>

    <form v-if="showForm === true">
    <div class = "search-bar" >
        <h1 class="search-bar-header"> What are you in the mood for? </h1>
      <input v-model="newPreferences.foodPref" type="text" name="test" id="" placeholder="ex: Pizza"/> 
      <br>
      <input v-model="newPreferences.zipCode" type="text" placeholder="Enter your zipcode"/>
      <br>
      <button class="search-button" v-on:click.prevent="addUserPref" >Add Preference</button>
      <button class="search-button" v-on:click.prevent="startSearch" >Search</button>
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
                foodPref: "pizza",
                zipCode: "60614",
            },
        showForm: true
    }},
    methods: {
        addUserPref(){

        let preferenceObject ={category:this.newPreferences.foodPref, zipCode:this.newPreferences.zipCode};
        console.log('debug');
        console.log(preferenceObject)
    
        this.$store.commit('ADD_USER_PREF', preferenceObject)

        },
        startSearch() {
            let info = {category: this.foodPref, zipCode: this.zipCode}
            YelpService.getSearchResults(info)
            .then(
                response => this.restaurants = response.data

            )
            this.showForm = false;

    //    yelpService.getSearchResults(this.$store.state.userPreferences)
    //   .then((response) => {
    //     this.restaurants = response.data;
    //     for (this.restaurant in this.restaurants) {
    //       this.$store.commit("ADD_SEARCHED_RESTAURANT", this.restaurant);
    //     }
    //   });

}}

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