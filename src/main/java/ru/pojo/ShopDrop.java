package ru.pojo;

public class ShopDrop {
    public static Product[] delete(Product[] products, int index) {
        if (index >= 0 && index <= products.length - 1) {
            for (int i = index; i < products.length - 1; i++) {
                products[i] = products[i + 1];
            }
            products[products.length - 1] = null;
        }
        return products;
    }
}
