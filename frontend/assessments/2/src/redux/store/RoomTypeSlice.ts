import { createSlice, PayloadAction } from '@reduxjs/toolkit';
import { RoomType } from '../types';

interface RoomTypeState {
  selectedRoomType: RoomType | null;
  roomTypes: RoomType[];
}

const initialState: RoomTypeState = {
  selectedRoomType: null,
  roomTypes: [], 
};

const roomTypeSlice = createSlice({
  name: 'roomType',
  initialState,
  reducers: {
    selectRoomType(state, action: PayloadAction<RoomType>) {
      state.selectedRoomType = action.payload;
    },
    setRoomTypes(state, action: PayloadAction<RoomType[]>) {
      state.roomTypes = action.payload;
    },
  },
});

export const { selectRoomType, setRoomTypes } = roomTypeSlice.actions;

export default roomTypeSlice.reducer;
