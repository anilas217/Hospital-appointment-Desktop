import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTable;

public class docuserinterface {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 * @param doccl 
	 */
	public static void Docuiinter(final docclass doccl) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					docuserinterface window = new docuserinterface(doccl);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param doccl 
	 */
	public docuserinterface(docclass doccl) {
		initialize(doccl);
	}

	/**
	 * Initialize the contents of the frame.
	 * @param doccl 
	 */
	private void initialize(docclass doccl) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel doclabel = new JLabel("-");
		doclabel.setBounds(10, 11, 414, 43);
		frame.getContentPane().add(doclabel);
		String name=doccl.getNameandsurname();
		String alan=doccl.getAlan();
		doclabel.setText("Hoþgeldiniz "+name+" Alaný: "+alan+" Hastalarý burdan görebilirsiniz.");
		
		textField = new JTextField();
		textField.setBounds(10, 65, 424, 136);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		patientwriteappointment ptwa=new patientwriteappointment(null, null, null, null, null);       //keep data on write class
		try {
			String filename=("Appointment2.txt");
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String line;
		    String docname=doccl.getNameandsurname();    //doctor name
		    String email=doccl.getMail();                //doctor email
		    ptwa.setDocname(docname);
		    ptwa.setDocmail(email);
			String surname;
			while ((line = br.readLine()) != null) {
			String[] lines=line.split(" ");
			if(lines[0].contentEquals(docname) &&lines[1].contentEquals(email)) {
				ptwa.setPatientname(lines[2]);
				ptwa.setPatientTC(lines[3]);
				ptwa.setPatienthours(lines[4]);
			}
				
			}
		}catch(IOException Ex) {
			
		}
		try {
		ptwa.getPatientname();
		textField.setText("Hastanýzýn ismi: "+ptwa.getPatientname()+" Hastanýzýn Tc: "+ptwa.getPatientTC()+" Hastanýzýn geliceði saat: "+ptwa.getPatienthours());
		
		}
		catch(NullPointerException Ex) {
			
		}
	}
}
