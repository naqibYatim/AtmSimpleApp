package Bank;
import java.util.*;
public class Deposit extends Transaction{
    
    String accNumber;
    double accBalance;
    
    public Deposit(String currentAccountNumber, double currentAccountBalance) throws IllegalAmountException{
        super(currentAccountNumber, currentAccountBalance);
    }
    
    public void DisplayAccNumAndBal() {
        
        accNumber = getAccountNumber();
        accBalance = getAccountBalance();
        
        System.out.println("Please enter amount you want to deposit");
        System.out.println("Press '0' to cancel deposit");
        
        Scanner input = new Scanner(System.in);
        double depAmount = input.nextDouble();
        
        // correctness
        assert depAmount > 0 : "Error! Number must be more than zero";
        // robustness
        try{
            
            if(depAmount < 0){
                System.out.println("Error! Please enter amount that is more than zero\n\n");
                DisplayAccNumAndBal();
            }else if(depAmount == 0){
                MainMenu.MainPage(accNumber, accBalance);
            }else{
                accBalance = accBalance + depAmount;
            }
            
            setAccountBalance(accBalance);
            
            boolean check;
            do{
                
                System.out.println("New balance in your account is : " + accBalance);
                System.out.println("\nDo you want to continue deposit? (press y || n)");
        
                Scanner choice = new Scanner(System.in);
                String cont = choice.nextLine();
        
                if(cont.equals("y") || cont.equals("yes")){
                    DisplayAccNumAndBal();
                    check = false;
                }else if(cont.equals("n") || cont.equals("no")){
                    MainMenu.MainPage(accNumber, accBalance);
                    check = false;
                }else{
                    System.out.println("Invalid input. Please enter a valid one\n\n");
                    check = true;
                }
            }while(check == true);
            
            
        }catch(IllegalAmountException ex){     
            System.out.println(ex);
            System.out.println("\n\n");
            DisplayAccNumAndBal();
        }catch(InputMismatchException x){      
            System.out.println(x);
            System.out.println("\n\n");
            DisplayAccNumAndBal();
        }catch(NumberFormatException exe){      
            System.out.println(exe);
            System.out.println("\n\n");
            DisplayAccNumAndBal();
        }
    }
}
