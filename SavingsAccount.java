
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class SavingsAccount extends BankAccount{
    private static final double minimumBalance=1000.0;
    private static final double interestRate=0.0;
    private static double transactionFee;
    private CheckingAccount checkingAccount;
    
    public SavingsAccount() {
        this.type = "savings";
        this.balance = 2000;
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
