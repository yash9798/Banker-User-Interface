import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;
import java.awt.Color;

public class AccountInfo extends JPanel {
	ArrayList<BankAccount> accs;
	public AccountInfo(ArrayList<BankAccount> b) {
		accs = b;
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		this.setBackground(new Color(170,153,255));
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		JLabel nameLabel = new JLabel("Name");
		this.add(nameLabel, gbc);

		gbc.gridy = 1;
		gbc.insets = new Insets(10, 10, 10, 10);
		JTextField name = new JTextField();
		
		name.setPreferredSize(new Dimension(150, 30));
		this.add(name, gbc);
		
		gbc.gridy = 2;
		JTextArea display = new JTextArea();
		display.setPreferredSize(new Dimension(500, 300));
	    display.setEditable(false); 
	    
	    JScrollPane scroll = new JScrollPane(display);
	    scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		this.add(display, gbc);
		
		gbc.gridy = 3;
		JButton search = new JButton("Search");
		this.add(search, gbc);
		search.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				display.setText("");
				if(!name.getText().equals("")) {
					for(int i = 0; i < accs.size(); i++) {
						if(accs.get(i).getName().equals(name.getText())) {
							display.append(accs.get(i).getAccountNumber() + "\t");
							if(accs.get(i) instanceof SavingsAccount)
								display.append("Savings Account\t");
							if(accs.get(i) instanceof CheckingAccount)
								display.append("Checking Account\t");
							display.append(accs.get(i).getBalance() + "\n");
						}
					}
				}
			}
		});
	} 
}
