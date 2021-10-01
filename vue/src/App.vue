<template>
  <div id="app">
    <div id="nav">
      <router-link class="nav" v-bind:to="{ name: 'home' }" v-show="$store.state.token != ''">HOME |&nbsp;</router-link>&nbsp;
      <router-link class="nav" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">LOGOUT |&nbsp;</router-link>&nbsp;
      <router-link class="nav" v-bind:to="{ name: 'favorites'}" v-show="$store.state.token != ''"> FAVORITES</router-link>
    </div>
    <router-view />
  </div>
</template>

<style>
body, html {
  /* background-image: url(https://i.ibb.co/W67Jc5V/tim-mossholder-FH3n-Wjvia-U-unsplash-1.jpg); */
  background-image: url("https://media-exp1.licdn.com/dms/image/C561BAQHRgrYG97gqww/company-background_10000/0/1624287459815?e=1633111200&v=beta&t=XRcgYgq64IR86nhhSwIxxBzkMYskKtNs0UL9cuxXmzY");
  height: 100%;
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
  background-attachment: fixed;
}

#nav, .nav {
  display: flex;
  gap: 13px;
  background-color:cornsilk;
  height: 20px;
  width: 120px;
  font-size: 20px;
  color: black;
  font-weight: bold;
  
}

.nav:hover {
  background-color: #cf740cf1;
  size: 44px;
}
</style>
// https://trello-backgrounds.s3.amazonaws.com/SharedBackground/2133x1600/cdd5e6250f57d20d721be784115d4a1e/photo-1466978913421-dad2ebd01d17.jpg