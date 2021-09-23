<template>
  <form v-on:submit.prevent="savePreferences">
      <div class="form-element">
          <label for="user">Name:</label>
          <input id="user" type="text" v-model="newPreferences.category" />
      </div>
      <div class="form-element">
          <label for="zip">Home Zip Code:</label>
          <input id="zip" type="text" v-model="newPreferences.zipCode" />
      </div>
      <div class="form-element">
          <label for="restaurant-preference">Restaurant Preference</label>
          <select id="preference" v-model="newPreferences.category">
            <option value="american">American</option>
            <option value="mexican">Mexican</option>
            <option value="italian">Italian</option>
            <option value="indian">Indian</option>
            <option value="chinese">Chinese</option>
          </select>
      </div>
      <div class="actions">
          <button v-on:click.prevent="resetForm" type="cancel">Cancel</button>
          <button>Submit</button>
      </div>
  </form>
</template>

<script>
import YelpService from '../services/YelpService';
export default {
    name: "add-preferences",
    data() {
        return {
            newPreferences: {
                category: "",
                preferencesID: 0,
                profileID: 0,
                zipCode: ""
                
            }
            
            
            
        };

    },
    methods: {
        savePreferences() {
        const userID = this.$route.params.userID;
        this.newPreferences.userID = userID;
        //this.$store.commit("EDIT_PREFERENCES", this.newPreferences);
        const addPreference = {
            category: this.category,
            zipCode: this.zipCode,
            

        }
        YelpService
        .postSearchResults(addPreference)
        // .then((response) => {
        //     alert("restaurant added!");
        //    this.$router.push('/');
        // })
        // .catch((err) => {
        //     console.error(err + " problem adding restaurant!")
        // })
        },
        resetForm() {
        this.newPreferences = {};
        }
    }
}
</script>

<style>

</style>