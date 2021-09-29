import axios from 'axios';

export default {

    getSearchResults(newPreferences) {
        return axios.get(`/restaurants?foodPref=${newPreferences.foodPref}&location=${newPreferences.zipCode}`)
    },

    getBusinessDetails(yelpId){
        return axios.get(`/restaurants/${yelpId}`)
    },

    getBusinessReviews(yelpId) {
        return axios.get(`/restaurants/${yelpId}/reviews`)
    },

    addPreferences(newPreferences) {
        return axios.post('/preferences', newPreferences)
    },

    addLikedRestaurant(restaurant) {

        return axios.post('/liked', restaurant)
    }
}