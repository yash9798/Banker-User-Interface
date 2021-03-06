import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import java.awt.Color;

public class add1 extends JPanel{
	ArrayList<BankAccount> accs;
	public add1(ArrayList<BankAccount> b)
	{
		accs=b;
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		this.setBackground(new Color(204,255,255));
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = gbc.WEST;
		gbc.insets = new Insets(10,10,10,10);
		JLabel name = new JLabel("Name ");
		add(name,gbc);
		
	
		gbc.gridx = 1;
		gbc.anchor = gbc.EAST;
		gbc.insets = new Insets(0,0,0,0);
		JTextField namebox = new JTextField("");
		namebox.setPreferredSize(new Dimension(150,30));
		add(namebox,gbc);
	
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.anchor = gbc.WEST;
		gbc.insets = new Insets(10,10,10,10);
		JLabel sa = new JLabel("Street Address: ");
		add(sa,gbc);
		
		gbc.gridx = 1;
		gbc.anchor = gbc.EAST;
		gbc.insets = new Insets(0,0,0,0);
		JTextField sa2 = new JTextField("");
		sa2.setPreferredSize(new Dimension(150,30));
		add(sa2,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.anchor = gbc.WEST;
		gbc.insets = new Insets(10,10,10,10);
		JLabel city = new JLabel("City: ");
		add(city,gbc);
		
		gbc.gridx = 1;
		gbc.anchor = gbc.EAST;
		gbc.insets = new Insets(0,0,0,0);
		JTextField city2 = new JTextField("");
		city2.setPreferredSize(new Dimension(150,30));
		add(city2,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.anchor = gbc.WEST;
		gbc.insets = new Insets(10,10,10,10);
		JLabel state = new JLabel("State: ");
		add(state,gbc);
		
		gbc.gridx = 1;
		gbc.anchor = gbc.EAST;
		gbc.insets = new Insets(0,0,0,0);
		JTextField state2 = new JTextField("");
		state2.setPreferredSize(new Dimension(150,30));
		add(state2,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.anchor = gbc.WEST;
		gbc.insets = new Insets(10,10,10,10);
		JLabel zip = new JLabel("Zip: ");
		add(zip,gbc);
		
		gbc.gridx = 1;
		gbc.anchor = gbc.EAST;
		gbc.insets = new Insets(0,0,0,0);
		JTextField zip2 = new JTextField("");
		zip2.setPreferredSize(new Dimension(150,30));
		add(zip2,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.anchor = gbc.WEST;
		gbc.insets = new Insets(10,10,10,10);
		JLabel bal = new JLabel("Balance: ");
		add(bal,gbc);
		
		gbc.gridx = 1;
		gbc.anchor = gbc.EAST;
		gbc.insets = new Insets(0,0,0,0);
		JTextField bal2 = new JTextField("");
		bal2.setPreferredSize(new Dimension(150,30));
		add(bal2,gbc);
		
		gbc.gridx = 1;
		gbc.gridy = -1;
		 String[] optionsToChoose = {"--Account Type--", "Checking", "Savings"};
		 JComboBox<String> jComboBox = new JComboBox<>(optionsToChoose);
		gbc.anchor = gbc.CENTER;
		add(jComboBox,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 7;
		gbc.gridwidth = 2;
		gbc.insets = new Insets(0,0,0,0);
		gbc.anchor = gbc.SOUTH;
		JButton create = new JButton("Create Account");
		create.setPreferredSize(new Dimension(300, 40));
		add(create, gbc);
		create.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int saved = -1;
				 
				try
				{
					double inum = Double.parseDouble(bal2.getText());
					inum = ((int)(100*inum))/100.0;
					if(!(namebox.getText().isEmpty()) && !(sa2.getText().isEmpty()) && !(city2.getText().isEmpty()) && !(state2.getText().isEmpty()) && !(zip2.getText().isEmpty()) && inum >=0 && jComboBox.getSelectedIndex() >= 1)
					{
					
						for(int i = 0; i < accs.size(); i++)
						{
							if(accs.get(i).getName().equals(namebox.getText()))
							{
								saved = i;
							}
						}
						
						if(saved > -1)
						{
							if(accs.get(saved).getStreetAddress().equals(sa2.getText()) && accs.get(saved).getCity().equals(city2.getText()) && accs.get(saved).getState().equals(state2.getText()) && accs.get(saved).getZipCode().equals(zip2.getText()))
							{
								if(jComboBox.getSelectedIndex() == 1)
								{
									b.add(new CheckingAccount(namebox.getText(), sa2.getText(), city2.getText(), state2.getText(), inum, zip2.getText()));
								}
								if(jComboBox.getSelectedIndex() == 2)
								{
									b.add(new SavingsAccount(namebox.getText(), sa2.getText(), city2.getText(), state2.getText(), inum, zip2.getText()));
								}
							}
							else
							{
								JOptionPane.showMessageDialog(null, "It doesnt match. You might need to update info: ");
							}
						}
						else
						{
							if(jComboBox.getSelectedIndex() == 1)
							{
								b.add(new CheckingAccount(namebox.getText(), sa2.getText(), city2.getText(), state2.getText(), inum, zip2.getText()));
							}
							if(jComboBox.getSelectedIndex() == 2)
							{
								b.add(new SavingsAccount(namebox.getText(), sa2.getText(), city2.getText(), state2.getText(), inum, zip2.getText()));
							}
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Invalid Information");
					}
					
					
					namebox.setText(null);
					sa2.setText(null);
					city2.setText(null);
					state2.setText(null);
					zip2.setText(null);
					bal2.setText(null);
					jComboBox.setSelectedIndex(0);
					
			
				
				}
				
				catch(Exception a) {
					
					if(bal2.getText().isEmpty())
					{
					
						JOptionPane.showMessageDialog(null, "Invalid deposit value.");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Invalid Information");
					}
					
					namebox.setText(null);
					sa2.setText(null);
					city2.setText(null);
					state2.setText(null);
					zip2.setText(null);
					bal2.setText(null);
					jComboBox.setSelectedIndex(0);
				}
				
		}
		
	});
}}
