package com.javaWeb.course.entities;

import org.springframework.stereotype.Component;

public enum OrderStatus{
    WAITING_PAYMENT, PAID, SHIPPED, DELIVERED, CANCELED
}