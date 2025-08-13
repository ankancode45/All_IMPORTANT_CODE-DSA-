/*Title: Bank Account Management System using Arrays in Core Java

Problem Statement:
Write a Java program to manage bank accounts using arrays. The program should allow the user to:

Create new bank accounts.

View all bank accounts.

Deposit money into an account.

Withdraw money from an account (if balance is sufficient).

Search for an account by account number.

The system should store a maximum of 100 accounts using arrays (no collections or database).

Requirements:

Use a BankAccount class with:

accountNumber (int)

accountHolderName (String)

balance (double)

Use an array of BankAccount objects in the main program.

Implement a simple menu-driven interface.
*/
import java.util.Scanner;

class BankAccount {
    int accountNumber;
    String accountHolderName;
    double balance;

    public BankAccount(int accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Amount deposited successfully. New Balance: " + balance);
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Amount withdrawn successfully. New Balance: " + balance);
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    public void displayAccount() {
        System.out.println("Account No: " + accountNumber + 
                           ", Name: " + accountHolderName + 
                           ", Balance: " + balance);
    }
}

class BankAccountManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount[] accounts = new BankAccount[100];
        int count = 0;

        while (true) {
            System.out.println("\n--- Bank Account Management System ---");
            System.out.println("1. Create Account");
            System.out.println("2. View All Accounts");
            System.out.println("3. Deposit Money");
            System.out.println("4. Withdraw Money");
            System.out.println("5. Search Account");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    if (count < accounts.length) {
                        System.out.print("Enter Account Number: ");
                        int accNo = sc.nextInt();
                        sc.nextLine(); // consume newline
                        System.out.print("Enter Account Holder Name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter Initial Balance: ");
                        double balance = sc.nextDouble();
                        accounts[count] = new BankAccount(accNo, name, balance);
                        count++;
                        System.out.println("Account created successfully!");
                    } else {
                        System.out.println("Account limit reached!");
                    }
                    break;

                case 2:
                    if (count == 0) {
                        System.out.println("No accounts to display.");
                    } else {
                        for (int i = 0; i < count; i++) {
                            accounts[i].displayAccount();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Account Number: ");
                    int depositAccNo = sc.nextInt();
                    BankAccount depositAcc = findAccount(accounts, count, depositAccNo);
                    if (depositAcc != null) {
                        System.out.print("Enter Amount to Deposit: ");
                        double depositAmount = sc.nextDouble();
                        depositAcc.deposit(depositAmount);
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;

                case 4:
                    System.out.print("Enter Account Number: ");
                    int withdrawAccNo = sc.nextInt();
                    BankAccount withdrawAcc = findAccount(accounts, count, withdrawAccNo);
                    if (withdrawAcc != null) {
                        System.out.print("Enter Amount to Withdraw: ");
                        double withdrawAmount = sc.nextDouble();
                        withdrawAcc.withdraw(withdrawAmount);
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;

                case 5:
                    System.out.print("Enter Account Number: ");
                    int searchAccNo = sc.nextInt();
                    BankAccount searchAcc = findAccount(accounts, count, searchAccNo);
                    if (searchAcc != null) {
                        searchAcc.displayAccount();
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;

                case 6:
                    System.out.println("Exiting system. Goodbye!");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    public static BankAccount findAccount(BankAccount[] accounts, int count, int accNo) {
        for (int i = 0; i < count; i++) {
            if (accounts[i].accountNumber == accNo) {
                return accounts[i];
            }
        }
        return null;
    }
}
/*
Explanation
BankAccount Class → Holds details of each account, with deposit/withdraw methods.

Array of BankAccount → Stores up to 100 accounts.

Menu-Driven System → Allows user to perform operations until they choose to exit.

findAccount Method → Searches for an account by account number.

Validation → Ensures no withdrawal beyond balance and checks for account existence.

-----------------------------------------------------
*/