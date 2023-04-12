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
    <>
    <div class="container mt-5">
        <h1>Каталог</h1>
        <main>
            <div>
                <h3>Фильтр</h3>
                <form class="col-12 d-flex" role="search">
                    <input type="search" id="filter-name" class="form-control me-2" placeholder="Название">
                        <select name="pets" id="filter-category" class="form-control me-2">
                            <option value="">Категория</option>
                            <option value="Собаки">Собаки</option>
                            <option value="Кошки">Кошки</option>
                            <option value="Амуниция для собак">Амуниция для собак</option>
                            <option value="Лежанки для собак">Лежанки для собак</option>
                        </select>
                        <input type="search" id="filter-min-price" class="form-control me-2" placeholder="Мин. Цена" />
                        <input type="search" id="filter-max-price" class="form-control me-2" placeholder="Макс. Цена" />
                    </input>
                </form>
                <button id="filter-button" type="button" class="btn btn-primary">Применить</button>
                <h3>Сортировка</h3>
                <div class="d-grid gap-2 d-md-block">
                    <button id="sort-price" class="btn btn-outline-primary" type="button">Цена</button>
                    <button id="sort-name" class="btn btn-outline-primary" type="button">Название</button>
                </div>
            </div>
            <div class="album py-5 bg-light">
                <div id="productsContainer" class="col-12 d-flex">
                {Array.from(products).map(product => (
                  <ProductCard key={product.id} product={product} />
                ))}
                </div>
            </div>
        </main>
    </div>
    </>
    );
}

export default Products;