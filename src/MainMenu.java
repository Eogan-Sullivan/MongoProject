import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Panel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Checkbox;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainMenu {

	private JFrame frmEganSullivanT;
	private JTextField txtName;
	private JTextField txtEmail;
	private JTextField txtSearch;
	private mongoOperation mongoConnect;
	private JTextPane txtSummary;
	private Checkbox chkResolved;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu window = new MainMenu();
					window.frmEganSullivanT.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainMenu() {
		initialize();
		mongoConnect = new mongoOperation("NoticeBoard","Notices");
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEganSullivanT = new JFrame();
		frmEganSullivanT.setFont(new Font("Arial Black", Font.PLAIN, 12));
		frmEganSullivanT.setTitle("E\u00F3gan Sullivan T00166087");
		frmEganSullivanT.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Eogan Sullivan\\Pictures\\mongodb1.png"));
		frmEganSullivanT.setBounds(100, 100, 450, 300);
		frmEganSullivanT.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEganSullivanT.getContentPane().setLayout(null);
		ImageIcon mongoIcon = new ImageIcon(new ImageIcon("C:\\Users\\Eogan Sullivan\\Pictures\\mongodb1.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
		
		JButton btnPostANotice = new JButton("Post ");
		btnPostANotice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		
			mongoConnect.Create(txtName.getText(), getSummary(), txtEmail.getText(),getResolved());	
			JOptionPane.showMessageDialog(null, "Post Success");
			txtName.setText("");
			txtEmail.setText("");
			
			}
		});
		
		btnPostANotice.setBounds(8, 38, 95, 23);
		frmEganSullivanT.getContentPane().add(btnPostANotice);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Search Summary For input in search Field
				
			}
		});
		btnSearch.setBounds(8, 72, 95, 23);
		frmEganSullivanT.getContentPane().add(btnSearch);
		
		JButton btnRemoveNotice = new JButton("Remove");
		btnRemoveNotice.setBounds(8, 106, 95, 23);
		frmEganSullivanT.getContentPane().add(btnRemoveNotice);
		
		JButton btnAppendNotice = new JButton("Append");
		btnAppendNotice.setBounds(8, 140, 95, 23);
		frmEganSullivanT.getContentPane().add(btnAppendNotice);
		
		JLabel lblName = new JLabel(" Name:");
		lblName.setBounds(109, 45, 52, 14);
		frmEganSullivanT.getContentPane().add(lblName);
		
		JLabel lblSummary = new JLabel("Summary:");
		lblSummary.setBounds(113, 79, 59, 14);
		frmEganSullivanT.getContentPane().add(lblSummary);
		
		chkResolved = new Checkbox("Resolved");
		chkResolved.setBounds(183, 203, 95, 22);
		frmEganSullivanT.getContentPane().add(chkResolved);
		
		txtName = new JTextField();
		txtName.setBounds(171, 42, 182, 20);
		frmEganSullivanT.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		JButton btnOk = new JButton("Ok");
		btnOk.setBounds(8, 174, 95, 23);
		frmEganSullivanT.getContentPane().add(btnOk);
		
		txtSummary = new JTextPane();
		txtSummary.setBounds(171, 75, 182, 91);
		frmEganSullivanT.getContentPane().add(txtSummary);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(173, 177, 180, 20);
		frmEganSullivanT.getContentPane().add(txtEmail);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(114, 181, 59, 14);
		frmEganSullivanT.getContentPane().add(lblEmail);
		
		txtSearch = new JTextField();
		txtSearch.setColumns(10);
		txtSearch.setBounds(171, 14, 182, 20);
		frmEganSullivanT.getContentPane().add(txtSearch);
		
		JLabel lblSearch = new JLabel("Search");
		lblSearch.setBounds(113, 17, 52, 14);
		frmEganSullivanT.getContentPane().add(lblSearch);
	}
	
	private String getSummary() {
		String txt = txtSummary.getText();
		txtSummary.setText("");
		return txt;
		
	}
	
	private Boolean getResolved() {
		Boolean state = chkResolved.getState();
		return state;
	}
}
