import { configureStore } from '@reduxjs/toolkit';
import userSliceReducer from './userSlice';
import usersSlice from '../../pages/Users/store/usersSlice';
import loadingScreen from './loadingScreen';
import authSlice from './authSlice/authSlice';

export default configureStore({
    devTools: process.env.NODE_ENV !== 'production',
    reducer:{
    }
});