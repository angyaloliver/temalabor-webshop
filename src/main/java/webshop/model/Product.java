package webshop.model;

import java.util.Collection;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private int id;
    private String name;
    private int numberInStock;
    private String description;
    private ProductPrice price;
    private Collection<ProductImage> images;
    private Collection<ProductCategory> categories;

    Product(int id, String n, int numb, String desc, ProductPrice pp) {
        this.id = id;
        this.name = n;
        this.numberInStock = numb;
        this.description = desc;
        this.price = pp;
    }

    public static Product createNewProduct(String name, int number, String description, ProductPrice pp) {
        int nextId = 0; //create random id, what was unused before TODO
        return new Product(nextId, name, number, description, pp);
    }
}
