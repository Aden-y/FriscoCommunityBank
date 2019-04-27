

import java.util.Scanner;

public class FriscoCommunityBank {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int customerNum = 0;
        String firstName, lastName;
        int number;
        String street;
        String city;
        String state;
        int zip;
        String choice;
        CustomerAddress customerAddress;
        BankAccount account = null;
        BankCustomer[] customers = new BankCustomer[4];
        BankCustomer customer = null;

        System.out.println("Welcome to the Frisco Community Bank");

        while (customerNum <= 4) {
            System.out.print("Enter " + (customerNum + 1) + ". customer first name: ");
            firstName = scanner.nextLine();

            System.out.print("Enter " + (customerNum + 1) + ". customer last name: ");
            lastName = scanner.nextLine();

            customers[customerNum] = new BankCustomer(firstName, lastName);
            account = new SavingsAccount();
            customers[customerNum].setSavingAccount((SavingsAccount)account);
            account = new CheckingAccount();
            customers[customerNum].setCheckingAccount((CheckingAccount)account);

            System.out.print("  Enter address number: ");
            while (true) {

                if (scanner.hasNextInt()) {
                    number = scanner.nextInt();
                    break;
                } else {
                    System.out.print("Invalid number format, try again: ");
                    scanner.nextLine(); // flush input
                }

            }
            scanner.nextLine(); //flush input
            System.out.print("  Enter address street: ");
            street = scanner.nextLine();
            System.out.print("  Enter address city: ");
            city = scanner.nextLine();
            System.out.print("  Enter address state: ");
            state = scanner.nextLine();
            System.out.print("  Enter address zip: ");
            while (true) {
                if (scanner.hasNextInt()) {
                    zip = scanner.nextInt();
                    break;
                } else {
                    System.out.print("Invalid number format, try again: ");
                    scanner.nextLine(); // flush input
                }
            }

            scanner.nextLine(); // flush input

            customerAddress = new CustomerAddress(number, street, city, state, zip);

           // customers[customerNum].setAddress(customerAddress);
            customerNum++;

            if (customerNum >= 2 && customerNum < 4) {
                System.out.print("Do you want to create any more customer(s)? Yes(y) or No(n): ");

                while (true) {
                    choice = scanner.nextLine();
                    if (choice.equalsIgnoreCase("y")) {
                        break;
                    } else if (choice.equalsIgnoreCase("n")) {
                        customerNum = 5;
                        break;
                    } else {
                        System.out.print("Invalid choice, try again: ");
                    }
                }

            } else if (customerNum == 4) {
                break;
            }
        }

        System.out.print("Enter first name of the customer you want to work with: ");
        boolean loop = true;
        while (loop) {
            firstName = scanner.nextLine();

            for (int i = 0; i < customers.length; i++) {
                if (customers[i].getFirstName().equals(firstName)) {
                    customer = customers[i];
                    loop = false;
                    break;
                }
            }
            if (loop) {
                System.out.print("There is no customer with that first name, try again: ");
            }

        }

        System.out.print("Choose type of account, Saving(s) or Checking(c): ");

        String type;

        while (true) {
            choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("s")) {
                account = customer.getSavingAccount();
                break;
            } else if (choice.equalsIgnoreCase("c")) {
                account = customer.getCheckingAccount();
                break;
            } else {
                System.out.print("Invalid choice, try again: ");
            }
        }
        loop = true;
        while (loop) {
            System.out.print("Choose activity, Balance(b), Deposit(d) or Withdrawal(w): ");

            choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("b")) {
                System.out.println("Customer Name: " + customer.getName());
                System.out.println("Account Type: " + account.getType());
                System.out.println("Current Balance: " + account.getBalance());

            } else if (choice.equalsIgnoreCase("d")) {
                System.out.print("Enter deposit amount: ");
                try {
                    int deposit = scanner.nextInt();
                    scanner.nextLine();
                    int oldBalance = account.getBalance();
                    account.setBalance(oldBalance + deposit);
                    System.out.println("Customer Name: " + customer.getName());
                    System.out.println("Account Type: " + account.getType());
                    System.out.println("Prev Balance: " + oldBalance);
                    System.out.println("New Balance: " + account.getBalance());
                } catch (Exception ex) {
                    System.out.println("Invalid amount format! ");
                    scanner.nextLine(); //flush input
                    continue;
                }

            } else if (choice.equalsIgnoreCase("w")) {
                System.out.print("Enter withdrawal amount: ");
                try {
                    int withdraw = scanner.nextInt();
                    scanner.nextLine();
                    int oldBalance = account.getBalance();
                    while (account.getBalance() < withdraw) {
                        System.out.print("Insufficient funds, enter amount again:");
                        withdraw = scanner.nextInt();
                        scanner.nextLine();
                    }
                    account.setBalance(oldBalance - withdraw);
                    System.out.println("Customer Name: " + customer.getName());
                    System.out.println("Account Type: " + account.getType());
                    System.out.println("Prev Balance: " + oldBalance);
                    System.out.println("New Balance: " + account.getBalance());
                } catch (Exception ex) {
                    System.out.println("Invalid amount format! ");
                    scanner.nextLine(); //flush input
                    continue;
                }

            } else {
                System.out.println("Invalid choice, try again!");
                continue;
            }

            System.out.print("Choose: quit(q) or countinue(c): ");
            while (true) {
                choice = scanner.nextLine();

                if (choice.equalsIgnoreCase("q")) {
                    loop = false;
                    break;
                } else if (choice.equalsIgnoreCase("c")) {
                    break;
                } else {
                    System.out.print("Invalid choice, try again: ");
                }
            }

        }

    }

}
