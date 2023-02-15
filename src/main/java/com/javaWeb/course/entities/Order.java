package com.javaWeb.course.entities;

import java.io.Serializable;
import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_order")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone="GMT")
    private Instant moment;
    private Integer orderStatus;

    @ManyToOne
    @JoinColumn(name="client_id")
    private User client;

    public Order(Long id, Instant moment, OrderStatus orderStatus, User client) {
        this.id = id;
        this.moment = moment;
        this.client = client;
        this.orderStatus = orderStatus.getCode();
    }

    public Order(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public OrderStatus getOrderStatus() {
        if (orderStatus != null)
            return OrderStatus.valueOf(orderStatus);
        return null;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus.getCode();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((moment == null) ? 0 : moment.hashCode());
        result = prime * result + ((orderStatus == null) ? 0 : orderStatus.hashCode());
        return result;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Order other = (Order) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (moment == null) {
            if (other.moment != null)
                return false;
        } else if (!moment.equals(other.moment))
            return false;
        if (orderStatus == null) {
            if (other.orderStatus != null)
                return false;
        } else if (!orderStatus.equals(other.orderStatus))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Order [id=" + id + ", moment=" + moment + ", orderStatus=" + orderStatus + ", client=" + client + "]";
    }   
    

    
    
}
