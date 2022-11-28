package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.hibernate.hql.ast.origin.hql.parse.HQLParser.new_key_return;

import dao.AccountDao;
import dao.EmployeeDao;
import model.Account;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.UIManager;

public class FrmLogin extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtTaiKhoan;
	private JPasswordField passwordField;
	private JButton btnDangNhap;
	private AccountDao accountDao;
	
	private static String idUSER;
	private static String typeUS;
	private static String statusUS;
	
	
	
	

	/**
	 * @return the idUSER
	 */
	public static String getIdUSER() {
		return idUSER;
	}

	/**
	 * @param idUSER the idUSER to set
	 */
	public static void setIdUSER(String idUSER) {
		FrmLogin.idUSER = idUSER;
	}

	/**
	 * @return the typeUS
	 */
	public static String getTypeUS() {
		return typeUS;
	}

	/**
	 * @param typeUS the typeUS to set
	 */
	public static void setTypeUS(String typeUS) {
		FrmLogin.typeUS = typeUS;
	}

	/**
	 * @return the statusUS
	 */
	public static String getStatusUS() {
		return statusUS;
	}

	/**
	 * @param statusUS the statusUS to set
	 */
	public static void setStatusUS(String statusUS) {
		FrmLogin.statusUS = statusUS;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmLogin frame = new FrmLogin();
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
	public FrmLogin() {
		
		SecurityManager securityManager = System.getSecurityManager();
		if (securityManager == null) {
			System.setProperty("java.security.policy", "rmi/policy.policy");
			System.setSecurityManager(new SecurityManager());
		}
		try {
		
			accountDao =  (AccountDao) Naming.lookup("rmi://localhost:1000/accountDao");

		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setTitle("\u0110\u0103ng nh\u1EADp\r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.disabledShadow"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTaiKhoan = new JLabel("T\u00E0i kho\u1EA3n: ");
		lblTaiKhoan.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblTaiKhoan.setBounds(10, 105, 116, 25);
		contentPane.add(lblTaiKhoan);
		
		JLabel lblTieuDe = new JLabel("HI\u1EC6U S\u00C1CH S\u00C0I G\u00D2N");
		lblTieuDe.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblTieuDe.setBounds(88, 30, 306, 35);
		contentPane.add(lblTieuDe);
		
		JLabel lblMatKhau = new JLabel("M\u1EADt kh\u1EA9u: ");
		lblMatKhau.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblMatKhau.setBounds(10, 155, 116, 25);
		contentPane.add(lblMatKhau);
		
		txtTaiKhoan = new JTextField();
		txtTaiKhoan.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtTaiKhoan.setBounds(128, 105, 300, 30);
		contentPane.add(txtTaiKhoan);
		txtTaiKhoan.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Times New Roman", Font.BOLD, 20));
		passwordField.setBounds(128, 155, 300, 30);
		contentPane.add(passwordField);
		
		btnDangNhap = new JButton("\u0110\u0103ng nh\u1EADp");
		btnDangNhap.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnDangNhap.setBounds(128, 231, 134, 30);
		contentPane.add(btnDangNhap);
		
		JButton btnThoat = new JButton("Tho\u00E1t");
		btnThoat.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnThoat.setBounds(294, 231, 134, 30);
		contentPane.add(btnThoat);
		
		JButton btnQuenMatKhau = new JButton("Qu\u00EAn m\u1EADt kh\u1EA9u");
		btnQuenMatKhau.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnQuenMatKhau.setBounds(150, 287, 244, 30);
		contentPane.add(btnQuenMatKhau);
		
		btnDangNhap.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		Object object = e.getSource();
		if (object.equals(btnDangNhap)) {
			String tk = txtTaiKhoan.getText().trim();
			String mk = passwordField.getText();
			Account account = null;
			try {
				account = accountDao.getAccount(tk);
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			if (account!=null && account.getIdAccount().getIdEmloyee().equals(tk) && account.getPassword().equals(mk)) {
				if (account.getStatus().equals("Đã khóa")) {
					JOptionPane.showMessageDialog(this, "Tài khoản của bạn đang bị khóa hãy thông báo đến quản lí để được giải quyết!");
				}else {
					FrmLogin.setIdUSER(tk);
					FrmLogin.setTypeUS(account.getType());
					dispose();
					new FrmHome().setVisible(true);
				}
			}
			else {
				JOptionPane.showMessageDialog(this, "Thông tin đăng nhập không chính xác!");
			}
		}
		else {
			JOptionPane.showMessageDialog(this, "Bạn đã nhập sai thông tin tài khoản!");
		}
	}
}
