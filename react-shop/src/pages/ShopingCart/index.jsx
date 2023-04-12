import React, { useState, useEffect } from 'react';
import axios from 'axios';
import TaskCard from '../../app/components/Task';

function Products() {
  const [Products, setProducts] = useState([]);

  useEffect(() => {
    axios.post('http://localhost:8080/api/product')
      .then(response => {
        setProducts(response.data);
        console.log(response.data)
      })
      .catch(error => {
        console.log(error);
      });
  }, []);

  return (
    <div>
      <h2>Tasks</h2>
      {Array.from(tasks).map(task => (
        <TaskCard key={task.id} task={task}/>
      ))}
    </div>
  );
}

export default Products;