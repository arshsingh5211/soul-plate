<template>
  <div id="app">
    <div id="nav">
      <router-link class="nav" v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link class="nav" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>&nbsp;|&nbsp;
      <router-link class="nav" v-bind:to="{ name: 'edit-preferences'}"> User Preferences</router-link>
    </div>
    <router-view />
  </div>
</template>

<style>
body, html {
  background-image: url(https://trello-backgrounds.s3.amazonaws.com/SharedBackground/2133x1600/cdd5e6250f57d20d721be784115d4a1e/photo-1466978913421-dad2ebd01d17.jpg);
  height: 100%;
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
}
#nav, .nav {
  color: white;
}
</style>
