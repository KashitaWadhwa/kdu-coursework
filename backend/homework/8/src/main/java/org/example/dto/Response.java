package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Response {
    private int id;
    private String name;
    private int price;
    private String res;

    public Response(String res){
        this.res = res;
    }
}
