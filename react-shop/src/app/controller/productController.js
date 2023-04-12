const db = require('../db')
class ProductController {
    
    async getProducts (req, res){
        const products = await db.query('select name, category, price, img from product')
        res.json(products.rows)

    }
    

}
module.exports = new ProductController()