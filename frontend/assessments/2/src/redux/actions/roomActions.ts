// import axios from "axios";
// import { ActionTypes } from "../action-types/ActionTypes";

// export const fetchRooms = () => {
//     return async (dispatch:any) => {
//       try {
//         const apiUrl = 'https://2346rgmyvja3vrvomsg45d5wsy0afagj.lambda-url.us-east-1.on.aws/';
//         const response = await axios.get( apiUrl);
//         dispatch({ type: ActionTypes.SET_ROOMS, payload: response.data });
//       } catch (error) {
//         console.error("Error fetching rooms:", error);
//       }
//     };
//   };

// roomActions.ts
import axios from "axios";
import { ActionTypes } from "../action-types/ActionTypes";
import { Dispatch } from "redux";

export const fetchRooms = () => {
  return async (dispatch: Dispatch<any>) => {
    try {
      const apiUrl = 'https://2346rgmyvja3vrvomsg45d5wsy0afagj.lambda-url.us-east-1.on.aws/';
      const response = await axios.get(apiUrl);
      dispatch({ type: ActionTypes.SET_ROOMS, payload: response.data });
    } catch (error) {
      console.error("Error fetching rooms:", error);
    }
  };
};

export const setRooms = (rooms:any) => {
    return {
        type: ActionTypes.SET_ROOMS,
        payload: rooms
    }
}