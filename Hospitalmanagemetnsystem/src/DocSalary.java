import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;

public class DocSalary {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void Docsa() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DocSalary window = new DocSalary();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @return 
	 * @throws IOException 
	 */
	public DocSalary() throws IOException{
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
		
		JLabel lblNewLabel = new JLabel("Doctor Salary");
		lblNewLabel.setBounds(10, 11, 92, 25);
		frame.getContentPane().add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 47, 195, 25);
		frame.getContentPane().add(comboBox);
		
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(10, 135, 414, 25);
		frame.getContentPane().add(comboBox_1);
		
		try {
			String filename=("Docsalary.txt");
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String line;
			while ((line = br.readLine()) != null) {
				comboBox.addItem(line);
			}
			}catch(IOException E) {
				
				   File file=new File("Docsalary.txt");
		           FileWriter fw=new FileWriter(file);
		           PrintWriter pw=new PrintWriter(fw); 
		           pw.println("Dahiliye 9000");
		           pw.println("Ýçhastalýklar 8000");
		           pw.println("Genelcerrahi 11000");
		           pw.println("çocukhastalýklarý 5000");
		           pw.println("Kulakburunboðaz 3000");
		           pw.println("Göðüshastalýðý 7000");
		           pw.close();
			}
		
		try {
			String filename=("Doctors.txt");
			BufferedReader bn = new BufferedReader(new FileReader(filename));
			String line;
			
			while ((line = bn.readLine()) != null) {
								
				String[] doc=line.split(" ");
			
			String flnname=("Docsalary.txt");
			BufferedReader bc = new BufferedReader(new FileReader(flnname));
			String ln;
			while ((ln = bc.readLine()) != null) {
				
				String[] sp=ln.split(" ");
			if(sp[0].contentEquals(doc[3])) {
				String ll;
			//	ll="Aldýðý maaþ"+sp[1]+" name and surname"+ doc[0]+" Mail"+doc[1]+" Department"+doc[3];
				changesalary chslry=new changesalary(sp[1], doc[1], null, doc[3]);
				ll=chslry.chlsalary(sp[1], doc[0], doc[1], null, doc[3]);
				
				comboBox_1.addItem(ll);
				
				
			}
			
			}
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
		btnNewButton.setBounds(10, 171, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Total Doctors");
		lblNewLabel_1.setBounds(10, 83, 76, 30);
		frame.getContentPane().add(lblNewLabel_1);
		
		
	}
	
}
class changesalary extends docclass{
	String line;
    public changesalary(String nameandsurname, String mail, char[] sifre, String alan) {
		super(nameandsurname, mail, sifre, alan);
		line="bdfghjk";
		
				
	}
	String slry;
	public String chlsalary(String slry,String nameandsurname, String mail, char[] sifre, String alan) {
	     line="Aldýðý maaþ "+slry+" name and surname "+nameandsurname+" Mail "+mail+" Department "+alan;
	     return line;
	}
	
}
