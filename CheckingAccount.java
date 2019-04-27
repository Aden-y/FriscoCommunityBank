/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class CheckingAccount extends BankAccount {
    private final double transactionFee = 0.0;
    private static final double minimumBalance = 500;
    private SavingsAccount savingsAccount;
    public CheckingAccount() {
        this.balance = 1000;
        this.type = "checking";
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
}
