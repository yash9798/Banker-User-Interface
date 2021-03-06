import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;

public class Close extends JPanel{
	
	public Close(ArrayList<BankAccount> b)
	{
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		this.setBackground(new Color(150,108,100));
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = gbc.WEST;
		gbc.insets = new Insets(10,10,10,10);
		JLabel a = new JLabel("Account Number: ");
		add(a,gbc);
		
		
		gbc.gridy = 1;
		JLabel n = new JLabel("Name: ");
		add(n,gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.anchor = gbc.EAST;
		gbc.insets = new Insets(0,0,0,0);
		JTextField ab = new JTextField("");
		ab.setPreferredSize(new Dimension(150,30));
		add(ab,gbc);
		
		gbc.gridy = 1;
		JTextField nb = new JTextField("");
		nb.setPreferredSize(new Dimension(150,30));
		add(nb,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 2;
		gbc.insets = new Insets(0,0,0,0);
		gbc.anchor = gbc.SOUTH;
		JButton create = new JButton("Close Account");
		create.setPreferredSize(new Dimension(300, 40));
		add(create, gbc);
		create.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				boolean ok = false;
				try
				{
					int inum = Integer.parseInt(ab.getText());
			if(!(ab.getText().isEmpty()) && !(nb.getText().isEmpty()))
			{
		
					for(int i = 0; i < b.size(); i++)
					{
						if(b.get(i).getAccountNumber() == inum && b.get(i).getName().equals(nb.getText()))
						{
					
							int result = JOptionPane.showConfirmDialog(null,"Are you sure you want to delete?", "Confirm",
						               JOptionPane.YES_NO_OPTION);
							  if(result == JOptionPane.YES_OPTION){
								  b.remove(i);
								  ok = true;
								  
						}
						
					}
					
		
				}
					if(!ok)
					{
						JOptionPane.showMessageDialog(null, "No registered account");
					}
			}			
			}
			catch(Exception a) {
					
				if(ab.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Not Enough Information");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Please Input an Actual Integer");
				}
					
				}
				
				ab.setText(null);
				nb.setText(null);
			}
			
		});
		}}
