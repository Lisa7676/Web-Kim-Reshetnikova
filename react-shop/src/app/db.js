const Pool = require('pg').Pool
const pool = new Pool({
  user: 'postgres',
  host: '46.146.100.152',
  database: 'postgres',
  password: '617',
  port: 5432,
}); 

module.exports = pool