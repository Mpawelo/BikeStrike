package bikestrike.model;

import java.time.LocalDate;

public class Bike extends Product {
    private String color;
    private String type;
    private LocalDate productionYear;
    private String model;

    public Bike(String name, double price, String brand, int stock,
                String color, String type, LocalDate productionYear, String model) {
        super(name, price, brand, stock);
        this.color = color;
        this.type = type;
        this.productionYear = productionYear;
        this.model = model;
    }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public LocalDate getProductionYear() { return productionYear; }
    public void setProductionYear(LocalDate productionYear) { this.productionYear = productionYear; }
    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }
}
