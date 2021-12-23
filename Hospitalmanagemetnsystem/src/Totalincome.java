import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;

public class Totalincome {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void Totalin() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Totalincome window = new Totalincome();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws IOException 
	 */
	public Totalincome() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 33, 414, 38);
		frame.getContentPane().add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Income");
		lblNewLabel.setBounds(10, 11, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Salary");
		lblNewLabel_1.setBounds(10, 92, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(10, 121, 414, 38);
		frame.getContentPane().add(comboBox_1);
		
		try {
			String filename=("PriceList.txt");
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String line;
			while ((line = br.readLine()) != null) {
				
			}
			}catch(IOException E) {
				
				   File file=new File("PriceList.txt");
		           FileWriter fw=new FileWriter(file);
		           PrintWriter pw=new PrintWriter(fw); 
		           pw.println("Dahiliye 100");
		           pw.println("Ýçhastalýklar 200");
		           pw.println("Genelcerrahi 400");
		           pw.println("çocukhastalýklarý 150");
		           pw.println("Kulakburunboðaz 100");
		           pw.println("Göðüshastalýðý 200");
		           pw.close();
			}
		try {
			String filename=("Appointment2.txt");
			BufferedReader bn = new BufferedReader(new FileReader(filename));
			String line;
			
			while ((line = bn.readLine()) != null) {
				
				String[] spl=line.split(" ");
				String writeon,writedoc;
				patientdept ptndept=new patientdept(spl[2], spl[3], null);
				
				writeon=ptndept.own(spl[0], spl[1], spl[2], spl[3]);
				comboBox.addItem(writeon);            //patients write
				
				
			}
		}catch(IOException E) {
			
		}
		try {
			String filename=("Doctors.txt");
			BufferedReader bn = new BufferedReader(new FileReader(filename));
			String line;
			String writedoc=null;
			while ((line = bn.readLine()) != null) {
				String[] ss=line.split(" ");
				patientdept ptndept=new patientdept(ss[2], ss[3], null);
				writedoc=ptndept.writedoc(ss[0], ss[1]);
				comboBox_1.addItem(writedoc);             //doctors write
			}
			
			
		}catch(IOException E) {
			
		}
		
		JButton btnNewButton = new JButton("Geri");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManagementSel mngsel=new ManagementSel();
				mngsel.ManagementSel();
			}
		});
		btnNewButton.setBounds(10, 186, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}

}
class patientdept extends Patientcls{
    String dept;
	public patientdept(String nameansur, String tc, char[] passwrd) {
		super(nameansur, tc, passwrd);
		
	}
	public String own(String docname,String docmail,String namesur,String tc) throws IOException {    //write on patients
		String line = null;
		String department = null;
		
		try {
			String filename=("Doctors.txt");
			BufferedReader bn = new BufferedReader(new FileReader(filename));
			String ss;
			
			while ((ss = bn.readLine()) != null) {
		     String[] tt=ss.split(" ");
		     if(tt[0].contentEquals(docname) && tt[1].contentEquals(docmail)) {
		    	 
		    	 department=tt[3];
		    	 
		    	 break;
		     }
			}
		
		}catch(IOException E) {
			
		}
		String flname=("PriceList.txt");
		BufferedReader bb = new BufferedReader(new FileReader(flname));
		String ll;
		
		while ((ll = bb.readLine()) != null) {
		String[] sl=ll.split(" ");
		
		if(sl[0].contentEquals(department)) {
			
			line="Patient namesurname "+namesur+" PatientId "+tc+" Own is "+sl[1];
			
			break;
		}
		
		}
		return line;
		
	}
	public String writedoc(String docname,String docmail) throws IOException {            //writeon doctor
		;
		String ll=null;
	String filename=("Doctors.txt");
	BufferedReader bb = new BufferedReader(new FileReader(filename));
	String line;
	
	while ((line = bb.readLine()) != null) {
	String[] gg=line.split(" ");
	if(gg[0].contentEquals(docname) &&gg[1].contentEquals(docmail)) {
		
		String department=gg[3];
		String fln=("Docsalary.txt");
		BufferedReader bc = new BufferedReader(new FileReader(fln));
		String llm;
		
		while ((llm = bc.readLine()) != null) {
			String[] jj=llm.split(" ");
			
			if(jj[0].contentEquals(department)) {
		
				ll="Doctor name is "+docname+" Doctor mail is "+docmail+" Doctor salary is "+jj[1];
				
				
			}
		}
		
	}
	}
	return ll;
	}
	
	}
	

 