package tuntikoodeja;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Lomake extends JFrame implements ActionListener{

	private JTextField nimiTXT = new JTextField();
	private JTextField kohdeTXT = new JTextField();
	private JButton nappi = new JButton("Kopioi");
	public Lomake(){
		this.setSize(400, 100);
		this.setLocation(600, 300);
		this.setLayout(null);
		nimiTXT.setBounds(20, 20, 100, 20);
		nappi.setBounds(140, 20, 100, 20);
		kohdeTXT.setBounds(260, 20, 100, 20);
		this.getContentPane().add(nimiTXT);
		this.getContentPane().add(nappi);
		this.getContentPane().add(kohdeTXT);
		nappi.addActionListener(this);
		this.setVisible(true);		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==nappi){
			kohdeTXT.setText(nimiTXT.getText());
		}
		
	}
	
	public static void main(String[] args) {
		new Lomake();
	}
}
