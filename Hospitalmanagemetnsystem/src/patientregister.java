import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;
import java.awt.event.ActionEvent;

public class patientregister {

	private JFrame frame;
	private JTextField TCtext;
	private JPasswordField password1;
	private JPasswordField password2;
	private JTextField Nameandsurname;

	/**
	 * Launch the application.
	 */
	public static void PTNREG() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					patientregister window = new patientregister();
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
	public patientregister() {
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
				Patientlog ptnlog=new Patientlog();
				ptnlog.Patientlgn();
			}
		});
		btnNewButton.setBounds(10, 11, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("TC kimlik");
		lblNewLabel.setBounds(10, 110, 73, 14);
		frame.getContentPane().add(lblNewLabel);
		
		TCtext = new JTextField();
		TCtext.setBounds(10, 124, 86, 20);
		frame.getContentPane().add(TCtext);
		TCtext.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Sifrenizi girin");
		lblNewLabel_1.setBounds(10, 145, 73, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		password1 = new JPasswordField();
		password1.setBounds(10, 162, 89, 20);
		frame.getContentPane().add(password1);
		
		JLabel lblNewLabel_2 = new JLabel("\u015Eifrenizi tekrar girin");
		lblNewLabel_2.setBounds(10, 177, 128, 23);
		frame.getContentPane().add(lblNewLabel_2);
		
		password2 = new JPasswordField();
		password2.setBounds(10, 196, 89, 20);
		frame.getContentPane().add(password2);
		
		JButton btnNewButton_1 = new JButton("Kay\u0131t");
		btnNewButton_1.addActionListener(new ActionListener() {     //kayýt butonu týklandý
			public void actionPerformed(ActionEvent e) {
				if(password1.getPassword().equals("") || password2.getPassword().equals("") || TCtext.getText().equals("") || Nameandsurname.getText().equals("")) { //control of null
					JOptionPane passwrong = new JOptionPane("Lütfen boþluklarý doldurun",JOptionPane.WARNING_MESSAGE);
					JDialog passdialog = passwrong.createDialog("Warning!");
					passdialog.setAlwaysOnTop(true);
					passdialog.setVisible(true);
				}
				else {
					boolean flg=true;
					char[] ps1=password1.getPassword();
					char[] ps2=password2.getPassword();
					String tctxt=TCtext.getText();
					String namesur=Nameandsurname.getText();
					if(ps1.length!=ps2.length) {
						JOptionPane passwrong = new JOptionPane("Sifreler ayni degil",JOptionPane.WARNING_MESSAGE);
						JDialog passdialog = passwrong.createDialog("Warning!");
						passdialog.setAlwaysOnTop(true);
						passdialog.setVisible(true);
						flg=false;
					}
					else {
						for(int mm=0;mm<ps1.length;mm++) {
							if(ps1[mm]!=ps2[mm]) {
								flg=false;
								JOptionPane passwrong = new JOptionPane("Sifreler ayni degil",JOptionPane.WARNING_MESSAGE);
								JDialog passdialog = passwrong.createDialog("Warning!");
								passdialog.setAlwaysOnTop(true);
								passdialog.setVisible(true);
								
								break;
							}
						}
					}
					if(flg==true)  {   //everything is true
						try {
							Patientcls ptcls=new Patientcls(namesur,tctxt,ps1);
							writeontxtfile(namesur,ps1,tctxt,ptcls);
						} catch (IOException e1) {
							
							e1.printStackTrace();
						}
					}
					
				}
				
			}

			private void writeontxtfile(String namesur,char[] ps1, String tctxt, Patientcls ptcls) throws IOException {                  //write to txt file
				String filename = "Patients.txt";
                 char[] jpss=ps1;
		        try(Stream<String> stream = Files.lines(Paths.get(filename))) {           //dosya var buraya yazdýrma 
		       
		        	FileWriter writer = new FileWriter(filename, true);
		        	writer.write(namesur+" "+tctxt+" "+ps1);
		        	writer.write("\n");
		        	writer.close();
		        	patientinterface ptniter=new patientinterface(ptcls);
		        	System.out.print(ptcls.getNameansur()+" "+ptcls.getPasswrd()+" ");
		        	ptniter.Patientinterface(ptcls);
		            
		        } catch(IOException e) {               //dosya yok yeni açma knk
		             
		           File file=new File("Patients.txt");
		           FileWriter fw=new FileWriter(file);
		           PrintWriter pw=new PrintWriter(fw); 
		           pw.println(namesur+" "+tctxt+" "+jpss);
		           pw.close();
		           patientinterface ptniter=new patientinterface(ptcls);
		           ptniter.Patientinterface(ptcls);
		           
		        }	
				
				
			}
		});
		btnNewButton_1.setBounds(10, 227, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("\u0130sim ve soyisim");
		lblNewLabel_3.setBounds(10, 66, 89, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		Nameandsurname = new JTextField();
		Nameandsurname.setBounds(10, 81, 86, 20);
		frame.getContentPane().add(Nameandsurname);
		Nameandsurname.setColumns(10);
	}

}
