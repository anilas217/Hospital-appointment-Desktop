import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JComboBox;

public class ShowPatient {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void Patients() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowPatient window = new ShowPatient();
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
	public ShowPatient() {
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
	
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 87, 414, 34);
		frame.getContentPane().add(comboBox);
		
		String filename=("Patients.txt");
		Patientcls ptcls=new Patientcls(filename, filename, null);
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String line;
			while ((line = br.readLine()) != null) {
			String[] spl=line.split(" ");
			ptcls.setNameansur(spl[0]);
			ptcls.setTc(spl[1]);
			comboBox.addItem("Patient name is "+spl[0]+" PatientId number is "+spl[1]);
			}
			
	
		}catch(IOException Ex) {
			
		}
		
		JButton btnNewButton = new JButton("Geri");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManagementSel mngsel=new ManagementSel();
				mngsel.ManagementSel();
			}
		});
		btnNewButton.setBounds(10, 27, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Gelen hastalar");
		lblNewLabel.setBounds(20, 62, 89, 14);
		frame.getContentPane().add(lblNewLabel);
		
		
	}
	
}
