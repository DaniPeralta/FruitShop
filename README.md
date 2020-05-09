# FruitShop
Project for technical test on a fruit shop in Java with Spring Boot.

Project developed in Spring Boot with JPA

I have assumed the change of making the application more modern and instead of reading the data from files, they are read through a REST service, since from my point of view it is something more current.

I have assumed, by doing it through a microservice, that first you have to start a purchase, ("/startPurchase") and from there and with the identifier of the purchase received, you add the different lines of purchase to that purchase, in which the prices and discounts that each type of fruit has are added.

The final result, I also thought, with directly make the call to ("/endPurchase/{id}") where id is the identifier of the purchase we are making, and will return all data of the purchase.

