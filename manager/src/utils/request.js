import axios from 'axios'
import { MessageBox, Message ,Notification} from 'element-ui'
import store from '@/store'
import {getToken, removeToken} from '@/utils/auth'

// create an axios instance
const service = axios.create({
  baseURL: process.env.VUE_APP_BASE_API, // url = base url + request url
  // withCredentials: true, // send cookies when cross-domain requests
  timeout: 5000 // request timeout
})

// request interceptor
service.interceptors.request.use(
  config => {
    // do something before request is sent

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
    switch (res.code) {
      case 0:{
        if (res.msg && res.msg !== '') {
         showSuccessMsg(res.msg)
        }
        break
      }
      case 1100:{
        showErrorMsg(res.msg)
        store.dispatch('user/resetToken').then(()=>{
          location.reload()

        })
        break
      }
      default:{
        showErrorMsg(res.msg)
      }
    }

    return res
  },
  error => {
    console.log('err' + error) // for debug
    showErrorMsg(error)
    return Promise.reject(error)
  }
)

export const request = service

export const fetchGet = function(url, params = {}) {
  return new Promise((resolve, reject) => {
    service.get(url, { params }).then(res => {
      resolve(res)
    }).catch(error => {
      reject(error)
    })
  })
}
export const fetchPost = function(url, params = {}) {
  return new Promise((resolve, reject) => {
    service.post(url, params).then(res => {
      resolve(res)
    }).catch(error => {
      reject(error)
    })
  })
}

export const fetchPut = (url, params = {}) => {
  return new Promise((resolve, reject) => {
    service.put(url, params).then(res => {
      resolve(res)
    }).catch(error => {
      reject(error)
    })
  })
}

export const fetchDelete = (url, params = {}) => {
  return new Promise((resolve, reject) => {
    service.delete(url, params).then(res => {
      resolve(res)
    }).catch(error => {
      reject(error)
    })
  })
}
function showErrorMsg(message) {
  Notification({
    message:message,
    type: 'error',
    duration: 3 * 1000
  })
}
function showSuccessMsg(message) {
  Notification({
    message:message,
    type: 'success',
    duration: 3 * 1000
  })
}
