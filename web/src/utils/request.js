// import axios from 'axios'
// create an axios instance
const service = axios.create({
  baseURL: process.env.VUE_APP_BASE_API, // url = base url + request url
  // withCredentials: true, // send cookies when cross-domain requests
  timeout: 5000 // request timeout
})

// request interceptor
service.interceptors.request.use(
  config => {

    return config
  },
  error => {
    // do something with request error
    console.log(error) // for debug
    return Promise.reject(error)
  }
)
// response interceptor
service.interceptors.response.use(
    /**
     * If you want to get http information such as headers or status
     * Please return  response => response
     */

    /**
     * Determine the request status by custom code
     * Here is just an example
     * You can also judge the status by HTTP Status Code
     */
    response => {
      const res = response.data

      return res
    },
    error => {

      return Promise.reject(error)
    }
)


export const request = service


export const fetchGet = function(url, params = {}) {
  return new Promise((resolve, reject) => {
    service.get(url, {params}).then(res => {
      resolve(res)
    }).catch(error => {
      reject(error)
    })
  })
}
export const fetchPost = function (url, params = {}) {
  return new Promise((resolve, reject) => {
    service.post(url, params).then(res => {
      resolve(res)
    }).catch(error => {
      reject(error)
    })
  })
}

export const  fetchPut =  (url, params = {}) =>{
  return new Promise((resolve, reject) => {
    service.put(url, params).then(res => {
      resolve(res)
    }).catch(error => {
      reject(error)
    })
  })
}

export const  fetchDelete = (url, params = {}) =>{
  return new Promise((resolve, reject) => {
    service.delete(url, params).then(res => {
      resolve(res)
    }).catch(error => {
      reject(error)
    })
  })
}
