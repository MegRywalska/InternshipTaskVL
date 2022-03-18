package com.virtuslab.internship.product;

import java.math.BigDecimal;
import java.util.Objects;

public record Product(String name, Type type, BigDecimal price) {


    public enum Type {
        DAIRY, FRUITS, VEGETABLES, MEAT, GRAINS
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name) && type == product.type && Objects.equals(price, product.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, price);
    }
}
