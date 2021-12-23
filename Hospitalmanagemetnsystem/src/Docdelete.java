import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JDialog;

public class Docdelete {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void Docdel() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Docdelete window = new Docdelete();
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
	public Docdelete() {
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
		
		JButton Back = new JButton("Geri");
		Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManagementSel mngsel=new ManagementSel();
				mngsel.ManagementSel();
			}
		});
		Back.setBounds(10, 11, 89, 23);
		frame.getContentPane().add(Back);
		
		JLabel lblNewLabel = new JLabel("Select Doctor");
		lblNewLabel.setBounds(10, 45, 100, 25);
		frame.getContentPane().add(lblNewLabel);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 81, 414, 25);
		frame.getContentPane().add(comboBox);
		
		String filename=("Doctors.txt");
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String line;
			while ((line = br.readLine()) != null) {
				String aa=line;
				String[] spl=line.split(" ");
				dcdel dc=new dcdel(spl[0], spl[1],null, spl[3]);
				//aa=dc.delete(spl[0], spl[1], spl[3]);
				comboBox.addItem(aa);
			}
		}catch(IOException Ex) {
			
		}
		JButton Delete = new JButton("Delete");
		Delete.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String[] array=new String[1000];
				String need=comboBox.getSelectedItem().toString();
				String filename=("Doctors.txt");
				
				try {
					BufferedReader br = new BufferedReader(new FileReader(filename));
					String line;
					int counter=0;
					while ((line = br.readLine()) != null) {
						if(need.contentEquals(line)) {
							
						}
						else {
							array[counter]=line;
							counter++;
						}
					}
					File file=new File("Doctors.txt");
			           FileWriter fw=new FileWriter(file);
			           PrintWriter pw=new PrintWriter(fw);
					for(int i=0;i<counter;i++) {
						String lm=array[i];
						System.out.println(lm);
			           pw.write(lm);
					}
					pw.close();
					String[] ss=need.split(" ");
					JOptionPane optionPane = new JOptionPane("Sildiðiniz doktor isim "+ss[0]+" Mail "+ss[1]+" Department "+ss[3],JOptionPane.WARNING_MESSAGE);
					JDialog dialog = optionPane.createDialog("Warning!");
					dialog.setAlwaysOnTop(true); // to show top of all other application
					dialog.setVisible(true); // to visible the dialog
				}catch(IOException Ex){
					
				}
			}
		});
		Delete.setBounds(10, 117, 89, 23);
		frame.getContentPane().add(Delete);
	}
}
class dcdel extends docclass{

	public dcdel(String nameandsurname, String mail, char[] sifre, String alan) {
		super(nameandsurname, mail, sifre, alan);
		// TODO Auto-generated constructor stub
	}
	public String delete(String namesur,String mail,String department) {
		String line=namesur+" "+mail+" "+department;
		return line;
	}
	public String readFile(String name,String mail,String depp) {
		String ll=null;
		return ll;
	}
	
}
