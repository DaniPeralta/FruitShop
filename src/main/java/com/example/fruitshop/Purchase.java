package com.example.fruitshop;

import javax.persistence.*;

public class Purchase {

    @ManyToOne
    @JoinColumn(name = "finalpurchase_id")
    private FinalPurchase finalPurchase;

    @ManyToOne
    @JoinColumn(name = "fruit_id")
    private Fruit fruit;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name="price")
    private Float price;


    Purchase(FinalPurchase finalPurchase, Fruit fruit, Integer quantity){
        this.finalPurchase = finalPurchase;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public FinalPurchase getFinalPurchase() {
        return finalPurchase;
    }

    public void setFinalPurchase(FinalPurchase finalPurchase) {
        this.finalPurchase = finalPurchase;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public void setFruit(Fruit fruit) {
        this.fruit = fruit;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(){
        this.price = (quantity*fruit.getPrice())-fruit.getOffer().checkDiscount(quantity);
    }
}
