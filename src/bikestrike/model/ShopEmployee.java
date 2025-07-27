package bikestrike.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class ShopEmployee extends Person {
    private String position;
    private LocalDate employmentDate;
    private double hourlyRate;
    private String companyAddress;
    private final List<Order> assignedOrders = new ArrayList<>();

    protected ShopEmployee(String first, String last) { super(first, last); }

    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }
    public LocalDate getEmploymentDate() { return employmentDate; }
    public void setEmploymentDate(LocalDate employmentDate) { this.employmentDate = employmentDate; }
    public double getHourlyRate() { return hourlyRate; }
    public void setHourlyRate(double hourlyRate) { this.hourlyRate = hourlyRate; }
    public String getCompanyAddress() { return companyAddress; }
    public void setCompanyAddress(String companyAddress) { this.companyAddress = companyAddress; }
    public List<Order> getAssignedOrders() { return Collections.unmodifiableList(assignedOrders); }

    void _assignOrder(Order o) { assignedOrders.add(o); }
}
