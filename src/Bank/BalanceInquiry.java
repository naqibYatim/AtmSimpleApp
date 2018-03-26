package Bank;

import java.util.*;

public class BalanceInquiry extends Transaction{

    String accNumber;
    double accBalance;
    
    public BalanceInquiry(String currentAccountNumber, double currentAccountBalance) throws IllegalAmountException {
        super(currentAccountNumber, currentAccountBalance);
    }
    
    public void DisplayAccNumAndBal(){
        
        accNumber = getAccountNumber();
        accBalance = getAccountBalance();
        
        System.out.println("Account : " + accNumber);
        System.out.println("Balance : RM " + accBalance);
        System.out.println("\nDo you want to continue transaction? (press y || n)");
        
        Scanner input = new Scanner(System.in);
        String cont = input.nextLine();
        
        try {
            if(cont.equals("y") || cont.equals("yes")){
                MainMenu.MainPage(accNumber, accBalance);
            }else if(cont.equals("n") || cont.equals("no")){
                setAccountBalance(accBalance);
                System.out.println("Thanks for using our system\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                new ValidationPage();
            }else{
                System.out.println("Invalid input. Please enter a valid one\n\n");
                DisplayAccNumAndBal();
            }
        }catch (IllegalAmountException ex) {
            System.out.println(ex);
        }catch(InputMismatchException e){
            System.out.println(e);
        }
    }
}
