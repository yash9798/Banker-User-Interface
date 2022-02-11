import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Dashboard extends JPanel {
	
	public Dashboard()
	{
		this.setBounds(100, 100, 500, 250);
		this.setVisible(false);
		JLabel poo = new JLabel("yas");
		poo.setBounds(200,200,100,200);
		this.add(poo);
	}
	
	public void setVisDash()
	{
		this.setVisible(true);
	}
}
