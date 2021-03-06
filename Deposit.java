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
import java.awt.Color;
import java.awt.Dimension;


public class Deposit extends JPanel {
	public Deposit (ArrayList<BankAccount> b) {
		this.setBounds(100, 100, 500, 250);
		this.setVisible(false);
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		this.setBackground(new Color(255,102,255));
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = gbc.WEST;
		gbc.insets = new Insets(10,10,10,10);
		JLabel num = new JLabel("Account Number: ");
		add(num,gbc);
		
		gbc.gridy = 1;
		JLabel amt = new JLabel("Deposit Amount: ");
		add(amt,gbc);
		
		gbc.gridy = 0;
		gbc.gridx = 1;
		JTextField tnum = new JTextField();
		tnum.setBounds(90, 100, 100, 30);
		tnum.setPreferredSize(new Dimension(120, 30));
		this.add(tnum, gbc);
		
		gbc.gridy = 1;
		gbc.gridx = 1;
		JTextField tamt = new JTextField();
		tamt.setBounds(90, 100, 100, 30);
		tamt.setPreferredSize(new Dimension(120, 30));
		this.add(tamt, gbc);
		
		gbc.gridy = 2;
		gbc.gridx = 0;
		gbc.gridwidth = 2;
		JButton deposit = new JButton("Deposit");
		deposit.setPreferredSize(new Dimension(300, 40));
		this.add(deposit,gbc);
		
		
		deposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int unum = Integer.parseInt(tnum.getText());
					double dAmt = Double.parseDouble(tamt.getText());
					BankAccount ba = null;
					for (int i = 0; i < b.size(); i++) {
						if (b.get(i).getAccountNumber() == unum && dAmt > 0) {
							System.out.println(b.get(i).getBalance());
							b.get(i).deposit(dAmt);
							System.out.println(b.get(i).getBalance());
							ba = b.get(i);
						}
					}
					JOptionPane.showMessageDialog(null, "New Balance: $" + ((int)(100*ba.getBalance()))/100.0, "$" + dAmt + " Deposit Successful", JOptionPane.INFORMATION_MESSAGE);
					tnum.setText(null);
					tamt.setText(null);
				} catch (Exception e1) {}
				tnum.setText(null);
				tamt.setText(null);
			}});
	}
}
