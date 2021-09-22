<template>
  <div id="login" class="text-center">
    <h1 class="welcome">Welcome to Restaurant Tinder</h1>
    <form class="form-signin" @submit.prevent="login">
      <h1 class="sign-in">Login</h1>
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
      <label for="username" class="sr-only">Username:  </label>
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
      <label for="password" class="sr-only">Password:  </label>
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

h1.welcome {
  margin-left: auto;
  margin-right: auto;
  width: 35%;
  height: auto;
  text-align: center;
  color: #D52929;
  border: 2px solid black;
  background: #FAD7A0 ;
  margin-bottom: 80px;
  font-family: sans-serif;
}
h1.sign-in {
  color: #D52929;
  text-align: center;
}
label.sr-only {
  align-content: center;
}
form {
  font-family: Liberation Sans, sans-serif;
  margin-left: auto;
  margin-right: auto;
  text-align: center;
  border: 2px solid black;
  line-height: 50px;
  width: 30%;
  height: 300px;
  background: wheat ;
}
.need-account{
  float: left;
  margin-left: 15px;
}

.submit {
  float: right;
  margin-top: 20px;
  margin-right: 25px;
  width: 80px;
  height: 30px;
  font-size: 15px;
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