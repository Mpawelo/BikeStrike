package bikestrike.model;

public class Salesman extends ShopEmployee {
    private double salesTarget;

    public Salesman(String first, String last) { super(first, last); }

    public Order createOrder() { return null; }
    public void assignOrderToClient(Order order, Client client) { /* TODO */ }
    public Client addClient(Client client) { return client; }

    public double getSalesTarget() { return salesTarget; }
    public void setSalesTarget(double salesTarget) { this.salesTarget = salesTarget; }
}
