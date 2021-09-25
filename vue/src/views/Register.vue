<template>
  <div id="register" class="text-center">
    <form class="form-register" @submit.prevent="register">
      <h2 class="h3 mb-3 font-weight-normal">Create Account</h2>
      <div class="alert alert-danger" role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
      <label for="username" class="sr-only">Username</label>
      <input
        type="text"
        id="username"
        class="form-control"
        placeholder="Username"
        v-model="user.username"
        required
        autofocus
      />
      <label for="password" class="sr-only">Password</label>
      <input
        type="password"
        id="password"
        class="form-control"
        placeholder="Password"
        v-model="user.password"
        required
      />
      <input
        type="password"
        id="confirmPassword"
        class="form-control"
        placeholder="Confirm Password"
        v-model="user.confirmPassword"
        required
      />
      <button class="btn btn-lg btn-primary btn-block" type="submit">
        Sign up
      </button><br>
      <router-link class="have-account" :to="{ name: 'login' }">Already have an account?</router-link>
    </form>
  </div>
</template>

<script>
import authService from '../services/AuthService';

export default {
  name: 'register',
  data() {
    return {
      user: {
        username: '',
        password: '',
        confirmPassword: '',
        role: 'user',
      },
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.',
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: '/login',
                query: { registration: 'success' },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Bad Request: Validation Errors';
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'There were problems registering this user.';
    },
  },
};
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Cormorant+Garamond&family=Montserrat&family=Roboto:wght@300&display=swap');

body {
  width: 100%;
  height: 100%;
  padding: 8% 0 0;
  margin: 0;
  display: flex;
}

label {
  color: 42403ff1;
}

.form-register h2 {
  font-family: 'Cormorant Garamond', serif;
  display: block;
  text-transform: uppercase;
  margin-left: auto;
  margin-right: auto;
  width: 100%;
  height: auto;
  color: #cf740cf1;
  letter-spacing: 4px;
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

form {
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

form input {
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

.have-account {
  float: center;
}

button {
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
button:hover {
  opacity: 0.9;
}
.have-account:hover {
  opacity: 0.8;
}

</style>
