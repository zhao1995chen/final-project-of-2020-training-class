import axios from 'axios'
import env from '@/common/env'

axios.defaults.baseURL = env.apiLink.apiPath;
axios.defaults.url = '/';
axios.defaults.headers['Accept'] = 'application/json';
axios.defaults.headers['Cache-Control'] = 'no-cache';
axios.defaults.headers['Content-Type'] = 'application/json';
axios.defaults.timeout = 30 * 1000;

export default {
  get: url => axios.get(url),
  post: (url, params) => axios.post(url, JSON.stringify(params)),
  put: (url, params) => axios.put(url, JSON.stringify(params)),
  delete: url => axios.delete(url)
}
