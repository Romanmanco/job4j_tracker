package ru.job4j.pojo;

public class ShopDrop {
    public static Product[] delete(Product[] products, int index) {
        for (int i = 0; i < products.length; i++) {
            Product product = products[i];
            if (products[i] == null) {
                System.out.println(product.getName());
            } else {
                System.out.println("null");
            }
        }
        return products;
    }
}
