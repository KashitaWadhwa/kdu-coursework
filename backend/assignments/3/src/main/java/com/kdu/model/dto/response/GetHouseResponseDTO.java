package com.kdu.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetHouseResponseDTO {
    private String message;
    private String houses;
    private HttpStatus httpStatus;
}
