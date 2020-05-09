package com.example.fruitshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/fruits")
public class FruitController  {

    @Autowired
    FruitRepository fruitRepository;

    @Autowired
    PurchaseRepository purchaseRepository;

    @ResponseBody
    @GetMapping("")
    public List<Fruit> listFruits(){
        return fruitRepository.findAll();
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public Fruit createFruit(@RequestBody Fruit fruit){
        return fruitRepository.save(fruit);
    }





}
