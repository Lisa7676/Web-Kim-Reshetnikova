
const express = require('express')
const productRouter = require('./src/app/router/productRoutes')
const PORT = process.env.PORT || 8080

const app = express()
var cors = require('cors')

app.use(cors())
app.use(express.json())
app.use('/api', productRouter)

app.listen(PORT, () => console.log('server started on port ' + PORT))