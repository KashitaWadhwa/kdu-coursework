package com.kdu.model.dto.response;

import com.kdu.model.entity.Room;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomResponseDTO {
    private String message;
    private Room room;
    private HttpStatus httpStatus;
}
