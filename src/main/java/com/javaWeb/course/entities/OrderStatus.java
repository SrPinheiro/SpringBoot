package com.javaWeb.course.entities;

public enum OrderStatus{
    WAITING_PAYMENT(0),
    PAID(1),
    SHIPPED(2),
    DELIVERED(3),
    CANCELED(4);

    private int code;

    private OrderStatus(int code){
        this.code = code;
    }

    public int getCode(){
        return code;
    }   

    public static OrderStatus valueOf(int code){
        for(OrderStatus o : OrderStatus.values()){
            if(o.getCode() == code)
                return o;
        }

        throw new IllegalArgumentException("Invalid Code");       
    }
}