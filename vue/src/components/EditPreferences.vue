<template>
  <form v-on:submit.prevent="savePreferences">
      <div class="form-element">
          <label for="user">Name:</label>
          <input id="user" type="text" v-model="newUser.user" />
      </div>
      <div class="form-element">
          <label for="zip">Home Zip Code:</label>
          <input id="zip" type="text" v-model="newUser.zip" />
      </div>
      <div class="form-element">
          <label for="restaurant-preference">Restaurant Preference</label>
          <select id="preference" v-model="newUser.preference" />
          <option value="american">American</option>
          <option value="mexican">Mexican</option>
          <option value="italian">Italian</option>
          <option value="indian">Indian</option>
          <option value="chinese">Chinese</option>
      </div>
      <div class="actions">
          <button v-on:click.prevent="resetForm" type="cancel">Cancel</button>
          <button>Submit</button>
      </div>
  </form>
</template>

<script>
export default {
    name: "add-preferences",
    data() {
        return {
            newPreferences: {
                preferenceName: "",
                preferencesID: 0,
                profileID: 0,
                homeZip: ""
            }
            
            
            
        };

    },
    methods: {
        savePreferences() {
        const userID = this.$route.params.id;
        this.newPreferences.userID = userID;
        //this.$store.commit("EDIT_PREFERENCES", this.newPreferences);
        },
        resetForm() {
        this.newPreferences = {};
        }
    }
}
</script>

<style>

</style>