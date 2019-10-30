package webshop.model;

import java.util.Collection;

public class Product {
    private int id;
    private String name;
    private int numberInStock;
    private String description;
    private ProductPrice price;
    private Collection<ProductImage> images;
    private Collection<ProductCategory> categories;
}
