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
        FinalPurchase f = finalPurchaseRepository.findById(purchase.getFinalPurchase().getId()).get();
        f.setTotalprice(purchase.getPrice());
        f.getOffers().add(purchase.getFruit().getOffer());

        finalPurchaseRepository.save(f);

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

}
