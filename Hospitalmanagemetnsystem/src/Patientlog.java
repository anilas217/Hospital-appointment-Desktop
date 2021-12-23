import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Patientlog {

	private JFrame frame;
	private JTextField tctext;
	private JPasswordField passtext;
    
	/**
	 * Launch the application.
	 */
	public void Patientlgn() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Patientlog window = new Patientlog();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Patientlog() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Geri");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Selecttyperegister selectypeee=new Selecttyperegister();
			     selectypeee.main(null);
			}
		});
		btnNewButton.setBounds(10, 11, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("TC kimlik no");
		lblNewLabel.setBounds(10, 67, 64, 14);
		frame.getContentPane().add(lblNewLabel);
		
		tctext = new JTextField();
		tctext.setBounds(10, 80, 86, 20);
		frame.getContentPane().add(tctext);
		tctext.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u015Eifrenizi girin");
		lblNewLabel_1.setBounds(10, 111, 76, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("Giri\u015F");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				if(passtext.getPassword().equals("") || tctext.getText().equals("")) {
					JOptionPane passwrong = new JOptionPane("Lütfen boþluklarý doldurun",JOptionPane.WARNING_MESSAGE);
					JDialog passdialog = passwrong.createDialog("Warning!");
					passdialog.setAlwaysOnTop(true);
					passdialog.setVisible(true);
				}
				else {
					String tcxt=tctext.getText();
					char[] pstxt=passtext.getPassword();
					String filename=("Patients.txt");
					BufferedReader br = new BufferedReader(new FileReader(filename));
					String line;
					while ((line = br.readLine()) != null) {
						System.out.println(line);
					       String[] values=line.split(" ");
					       String tcinput=values[1];
					       String name=values[0];
					       char[] passwordinput=values[2].toCharArray();
					       if(tcxt.contentEquals(tcinput) || passwordinput==pstxt) {
					    	   Patientcls ptcs=new Patientcls(name,tcxt,passwordinput);
					    	   patientinterface ptinter=new patientinterface(ptcs);
					    	   ptinter.Patientinterface(ptcs);
					    	   
					       }
					    }
				}
			}catch(IOException E) {
				
			}
			}
		});
		btnNewButton_1.setBounds(10, 156, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Kay\u0131t");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				patientregister ptnreg=new patientregister();
				ptnreg.PTNREG();
			}
		});
		btnNewButton_2.setBounds(107, 156, 89, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		passtext = new JPasswordField();
		passtext.setBounds(10, 124, 79, 20);
		frame.getContentPane().add(passtext);
	}
}
