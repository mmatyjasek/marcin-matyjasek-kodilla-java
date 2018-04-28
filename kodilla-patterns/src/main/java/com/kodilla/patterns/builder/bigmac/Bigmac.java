package com.kodilla.patterns.builder.bigmac;

import java.util.ArrayList;
import java.util.List;

public class Bigmac {

    private final String bun;
    private final int qtyOfBurgers;
    private final String sauce;
    private final List<String> ingredients;
    public final static int MIN_QTY_OF_BURGERS = 1;

    public static class BigmacBuilder {
        private String bun;
        private int qtyOfBurgers;
        private String sauce;
        private List<String> ingredients = new ArrayList<>();

        public BigmacBuilder bun(String bun) {
            this.bun = bun;
            return this;
        }

        public BigmacBuilder qtyOfBurgers(int qtyOfBurgers) {
            this.qtyOfBurgers = qtyOfBurgers;
            return this;
        }

        public BigmacBuilder sauce(String sauce) {
            this.sauce = sauce;
            return this;
        }

        public BigmacBuilder ingredient(String ingredient) {
            ingredients.add(ingredient);
            return this;
        }

        public Bigmac build() {
            if (bun.length() == 0) {
                throw new IllegalStateException("There is no bun selected!");
            }

            if (qtyOfBurgers <MIN_QTY_OF_BURGERS) {
                throw new IllegalStateException("Bigmac must contain at least one burger!");
            }

            if (sauce.length() == 0) {
                sauce = "No sauce";
            }

            return new Bigmac(bun, qtyOfBurgers, sauce, ingredients);
        }
    }

    private Bigmac(final String bun, final int qtyOfBurgers, String sauce, List<String> ingredients) {
        this.bun = bun;
        this.qtyOfBurgers = qtyOfBurgers;
        this.sauce = sauce;
        this.ingredients = new ArrayList<>(ingredients);
    }

    public String getBun() {
        return bun;
    }

    public int getQtyOfBurgers() {
        return qtyOfBurgers;
    }

    public String getSauce() {
        return sauce;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {
        return "BigMac{" +
                "bun: " + bun +
                "; quantity of burgers: " + qtyOfBurgers +
                "; sauce: " + sauce +
                "; ingredients: " + ingredients +
                '}';
    }
}
