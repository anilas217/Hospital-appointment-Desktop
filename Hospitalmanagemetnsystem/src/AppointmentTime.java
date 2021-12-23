import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Stack;
import java.util.stream.Stream;
import java.awt.event.ActionEvent;

public class AppointmentTime {
	JComboBox comboBox1 = new JComboBox();
	String DoctorName;
	String DoctorMail;
	private JFrame frame;

	/**
	 * Launch the application.
	 * @param ptcls 
	 */
	public void AppointmentT(final Docclsclass dcv, final Patientcls ptcls) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
			   
				comboBox1.setBounds(151, 72, 107, 30);
				frame.getContentPane().add(comboBox1);
				// DoctorName=name;
				// DoctorMail=mail;
				try {
					AppointmentTime window = new AppointmentTime(dcv,ptcls);
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
	public AppointmentTime(Docclsclass dcv, Patientcls ptcls) {
		initialize(dcv,ptcls);
		BufferedReader reader;
		
		try {
			reader = new BufferedReader(new FileReader(
					"Appointment.txt"));
			String line = reader.readLine();
			while (line != null) {
				String[] part=line.split(" ");                         //doktor ve mailini al
				
				String name=dcv.getName();
				String mail=dcv.getMail();
				if(part[0].contentEquals(name) && part[1].contentEquals(mail)) {          
					for(int i=1;i<part.length;i++) {
						String time=part[i];
						comboBox1.addItem(time+"\n");
					}    
					
					
				//	Appointmenttime(name,email,ptcls,comboBoxforfDoc);          //display appointment for user             
				}   
				
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException E) {                 //ýf not have a appointment txt file give error
			JOptionPane passwrong = new JOptionPane("Sistem belirtilen ''Appointment.txt'' dosyasýný bulamadý",JOptionPane.WARNING_MESSAGE);
			JDialog passdialog = passwrong.createDialog("Uyarý!");
			passdialog.setAlwaysOnTop(true); // to show top of all other application
			passdialog.setVisible(true); // to visible the dialog
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(final Docclsclass dcv,final Patientcls ptcls) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		final JComboBox comboBox1 = new JComboBox();
		comboBox1.setBounds(151, 72, 107, 30);
		frame.getContentPane().add(comboBox1);
		
		JLabel lblNewLabel = new JLabel("Randevu saatini se\u00E7in");
		lblNewLabel.setBounds(154, 47, 125, 14);
		frame.getContentPane().add(lblNewLabel);
		DoctorName=dcv.getName();
		DoctorMail=dcv.getMail();
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(
					"Appointment.txt"));
			String line = reader.readLine();
			while (line != null) {
				String[] part=line.split(" ");                         //doktor ve mailini al
				if(part[0].contentEquals(DoctorName) && part[1].contentEquals(DoctorMail)) {          
					for(int i=2;i<part.length;i++) {
						String time=part[i];
						comboBox1.addItem(time);
						
					}
					
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
		final Stack<String> stk=new Stack<String>();
		JButton TakeAp = new JButton("Randevuyu Al");
		TakeAp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=dcv.getName();
        		String email=dcv.getMail();
				
				BufferedReader reader;
				try {
					String timebet=comboBox1.getSelectedItem().toString();
					reader = new BufferedReader(new FileReader(
							"Appointment.txt"));
					String line = reader.readLine();
					while (line != null) {
						String[] calc=line.split(" ");
                        for(int i=0;i<calc.length;i++) {
                        	String times=calc[i];
                        	if(times.contentEquals(timebet)) {            //write on the appointment2 txt
                        		
                        		String tt=timebet;
                        		
                                String filename="Appointment2.txt";
                		        try(Stream<String> stream = Files.lines(Paths.get(filename))) {          //dosya var buraya yazdýrma 
                		       
                		        	FileWriter writer = new FileWriter(filename, true);
                		        	String ptnname=ptcls.getNameansur();
                		        	String tc=ptcls.getTc();
                		        	 
                		        	writer.write(name+" "+email+" "+ptnname+" "+tc+" "+tt);
                		        	writer.write("\n");
                		        	writer.close();
                		        	
                		      
                		           
                		        } catch(IOException ex) {                          //yeni dosya aç buraya yazdýr
                		           
                		           File file=new File("Appointment2.txt");
                		           FileWriter fw=new FileWriter(file);
                		           PrintWriter pw=new PrintWriter(fw);
                		           String patientname=ptcls.getNameansur();
                  		            String tcid=ptcls.getTc();
                		           pw.println(name+" "+email+" "+patientname+" "+tcid+" "+tt);
                		           pw.close();
                		          // docuserinterface.Docuiinter();
                		        }
                        	}
                        	else {
                        		if(i>=2) {
                        		stk.push(times);
                        	}
                        	}
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
				
				try {                             //write on the appointment for new time between
					String timebet=comboBox1.getSelectedItem().toString();
					
					File file=new File("Appointment.txt");    //creates a new file instance  
					FileReader fr=new FileReader(file);   //reads the file  
					BufferedReader br=new BufferedReader(fr);  //creates a buffering character input stream  
					StringBuffer sb=new StringBuffer();    //constructs a string buffer with no characters  
					String line;  
					
					while((line=br.readLine())!=null)  
					{  
				
				      String[] see=line.split(" ");
				      
				      if(see[0].contentEquals(name) && see[1].contentEquals(email)) {
				    	  File fls=new File("Appointment.txt");
       		            FileWriter fw=new FileWriter(file);
       		            PrintWriter pw=new PrintWriter(fw);
       		            pw.print(name+" "+email+" ");
       		       
       		         while(!(stk.isEmpty())) {
       		        	 
				    		  String stknn=(String) stk.peek();
				    		  
				    		  if(stknn.contentEquals((timebet))) {       //equality
				    			  stk.pop();
				    	  }
				    		  else {                    //not
				    			  pw.print(stknn+" ");
				    			  stk.pop();
					    		  
				    		  }
				    	  }
				    	  pw.println();
				    	  pw.close();
				    	 
				    	 
				       }
					}
					 
			    	   JOptionPane passwrong = new JOptionPane("Bu saatte "+timebet+" "+name+" Doktorundan randevu aldýnýz",JOptionPane.WARNING_MESSAGE);
						JDialog passdialog = passwrong.createDialog("Uyarý!");
						passdialog.setAlwaysOnTop(true); // to show top of all other application
						passdialog.setVisible(true); // to visible the dialog
						Selecttyperegister selectypeee=new Selecttyperegister();
					     selectypeee.main(null);
			}catch(IOException E) {
				JOptionPane passwrong = new JOptionPane("Sistem belirtilen 'Appointment.txt'' dosyasýný bulamadý",JOptionPane.WARNING_MESSAGE);
				JDialog passdialog = passwrong.createDialog("Uyarý!");
				passdialog.setAlwaysOnTop(true); // to show top of all other application
				passdialog.setVisible(true); // to visible the dialog
			}
			}
		});
		TakeAp.setBounds(141, 113, 138, 23);
		frame.getContentPane().add(TakeAp);
		
		JButton btnNewButton = new JButton("Geri");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				patientinterface ptn=new patientinterface(ptcls);
				ptn.Patientinterface(ptcls);
			}
		});
		btnNewButton.setBounds(10, 11, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
