

import java.util.ArrayList;
import java.util.Date;

public abstract class BankAccount {

    static String bankName = "Frisco Community Bank";
    private static int currentNumber = 0;

    public String accountNum;
    public String createDate;
    public CustomerAddress customerName;
    public int balance;
    public String type;
    public void print(){
        System.out.println("Bank Name:\t"+bankName);
        System.out.println("Account Number:\t"+this.accountNum);
        System.out.println("Created on:\t"+this.createDate);
        System.out.println("Customer Name:\t"+this.customerName);
        System.out.println("Account Balance:\t"+this.balance);
        System.out.println("Account type:\t"+this.type);
    }
    @Override
    public String toString(){
        String s = "";
        s+="Account Number:   "+this.accountNum+"\n";
        s+="Customer Name :   "+this.customerName+"\n";
       s+="Creat  Date :   "+this.createDate;
        System.out.println(s);
        return s;
    }
    public BankAccount() {
        this.accountNum = currentNumber++ + "";
        createDate = (new Date()).toString();
    }

    public static String getBankName() {
        return bankName;
    }

    public static int getCurrentNumber() {
        return currentNumber;
    }
    public void withdraw(double amount){
        this.balance-=amount;
    }
    public void deposit(double amount){
        this.balance+=amount;
    }
    public void transfer(BankAccount account , double amount){
        account.balance+=amount;
        this.balance-=amount;
        
    }
    
    public void showBalance(){
        System.out.println("Balance: $"+this.balance);
    }

    public String getAccountNum() {
        return accountNum;
    }

    public String getCreateDate() {
        return createDate;
    }

    public CustomerAddress getCustomerName() {
        return customerName;
    }

    public int getBalance() {
        return balance;
    }

    public String getType() {
        return type;
    }

    public static void setBankName(String bankName) {
        BankAccount.bankName = bankName;
    }

    public static void setCurrentNumber(int currentNumber) {
        BankAccount.currentNumber = currentNumber;
    }

    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public void setCustomerName(CustomerAddress customerName) {
        this.customerName = customerName;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BankAccount[] allSavingAccounts() {
       ArrayList<BankCustomer> bankCustomers = BankCustomer.getCustomers();
        BankAccount[] savingAccounts = new BankAccount[bankCustomers.size()];

        for (int i = 0; i < bankCustomers.size(); i++) {
            savingAccounts[i] = bankCustomers.get(i).getSavingAccount();
        }

        return savingAccounts;
    }

    public BankAccount[] allCheckingAccounts() {
       ArrayList<BankCustomer> bankCustomers = BankCustomer.getCustomers();
        BankAccount[] checkingAccounts = new BankAccount[bankCustomers.size()];

        for (int i = 0; i < bankCustomers.size(); i++) {
            checkingAccounts[i] = bankCustomers.get(i).getCheckingAccount();
        }

        return checkingAccounts;
    }

}
