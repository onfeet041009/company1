package controller.sample2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DaO.impMember;
import model.member;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class addMember extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField username;
	private JTextField password;
	private JTextField address;
	private JTextField mobile;
	private JTextField phone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addMember frame = new addMember();
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
	public addMember() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("註冊會員");
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(83, 10, 248, 41);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("姓名");
		lblNewLabel_1.setFont(new Font("新細明體", Font.BOLD, 16));
		lblNewLabel_1.setBounds(22, 62, 46, 29);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("帳號");
		lblNewLabel_2.setFont(new Font("新細明體", Font.BOLD, 16));
		lblNewLabel_2.setBounds(22, 122, 46, 29);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("密碼");
		lblNewLabel_3.setFont(new Font("新細明體", Font.BOLD, 16));
		lblNewLabel_3.setBounds(22, 188, 46, 29);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("地址");
		lblNewLabel_4.setFont(new Font("新細明體", Font.BOLD, 16));
		lblNewLabel_4.setBounds(22, 254, 46, 29);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("手機號碼");
		lblNewLabel_5.setFont(new Font("新細明體", Font.BOLD, 16));
		lblNewLabel_5.setBounds(22, 326, 81, 29);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("電話");
		lblNewLabel_6.setFont(new Font("新細明體", Font.BOLD, 16));
		lblNewLabel_6.setBounds(22, 400, 46, 29);
		contentPane.add(lblNewLabel_6);
		
		name = new JTextField();
		name.setBounds(113, 66, 96, 21);
		contentPane.add(name);
		name.setColumns(10);
		
		username = new JTextField();
		username.setBounds(113, 126, 153, 21);
		contentPane.add(username);
		username.setColumns(10);
		
		password = new JTextField();
		password.setBounds(113, 192, 153, 21);
		contentPane.add(password);
		password.setColumns(10);
		
		address = new JTextField();
		address.setBounds(113, 258, 186, 21);
		contentPane.add(address);
		address.setColumns(10);
		
		mobile = new JTextField();
		mobile.setBounds(113, 330, 153, 21);
		contentPane.add(mobile);
		mobile.setColumns(10);
		
		phone = new JTextField();
		phone.setBounds(113, 404, 153, 21);
		contentPane.add(phone);
		phone.setColumns(10);
		
		JButton btnNewButton = new JButton("加入會員");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 * 1.username->getText()
				 * 2.帳號判斷->queryusername():boolean
				 * 3.true->重覆->addError
				 * 4.false->接收所有資料->new member->add()->addSuccess
				 */
				String Username=username.getText();
				if(new impMember().queryUser(Username)) 
				{
					addError error=new addError();
					error.show();
					dispose();
				}
				else 
				{
					String Name=name.getText();
					String Password=password.getText();
					String Address=address.getText();
					String Mobile=mobile.getText();
					String Phone=phone.getText();
					
					member m=new member(Name,Username,Password,Address,Mobile,Phone);
					
					new impMember().add(m);
					
					addSuccess success=new addSuccess();
					success.show();
					dispose();
				}
			}
		});
		btnNewButton.setBounds(179, 505, 87, 23);
		contentPane.add(btnNewButton);
	}

}
