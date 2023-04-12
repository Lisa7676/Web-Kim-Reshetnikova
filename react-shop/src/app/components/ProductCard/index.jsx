import React, { useState } from 'react';
import {
  Button 
} from 'react-bulma-components';
import { useNavigate } from 'react-router-dom';
import { useDispatch } from 'react-redux';
import './Task.scss';
import { useForm } from "react-hook-form";


function ProductCard(props) {
  const {  img, name, category, price} = props.product;
  return (  
      <form className='box box-Product'>
      <div>
        <div class="con4">
          <img className="img" type="userFoto" alt="Аватарка" scr={img}></img>
        </div>  
      </div>

      <div className='field-product'>
        <div class="con1">
          <output class="output" type="name">{name}</output>
        </div>  
      </div>


      <div className='field-product'>
        <div class="con1">
          <output class="output" type="category">{category}</output>
        </div>  
      </div>

        <div className='field-product'>
        <div class="con2">
          <output class="output" type="faculty">{price} руб/шт</output>
        </div>  
        </div>
      </form>
  )
  }

export default ProductCard;
