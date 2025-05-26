package com.effectivejava.practice.generics;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SubType {
    public static void main(String[] args) {
        List<Number> ints = new ArrayList<Number>();
        ints.add(1);
        ints.add(2.14);
        System.out.println(ints);
        assert ints.toString().equals("[1,2.14]");
        // Example of wildcard op

        Inventory<Product> productInventory = new Inventory<>();
        Product test = new Product("Test");
        Electronic electronic = new Electronic("test", "lg");
        productInventory.add(test);
        productInventory.add(electronic);
        // System.out.println(productInventory);
        List<Product> ofProducts = List.of(test, electronic);
        List<Object> allProducts = new ArrayList<>();
        InventoryUtil.pulAll(allProducts, ofProducts);
        System.out.println(allProducts);
    }
}


class Product {
    private String name;
    public Product(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                '}';
    }
}


class Book extends Product {
    public Book(String name) {
        super(name);
    }
}

class Electronic extends Product {
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    private String brand;
    public Electronic(String name, String brand) {
        super(name);
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Electronic{" +
                "brand='" + brand + '\'' +
                ",name='"+ getName() + '\'' +
                '}';
    }
}

class Inventory<T> {
    List<T> items = new ArrayList<>();

    public <X extends T> void add(X item) {
        items.add(item);
    }

    public void addAll(List<? extends T> values) {
        items.addAll(values);
    }

    public List<T> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "items=" + items.toString() +
                '}';
    }
}

class InventoryUtil {
      public static <T> void pulAll(List<? super T> des, List<? extends T> source) {
            des.addAll(source);
      }
}


