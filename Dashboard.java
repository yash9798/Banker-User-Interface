import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Dashboard extends JPanel {
	
	public Dashboard()
	{
		this.setBounds(100, 100, 500, 250);
		this.setVisible(false);
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = gbc.WEST;
		gbc.insets = new Insets(10,10,10,10);
		JLabel bank = new JLabel("Bank accounts: "); // + num bank accounts
		add(bank,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.anchor = gbc.WEST;
		gbc.insets = new Insets(10,10,10,10);
		JLabel check = new JLabel("Checking accounts: "); // + num checkings accounts
		add(check,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.anchor = gbc.WEST;
		gbc.insets = new Insets(10,10,10,10);
		JLabel savings = new JLabel("Savings accounts: "); // + num savings accounts
		add(savings,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.anchor = gbc.WEST;
		gbc.insets = new Insets(10,10,10,10);
		JLabel moners = new JLabel("Moners deposited "); // + moners
		add(moners,gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.anchor = gbc.CENTER;
		gbc.insets = new Insets(10,10,10,10);
		JButton end = new JButton("End of Month Update"); // + moners
		add(end,gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.anchor = gbc.CENTER;
		gbc.insets = new Insets(10,10,10,10);
		JButton ow = new JButton("Overwrite"); // + moners
		add(ow,gbc);
	}
}
