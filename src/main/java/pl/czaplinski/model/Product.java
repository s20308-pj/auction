package pl.czaplinski.model;

import java.util.UUID;

public class Product {

    private UUID uuid;
    private String name;
    private String description;
    private double price;
    private String imageUrl;

    public Product(String name, String description, String imageUrl) {
        this.uuid = UUID.randomUUID();
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
