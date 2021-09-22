import axios from 'axios';

export default {

    getSearchResults(newPreferences) {
        return axios.get(`/restaurants?foodPref=${newPreferences.preferenceName}&location=${newPreferences.homeZip}`)
    }
}