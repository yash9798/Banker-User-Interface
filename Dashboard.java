import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Dashboard extends JPanel {
	ArrayList<BankAccount> accs;;
	public Dashboard(ArrayList<BankAccount> b) throws IOException
	{
		accs=b;
		this.setBounds(100, 100, 500, 250);
		this.setVisible(false);
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = gbc.WEST;
		gbc.insets = new Insets(10,10,10,10);
		JLabel bank = new JLabel("Bank accounts: " + accs.size()); // + num bank accounts
		add(bank,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.anchor = gbc.WEST;
		gbc.insets = new Insets(10,10,10,10);
		int c = 0;
		int r = 0;
		int m = 0;
		for(int i = 0; i < accs.size(); i++)
		{
			
			if(accs.get(i) instanceof CheckingAccount)
					{
		c++;
					}
			if(accs.get(i) instanceof SavingsAccount)
			{
				r++;
			}
			
			m += accs.get(i).getBalance();
		}
		JLabel check = new JLabel("Checking accounts: " +c); // + num checkings accounts
		add(check,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.anchor = gbc.WEST;
		gbc.insets = new Insets(10,10,10,10);
		JLabel savings = new JLabel("Savings accounts: " + r); // + num savings accounts
		add(savings,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.anchor = gbc.WEST;
		gbc.insets = new Insets(10,10,10,10);
		JLabel moners = new JLabel("Moners deposited $" + m); // + moners
		add(moners,gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.anchor = gbc.CENTER;
		gbc.insets = new Insets(10,10,10,10);
		JButton end = new JButton("End of Month Update"); // + moners
		end.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String password = JOptionPane.showInputDialog("Enter a password: ");
				if(password.equals("password"))
				{
					for(int i = 0; i < accs.size(); i++)
					{
						
//						if(accs.get(i) instanceof CheckingAccount)
//								{
//							accs.get(i).endOfMonthUpdate();
//								}
//						if(accs.get(i) instanceof SavingsAccount)
//						{
							accs.get(i).endOfMonthUpdate();
//						}
					}
				}
			}});
		add(end,gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.anchor = gbc.CENTER;
		gbc.insets = new Insets(10,10,10,10);
		JButton ow = new JButton("Overwrite"); // + moners
		add(ow,gbc);
	}
}
