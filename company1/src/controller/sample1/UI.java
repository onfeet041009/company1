package controller.sample1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DaO.impMember;
import model.member;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class UI extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField username;
	private JTextField password;
	private JTextField address;
	private JTextField mobile;
	private JTextField phone;
	private JTextField nameUpdate;
	private JTextField updateid;
	private JTextField addressUpdate;
	private JTextField deleteid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI frame = new UI();
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
	public UI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 550);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(64, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 0));
		panel.setBounds(10, 56, 308, 429);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("姓名");
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 63, 46, 21);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("帳號");
		lblNewLabel_1.setFont(new Font("新細明體", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 106, 46, 21);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("密碼");
		lblNewLabel_2.setFont(new Font("新細明體", Font.BOLD, 14));
		lblNewLabel_2.setBounds(10, 147, 46, 21);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("地址");
		lblNewLabel_3.setFont(new Font("新細明體", Font.BOLD, 14));
		lblNewLabel_3.setBounds(10, 189, 46, 21);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("手機");
		lblNewLabel_4.setFont(new Font("新細明體", Font.BOLD, 14));
		lblNewLabel_4.setBounds(10, 231, 46, 21);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("電話");
		lblNewLabel_5.setFont(new Font("新細明體", Font.BOLD, 14));
		lblNewLabel_5.setBounds(10, 273, 46, 21);
		panel.add(lblNewLabel_5);
		
		name = new JTextField();
		name.setBounds(66, 63, 96, 21);
		panel.add(name);
		name.setColumns(10);
		
		username = new JTextField();
		username.setColumns(10);
		username.setBounds(66, 106, 96, 21);
		panel.add(username);
		
		password = new JTextField();
		password.setColumns(10);
		password.setBounds(66, 147, 96, 21);
		panel.add(password);
		
		address = new JTextField();
		address.setColumns(10);
		address.setBounds(66, 189, 210, 21);
		panel.add(address);
		
		mobile = new JTextField();
		mobile.setColumns(10);
		mobile.setBounds(66, 231, 166, 21);
		panel.add(mobile);
		
		phone = new JTextField();
		phone.setColumns(10);
		phone.setBounds(66, 273, 166, 21);
		panel.add(phone);
		
		JButton create = new JButton("新增");
		create.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 * 1.UI接收 getText
				 * 2.new member()
				 * 3.add(m)
				 */
				String Name=name.getText();
				String Username=username.getText();
				String Password=password.getText();
				String Address=address.getText();
				String Mobile=mobile.getText();
				String Phone=phone.getText();
				member m=new member(Name,Username,Password,Address,Mobile,Phone);
				
				new impMember().add(m);
			}
		});
		create.setBounds(118, 341, 87, 23);
		panel.add(create);
		
		JLabel lblNewLabel_6 = new JLabel("請輸入會員資料");
		lblNewLabel_6.setFont(new Font("新細明體", Font.BOLD, 16));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(74, 10, 158, 29);
		panel.add(lblNewLabel_6);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 128, 0));
		panel_1.setBounds(328, 56, 558, 429);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JTextArea show = new JTextArea();
		show.setBounds(10, 149, 538, 270);
		panel_1.add(show);
		
		JLabel total = new JLabel("");
		total.setBounds(485, 121, 63, 21);
		panel_1.add(total);
		
		JLabel lblNewLabel_7 = new JLabel("姓名");
		lblNewLabel_7.setFont(new Font("新細明體", Font.BOLD, 14));
		lblNewLabel_7.setBounds(123, 28, 46, 15);
		panel_1.add(lblNewLabel_7);
		
		JLabel lblNewLabel_7_1 = new JLabel("Id");
		lblNewLabel_7_1.setFont(new Font("新細明體", Font.BOLD, 14));
		lblNewLabel_7_1.setBounds(123, 57, 46, 15);
		panel_1.add(lblNewLabel_7_1);
		
		JLabel lblNewLabel_7_2 = new JLabel("地址");
		lblNewLabel_7_2.setFont(new Font("新細明體", Font.BOLD, 14));
		lblNewLabel_7_2.setBounds(123, 90, 46, 15);
		panel_1.add(lblNewLabel_7_2);
		
		nameUpdate = new JTextField();
		nameUpdate.setBounds(179, 25, 96, 21);
		panel_1.add(nameUpdate);
		nameUpdate.setColumns(10);
		
		updateid = new JTextField();
		updateid.setBounds(179, 54, 96, 21);
		panel_1.add(updateid);
		updateid.setColumns(10);
		
		addressUpdate = new JTextField();
		addressUpdate.setBounds(179, 87, 175, 21);
		panel_1.add(addressUpdate);
		addressUpdate.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("id");
		lblNewLabel_8.setBounds(123, 124, 46, 15);
		panel_1.add(lblNewLabel_8);
		
		deleteid = new JTextField();
		deleteid.setBounds(179, 118, 96, 21);
		panel_1.add(deleteid);
		deleteid.setColumns(10);
		
		JButton read = new JButton("查詢");
		read.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 * 1.show.setText-->queryAll1():String
				 */
				
				show.setText(new impMember().queryAll1());
				List<member> l=new impMember().queryAll2();
				total.setText("共:"+l.size()+"筆");
				
			}//嘖嘖 好像知道甚麼惹...回去有力氣我再來改進(倒
		});
		read.setBounds(10, 10, 87, 23);
		panel_1.add(read);
		
		JButton update = new JButton("修改");
		update.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					/*
					 * 1.nameUpdate,addressUpdate ,updateid-->getText
					 * 2.updateId-->轉成int--->queryId(id)-->member m
					 * 3.m.setName(),m.setAddress()
					 * 4.update(m)
					 */
					
					String Name=nameUpdate.getText();
					String Address=addressUpdate.getText();
					
					int ID=Integer.parseInt(updateid.getText());				
					member m=new impMember().queryId(ID);
					m.setName(Name);
					m.setAddress(Address);
					
					new impMember().update(m);				
					
				
			}
		});
		update.setBounds(10, 53, 87, 23);
		panel_1.add(update);
		
		JButton delete = new JButton("刪除");
		delete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 * 1.deleteId-->getText-->轉型-->int
				 * 2.執行 delete(id)
				 */
				
				int Id=Integer.parseInt(deleteid.getText());
				
				new impMember().delete(Id);
				
				
			}
		});
		delete.setBounds(10, 97, 87, 23);
		panel_1.add(delete);
		
		
		
		
		
		
		
		
		
		
	}
}
