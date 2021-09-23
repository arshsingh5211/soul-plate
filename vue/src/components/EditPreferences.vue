<template>
  <form class="pref-form" v-on:submit.prevent="savePreferences">
      <h1>Edit Preferences</h1>
      <h4>Tell us what your taste buds like! You can always change your preferences later.</h4>
      <div class="form-element">
          <label for="user">What's your name: </label>
          <input id="user" type="text" v-model="newPreferences.name" />
      </div>
      <div class="form-element">
          <label for="zip">Home Zip Code: </label>
          <input id="zip" type="text" v-model="newPreferences.homeZip" />
      </div>
      <div class="form-element">
          <label for="restaurant-preference">What cuisines do you like? Any nutritional barriers or allergies? </label><br>
          <select id="preference" v-model="newPreferences.preferencesID">
            <option value="american">American</option>
            <option value="mexican">Mexican</option>
            <option value="italian">Italian</option>
            <option value="indian">Indian</option>
            <option value="chinese">Chinese</option>
          </select>
      </div>
      <div class="actions">
          <button v-on:click.prevent="resetForm" type="reset">reset</button>
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
                name: "",
                preferencesID: 0,
                userID: 0,
                homeZip: ""
            }
            
            
            
        };

    },
    methods: {
        savePreferences() {
        const userID = this.$route.params.userID;
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
@import url('https://fonts.googleapis.com/css2?family=Cormorant+Garamond&family=Montserrat&family=Roboto:wght@300&display=swap');

.pref-form body {
  width: 100%;
  height: 100%;
  padding: 8% 0 0;
  margin: 0;
  display: flex;
}

label {
  color: #c26801;
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
  outline: 0;
  background: rgb(243, 231, 226);
  width: 50%;
  border: 0;
  margin: 0 0 15px;
  padding: 5px;
  box-sizing: border-box;
  font-size: 14px;
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