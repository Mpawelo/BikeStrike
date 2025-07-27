package bikestrike.model;

public abstract class Product {
    private static int NEXT_ID = 1;
    private final int id = NEXT_ID++;

    private String name;
    private double price;
    private String brand;
    private int stock;

    protected Product(String name, double price, String brand, int stock) {
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.stock = stock;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }
    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }

    @Override public String toString() { return name + " (" + brand + ")"; }
}