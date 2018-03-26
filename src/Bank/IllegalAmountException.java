package Bank;

public class IllegalAmountException extends Exception{
    
    public IllegalAmountException(){
        
    }
    
    public IllegalAmountException(String errorMessage){
        
        super(errorMessage);
        
    }
}
