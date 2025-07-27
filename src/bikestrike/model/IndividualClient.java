package bikestrike.model;

public class IndividualClient extends Client {
    private static final long serialVersionUID = 1L;
    public IndividualClient() { super(); }
    public String toString() { return firstName + " " + lastName + " (" + email + ")"; }
}