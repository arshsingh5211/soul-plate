<template>
  <div class="card">
    <h2 class="restaurant-name">{{ restaurant.name }}</h2>
    <h3 class="restaurant-zip">{{ restaurant.zip }}</h3>
  </div>
</template>

<script>
export default {
    name: 'restaurant-card',
    props: ["restaurant"],
}
</script>

<style>
.card {
    border: 2px solid black;
    border-radius: 10px;
    width: 250px;
    height: 550px;
    margin: 20px;
}

.card.like {
    background-color: lightgray;
}

.card .restaurant-name {
    font-size: 1.5rem;
}

.card .restaurant-zip {
    font-size: 1rem;
}
</style>