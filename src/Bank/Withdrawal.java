package Bank;

import java.util.*;

public class Withdrawal extends Transaction{
    
    String accNumber;
    double accBalance;
    
    public Withdrawal(String currentAccountNumber, double currentAccountBalance) throws IllegalAmountException{
        super(currentAccountNumber, currentAccountBalance);
    }

    public void DisplayAccNumAndBal() {
        
        accNumber = getAccountNumber();
        accBalance = getAccountBalance();
        
        System.out.println("Choose amount you want to withdraw : (press 1 || 2 || 3 || 4 || 5 || 6)");
        System.out.println("1 : RM 500");
        System.out.println("2 : RM 400");
        System.out.println("3 : RM 300");
        System.out.println("4 : RM 200");
        System.out.println("5 : RM 100");
        System.out.println("6 : Other Amount");
        System.out.println("Press 'x' to cancel withdraw");
        
        Scanner input = new Scanner(System.in);
        String userNum = input.nextLine();
        
        try{
            if(userNum.equals("1")){
                accBalance = accBalance - 500.00;
            }else if(userNum.equals("2")){
                accBalance = accBalance - 400.00;
            }else if(userNum.equals("3")){
                accBalance = accBalance - 300.00;
            }else if(userNum.equals("4")){
                accBalance = accBalance - 200.00;
            }else if(userNum.equals("5")){
                accBalance = accBalance - 100.00;
            }else if(userNum.equals("6")){
                otherAmount();
            }else if(userNum.equals("x")){
                MainMenu.MainPage(accNumber, accBalance);
            }else{
                System.out.println("Invalid input. Please enter the valid input\n\n");
                DisplayAccNumAndBal();
            } 
            setAccountBalance(accBalance);
            
            System.out.println("Please take money from cash dispenser\n");
            
            // boolean to check if 
            boolean check;
            do{
                
                System.out.println("New balance in your account is : " + accBalance);
                System.out.println("\nDo you want to continue withdrawal? (press y || n)");
        
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
            
        }catch(IllegalAmountException ex){      // Own Exception
            System.out.println(ex);
            System.out.println("\n\n");
            DisplayAccNumAndBal();
        }catch(InputMismatchException x){       // input mismatch exception
            System.out.println(x);
            System.out.println("\n\n");
            DisplayAccNumAndBal();
        }catch(NumberFormatException exe){      // number format exception
            System.out.println(exe);
            System.out.println("\n\n");
            DisplayAccNumAndBal();
        }
    }
    
    public void otherAmount(){
        
        System.out.println("Please enter amount to withdraw");
        Scanner amount = new Scanner(System.in);
        double withdrawAmount = amount.nextDouble();
        
        // correctness
        assert withdrawAmount > 0 : "Error! Number must be more than zero";
        // robustness
        try{
            if(withdrawAmount <= 0){
                System.out.println("Error! Please enter amount that is more than zero\n\n");
                otherAmount();
            }else{
                accBalance = accBalance - withdrawAmount;
            }
        }catch(NumberFormatException ex){
            System.out.println(ex);
            otherAmount();
        }catch(InputMismatchException e){
            System.out.println(e);
            otherAmount();
        }
    }
}
