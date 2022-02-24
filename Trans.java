import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Trans extends JPanel{

	JLabel account1;
	JLabel account2;
	JLabel deposit;
	
	public Trans(ArrayList<BankAccount> b)
	{
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		this.setBackground(new Color(255,204,229));
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = gbc.WEST;
		gbc.insets = new Insets(10,10,10,10);
		account1 = new JLabel("Account number of withdrawal: "); 
		add(account1,gbc);
		
		gbc.gridy=1;
		account2 = new JLabel("Account number of deposit: "); 
		add(account2,gbc);
		
		gbc.gridy=2;
		deposit = new JLabel("Deposit transferred: "); 
		add(deposit,gbc);
		
		gbc.gridx = 1;
		gbc.gridy=0;
		gbc.anchor = gbc.EAST;
		gbc.insets = new Insets(0,0,0,0);
		JTextField from = new JTextField("");
		from.setPreferredSize(new Dimension(150,30));
		add(from,gbc);
		
		gbc.gridy=1;
		JTextField to = new JTextField("");
		to.setPreferredSize(new Dimension(150,30));
		add(to,gbc);
		
		gbc.gridy=2;
		JTextField deposit2 = new JTextField("");
		deposit2.setPreferredSize(new Dimension(150,30));
		add(deposit2,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth=2;
		gbc.anchor = gbc.CENTER;
		gbc.insets = new Insets(10,10,10,10);
		JButton r = new JButton("Transfer"); 
		r.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				int giverAcc = -1;
				int recuAcc = -1;
				try
				{
					double deposit = Double.parseDouble(deposit2.getText());
					int recu = Integer.parseInt(to.getText());	
					int giver = Integer.parseInt(from.getText());	
					if(deposit >= 0 && giver >= 0 && recu >= 0)
					{
						for(int i = 0; i < b.size(); i++)
						{
							if(b.get(i).getAccountNumber() == giver)
							{
								giverAcc = i;
							}
							if(b.get(i).getAccountNumber() == recu)
							{
								recuAcc = i;
							}
						}
						b.get(giverAcc).withdraw(deposit);
						b.get(recuAcc).deposit(deposit);
						if(giverAcc == -1 || recuAcc == -1)
						{
							JOptionPane.showMessageDialog(null, "Matching Account Error");	
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Negative numbers are not applicable");	
					}
					}
				catch(Exception q)
				{
					JOptionPane.showMessageDialog(null, "Invalid Information");	
				}
			}});
		add(r,gbc);
		
	}
	
	

}
