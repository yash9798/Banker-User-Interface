import java.util.ArrayList;
import javax.swing.JFrame;
public class BankAccountMain extends JFrame {
  //create your fields here
  public BankAccountMain() {
  }
  public static void main(String[] args) {
    new BankAccountMain();
  }
  /**
   * this method should return all bank accounts in 
   * a person's name.  You should implement this method
   */
  public static ArrayList<BankAccount> getAccountsFromName(ArrayList<BankAccount> accounts, String name) {
    return null;
  }
  /**
   * this method should return the bank account 
   * which matches the given account number.  You
   * should implement this method
   */
  public static BankAccount getAccountFromNumber(ArrayList<BankAccount> accounts, int accountNumber) {
    return null;
  }
}
