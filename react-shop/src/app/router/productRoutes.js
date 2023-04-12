const Router = require('express')
const router = new Router()
const productController = require('../controller/productController')

router.post('/product', productController.getProducts)

module.exports =  router
