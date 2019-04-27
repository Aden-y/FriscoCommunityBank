/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class OfficeAddress extends CustomerAddress{
    private int suite;
    private String fax;
    public OfficeAddress(int number, String street, String city, String state, int zip, int suite, String fax) {
        super(number, street, city, state, zip);
        this.suite = suite;
        this.fax = fax;
    }

    public int getSuite() {
        return suite;
    }

    public String getFax() {
        return fax;
    }

    public void setSuite(int suite) {
        this.suite = suite;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }
    
}
