
import java.util.ArrayList;



public class BankCustomer {

    String firstName;
    String lastName;
    private HomeAddress homeAddress;
    private MoneyMarketAccount moneyMarketAccount ;
    private SavingsAccount savingAccount;
    private CheckingAccount checkingAccount;
    private OfficeAddress officeAddress;
    private static ArrayList<BankCustomer> customers= new ArrayList<BankCustomer>() ;

    public BankCustomer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        customers.add(this);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Object [] getAddress() {
        Object [] addresses = new Object [2];
        addresses[0] = this.homeAddress;
        addresses[1] = this.officeAddress;
        return addresses;
    }




    public static ArrayList<BankCustomer> getCustomers() {
        return customers;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public HomeAddress getHomeAddress() {
        return homeAddress;
    }

    public MoneyMarketAccount getMoneyMarketAccount() {
        return moneyMarketAccount;
    }

    public SavingsAccount getSavingAccount() {
        return savingAccount;
    }

    public CheckingAccount getCheckingAccount() {
        return checkingAccount;
    }

    public OfficeAddress getOfficeAddress() {
        return officeAddress;
    }

    public void setHomeAddress(HomeAddress homeAddress) {
        this.homeAddress = homeAddress;
    }

    public void setMoneyMarketAccount(MoneyMarketAccount moneyMarketAccount) {
        this.moneyMarketAccount = moneyMarketAccount;
    }

    public void setSavingAccount(SavingsAccount savingAccount) {
        this.savingAccount = savingAccount;
    }

    public void setCheckingAccount(CheckingAccount checkingAccount) {
        this.checkingAccount = checkingAccount;
    }

    public void setOfficeAddress(OfficeAddress officeAddress) {
        this.officeAddress = officeAddress;
    }

  

  

    public static void setCustomers(ArrayList<BankCustomer> customers) {
        BankCustomer.customers = customers;
    }

    public static ArrayList<BankCustomer> allCustomers() {
        return customers;
    }

    public String getName() {
        return lastName + ", " + firstName;
    }

    public BankAccount[] showAccounts() {
        BankAccount[] accounts = new BankAccount[3];
        accounts[0] = savingAccount;
        accounts[1] = checkingAccount;
        accounts[3] = moneyMarketAccount;
        return accounts;
    }

}
