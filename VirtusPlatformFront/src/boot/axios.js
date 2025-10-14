import axios from 'axios'

const _axios = axios.create({
  baseURL: 'http://localhost:8000/'
})

export default async ({ Vue }) => {
  Vue.prototype.$axios = _axios

}

export {_axios}

