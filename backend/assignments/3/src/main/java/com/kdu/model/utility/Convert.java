package com.kdu.model.utility;

public class Convert {

    private Convert(){}
    public static boolean isParsable(String string){
        try{
            Long.parseLong(string);
            return true;
        }catch (NumberFormatException ex){
            return false;
        }
    }
}
