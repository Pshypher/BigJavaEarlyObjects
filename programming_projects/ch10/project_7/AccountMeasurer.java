package project_7;

public class AccountMeasurer implements Measurer
{
   public double measure(Object obj)
   {  
      BankAccount account = (BankAccount) obj;
      return account.getBalance(); 
   }
}