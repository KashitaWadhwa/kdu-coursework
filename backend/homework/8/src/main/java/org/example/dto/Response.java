package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Response {
    private int id;
    private String name;
    private int price;
    private String response;

    public Response(String response){
        this.response = response;
    }
}
