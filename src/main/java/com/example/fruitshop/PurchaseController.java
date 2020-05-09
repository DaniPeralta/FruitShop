package com.example.fruitshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/purchase")
public class PurchaseController {

    @Autowired
    FruitRepository fruitRepository;

    @Autowired
    FinalPurchaseRepository finalPurchaseRepository;

    @Autowired
    PurchaseRepository purchaseRepository;


    @ResponseBody
    @GetMapping("")
    public List<Purchase> listPurchases(){
        return purchaseRepository.findAll();
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/")
    public Purchase makePurchase(@RequestBody Purchase purchase){
        purchase.setPrice();
        addValuesToFinalPurchase(purchase);
        return purchaseRepository.save(purchase);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/startPurchase")
    public FinalPurchase startPurchase(){
        return finalPurchaseRepository.save(new FinalPurchase());
    }

    @GetMapping("/endPurchase/{id}")
    public FinalPurchase getFinal(@PathVariable("id") Integer id){
        return finalPurchaseRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("No purchase found with id="+id));
    }

    private void addValuesToFinalPurchase(Purchase purchase){
        FinalPurchase f = finalPurchaseRepository.findById(purchase.getFinalPurchase().getId()).get();
        f.setTotalprice(purchase.getPrice());

        if(purchase.isApplyDiscount())
            f.getOffers().add(purchase.getFruit().getOffer());
        f.getFruits().add((purchase.getFruit()));

        finalPurchaseRepository.save(f);
    }
}
