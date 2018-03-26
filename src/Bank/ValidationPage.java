package Bank;

import java.util.Scanner;

public class ValidationPage {
    
    double currentAccountBalance;
    String currentAccountNumber;
    String currentAccountPIN;
    
    // collection of account number user in database
    String accountNum[] = new String[10];
    
    // collection of PIN number user in database
    String PINNum[] = new String[10];
        
    // amount of balance in user account
    double balance[] = new double[accountNum.length];
    
    // bool to check if the user is a valid customer or not
    static boolean customer;
    
    // bool to check a valid account number
    boolean validAccountNum;
    
    public ValidationPage(){
        
        accountNum[0] = "01230";
        accountNum[1] = "01231";
        accountNum[2] = "01232";
        accountNum[3] = "01233";
        accountNum[4] = "01234";
        accountNum[5] = "01235";
        accountNum[6] = "01236";
        accountNum[7] = "01237";
        accountNum[8] = "01238";
        accountNum[9] = "01239";
        
        PINNum[0] = "00000";
        PINNum[1] = "00001";
        PINNum[2] = "00002";
        PINNum[3] = "00003";
        PINNum[4] = "00004";
        PINNum[5] = "00005";
        PINNum[6] = "00006";
        PINNum[7] = "00007";
        PINNum[8] = "00008";
        PINNum[9] = "00009";
        
        balance[0] = 1000;
        balance[1] = 2000;
        balance[2] = 3000;
        balance[3] = 4000;
        balance[4] = 5000;
        balance[5] = 6000;
        balance[6] = 7000;
        balance[7] = 8000;
        balance[8] = 9000;
        balance[9] = 10000;
        
        
        System.out.println("Welcome!");
        ValidateAccount();
        
    }
    
    // method used to validate the account number
    public void ValidateAccount(){
        
        System.out.println("Please enter your account number:");
        
        Scanner input = new Scanner(System.in);
        String userAccountNum = input.nextLine();
        
        for(int i=0; i< accountNum.length; i++){
            
            if(accountNum[i].equals(userAccountNum)){
                validAccountNum = true;
                currentAccountNumber = accountNum[i];
                currentAccountPIN = PINNum[i];
                currentAccountBalance = balance[i];
                break;
            }else{
                customer = false;
            }
        }
        
        if(validAccountNum == true){
            ValidatePIN(currentAccountNumber, currentAccountPIN, currentAccountBalance);
        }else{
            System.out.println("Invalid account number");
            System.out.println("Please enter the appropriate account number");
            System.out.println("-------------------------------------------\n");
     
            ValidateAccount();
        }
        
    }
    
    // method to validate PIN number of account
    public void ValidatePIN(String currentAccountNumbers,String currentAccountPINs, double currentAccountBalances){
        
        System.out.println("Please enter PIN number:");
        Scanner input = new Scanner(System.in);
        String userAccountPIN = input.nextLine();
        
        for(int i=0; i< accountNum.length; i++){
            if(userAccountPIN.equals(currentAccountPINs)){
                customer = true;
                break;
            }else{
                customer = false;
            }
        }
        if(customer == true){
            try {
                MainMenu mainMenuObj = new MainMenu(currentAccountNumbers, currentAccountBalances);
            } catch (IllegalAmountException ex) {
                System.out.println(ex);
            }
        }else{
            System.out.println("\nInvalid PIN number!");
            System.out.println("Please enter the appropriate PIN number\n");
            
            ValidatePIN(currentAccountNumbers, currentAccountPINs, currentAccountBalances);
        }
    }
}
