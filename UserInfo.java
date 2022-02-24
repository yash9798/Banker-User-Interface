import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;

public class UserInfo extends JPanel {
	private ArrayList<BankAccount> accs;
	public UserInfo(ArrayList<BankAccount> b) throws IOException {
		accs = b;
		this.setBounds(100, 100, 500, 250);
		this.setVisible(false);
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		this.setBackground(new Color(255,242,179));
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.anchor = gbc.WEST;
		gbc.insets = new Insets(10, 10, 10, 10);
		JLabel nameLabel = new JLabel("Name:");
		this.add(nameLabel, gbc);
		gbc.gridwidth = 2;
		gbc.gridx = 2;
		JTextField name = new JTextField();
		name.setBounds(90, 100, 100, 30);
		name.setPreferredSize(new Dimension(120, 30));
		this.add(name, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		JLabel addressLabel = new JLabel("Address:");
		this.add(addressLabel, gbc);
		
		gbc.gridx = 2;
		JTextField address = new JTextField();
		address.setBounds(90, 100, 100, 30);
		address.setPreferredSize(new Dimension(120, 30));
		this.add(address,gbc);
		address.setEnabled(false);

		gbc.gridx = 1;
		gbc.gridy = 2;
		JLabel cityLabel = new JLabel("City:");
		this.add(cityLabel, gbc);
		
		gbc.gridx = 2;
		JTextField city = new JTextField();
		city.setBounds(90, 100, 100, 30);
		city.setPreferredSize(new Dimension(120, 30));
		this.add(city, gbc);
		city.setEnabled(false);

		gbc.gridx = 1;
		gbc.gridy = 3;
		JLabel stateLabel = new JLabel("State:");
		this.add(stateLabel, gbc);
		
		gbc.gridx = 2;
		JTextField state = new JTextField();
		state.setBounds(90, 100, 100, 30);
		state.setPreferredSize(new Dimension(120, 30));
		this.add(state, gbc);
		state.setEnabled(false);

		gbc.gridx = 1;
		gbc.gridy = 4;
		JLabel zipLabel = new JLabel("Zipcode:");
		this.add(zipLabel, gbc);
		
		gbc.gridx = 2;
		JTextField zipcode = new JTextField();
		zipcode.setBounds(90,100,100,30);
		zipcode.setPreferredSize(new Dimension(120,30));
		this.add(zipcode,gbc);
		zipcode.setEnabled(false);

		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.gridwidth = 1;
		JButton find = new JButton("Find");
		find.setPreferredSize(new Dimension(100, 45));
		this.add(find, gbc);
		if(name.getText() != null) {
			find.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					for(int i = 0; i < accs.size(); i++) {
						if(accs.get(i).getName().equals(name.getText())) {
							address.setText(accs.get(i).getStreetAddress());
							city.setText(accs.get(i).getCity());
							state.setText(accs.get(i).getState());
							zipcode.setText(accs.get(i).getZipCode());
						}
					}
				}
			});
		}

		gbc.gridx = 2;
		gbc.gridy = 5;
		JButton update = new JButton("Update");
		update.setPreferredSize(new Dimension(100, 45));
		update.setEnabled(false);
		this.add(update,gbc);
		update.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<Integer> userArr = new ArrayList<Integer>();
				for(int i = 0; i < accs.size(); i++) {
					if(b.get(i).getName().equals(name.getText()))
						userArr.add(i);
				}
				for(int i = 0; i < userArr.size(); i++) {
					address.setText(address.getText());
					city.setText(city.getText());
					state.setText(state.getText());
					zipcode.setText(zipcode.getText());
				}
			}
		});
		
		gbc.gridx = 3;
		JButton cancel = new JButton("Cancel");
		cancel.setPreferredSize(new Dimension(100,45));
		cancel.setEnabled(false);
		this.add(cancel, gbc);
		cancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				address.setEnabled(false);
				address.setText("");
				city.setEnabled(false);
				city.setText("");
				state.setEnabled(false);
				state.setText("");
				zipcode.setEnabled(false);
				zipcode.setText("");
				name.setEnabled(true);
				update.setEnabled(false);
				cancel.setEnabled(false);
			}
		});

		gbc.gridx = 1;
		JButton edit = new JButton("Edit");
		edit.setPreferredSize(new Dimension(100,45));
		this.add(edit,gbc);
		edit.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) {
				address.setEnabled(true);
				city.setEnabled(true);
				state.setEnabled(true);
				zipcode.setEnabled(true);
				name.setEnabled(false);
				update.setEnabled(true);
				cancel.setEnabled(true);
			}
		});
	}
}
