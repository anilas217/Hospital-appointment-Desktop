import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Doctorlog {

	private JFrame frame;
	private JTextField mailtext;
	private JPasswordField passtext;
	private JTable table;
	private JButton btnNewButton;
	private JButton btnNewButton_2;

	/**
	 * Launch the application.
	 */
	public void Doctorlgn() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Doctorlog window = new Doctorlog();
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
	public Doctorlog() {
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
		
		JLabel lblNewLabel = new JLabel("Doktor Girisi");
		lblNewLabel.setBounds(160, 28, 86, 23);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("lütfen mailinizi yazin");
		lblNewLabel_1.setBounds(103, 62, 96, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		mailtext = new JTextField();
		mailtext.setBounds(103, 87, 177, 23);
		frame.getContentPane().add(mailtext);
		mailtext.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Sifrenizi girin");
		lblNewLabel_2.setBounds(103, 116, 96, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		passtext = new JPasswordField();
		passtext.setBounds(103, 148, 191, 23);
		frame.getContentPane().add(passtext);
		
		table = new JTable();
		table.setBounds(40, 171, 40, 0);
		frame.getContentPane().add(table);
		
		btnNewButton = new JButton("Giris");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				
				if(passtext.getPassword().equals("") || mailtext.getText().equals("") ) {
					JOptionPane passwrong = new JOptionPane("Lütfen boþluklarý doldurun",JOptionPane.WARNING_MESSAGE);
					JDialog passdialog = passwrong.createDialog("Warning!");
					passdialog.setAlwaysOnTop(true); // to show top of all other application
					passdialog.setVisible(true); // to visible the dialog
				}
				
				else 
				{
					try {
						 boolean flag=false;
					char[] passwrd=passtext.getPassword();
					String maille=mailtext.getText();
					String filename=("Doctors.txt");
					BufferedReader br = new BufferedReader(new FileReader(filename));
					String line;
					while ((line = br.readLine()) != null) {
					       String[] values=line.split(" ");
					       String name=values[0];
					       String mails=values[1];
					       String department=values[3];
					      
					       String s=String.valueOf(passwrd).toString();
					      String k=values[2].toString();
					     
					       if(maille.contentEquals(mails) || s.contentEquals(k)) {
					    	   
					    	   docclass dcsl=new docclass(name,mails,null,department);
					    	   flag=true;
					        docuserinterface dcui=new docuserinterface(dcsl);
					        dcui.Docuiinter(dcsl);
					       }
					    }
					if(flag==false) {
						JOptionPane passwrong = new JOptionPane("Kullanýcý bulunamadý",JOptionPane.WARNING_MESSAGE);
						JDialog passdialog = passwrong.createDialog("Warning!");
						passdialog.setAlwaysOnTop(true); // to show top of all other application
						passdialog.setVisible(true); // to visible the dialog
					}
					
				}catch(IOException E) {
					System.out.print("Doktor dosyasý yok kayýt lazým önce");
				}
				}
				
				
				}catch(NullPointerException E) {
					JOptionPane passwrong = new JOptionPane("Lütfen boþluklarý doldurun",JOptionPane.WARNING_MESSAGE);
					JDialog passdialog = passwrong.createDialog("Warning!");
					passdialog.setAlwaysOnTop(true); // to show top of all other application
					passdialog.setVisible(true); // to visible the dialog
				}
				
			}
		});
		btnNewButton.setBounds(103, 203, 106, 23);
		frame.getContentPane().add(btnNewButton);
		
		btnNewButton_2 = new JButton("Geri");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			     Selecttyperegister selectypeee=new Selecttyperegister();
			     selectypeee.main(null);
			}
		});
		btnNewButton_2.setBounds(10, 11, 89, 23);
		frame.getContentPane().add(btnNewButton_2);
	}
}
