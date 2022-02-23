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
		this.setVisible(false);
		this.setBounds(100, 100, 500, 250);
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		JLabel nameLabel = new JLabel("Name");
		this.add(nameLabel, gbc);

		gbc.gridy = 1;
		gbc.insets = new Insets(10, 10, 10, 10);
		JTextField name = new JTextField();
		name.setBounds(90, 100, 100, 30);
		name.setPreferredSize(new Dimension(120, 30));
		this.add(name, gbc);
		
		gbc.gridy = 2;
		JTextArea display = new JTextArea();
		display.setBounds(90, 100, 100, 30);
		display.setPreferredSize(new Dimension(720, 360));
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
				String theText = "";
				if(!name.getText().equals("")) {
					for(int i = 0; i < accs.size(); i++) {
						if(accs.get(i).getName().equals(name.getText())) {
							theText += accs.get(i).getAccountNumber() + "\t";
							if(accs.get(i) instanceof SavingsAccount)
								theText += "Savings Account\t";
							if(accs.get(i) instanceof CheckingAccount)
								theText += "Checking Account\t";
							theText += accs.get(i).getBalance() + "\n";
						}
					}
				}
			}
		});
	} 
}