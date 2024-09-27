import { ActionTypes } from "../action-types/ActionTypes";

const initialState = {
  rooms: [],
};

export const roomReducer = (state = initialState, action:any) => {
  switch (action.type) {
    case ActionTypes.SET_ROOMS:
      return {
        ...state,
        rooms: action.payload,
      };

      case ActionTypes.FETCH_ROOMS:
        return {
          ...state,
          rooms: action.payload,
        };
    default:
      return state;
  }
};