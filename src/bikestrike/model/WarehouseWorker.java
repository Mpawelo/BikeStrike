package bikestrike.model;

public class WarehouseWorker extends ShopEmployee {
    private String workingHours;

    public WarehouseWorker(String first, String last) { super(first, last); }

    public void addProduct(Product p) { /* TODO */ }

    public String getWorkingHours() { return workingHours; }
    public void setWorkingHours(String workingHours) { this.workingHours = workingHours; }
}