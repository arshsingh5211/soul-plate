<template>
  <div id="login" class="text-center">
    <form class="form-signin" @submit.prevent="login">
      <h1 class="sign-in">Find your SoulPLATE!</h1>
      <div
        class="alert alert-danger"
        role="alert"
        v-if="invalidCredentials"
      >Invalid username and password!</div>
      <div
        class="alert alert-success"
        role="alert"
        v-if="this.$route.query.registration"
      >Thank you for registering, please sign in.</div>
      <input
        type="text"
        id="username"
        class="form-control"
        placeholder="Username"
        v-model="user.username"
        required
        autofocus
      />
      <br>
      <input
        type="password"
        id="password"
        class="form-control"
        placeholder="Password"
        v-model="user.password"
        required
      />
      <br>
      <button class="submit" type="submit">Sign in</button>
      <br>
      <router-link class="need-account" :to="{ name: 'register' }">Need an account?</router-link>
    </form>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Cormorant+Garamond&family=Montserrat&family=Roboto:wght@300&display=swap');

body {
  width: 100%;
  height: 100%;
  /* padding: 1% 0 0;
  margin: 0; */
  display: flex;
}

h1.sign-in {
  font-family: 'Montserrat', serif;
  color: #cf740cf1;;
  text-align: center;
}
label.sr-only {
  align-content: center;
}
.form-signin {
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

.form-signin input {
  font-family: "Roboto", sans-serif;
  outline: 0;
  background: rgb(243, 231, 226);
  width: 100%;
  border: 0;
  margin: 0 0 15px;
  padding: 15px;
  box-sizing: border-box;
  font-size: 14px;
}

.need-account{
  float: center;
}

.submit {
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
.submit:hover {
  opacity: 0.9;
}
.need-account:hover {
  opacity: 0.8;
}

</style>
<!-- #FFEDB4 -->
<!-- ffd79c -->