import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class ManagementSel {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void ManagementSel() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagementSel window = new ManagementSel();
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
	public ManagementSel() {
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
		
		JButton btnNewButton = new JButton("Delete Doctor");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Docdelete doc=new Docdelete();
				doc.Docdel();
			}
		});
		btnNewButton.setBounds(65, 51, 101, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Total Income");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Totalincome ttlin;
				try {
					ttlin = new Totalincome();
					ttlin.Totalin();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_1.setBounds(185, 52, 101, 20);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("Patients");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowPatient ptcsl=new ShowPatient();
				ptcsl.Patients();
			}
		});
		btnNewButton_3.setBounds(185, 83, 89, 23);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Doctors Salary");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DocSalary dcsl;
				try {
					dcsl = new DocSalary();
					dcsl.Docsa();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_4.setBounds(65, 85, 103, 23);
		frame.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_2 = new JButton("Doctor Register");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DoctorRegister dcrt=new DoctorRegister();
				dcrt.Doctorreg();
			}
		});
		btnNewButton_2.setBounds(121, 117, 121, 23);
		frame.getContentPane().add(btnNewButton_2);
	}
}
