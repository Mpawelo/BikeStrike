package bikestrike.model;

import java.time.LocalDate;

public class EmployeeOrderAssignment {
    private final LocalDate assignDate;
    private final ShopEmployee employee;
    private final Order order;

    public EmployeeOrderAssignment(LocalDate assignDate, ShopEmployee employee, Order order) {
        this.assignDate = assignDate;
        this.employee = employee;
        this.order = order;
    }

    public LocalDate getAssignDate() { return assignDate; }
    public ShopEmployee getEmployee() { return employee; }
    public Order getOrder() { return order; }
}