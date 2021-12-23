import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Management {

	private JFrame frame;
	private JTextField Id;
	private JPasswordField Password;

	/**
	 * Launch the application.
	 */
	public static void Management() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Management window = new Management();
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
	public Management() {
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
		
		JLabel lblNewLabel = new JLabel("Write MasterId");
		lblNewLabel.setBounds(47, 66, 72, 22);
		frame.getContentPane().add(lblNewLabel);
		
		Id = new JTextField();
		Id.setBounds(140, 68, 135, 20);
		frame.getContentPane().add(Id);
		Id.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Write Master Password");
		lblNewLabel_1.setBounds(10, 93, 135, 25);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Entry");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String passwrd=Password.getText().toString();
				String ide=Id.getText().toString();
				String filename=("Management.txt");
				try {
					BufferedReader br = new BufferedReader(new FileReader(filename));
					String line;
					
					while ((line = br.readLine()) != null) {
			                 String[] spl=line.split(" ");
			                 if(ide.contentEquals(spl[0])&& passwrd.contentEquals(spl[1])) {
			                	 ManagementSel mngsll=new ManagementSel();
			                	 mngsll.ManagementSel();
			                 }
		                       }
				} catch (IOException e1) {
					JOptionPane passwrong = new JOptionPane("You have to create management.txt file which in inside key,password",JOptionPane.WARNING_MESSAGE);
					JDialog passdialog = passwrong.createDialog("Warning!");
					passdialog.setAlwaysOnTop(true); // to show top of all other application
					passdialog.setVisible(true); // to visible the dialog
				}
				
			}
		});
		btnNewButton.setBounds(160, 141, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		Password = new JPasswordField();
		Password.setBounds(140, 99, 135, 19);
		frame.getContentPane().add(Password);
	}
}
