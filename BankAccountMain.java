import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
public class MelBank extends JFrame {
	//create your fields here
	public MelBank() {
		CardLayout cardLayout = new CardLayout();
		JMenuBar menuBar = new JMenuBar();
		
		JMenu accountMenu = new JMenu("Accounts");
		JMenuItem userInfoItem = new JMenuItem("User Info");
		JMenuItem addAccountItem = new JMenuItem("Add Account");
		JMenuItem closeAccountItem = new JMenuItem("Close Account");
		accountMenu.add(userInfoItem);
		accountMenu.add(addAccountItem);
		accountMenu.add(closeAccountItem);
		
		
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
		menuBar.add(dashboardItem);
		menuBar.add(accountMenu);
		
		JMenuItem dashboardItem = new JMenuItem("Dashboard");
		JPanel overall = new JPanel();
		overall.setLayout(cardLayout);
		Dashboard dash = new Dashboard();
		overall.add(dash, "dash");
		dashboardItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(overall, "dash");
			}
		});	
		
		UserInfo userInfo = new UserInfo();
		overall.add(userinfo, "userinfo");
		userInfoItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(overall, "userinfo");
			}
		});	
		
		Add add = new Add();
		overall.add(add, "add");
		addAccountItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(overall, "add");
			}
		});	
		
		Close close = new Close();
		overall.add(close, "close");
		closeAccountItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(overall, "close");
			}
		});	
		
		Deposit dep = new Deposit();
		overall.add(dep, "dep");
		depositItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(overall, "deposit");
			}
		});	
		
		Withdraw wd = new Withdraw();
		overall.add(wd, "wd");
		withdrawItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(overall, "wd");
			}
		});	
		
		Trans tr = new Transe();
		overall.add(tr, "tr");
		transferItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(overall, "close");
			}
		});	
		
		accountInfo ai = new accountInfo();
		overall.add(ai, "ai");
		getAccountInfoItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(overall, "ai");
			}
		});	
		
		
		
		
		this.add(overall);
		this.setJMenuBar(menuBar);
		this.setBounds(100, 100, 500, 250);
		this.setVisible(true);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new MelBank();
	}
	/**
	 * this method should return all bank accounts in 
	 * a person's name.  You should implement this method
	 */
	public static ArrayList<BankAccount> getAccountsFromName(ArrayList<BankAccount> accounts, String name) {
		ArrayList<BankAccount> nameAccs  = new ArrayList<BankAccount>();
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getName().equals(name)) 
				nameAccs.add(accounts.get(i));
		}
		return nameAccs; //FIX THIS PART
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
		return null; //FIX THIS PART 
	}
}
