package bikestrike.model;

public abstract class Client extends Person {
    private static final long serialVersionUID = 1L;
    protected String email;
    public Client() { super(); }


    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    private final java.util.List<Order> orders = new java.util.ArrayList<>();

    public java.util.List<Order> getOrders() { return orders; }

    void _addOrder(Order o) { orders.add(o); }
}
