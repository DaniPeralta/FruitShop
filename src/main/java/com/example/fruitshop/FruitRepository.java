package com.example.fruitshop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface FruitRepository extends JpaRepository<Fruit, Integer>{
}
