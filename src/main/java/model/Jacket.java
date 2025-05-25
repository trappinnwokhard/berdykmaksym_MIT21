package model;

public class Jacket {
    private int id;
    private String brand;
    private String model;
    private double price;
    private String size;
    private String imageUrl;

    // Конструктор без id
    public Jacket(String brand, String model, double price, String size, String imageUrl) {
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.size = size;
        this.imageUrl = imageUrl;
    }

    // Конструктор з id
    public Jacket(int id, String brand, String model, double price, String size, String imageUrl) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.size = size;
        this.imageUrl = imageUrl;
    }

    // Геттери і сеттери
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}