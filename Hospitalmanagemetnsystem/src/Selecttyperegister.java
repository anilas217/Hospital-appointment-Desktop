import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.SpringLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Selecttyperegister {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Selecttyperegister window = new Selecttyperegister();
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
	public Selecttyperegister() {
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
		
		JButton doctor = new JButton("Doktor Giriþi");
		doctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {     //Goes to doctorlog
				Doctorlog dcl=new Doctorlog();
				dcl.Doctorlgn();
			}
		});
		doctor.setBounds(130, 90, 89, 23);
		frame.getContentPane().add(doctor);
		
		JButton hastagiris = new JButton("Hasta Giriþi");
		hastagiris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {          //Goes to patientlog
				Patientlog ptnlgn=new Patientlog();
				ptnlgn.Patientlgn();
			}
		});
		hastagiris.setBounds(247, 90, 89, 23);
		frame.getContentPane().add(hastagiris);
		
		JButton ManagementAccess = new JButton("Y\u00F6netim Giri\u015Fi");
		ManagementAccess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Management mng=new Management();
				mng.Management();
				
				
			}
		});
		ManagementAccess.setBounds(183, 124, 115, 23);
		frame.getContentPane().add(ManagementAccess);
	}
}
