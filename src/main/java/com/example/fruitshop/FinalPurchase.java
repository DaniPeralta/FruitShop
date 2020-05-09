package com.example.fruitshop;

import javax.persistence.*;
import java.util.List;

public class FinalPurchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "totalprice", nullable = false)
    private Float totalprice ;

    @JoinColumn(name = "offer_id")
    private List<Offer> offers;

    FinalPurchase(){
        this.totalprice = 0F;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(Float totalprice) {
        this.totalprice =+ totalprice;
    }

    public List<Offer> getOffers() {
        return offers;
    }

    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }


}
