package Bank;

public abstract class Transaction {     // An abstract class Transaction
    
    private String accountNumber;
    private double accountBalance;
    
    public Transaction(String currentAccountNumber, double currentAccountBalance) throws IllegalAmountException{
        setAccountNumber(currentAccountNumber);
        setAccountBalance(currentAccountBalance);
    }
    
    public void setAccountNumber(String value){
        accountNumber = value;
    }
    public String getAccountNumber(){
        return accountNumber;
    }
    
    public void setAccountBalance(double value) throws IllegalAmountException{
        if(value <= 0){
            throw new IllegalAmountException("Invalid amount. Not enough amount to withdraw from account");
        }
        accountBalance = value;
    }
    public double getAccountBalance(){
        return accountBalance;
    }
    
    public abstract void DisplayAccNumAndBal();     // abstract method

}
