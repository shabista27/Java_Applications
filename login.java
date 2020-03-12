

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField Username;
	private JPasswordField Password;

	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 200, 800, 500);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.desktop);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Username = new JTextField();
		Username.setBounds(281, 141, 260, 35);
		contentPane.add(Username);
		Username.setColumns(10);
		
		JButton btnLogin = new JButton("login");
		btnLogin.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) 
			{
				if(Username.getText().isEmpty() || Password.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null," EMPTY.."+"!");
				}
				
				else if(Username.getText().equals("admin") || Password.getText().equals("12345"))
				{
					JOptionPane.showMessageDialog(null,"Success"+"!");
					
				}
				
				else
				{
					JOptionPane.showMessageDialog(null,"Invalid"+"!");
				}
			}
		});
		btnLogin.setBounds(214, 300, 114, 25);
		contentPane.add(btnLogin);
		
		JButton btnCancel = new JButton("cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				dispose();
			}
		});
		btnCancel.setBounds(387, 300, 114, 25);
		contentPane.add(btnCancel);
		
		Password = new JPasswordField();
		Password.setBounds(281, 188, 260, 35);
		contentPane.add(Password);
		
		JLabel user = new JLabel("Username: ");
		user.setFont(new Font("DialogInput", Font.BOLD, 25));
		user.setVerticalAlignment(SwingConstants.BOTTOM);
		user.setForeground(Color.YELLOW);
		user.setBounds(43, 134, 180, 35);
		contentPane.add(user);
		
		JLabel pass = new JLabel("Password:");
		pass.setVerticalAlignment(SwingConstants.BOTTOM);
		pass.setForeground(Color.YELLOW);
		pass.setFont(new Font("DialogInput", Font.BOLD, 25));
		pass.setBounds(43, 181, 180, 35);
		contentPane.add(pass);
		
		JLabel Login = new JLabel("LOGIN.");
		Login.setForeground(SystemColor.info);
		Login.setBackground(SystemColor.info);
		Login.setFont(new Font("Gargi", Font.BOLD, 26));
		Login.setBounds(281, 52, 279, 45);
		contentPane.add(Login);
	}
}
