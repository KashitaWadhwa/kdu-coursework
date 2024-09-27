import { combineReducers } from 'redux';
import { roomReducer } from './roomReducer';

const reducer = combineReducers({
    room: roomReducer
});

export default reducer;