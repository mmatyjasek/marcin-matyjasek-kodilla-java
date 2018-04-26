package com.kodilla.patterns.builder.bigmac;

import org.junit.Assert;
import org.junit.Test;

public class BigmacTestSuite {

    @Test
    public void testNewBigmac() {
        //Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .ingredient("Onion")
                .qtyOfBurgers(1)
                .bun("With sesame")
                .sauce("Ketchup")
                .ingredient("Bacon")
                .ingredient("Mushrooms")
                .ingredient("Shrimps")
                .build();
        System.out.println(bigmac);
        //When
        int howManyIngredients = bigmac.getIngredients().size();
        //Then
        Assert.assertEquals(4, howManyIngredients);
        Assert.assertEquals("With sesame", bigmac.getBun());
        Assert.assertEquals("Ketchup", bigmac.getSauce());
        Assert.assertEquals(1, bigmac.getQtyOfBurgers());
    }
}
