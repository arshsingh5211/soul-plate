<template>
  <form class="pref-form" v-on:submit.prevent="savePreferences">
      <h1>Edit Preferences</h1>
      <h4>Tell us what your taste buds like! You can always change your preferences later.</h4>
      <div class="form-element">
          <label for="user">Your Name:</label>
          <input id="user" type="text" v-model="newPreferences.name" />
      </div>
      <div class="form-element">
          <label for="zip">Home Zip Code:</label>
          <input id="zip" type="text" v-model="newPreferences.homeZip" />
      </div>
      <div class="form-element">
          <label for="restaurant-preference">What cuisines do you like? Any nutritional barriers or allergies? </label><br>
          <select id="preference" v-model="newPreferences.preference">
            <option value="american">American</option>
            <option value="mexican">Mexican</option>
            <option value="italian">Italian</option>
            <option value="indian">Indian</option>
            <option value="chinese">Chinese</option>
          </select>
      </div>
      <div class="actions">
          <button v-on:click.prevent="resetForm" type="reset">reset</button>
          <button v-on:click="savePreferences">Save</button>
      </div>
  </form>
</template>

<script>
import yelpService from "../services/YelpService"
export default {
    name: "add-preferences",
    props: ["userId"],
    data() {
        return {
            newPreferences: {
                preferencesID: 0,
                userId: this.userId,
                name: "",
                homeZip: "",
                preference: ""
            }
        };
    },
    methods: {
        savePreferences() {
          // const newUserPref = {
          //   category: this.newPreferences.category,
          //   zipCode: this.newPreferences.zipCode
          // }
          // const userID = this.$route.params.userID;
          // this.newPreferences.userID = userID;
          yelpService.addPreferences(this.newPreferences).then(response => {
            if (response.status === 201) {
              this.$router.push('/');
            }
          })
          .catch(error => {
            this.handleErrorResponse(error, "adding");
          });
        },
        
      
        // //this.$store.commit("EDIT_PREFERENCES", this.newPreferences);
        // },
        resetForm() {
        this.newPreferences = {};
        }
    }
}
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Cormorant+Garamond&family=Montserrat&family=Roboto:wght@300&display=swap');

.pref-form body {
  width: 100%;
  height: 100%;
  margin-left: auto;
  margin-right: auto;
  padding: 8% 0 0;
  margin: 0;
  display: flex;
}

.pref-form label {
  color: #c26801;
  display: inline-block;
  width: 250px;
}

 .pref-form h1 {
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

.pref-form h4 {
  font-family: 'Monteserrat', serif;
  font-weight: bold;
  display: block;
  margin-left: auto;
  margin-right: auto;
  width: 100%;
  height: auto;
  color: #42403ff1;
  letter-spacing: 1px;
  max-width: 100%;
  min-width: 0px;
  opacity: 1;
  word-break: keep-all;
  padding: 10px 0px 10px 0px;
}

label.sr-only {
  align-content: center;
}

.pref-form {
  margin: 0;
  position: absolute;
  top: 40%;
  left: 50%;
  font-family: 'Montserrat', serif;
  font-size: 12px;
  background:whitesmoke;
  max-width: 300px;
  padding: 10px 40px 20px 40px;
  text-align: center;
  box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);
  border-radius: 10px;
  -ms-transform: translate(-50%, -50%);
  transform: translate(-50%, -50%);
}

.pref-form input {
  font-family: "Roboto", sans-serif;
  display: inline-block;
  outline: 0;
  background: rgb(243, 231, 226);
  width: 50%;
  border: 0;
  margin: 0 0 15px;
  padding: 5px;
  box-sizing: border-box;
  font-size: 14px;
  text-align: right;
}

.pref-form button {
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
button:hover {
  opacity: 0.9;
}
.have-account:hover {
  opacity: 0.8;
}
</style>
