import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
public class BankAccountMain extends JFrame {
	//create your fields here
	public BankAccountMain() {
		JMenuBar menuBar = new JMenuBar();
		JMenu accountMenu = new JMenu("Accounts");
		JMenuItem userInfoItem = new JMenuItem("User Info");
		JMenuItem addAccountItem = new JMenuItem("Add Account");
		JMenuItem closeAccountItem = new JMenuItem("Close Account");
		accountMenu.add(userInfoItem);
		accountMenu.add(addAccountItem);
		accountMenu.add(closeAccountItem);
		menuBar.add(accountMenu);
		JMenu transactionsMenu = new JMenu("Transactions");
		JMenuItem depositItem = new JMenuItem("Deposit");
		JMenuItem withdrawItem = new JMenuItem("Withdraw");
		JMenuItem transferItem = new JMenuItem("Transfer");
		JMenuItem getAccountInfoItem = new JMenuItem("Get Account Info");
		transactionsMenu.add(depositItem);
		transactionsMenu.add(withdrawItem);
		transactionsMenu.add(transferItem);
		transactionsMenu.add(getAccountInfoItem);
		menuBar.add(transactionsMenu);
		JMenuItem dashboardItem = new JMenuItem("Dashboard");
		menuBar.add(dashboardItem);
		this.setJMenuBar(menuBar);
		this.setBounds(100, 100, 500, 250);
		this.setVisible(true);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new BankAccountMain();
	}
	/**
	 * this method should return all bank accounts in 
	 * a person's name.  You should implement this method
	 */
	public static ArrayList<BankAccount> getAccountsFromName(ArrayList<BankAccount> accounts, String name) {
		ArrayList<BankAccount> nameAccs  = new ArrayList<BankAccount>();
		boolean hasAcc = false;
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getName().equals(name)) {
				nameAccs.add(accounts.get(i));
				hasAcc = true;
			}	
		}
		if (hasAcc) return nameAccs; else return null;
	}
	/**
	 * this method should return the bank account 
	 * which matches the given account number.  You
	 * should implement this method
	 */
	public static BankAccount getAccountFromNumber(ArrayList<BankAccount> accounts, int accountNumber) {
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getAccountNumber() == accountNumber) 
				return accounts.get(i);
		}
		return null;
	}
}
