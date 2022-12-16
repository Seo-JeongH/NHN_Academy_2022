package com.nhnacademy;

public class ChangeFailedException extends RuntimeException{
    public ChangeFailedException(){
        super("Change failed : Sub Method");
    }
}
