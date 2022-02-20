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
import java.io.*;
import java.time.LocalDate;

public class MelBank extends JFrame {
	//fields
	ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
	
	public MelBank() throws IOException {
		//initializes ArrayList<BankAccount> accounts
		getAccsFromFile();
		
		CardLayout cardLayout = new CardLayout();
	//components
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
			JPanel overall = new JPanel();
			overall.setLayout(cardLayout);
			Dashboard dash = new Dashboard(accounts);
			overall.add(dash, "dash");
			dashboardItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cardLayout.show(overall, "dash");
				}
			});
			menuBar.add(dashboardItem);
			this.add(overall);
			this.setJMenuBar(menuBar);
			
			add1 add = new add1(accounts);
			overall.add(add, "add");
			addAccountItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					cardLayout.show(overall, "add");
				}
			});	
	
			/*UserInfo userInfo = new UserInfo();
			overall.add(userinfo, "userinfo");
			userInfoItem.addActionListener(new ActionListener() {
				@Override
				.public void actionPerformed(ActionEvent e) {
				cardLayout.show(overall, "userinfo");
			}
		});	
		
			add add = new add();
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
		
		Trans tr = new Trans();
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
		});	*/
			
		this.setBounds(100, 100, 500, 400);
		this.setVisible(true);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	}

//MAIN METHOD BELOW
public static void main(String[] args) throws IOException {
	boolean fileCreated = new File("accountInfo.txt").createNewFile(); //creates a text file called "acccountInfo.txt" provided one does not already exist
	if (fileCreated) { //Code block displays the date that the file was created in the file
		PrintWriter pw = new PrintWriter(new FileWriter("accountInfo.txt"),true);
		pw.println("accountInfo.txt created on " + LocalDate.now());
		pw.close();
	}
	
	new MelBank();
}
//MAIN METHOD ABOVE	
	
//get acc methods
	public static ArrayList<BankAccount> getAccountsFromName(ArrayList<BankAccount> accounts, String name) {
		ArrayList<BankAccount> nameAccs  = new ArrayList<BankAccount>();
		boolean hasAcc = false;
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getName().equals(name)) 
			if (accounts.get(i).getName().equals(name)) {
				nameAccs.add(accounts.get(i));
				hasAcc = true;
			}	
		}
		if (hasAcc) return nameAccs; else return null;
	}
	public static BankAccount getAccountFromNumber(ArrayList<BankAccount> accounts, int accountNumber) {
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getAccountNumber() == accountNumber) 
				return accounts.get(i);
		}
		return null;
	}
	
//this class's constructor is already too crowded so I'm gonna just do the file reading portion in a method
	public void getAccsFromFile() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("accountInfo.txt"));
		//constructor argument variables		
		int accNum = 0;
		String name = "";
		String streetAddress = "";
		String state = "";
		String city = "";
		String zipCode = "";
		double balance = 0;
		//for checking account only
		int numTransactions = 0;
		
		String s; //String that holds all information for a single account
		/*
		 * To extract from line:
		 * 		Account Type (Savings/Checking)
		 * 		Account Number
		 * 		Name
		 * 		Street Address
		 * 		State
		 * 		City
		 * 		Zip Code
		 * 		Balance
		 * 		numTransactions (for checking account only
		 * 
		 * NOTE: BANK ACCOUNT INFO IS DISPLAYED IN THE FILE AS:
		 * CA<num>38263<num/><name>Obama<name/><street>1600 Pennsylvania Ave.<street/><city>Washington<city/><state>Maryland<state/><zip>12842<zip/><balance>419.26<balance/><trans>10<trans/>
		 */
		while ((s = br.readLine()) != null) {
			if (s.length() > 1 && (s.substring(0,1).equals("SA") || s.substring(0,1).equals("CA"))) {
				accNum = Integer.parseInt(s.substring((s.indexOf("<num>") + 5),s.indexOf("<num/>")));
				name = s.substring((s.indexOf("<name>") + 6),s.indexOf("<name/>"));
				streetAddress = s.substring((s.indexOf("<street>") + 8),s.indexOf("<street/>"));
				city = s.substring((s.indexOf("<city>") + 6),s.indexOf("<city/>"));
				state = s.substring((s.indexOf("<state>") + 7),s.indexOf("<state/>"));
				zipCode = s.substring((s.indexOf("<zip>") + 5),s.indexOf("<zip/>"));
				balance = Double.parseDouble(s.substring((s.indexOf("<balance>") + 9),s.indexOf("<balance/>")));
				numTransactions = Integer.parseInt(s.substring((s.indexOf("<trans>") + 7),s.indexOf("<trans/>")));
				
				//Constructs accounts
				if (s.substring(0,1).equals("SA"))
					accounts.add(new SavingsAccount(name,streetAddress,city,state,balance,zipCode,accNum));
				if (s.substring(0,1).equals("CA")) {
					accounts.add(new CheckingAccount(name,streetAddress,city,state,balance,zipCode,accNum,numTransactions));
				}
			}
		}
	}
//write to file methods for savings accounts and checking accounts
	public void writeAccToFile(SavingsAccount s) throws IOException {
		PrintWriter pw = new PrintWriter(new FileWriter("accountInfo.txt",true));
		pw.println("\nSA"
				+ "<num>" + s.getAccountNumber() + "<num/>"
				+ "<name>" + s.getName() + "<name/>"
				+ "<street>" + s.getStreetAddress() + "<street/>"
				+ "<city>" + s.getCity() +  "<city/>"
				+ "<state>" + s.getState() + "<state/>"
				+ "<zip>" + s.getZipCode() + "<zip/>"
				+ "<balance>" + s.getBalance() + "<balance/>");
		pw.close();
	}
	public void writeAccToFile(CheckingAccount c) throws IOException {
		PrintWriter pw = new PrintWriter(new FileWriter("accountInfo.txt",true));
		pw.println("\nCA"
				+ "<num>" + c.getAccountNumber() + "<num/>"
				+ "<name>" + c.getName() + "<name/>"
				+ "<street>" + c.getStreetAddress() + "<street/>"
				+ "<city>" + c.getCity() +  "<city/>"
				+ "<state>" + c.getState() + "<state/>"
				+ "<zip>" + c.getZipCode() + "<zip/>"
				+ "<balance>" + c.getBalance() + "<balance/>"
				+ "<trans>" + c.getNumTransactions() + "<trans/>");
		pw.close();
	}
	
	public int getNumBank() {
		return accounts.size();
	}

}
