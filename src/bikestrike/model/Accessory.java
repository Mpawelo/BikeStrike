package bikestrike.model;

public class Accessory extends Product {
    private boolean forAdults;
    private boolean forKids;
    private String size;

    public Accessory(String name, double price, String brand, int stock,
                     boolean forAdults, boolean forKids, String size) {
        super(name, price, brand, stock);
        this.forAdults = forAdults;
        this.forKids = forKids;
        this.size = size;
    }

    public boolean isForAdults() { return forAdults; }
    public void setForAdults(boolean forAdults) { this.forAdults = forAdults; }
    public boolean isForKids() { return forKids; }
    public void setForKids(boolean forKids) { this.forKids = forKids; }
    public String getSize() { return size; }
    public void setSize(String size) { this.size = size; }
}
