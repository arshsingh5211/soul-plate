import axios from 'axios';

export default {

    getSearchResults(newPreferences) {
        return axios.get(`/restaurants?foodPref=${newPreferences.category}&location=${newPreferences.zipCode}`)
    },

    postSearchResults(newPreferences){
        return axios.post('/preferences', newPreferences)
    },

    addPreferences(newPreferences) {
        return axios.post('/preferences', newPreferences)
    }
}