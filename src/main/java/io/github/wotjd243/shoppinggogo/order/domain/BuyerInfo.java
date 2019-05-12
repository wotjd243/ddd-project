package io.github.wotjd243.shoppinggogo.order.domain;

import io.github.wotjd243.shoppinggogo.user.domain.Address;
import io.github.wotjd243.shoppinggogo.user.domain.Phone;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class BuyerInfo {
    private Address destination;
    private Phone phone;
    private List<Long> orderProducts;

    public BuyerInfo(Address destination, Phone phone ,List<Long> orderProducts) {
        this.destination = destination;
        this.phone = phone;
        this.orderProducts = new ArrayList<Long>(orderProducts);
    }
    public void setDestination(Address destination){
        this.destination = destination;
    }
    public void setPhone(Phone phone){
        this.phone = phone;
    }


    public List<Long> getOrderProducts() {
        return orderProducts;
    }
}
