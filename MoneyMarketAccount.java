/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class MoneyMarketAccount extends BankAccount{
    private static final double transactionFee=10.0;
    private static final double minimumBalance = 5000;
    private SavingsAccount savingsAccount;
    
    public MoneyMarketAccount() {
        this.balance = 10000;
        this.type = "money market";
    }
            public void withdraw(double amount){
       if(amount > this.balance){
           System.out.println("Could not withdraw "+amount+" which is more than your balance of "+this.balance);
           return;
       }else if(this.balance - amount < minimumBalance){
           System.out.println("Could not withdrow this amout since your balance wil be below the reqired minimum of "+minimumBalance);
           return;
       }else if(this.balance - amount - transactionFee < minimumBalance){
           System.out.println("Could not withdraw since your balance wil be below the minimum balance");
           return;
       }
        this.balance-=amount;
    }

    public void transfer(BankAccount account , double amount){
        
        if(this.balance - amount - transactionFee < minimumBalance){
            System.out.println("You have Insafficient funds to transfer "+amount);
            return;
        }
        account.balance+=amount;
        this.balance-=amount;
        
    }
    public static double getTransactionFee() {
        return transactionFee;
    }

    public SavingsAccount getSavingsAccount() {
        return savingsAccount;
    }

    public void setSavingsAccount(SavingsAccount savingsAccount) {
        this.savingsAccount = savingsAccount;
    }

}
