package bikestrike.model;

public class Manager extends ShopEmployee {
    private int teamSize;
    private double departmentBudget;

    public Manager(String first, String last) { super(first, last); }

    public void addEmployee(ShopEmployee emp) { /* TODO */ }
    public void removeEmployee(ShopEmployee emp) { /* TODO */ }

    public int getTeamSize() { return teamSize; }
    public void setTeamSize(int teamSize) { this.teamSize = teamSize; }
    public double getDepartmentBudget() { return departmentBudget; }
    public void setDepartmentBudget(double departmentBudget) { this.departmentBudget = departmentBudget; }
}