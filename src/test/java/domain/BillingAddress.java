package domain;

public class BillingAddress {

    private String firstName;
    private String lastName;
    private String billingStreet;
    private String bCity;
    private String bState;
    private String zipCode;
    private String email;

    public BillingAddress() {
    }

    public BillingAddress(String firstName, String lastName, String billingStreet, String bCity, String bState, String zipCode, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.billingStreet = billingStreet;
        this.bCity = bCity;
        this.bState = bState;
        this.zipCode = zipCode;
        this.email = email;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBillingStreet() {
        return billingStreet;
    }

    public void setBillingStreet(String billingStreet) {
        this.billingStreet = billingStreet;
    }

    public String getbCity() {
        return bCity;
    }

    public void setbCity(String bCity) {
        this.bCity = bCity;
    }

    public String getbState() {
        return bState;
    }

    public void setbState(String bState) {
        this.bState = bState;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
