import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class patientinterface {

	private JFrame frame;
	private JComboBox comboBox1;

	/**
	 * Launch the application.
	 */
	public void Patientinterface(final Patientcls ptcls) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					patientinterface window = new patientinterface(ptcls);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param ptcls 
	 */
	public patientinterface(Patientcls ptcls) {
		initialize(ptcls);
	}

	/**
	 * Initialize the contents of the frame.
	 * @param ptcls 
	 */
	private void initialize(final Patientcls ptcls) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("L\u00FCtfen randevu al\u0131ca\u011F\u0131n\u0131z b\u00F6l\u00FCm\u00FC se\u00E7in");
		lblNewLabel.setBounds(10, 11, 211, 20);
		frame.getContentPane().add(lblNewLabel);
		
		final JComboBox comboBox1;
		comboBox1 = new JComboBox();
		comboBox1.setBounds(20, 32, 160, 23);
		frame.getContentPane().add(comboBox1);
		
		final JComboBox<String> comboBoxforfDoc = new JComboBox();
		comboBoxforfDoc.setBounds(20, 118, 97, 38);
		frame.getContentPane().add(comboBoxforfDoc);
		
		
		comboBox1.addItem("Dahiliye");
		comboBox1.addItem("Ýçhastalýklar");
		comboBox1.addItem("Genelcerrahi");
		comboBox1.addItem("çocukhastalýklarý");
		comboBox1.addItem("Kulakburunboðaz");
		comboBox1.addItem("Göðüshastalýðý");
		comboBox1.setSelectedItem(null);
		
		JButton btnNewButton = new JButton("Ara");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String Boxgetfield=(String) comboBox1.getSelectedItem();
					Boxgetfield=Boxgetfield.replace(" ","");
					if(comboBox1.getSelectedItem().equals("")) {                //if combobox is empty
						JOptionPane passwrong = new JOptionPane("Lütfen alaný seçin",JOptionPane.WARNING_MESSAGE);
						JDialog passdialog = passwrong.createDialog("Uyarý!");
						passdialog.setAlwaysOnTop(true); // to show top of all other application
						passdialog.setVisible(true); // to visible the dialog
					}
					else {
						BufferedReader reader;
						try {
							reader = new BufferedReader(new FileReader(
									"Doctors.txt"));
							String line = reader.readLine();
							while (line != null) {
								String[] part=line.split(" ");
								if(part[3].contentEquals(Boxgetfield)) {          //aranýlan ile sonuç ayný ise
									String name =part[0];
									String email=part[1];
									
									comboBoxforfDoc.addItem(name+" "+email);
								//	Appointmenttime(name,email,ptcls,comboBoxforfDoc);          //display appointment for user             
								}
								
								line = reader.readLine();
							}
							reader.close();
						} catch (IOException E) {                 //ýf not have a doctors txt file give error
							JOptionPane passwrong = new JOptionPane("Sistem belirtilen ''Doctors.txt'' dosyasýný bulamadý",JOptionPane.WARNING_MESSAGE);
							JDialog passdialog = passwrong.createDialog("Uyarý!");
							passdialog.setAlwaysOnTop(true); // to show top of all other application
							passdialog.setVisible(true); // to visible the dialog
						}
					}
					
				}catch(NullPointerException E) {
					
				}
				
				
			}
		});
		btnNewButton.setBounds(18, 66, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("L\u00FCtfen doktoru se\u00E7in");
		lblNewLabel_1.setBounds(20, 96, 160, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton Appointment_Time = new JButton("Randevu saatini se\u00E7");              //appointment time
		Appointment_Time.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String docnameandmail=(String)comboBoxforfDoc.getSelectedItem();
				if(docnameandmail=="") {
					JOptionPane passwrong = new JOptionPane("Lütfen doktorunuzu seçin beni delirtmeyin",JOptionPane.WARNING_MESSAGE);
					JDialog passdialog = passwrong.createDialog("Uyarý!");
					passdialog.setAlwaysOnTop(true); // to show top of all other application
					passdialog.setVisible(true); // to visible the dialog
				}
				else {
					String[] nam_email=docnameandmail.split(" ");
					Docclsclass dc=new Docclsclass(null,null);
				//	System.out.println(nam_email[0]+" "+nam_email[1]);    Veri doðru yazýyor
					dc.setName(nam_email[0]);
					dc.setMail(nam_email[1]);
					
					AppointmentTime tkp=new AppointmentTime(dc,ptcls);
					tkp.AppointmentT(dc,ptcls);
					
				}
				
			}
		});
		Appointment_Time.setBounds(20, 171, 129, 20);
		frame.getContentPane().add(Appointment_Time);
		BufferedReader reader;
		try {                         //show active appointment
			reader = new BufferedReader(new FileReader(
					"Appointment.txt"));
			String line = reader.readLine();
			while (line != null) {
				
			
				line = reader.readLine();
			}
			reader.close();
		}catch(IOException E) {
			
		}
		
		
		
		
		
	}

	protected void Appointmenttime(String name, String email, Patientcls ptcls, JComboBox<String> comboBoxforfield) throws IOException {       //look appointment from doctor free time
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(
					"Appointment.txt"));
			String line = reader.readLine();
			while (line != null) {
				
			
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException E) {                 //if not have a appointment time 
			File file=new File("Appointment.txt");
	           FileWriter fw=new FileWriter(file);
	           PrintWriter pw=new PrintWriter(fw);
	           pw.println(name+" "+email+" ");
	           pw.close();
		}
		
		
		
		
	}
}
