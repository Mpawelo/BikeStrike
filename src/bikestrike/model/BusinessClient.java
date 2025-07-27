package bikestrike.model;

public class BusinessClient extends Client {
    private static final long serialVersionUID = 1L;
    private String companyName;
    private String nip;

    public BusinessClient() { super(); }

    public String getCompanyName() { return companyName; }
    public void setCompanyName(String companyName) { this.companyName = companyName; }
    public String getNip() { return nip; }
    public void setNip(String nip) { this.nip = nip; }

    @Override public String toString() { return companyName + " (NIP " + nip + ")"; }
}