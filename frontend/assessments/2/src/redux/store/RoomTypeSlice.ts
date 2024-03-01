// store/roomTypeSlice.ts

import { createSlice, PayloadAction } from '@reduxjs/toolkit';
import { RoomType } from '../types';

interface RoomTypeState {
  selectedRoomType: RoomType | null;
  roomTypes: RoomType[];
}

const initialState: RoomTypeState = {
  selectedRoomType: null,
  roomTypes: [], // Initialize with empty array, will be updated after fetching room types from API
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
