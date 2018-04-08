package com.kodilla.good.patterns.challenges.food2door.basket;

import com.kodilla.good.patterns.challenges.eshopping.product.Product;

import java.util.HashMap;
import java.util.Map;

public class Basket {

    Map<Product, Double> shoppingList = new HashMap<>();

    public void addToShoppingList(Product product, Double quantity){
            shoppingList.put(product, quantity);
    }

    public Double returnTotalAmount(){
        return shoppingList.entrySet().stream()
                .map(a -> a.getKey().getPricePLN()*a.getValue())
                .reduce(0.0, (sum, current) -> sum +=current);
    }

    @Override
    public String toString() {
        String bas = shoppingList.entrySet().stream()
                .map(p-> p.getKey().getProductName() + " x " + p.getValue() + " ")
                .reduce("",(fin, cur)-> fin += cur);

        return "{" + bas + '}';
    }

}
