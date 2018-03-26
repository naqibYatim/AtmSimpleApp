package Bank;

import java.util.Scanner;

public class MainMenu {
    
    public MainMenu(String currentAccountNumber, double currentAccountBalance) throws IllegalAmountException{
        MainPage(currentAccountNumber, currentAccountBalance);
    }
    
    // method to display main page (declare as static so that this method can be called withour creating it's instances)
    public static void MainPage(String currentAccountNumber, double currentAccountBalances) throws IllegalAmountException{
        
        System.out.println("\n\n--------------------------------------------------");
        System.out.println("Please choose your transaction(press 1 || 2 || 3)\n");
        System.out.println("1: Check balance");
        System.out.println("2: Withdraw money");
        System.out.println("3: Deposit money");
        System.out.println("Press 'x' to cancel transaction\n");
        
        Scanner input = new Scanner(System.in);
        String transaction = input.nextLine();
        
        if(transaction.equals("1")){
            // Practising polymorphism
            Transaction transactionBalance = new BalanceInquiry(currentAccountNumber, currentAccountBalances);
            // polymorphic method
            transactionBalance.DisplayAccNumAndBal();
        }else if(transaction.equals("2")){
            Transaction transactionWithdraw = new Withdrawal(currentAccountNumber, currentAccountBalances);
            transactionWithdraw.DisplayAccNumAndBal();
        }else if(transaction.equals("3")){
            Transaction transactionDeposit = new Deposit(currentAccountNumber, currentAccountBalances);
            transactionDeposit.DisplayAccNumAndBal();
        }else if(transaction.equals("x")){
            System.out.println("Thanks for using our system\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            new ValidationPage();
        }else{
            System.out.println("Invalid number input. Please enter the valid one\n\n");
            MainPage(currentAccountNumber, currentAccountBalances);
        }
    }
}
