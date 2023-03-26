import axios from 'axios'
const instance = axios.create({ baseURL: 'http://127.0.0.1:8083' })
//const instance = axios.create({ baseURL: 'http://192.168.0.6:8087' })
export default instance