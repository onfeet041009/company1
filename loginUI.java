package controller.sample2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DaO.impMember;
import model.member;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class loginUI extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JTextField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginUI frame = new loginUI();
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
	public loginUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("會員登入系統");
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(166, 10, 147, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("帳號");
		lblNewLabel_1.setFont(new Font("新細明體", Font.BOLD, 14));
		lblNewLabel_1.setBounds(23, 71, 46, 18);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("密碼");
		lblNewLabel_2.setFont(new Font("新細明體", Font.BOLD, 14));
		lblNewLabel_2.setBounds(23, 141, 46, 18);
		contentPane.add(lblNewLabel_2);
		
		username = new JTextField();
		username.setBounds(104, 68, 138, 21);
		contentPane.add(username);
		username.setColumns(10);
		
		password = new JTextField();
		password.setBounds(104, 138, 138, 21);
		contentPane.add(password);
		password.setColumns(10);
		
		JButton login = new JButton("登入");
		login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 * 1.帳號密碼 getText()
				 * 2.queryUser(帳號,密碼):member
				 * 3.!=unll-->loginSuccess
				 * 4.null-->longinError
				 */
				String Username=username.getText();
				String Password=password.getText();
				
				member m=new impMember().queryMember(Username,Password);
				
				if(m!=null) 
				{
					loginSuccess l=new loginSuccess();
					l.show();
					dispose();
				}
				else 
				{
					loginError l=new loginError();
					l.show();
					dispose();
				}
			}
		});
		login.setFont(new Font("新細明體", Font.BOLD, 14));
		login.setBounds(143, 209, 87, 23);
		contentPane.add(login);
	}
}
