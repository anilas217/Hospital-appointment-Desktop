import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;
import java.awt.event.ActionEvent;

public class DoctorRegister {
    
	private JFrame frame;
	private JTextField textFieldmail;
	private JPasswordField passwordFieldFirst;
	private JPasswordField passwordFieldSecond;
	private JLabel lblNewLabel_3;
	private JTextField textFieldNameandsurname;

	/**
	 * Launch the application.
	 */
	public void Doctorreg() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoctorRegister window = new DoctorRegister();
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
	public DoctorRegister() {
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
		
		textFieldmail = new JTextField();
		textFieldmail.setBounds(10, 66, 172, 24);
		frame.getContentPane().add(textFieldmail);
		textFieldmail.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Lütfen mailinizi yazin");
		lblNewLabel.setBounds(10, 45, 124, 25);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Sifrenizi yazin");
		lblNewLabel_1.setBounds(10, 92, 86, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Sifrenizi tekrar yazin");
		lblNewLabel_2.setBounds(10, 125, 97, 20);
		frame.getContentPane().add(lblNewLabel_2);
		
		passwordFieldFirst = new JPasswordField();
		passwordFieldFirst.setBounds(10, 105, 172, 20);
		frame.getContentPane().add(passwordFieldFirst);
		
		passwordFieldSecond = new JPasswordField();
		passwordFieldSecond.setBounds(10, 144, 172, 20);
		frame.getContentPane().add(passwordFieldSecond);
		
		lblNewLabel_3 = new JLabel("Alanýnýzý seçin");
		lblNewLabel_3.setBounds(10, 168, 72, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.addItem("Dahiliye");
		comboBox.addItem("Ýçhastalýklar");
		comboBox.addItem("Genelcerrahi");
		comboBox.addItem("çocukhastalýklarý");
		comboBox.addItem("Kulakburunboðaz");
		comboBox.addItem("Göðüshastalýðý");
		
		
		
		
		
		comboBox.setSelectedItem(null);
		comboBox.setBounds(10, 188, 87, 20);
		frame.getContentPane().add(comboBox);
		
		JButton btnNewButton = new JButton("Kaydol");    //kayýt buttonu
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String field;
				try {
					
				field=(String) comboBox.getSelectedItem();
				String nameandsurn=textFieldNameandsurname.getText();
				char[] pass1=passwordFieldFirst.getPassword();
				char[] pass2=passwordFieldSecond.getPassword();
				String maille=textFieldmail.getText();
				boolean contrl=true;
				for(int i=0;i<pass1.length;i++) {
					if(pass1.length!=pass2.length) {
						JOptionPane passwrong = new JOptionPane("Sifreler ayni degil",JOptionPane.WARNING_MESSAGE);
						JDialog passdialog = passwrong.createDialog("Warning!");
						passdialog.setAlwaysOnTop(true); // to show top of all other application
						passdialog.setVisible(true); // to visible the dialog
						contrl=false;
						break;
					}
					else {
						char rr=pass1[i];
						char rt=pass2[i];
						if(rr!=rt) {
							JOptionPane passwrong = new JOptionPane("Sifreler ayni degil",JOptionPane.WARNING_MESSAGE);
							JDialog passdialog = passwrong.createDialog("Warning!");
							passdialog.setAlwaysOnTop(true); // to show top of all other application
							passdialog.setVisible(true); // to visible the dialog
							contrl=false;
							break;
						}
					}
				}
			   
			    if(contrl==true) {
			       
			       
			    	try {
			    		if(comboBox.getSelectedItem().equals("") || textFieldNameandsurname.getText().equals("") || textFieldmail.getText().equals("")) {
			    			JOptionPane passwrong = new JOptionPane("Lütfen boþluklarý doldurun",JOptionPane.WARNING_MESSAGE);
							JDialog passdialog = passwrong.createDialog("Warning!");
							passdialog.setAlwaysOnTop(true); // to show top of all other application
							passdialog.setVisible(true); // to visible the dialog
			    		}
			    		else {
			    			docreg(nameandsurn,maille,pass1,field);         //hepsi doðru doctors txt dosyasý açýlýp yazdýrýlcak
			    		}
						
					} catch (IOException e1) {
					
						e1.printStackTrace();
					
			    }
			    }
			    
			    
			}catch(NullPointerException E) {
				JOptionPane optionPane = new JOptionPane("Lütfen boþluklarý doldurun",JOptionPane.WARNING_MESSAGE);
				JDialog dialog = optionPane.createDialog("Warning!");
				dialog.setAlwaysOnTop(true); // to show top of all other application
				dialog.setVisible(true); // to visible the dialog
			}
				}

			void docreg(String nameandsurn, String maille, char[] pass1, String field) throws IOException {
				String filename = "Doctors.txt";
                String filename2="Appointment.txt";
		        try(Stream<String> stream = Files.lines(Paths.get(filename))) {          //dosya var buraya yazdýrma 
		       
		        	FileWriter writer = new FileWriter(filename, true);
		        	field=field.replace(" ", "");
		        	writer.write(nameandsurn+" "+maille+" "+pass1+" "+field);
		        	writer.write("\n");
		        	writer.close();
		        	
		        //	docuserinterface.Docuiinter();
		           
		        } catch(IOException e) {                          //yeni dosya aç buraya yazdýr
		           
		           File file=new File("Doctors.txt");
		           FileWriter fw=new FileWriter(file);
		           PrintWriter pw=new PrintWriter(fw);
		          // docclass dcx=new docclass(nameandsurn,maille,pass1,field);
		           field=field.replace(" ", "");
		           pw.println(nameandsurn+" "+maille+" "+pass1+" "+field);
		           pw.close();
		          // docuserinterface.Docuiinter();
		        }
		        try(Stream<String> stream = Files.lines(Paths.get(filename2))){          //dosya yok aç Appointment.txt
		        	FileWriter writer = new FileWriter(filename2, true);
		        	field=field.replace(" ", "");
		        	writer.write(nameandsurn +" "+maille+" 8.00-9.00"+" "+"9.00-10.00"+" "+"10.00-11.00 11.00-12.00 13.00-14.00 14.00-15.00 15.00-16.00 16.00-17.00");
		        	writer.write("\n");
		        	writer.close();
		        	docclass doccl=new docclass(nameandsurn,maille,null,field);
		        	docuserinterface.Docuiinter(doccl);
		        	
		        }catch(IOException es) {                         //dosya var aç yazdýr
		        	 File file=new File("Appointment.txt");
			           FileWriter fw=new FileWriter(file);
			           PrintWriter pw=new PrintWriter(fw);
			           field=field.replace(" ", "");
			           pw.write(nameandsurn+" "+maille+" 8.00-9.00"+" "+"9.00-10.00"+" "+"10.00-11.00 11.00-12.00 13.00-14.00 14.00-15.00 15.00-16.00 16.00-17.00");
			           pw.write("\n");
			           pw.close();
			           docclass doccl=new docclass(nameandsurn,maille,null,field);
			           docuserinterface.Docuiinter(doccl);
		        }
				
			}
		});
		btnNewButton.setBounds(10, 219, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Geri");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManagementSel doctorlgn=new ManagementSel();
				doctorlgn.ManagementSel();
			}
		});
		btnNewButton_1.setBounds(205, 0, 60, 20);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_4 = new JLabel("\u0130sim ve soyisminizi yaz\u0131n");
		lblNewLabel_4.setBounds(10, 11, 136, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		textFieldNameandsurname = new JTextField();
		textFieldNameandsurname.setBounds(10, 25, 172, 20);
		frame.getContentPane().add(textFieldNameandsurname);
		textFieldNameandsurname.setColumns(10);
	}
}
