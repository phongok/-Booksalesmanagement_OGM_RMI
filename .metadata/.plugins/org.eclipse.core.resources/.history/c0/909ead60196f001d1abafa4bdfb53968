package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;

import org.hibernate.hql.ast.origin.hql.parse.HQLParser.new_key_return;
import org.hibernate.hql.ast.origin.hql.resolve.GeneratedHQLResolver.intermediateIndexOperation_return;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import dao.AccountDao;
import dao.EmployeeDao;
import model.Account;
import model.Employee;

import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class FrmEmployeeManager extends JFrame implements ActionListener, MouseListener {

	private JPanel contentPane;
	private JTextField txtIdEmp;
	private JTextField txtNameEmp;
	private JTextField txtIdcard;
	private JTextField txtAddress;
	private JTextField txtPhone;
	private JTextField txtEmail;
	private JDateChooser dateNgaySinhEmp;
	private DefaultTableModel data_ModelEmployee;
	private JTable table_Employee;
	private JTextField txtSeach;
	private JButton btnExit;
	private JButton btnUpdate;
	private JButton btnSave;

	private EmployeeDao employeeDao;
	private AccountDao accountDao;
	private List<Employee> employees = new ArrayList<>();
	
	private JComboBox cmbGender;
	private JComboBox cmbPosition;
	private JComboBox cmbStatus;
	private JButton btnXoaTrang;
	private JButton btnSeach;
	private JButton btnHienBang;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {

				try {
					FrmEmployeeManager frame = new FrmEmployeeManager();
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
	public FrmEmployeeManager() {

		SecurityManager securityManager = System.getSecurityManager();
		if (securityManager == null) {
			System.setProperty("java.security.policy", "rmi/policy.policy");
			System.setSecurityManager(new SecurityManager());
		}
		try {
			employeeDao = (EmployeeDao) Naming.lookup("rmi://localhost:1000/employeeDao");
			accountDao =  (AccountDao) Naming.lookup("rmi://localhost:1000/accountDao");

		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setTitle("Quản lí nhân viên");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 5, 1540, 820);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel pnlInfo = new JPanel();
		pnlInfo.setBorder(UIManager.getBorder("ToolTip.border"));
		pnlInfo.setBackground(SystemColor.inactiveCaptionBorder);
		pnlInfo.setBounds(2, 2, 1518, 445);
		contentPane.add(pnlInfo);
		pnlInfo.setLayout(null);

		JLabel lblTittle = new JLabel("Quản Lí Nhân Viên");
		lblTittle.setFont(new Font("Times New Roman", Font.BOLD, 35));
		lblTittle.setBounds(618, 10, 404, 40);
		pnlInfo.add(lblTittle);

		JLabel lblNewLabel_1 = new JLabel("Mã nhân viên: ");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_1.setBounds(140, 90, 165, 30);
		pnlInfo.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Tên nhân viên: ");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_1_1.setBounds(140, 150, 150, 30);
		pnlInfo.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Ngày sinh: ");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_1_2.setBounds(140, 210, 142, 30);
		pnlInfo.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("Giới tính: ");
		lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_1_3.setBounds(140, 270, 142, 30);
		pnlInfo.add(lblNewLabel_1_3);

		JLabel lblNewLabel_1_3_1 = new JLabel("CCCD: ");
		lblNewLabel_1_3_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_1_3_1.setBounds(140, 330, 142, 30);
		pnlInfo.add(lblNewLabel_1_3_1);

		JLabel lblNewLabel_1_3_2 = new JLabel("Chức vụ: ");
		lblNewLabel_1_3_2.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_1_3_2.setBounds(880, 90, 142, 30);
		pnlInfo.add(lblNewLabel_1_3_2);

		JLabel lblNewLabel_1_3_3 = new JLabel("Địa chỉ: ");
		lblNewLabel_1_3_3.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_1_3_3.setBounds(880, 150, 142, 30);
		pnlInfo.add(lblNewLabel_1_3_3);

		JLabel lblNewLabel_1_3_4 = new JLabel("Số điện thoại: ");
		lblNewLabel_1_3_4.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_1_3_4.setBounds(880, 210, 142, 30);
		pnlInfo.add(lblNewLabel_1_3_4);

		JLabel lblNewLabel_1_3_5 = new JLabel("Email: ");
		lblNewLabel_1_3_5.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_1_3_5.setBounds(880, 270, 142, 30);
		pnlInfo.add(lblNewLabel_1_3_5);

		JLabel lblNewLabel_1_3_6 = new JLabel("Tình trạng: ");
		lblNewLabel_1_3_6.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_1_3_6.setBounds(880, 330, 142, 30);
		pnlInfo.add(lblNewLabel_1_3_6);

		txtIdEmp = new JTextField();
		txtIdEmp.setFont(new Font("Times New Roman", Font.BOLD, 22));
		txtIdEmp.setBounds(320, 90, 320, 30);
		pnlInfo.add(txtIdEmp);
		txtIdEmp.setColumns(10);

		txtNameEmp = new JTextField();
		txtNameEmp.setFont(new Font("Times New Roman", Font.BOLD, 22));
		txtNameEmp.setColumns(10);
		txtNameEmp.setBounds(320, 150, 320, 30);
		pnlInfo.add(txtNameEmp);

		txtIdcard = new JTextField();
		txtIdcard.setFont(new Font("Times New Roman", Font.BOLD, 22));
		txtIdcard.setColumns(10);
		txtIdcard.setBounds(320, 330, 320, 30);
		pnlInfo.add(txtIdcard);

		dateNgaySinhEmp = new JDateChooser();
		dateNgaySinhEmp.setDateFormatString("yyyy-MM-dd");
		dateNgaySinhEmp.setFont(new Font("Time New Roman", Font.BOLD, 18));
		dateNgaySinhEmp.setBounds(320, 210, 320, 30);
		pnlInfo.add(dateNgaySinhEmp);

		txtAddress = new JTextField();
		txtAddress.setFont(new Font("Times New Roman", Font.BOLD, 22));
		txtAddress.setColumns(10);
		txtAddress.setBounds(1040, 150, 320, 30);
		pnlInfo.add(txtAddress);

		txtPhone = new JTextField();
		txtPhone.setFont(new Font("Times New Roman", Font.BOLD, 22));
		txtPhone.setColumns(10);
		txtPhone.setBounds(1040, 213, 320, 30);
		pnlInfo.add(txtPhone);

		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Times New Roman", Font.BOLD, 22));
		txtEmail.setColumns(10);
		txtEmail.setBounds(1040, 273, 320, 30);
		pnlInfo.add(txtEmail);

		cmbStatus = new JComboBox();
		cmbStatus
				.setModel(new DefaultComboBoxModel(new String[] { "Đang làm việc", "Tạm nghĩ việc", "Đã thôi việc" }));
		cmbStatus.setFont(new Font("Times New Roman", Font.BOLD, 22));
		cmbStatus.setBounds(1040, 330, 320, 30);
		pnlInfo.add(cmbStatus);

		cmbPosition = new JComboBox();
		cmbPosition.setModel(
				new DefaultComboBoxModel(new String[] { "Quản lí", "Nhân viên bán hàng", "Nhân viên thanh toán" }));
		cmbPosition.setFont(new Font("Times New Roman", Font.BOLD, 22));
		cmbPosition.setBounds(1040, 90, 320, 30);
		pnlInfo.add(cmbPosition);

		cmbGender = new JComboBox();
		cmbGender.setModel(new DefaultComboBoxModel(new String[] { "Nam", "Nữ" }));
		cmbGender.setFont(new Font("Times New Roman", Font.BOLD, 22));
		cmbGender.setBounds(320, 270, 320, 30);
		pnlInfo.add(cmbGender);

		btnSave = new JButton("Thêm");
		btnSave.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnSave.setBounds(434, 395, 130, 35);
		pnlInfo.add(btnSave);

		btnUpdate = new JButton("Cập nhật");
		btnUpdate.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnUpdate.setBounds(636, 395, 150, 35);
		pnlInfo.add(btnUpdate);

		btnExit = new JButton("Quay lại");
		btnExit.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnExit.setBounds(1090, 395, 130, 35);
		pnlInfo.add(btnExit);
		
		btnXoaTrang = new JButton("Xóa trắng");
		btnXoaTrang.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnXoaTrang.setBounds(865, 395, 150, 35);
		pnlInfo.add(btnXoaTrang);
		
		btnHienBang = new JButton("Hiện bảng");
		btnHienBang.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnHienBang.setBounds(187, 395, 177, 35);
		pnlInfo.add(btnHienBang);

		JPanel pnlListEmployee = new JPanel();
		pnlListEmployee.setBorder(UIManager.getBorder("ToolTip.border"));
		pnlListEmployee.setBackground(SystemColor.inactiveCaptionBorder);
		pnlListEmployee.setBounds(2, 457, 1518, 313);
		contentPane.add(pnlListEmployee);
		pnlListEmployee.setLayout(null);

		Box bQuanLiNhanVien;
		pnlListEmployee.add(bQuanLiNhanVien = Box.createHorizontalBox());

		JLabel lblTimKiem = new JLabel("Tìm kiếm: ");
		lblTimKiem.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblTimKiem.setBounds(29, 10, 111, 45);
		pnlListEmployee.add(lblTimKiem);

		txtSeach = new JTextField();
		txtSeach.setFont(new Font("Times New Roman", Font.BOLD, 22));
		txtSeach.setBounds(140, 20, 314, 30);
		pnlListEmployee.add(txtSeach);
		txtSeach.setColumns(10);

		btnSeach = new JButton("Tìm kiếm");
		btnSeach.setFont(new Font("Times New Roman", Font.BOLD, 22));
		btnSeach.setBounds(464, 20, 130, 30);
		pnlListEmployee.add(btnSeach);
		String[] headers_NV = { "Mã nhân viên", "Tên nhân viên", "Ngày sinh", "Giới tính", "Số CCCD", "Tên chức vụ",
				"Địa chỉ", "SDT", "Email", "Trình trạng" };
		data_ModelEmployee = new DefaultTableModel(headers_NV, 0);
		JScrollPane jScrollPane_NhanVien;
		bQuanLiNhanVien.add(jScrollPane_NhanVien = new JScrollPane(table_Employee = new JTable(data_ModelEmployee)));
		jScrollPane_NhanVien.setBorder(BorderFactory.createTitledBorder("Danh sách nhân viên"));
		bQuanLiNhanVien.setBounds(5, 65, 1510, 240);
		
		updateTableEmployee();
		
		table_Employee.addMouseListener(this);

		btnExit.addActionListener(this);
		btnSave.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnXoaTrang.addActionListener(this);
		btnSeach.addActionListener(this);
		btnHienBang.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object object = e.getSource();
		if (object.equals(btnExit)) {
			dispose();
			new FrmHome().setVisible(true);
		}
		else if (object.equals(btnSave)) {
			try {
				saveEmployee();
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if (object.equals(btnUpdate)) {
			try {
				updateEmployee();
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if (object.equals(btnXoaTrang)) {
			xoaTrang();
		}
		else if (object.equals(btnSeach)) {
			try {
				seachAction();
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if (object.equals(btnHienBang)) {
			DeleteTableEmployee();
			updateTableEmployee();
		}

	}
	
	private void xoaTrang() {
		txtIdEmp.setText(null);
		txtNameEmp.setText(null);
		dateNgaySinhEmp.setDate(null);
		cmbGender.setSelectedItem(null);
		
		txtIdcard.setText(null);
		cmbPosition.setSelectedItem(null);
		txtAddress.setText(null);
		txtPhone.setText(null);
		txtEmail.setText(null);
		
		cmbStatus.setSelectedItem(null);
		txtIdEmp.requestFocus();
	}
	
	
	private void seachAction() throws RemoteException {
		String id = txtSeach.getText().trim();
		Employee employee = employeeDao.getEmployee(id);
		if (employee!=null) {
			DeleteTableEmployee();
			String rowEmlpoyee[] = { employee.getIdEmloyee(), employee.getName(), employee.getDateofbirth() + "",
					employee.getGender(), employee.getIdcard(), employee.getPosition(), employee.getAddress(),
					employee.getPhonenumber(), employee.getEmail(), employee.getStatus() };
			data_ModelEmployee.addRow(rowEmlpoyee);
		} else {
			JOptionPane.showMessageDialog(this, "Không tìm thấy");
		}
	}
	
	private void updateEmployee() throws RemoteException{
		
		int row = table_Employee.getSelectedRow();
		if (row!=-1) {
			String maNV = table_Employee.getValueAt(row, 0).toString();
			String nameEmp = txtNameEmp.getText().trim();
			
			int ngay = dateNgaySinhEmp.getDate().getDay();
			int thang = dateNgaySinhEmp.getDate().getMonth() + 1;
			int nam = dateNgaySinhEmp.getDate().getYear() + 1900;
			
			Date date =  new Date(nam-1900, thang, ngay);
			String gender =  cmbGender.getSelectedItem().toString();
			String idCard = txtIdcard.getText().trim();
			String position = cmbPosition.getSelectedItem().toString();
			String address = txtAddress.getText().trim();
			String phoneNumber = txtPhone.getText().trim();
			String email = txtEmail.getText();
			String status = "Đang làm việc";
			
			Employee employee = new Employee(maNV, nameEmp, date, gender, idCard, position, address, phoneNumber, email, status);
			if (valib_data()) {
				if (employeeDao.updateEmployee(employee)) {
					JOptionPane.showMessageDialog(this, "Cập nhật thành công");
					table_Employee.setValueAt(employee.getName(), row, 1);
					table_Employee.setValueAt(employee.getDateofbirth(), row, 2);
					table_Employee.setValueAt(employee.getGender(), row, 3);
					table_Employee.setValueAt(employee.getIdcard(), row, 4);
					table_Employee.setValueAt(employee.getPosition(), row, 5);
					table_Employee.setValueAt(employee.getAddress(), row, 6);
					table_Employee.setValueAt(employee.getPhonenumber(), row, 7);
					table_Employee.setValueAt(employee.getEmail(), row, 8);
					table_Employee.setValueAt(employee.getStatus(), row, 9);
					
				}
				else {
					JOptionPane.showMessageDialog(this, "Cập nhật thất bại");
				}
			} 
		}
		else {
			JOptionPane.showMessageDialog(this, "Bạn chưa chọn nhân viên cần cập nhật");
		}
		
		
		
	}
	private void DeleteTableEmployee() {

		DefaultTableModel dm = (DefaultTableModel) table_Employee.getModel();
		dm.getDataVector().removeAllElements();

	}
	private void saveEmployee() throws RemoteException {
		String maNV = txtIdEmp.getText().trim();
		String nameEmp = txtNameEmp.getText().trim();
		
		int ngay = dateNgaySinhEmp.getDate().getDay();
		int thang = dateNgaySinhEmp.getDate().getMonth() + 1;
		int nam = dateNgaySinhEmp.getDate().getYear() + 1900;
		
		Date date =  new Date(nam, thang, ngay);
		String gender =  cmbGender.getSelectedItem().toString();
		String idCard = txtIdcard.getText().trim();
		String position = cmbPosition.getSelectedItem().toString();
		String address = txtAddress.getText().trim();
		String phoneNumber = txtPhone.getText().trim();
		String email = txtEmail.getText();
		String status = "Đang làm việc";
		
		Employee employee = new Employee(maNV, nameEmp, date, gender, idCard, position, address, phoneNumber, email, status);
		if (valib_data()) {
			if (employeeDao.createEmployee(employee)) {
				JOptionPane.showMessageDialog(this, "Thêm thành công");
				String rowEmlpoyee[] = { employee.getIdEmloyee(), employee.getName(), employee.getDateofbirth() + "",
						employee.getGender(), employee.getIdcard(), employee.getPosition(), employee.getAddress(),
						employee.getPhonenumber(), employee.getEmail(), employee.getStatus() };
				data_ModelEmployee.addRow(rowEmlpoyee);
				Account account = new Account(employee, position, "Đang hoạt động", "12345");
				accountDao.createAccount(account);
			}
			else {
				JOptionPane.showMessageDialog(this, "Thêm thất bại, mã bị trùng");
			}
		} 
		
		
	}
	
	private boolean valib_data() {
		
		return true;
	}

	private void updateTableEmployee() {
		try {
			employees.clear();
			employees = employeeDao.getEmployees();
			for (Employee employee : employees) {
				String rowEmlpoyee[] = { employee.getIdEmloyee(), employee.getName(), employee.getDateofbirth() + "",
						employee.getGender(), employee.getIdcard(), employee.getPosition(), employee.getAddress(),
						employee.getPhonenumber(), employee.getEmail(), employee.getStatus() };
				data_ModelEmployee.addRow(rowEmlpoyee);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void mouseClicked(MouseEvent e) {
		Object src = e.getSource();
		if (src.equals(table_Employee)) {
			int row = table_Employee.getSelectedRow();
			if (row!=-1) {
				txtIdEmp.setText(table_Employee.getValueAt(row, 0).toString());
				txtNameEmp.setText(table_Employee.getValueAt(row, 1).toString());
				
				cmbGender.setSelectedItem(table_Employee.getValueAt(row, 3).toString());
				
				txtIdcard.setText(table_Employee.getValueAt(row, 4).toString());
				cmbPosition.setSelectedItem(table_Employee.getValueAt(row, 5).toString());
				txtAddress.setText(table_Employee.getValueAt(row, 6).toString());
				txtPhone.setText(table_Employee.getValueAt(row, 7).toString());
				txtEmail.setText(table_Employee.getValueAt(row, 8).toString());
				
				cmbStatus.setSelectedItem(table_Employee.getValueAt(row, 9).toString());
			}
		}
		

	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
