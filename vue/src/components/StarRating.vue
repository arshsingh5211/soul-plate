<template>
<div id="app">
  <div class="title">
 
  </div>
  <div>
    <svg
      v-for="i in max"
      :key="i.id"
      :width="30 / max +'%'"
      :height="30 / max +'%'"
      viewBox="0 0 510 510"
    >
      <defs v-if="isCurrentStar(i)">
        <linearGradient id="grad" x1="0%" y1="0%" x2="100%" y2="0%">
          <stop offset="0%" class="gradient-start" />
          <stop :offset="getStarPercentage(i)" class="gradient-start" />
          <stop :offset="getStarPercentage(i)" class="gradient-end" />
          <stop offset="100%" class="gradient-end" />
        </linearGradient>
      </defs>
      <polygon
        points="255,402.212 412.59,497.25 370.897,318.011 510,197.472 326.63,181.738 255,12.75 183.371,181.738 0,197.472 139.103,318.011 97.41,497.25"
        :class="getStarClass(i)"
      />
    </svg>
  </div>
</div>
</template>

<script>
// import yelpService from '../services/YelpService';
export default {

data() {
    return {
      max: 5,
      
    }
  },
  props: ['rating'],
  methods: {
    isCurrentStar(index) {
      const diff = this.rating - index + 1;
      return diff > 0 && diff < 1;
    },
    getStarPercentage(index) {
      return (this.rating - (index - 1)) * 100 + '%';
    },
    getStarClass(index) {
      const classNames = ['star'];
      (this.rating > index - 1) && classNames.push('filled');
      (index === parseInt(this.rating) + 1) && classNames.push('gradient');
      return classNames.join(' ');
    }
  },
  //  created() {
  //   let id = this.$route.params.id;

  //    yelpService.getBusinessDetails(id).then((response) =>{
  //       this.rating = response.data.rating;
  //     });
     
  // }
}
</script>

<style>
#rating {
  width: 150px;
  border: none;
  border-radius: 0;
  font-size: 40px;
  line-height: 40px;
  text-align: right;
  background-color: transparent;
  color: rgb(255, 255, 255);
  outline: none;
  padding: 10px;
  
  }
  .focus {
    box-shadow: 0 0 0 2px #ff0 inset;
  }


.star {
  stroke-width: 10px;
  stroke: rgba(24, 22, 22, 0.959);
  display: inline-block;
  fill: transparent;
}
  .filled {
    fill: rgb(255, 174, 0);
  }
  
  .gradient {
    fill: url(#grad);
  }


.gradient-start {
  stop-color: rgb(255, 174, 0);;
  stop-opacity: 1;
}

.gradient-end {
  stop-color: transparent;
  stop-opacity: 1;
}
</style>