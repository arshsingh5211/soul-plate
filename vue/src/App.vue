<template>
  <div id="app">
    <div id="nav">
      <router-link class="nav" v-bind:to="{ name: 'home' }" v-show="$store.state.token != ''">Home |&nbsp;</router-link>&nbsp;
      <router-link class="nav" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout |&nbsp;</router-link>&nbsp;
      <router-link class="nav" v-bind:to="{ name: 'favorites'}" v-show="$store.state.token != ''"> Favorites List</router-link>
    </div>
    <router-view />
  </div>
</template>

<style>
body, html {
  background-image: url(https://i.ibb.co/W67Jc5V/tim-mossholder-FH3n-Wjvia-U-unsplash-1.jpg);
  height: 100%;
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
}

#nav, .nav {

  color: white;
}
</style>
// https://trello-backgrounds.s3.amazonaws.com/SharedBackground/2133x1600/cdd5e6250f57d20d721be784115d4a1e/photo-1466978913421-dad2ebd01d17.jpg