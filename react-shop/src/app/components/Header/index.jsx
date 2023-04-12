import { Navbar, Heading } from 'react-bulma-components';
import './Header.scss';
import { useSelector, useDispatch } from "react-redux";
import React from 'react';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { 
  faBars,
  faCircleUser,
  faArrowRightFromBracket
 } from '@fortawesome/free-solid-svg-icons';
import { Link } from 'react-router-dom';
import { toggleMenu } from '../../store/mainMenuSlice';

const Header = () => {

  return (
    <Navbar className='header'>
      <div className='icon header-bars' >
        <FontAwesomeIcon 
          icon={ faBars } 
          size='lg' />
      </div>
      <div className='header-logo'>Upsilon</div>
      <div className='header-accountInfo'>
        <Link className='icon accountInfo-icon' to={'/account'}>
        <FontAwesomeIcon 
            icon={ faCircleUser } 
            size='2x' />
        </Link>
        <div className='accountInfo-name'></div>
          <Link className='icon accountInfo-exit' to={'/'}>
          <FontAwesomeIcon 
            icon={ faArrowRightFromBracket } 
            size='lg' />
          </Link>
        </div>
    </Navbar>
  )
}


export default Header;