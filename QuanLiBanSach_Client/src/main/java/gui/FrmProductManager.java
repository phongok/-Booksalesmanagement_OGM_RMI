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
import java.util.List;

import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.hibernate.hql.ast.origin.hql.parse.HQLParser.new_key_return;
import org.hibernate.hql.ast.origin.hql.resolve.GeneratedHQLResolver.intermediateIndexOperation_return;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import dao.AccountDao;
import dao.EmployeeDao;
import dao.ProductDao;
import model.Product;

import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class FrmProductManager extends JFrame implements ActionListener, MouseListener {

	private JPanel contentPane;
	private JTextField txtMaSP;
	private JTextField txtTenSP;
	private JTextField txtDonGia;

	private JTable table_Product;
	private JTextField txtSeach;
	private JButton btnXoa;
	private JButton btnUpdate;
	private JButton btnSave;
	private JTextField txtSoLuong;
	private JTextField txtNCC;
	private DefaultTableModel data_ModelProduct;

	private ProductDao productDao;
	private List<Product> products = new ArrayList<Product>();
	private JComboBox cmbTT;
	private JComboBox cmbLoai;
	private JButton btnHienBang;
	private JButton btnXoaTrang;
	private JButton btnQuayLai;
	private JButton btnSearch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmProductManager frame = new FrmProductManager();
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
	public FrmProductManager() {

		SecurityManager securityManager = System.getSecurityManager();
		if (securityManager == null) {
			System.setProperty("java.security.policy", "rmi/policy.policy");
			System.setSecurityManager(new SecurityManager());
		}
		try {
			productDao = (ProductDao) Naming.lookup("rmi://localhost:1000/productDao");

		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		setTitle("Qu???n l?? s???n ph???m");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 3, 1540, 820);
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

		JLabel lblTittle = new JLabel("Qu???n L?? S???n Ph???m");
		lblTittle.setFont(new Font("Times New Roman", Font.BOLD, 35));
		lblTittle.setBounds(618, 10, 404, 40);
		pnlInfo.add(lblTittle);

		JLabel lblNewLabel_1 = new JLabel("M?? s???n ph???m :");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_1.setBounds(135, 90, 155, 30);
		pnlInfo.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("T??n s???n ph???m: ");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_1_1.setBounds(135, 150, 155, 30);
		pnlInfo.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("S??? l?????ng: ");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_1_2.setBounds(135, 210, 155, 30);
		pnlInfo.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("Lo???i s???n ph???m: ");
		lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_1_3.setBounds(135, 270, 155, 30);
		pnlInfo.add(lblNewLabel_1_3);

		JLabel lblNewLabel_1_3_1 = new JLabel("????n gi??: ");
		lblNewLabel_1_3_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_1_3_1.setBounds(135, 330, 155, 30);
		pnlInfo.add(lblNewLabel_1_3_1);

		JLabel lblNewLabel_1_3_2 = new JLabel("Nh?? cung c???p: ");
		lblNewLabel_1_3_2.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_1_3_2.setBounds(845, 90, 177, 30);
		pnlInfo.add(lblNewLabel_1_3_2);

		txtMaSP = new JTextField();
		txtMaSP.setFont(new Font("Times New Roman", Font.BOLD, 22));
		txtMaSP.setBounds(320, 90, 320, 30);
		pnlInfo.add(txtMaSP);
		txtMaSP.setColumns(10);

		txtTenSP = new JTextField();
		txtTenSP.setFont(new Font("Times New Roman", Font.BOLD, 22));
		txtTenSP.setColumns(10);
		txtTenSP.setBounds(320, 150, 320, 30);
		pnlInfo.add(txtTenSP);

		txtDonGia = new JTextField();
		txtDonGia.setFont(new Font("Times New Roman", Font.BOLD, 22));
		txtDonGia.setColumns(10);
		txtDonGia.setBounds(320, 330, 320, 30);
		pnlInfo.add(txtDonGia);

		cmbLoai = new JComboBox();
		cmbLoai.setModel(new DefaultComboBoxModel(new String[] { "V???", "B??t", "S??ch" }));
		cmbLoai.setFont(new Font("Times New Roman", Font.BOLD, 22));
		cmbLoai.setBounds(320, 270, 320, 30);
		pnlInfo.add(cmbLoai);

		btnSave = new JButton("Th??m");
		btnSave.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnSave.setBounds(498, 395, 130, 35);
		pnlInfo.add(btnSave);

		btnUpdate = new JButton("C???p nh???t");
		btnUpdate.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnUpdate.setBounds(688, 395, 150, 35);
		pnlInfo.add(btnUpdate);

		btnXoa = new JButton("X??a");
		btnXoa.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnXoa.setBounds(892, 395, 130, 35);
		pnlInfo.add(btnXoa);

		txtSoLuong = new JTextField();
		txtSoLuong.setFont(new Font("Times New Roman", Font.BOLD, 22));
		txtSoLuong.setColumns(10);
		txtSoLuong.setBounds(320, 210, 320, 30);
		pnlInfo.add(txtSoLuong);

		txtNCC = new JTextField();
		txtNCC.setFont(new Font("Times New Roman", Font.BOLD, 22));
		txtNCC.setColumns(10);
		txtNCC.setBounds(1040, 90, 320, 30);
		pnlInfo.add(txtNCC);

		JLabel lblNewLabel_1_3_2_1 = new JLabel("T??nh tr???ng:");
		lblNewLabel_1_3_2_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_1_3_2_1.setBounds(845, 150, 177, 30);
		pnlInfo.add(lblNewLabel_1_3_2_1);

		btnXoaTrang = new JButton("X??a tr???ng");
		btnXoaTrang.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnXoaTrang.setBounds(1070, 395, 150, 35);
		pnlInfo.add(btnXoaTrang);

		btnQuayLai = new JButton("Quay l???i");
		btnQuayLai.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnQuayLai.setBounds(1270, 395, 130, 35);
		pnlInfo.add(btnQuayLai);

		cmbTT = new JComboBox();
		cmbTT.setModel(new DefaultComboBoxModel(new String[] { "??ang kinh doanh", "Ng???ng kinh doanh" }));
		cmbTT.setFont(new Font("Times New Roman", Font.BOLD, 22));
		cmbTT.setBounds(1040, 150, 320, 30);
		pnlInfo.add(cmbTT);

		btnHienBang = new JButton("Hi???n b???ng");
		btnHienBang.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnHienBang.setBounds(283, 395, 150, 35);
		pnlInfo.add(btnHienBang);

		JPanel pnlListProduct = new JPanel();
		pnlListProduct.setBorder(UIManager.getBorder("ToolTip.border"));
		pnlListProduct.setBackground(SystemColor.inactiveCaptionBorder);
		pnlListProduct.setBounds(2, 457, 1518, 313);
		contentPane.add(pnlListProduct);
		pnlListProduct.setLayout(null);

		Box bQuanLiProduct;
		pnlListProduct.add(bQuanLiProduct = Box.createHorizontalBox());

		JLabel lblTimKiem = new JLabel("T??m ki???m: ");
		lblTimKiem.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblTimKiem.setBounds(29, 10, 111, 45);
		pnlListProduct.add(lblTimKiem);

		txtSeach = new JTextField();
		txtSeach.setFont(new Font("Times New Roman", Font.BOLD, 22));
		txtSeach.setBounds(140, 20, 314, 30);
		pnlListProduct.add(txtSeach);
		txtSeach.setColumns(10);

		btnSearch = new JButton("T??m ki???m");
		btnSearch.setFont(new Font("Times New Roman", Font.BOLD, 22));
		btnSearch.setBounds(464, 20, 130, 30);
		pnlListProduct.add(btnSearch);
		
		
		String[] headers_NV = { "M?? s???n ph???m", "T??n s???n ph???m", "Lo???i s???n ph???m", "????n gi??", "S??? l?????ng", "Nh?? cung c???p",
				"T??nh tr???ng" };
		data_ModelProduct = new DefaultTableModel(headers_NV, 0);
		JScrollPane jScrollPane_Product;
		bQuanLiProduct.add(jScrollPane_Product = new JScrollPane(table_Product = new JTable(data_ModelProduct)));
		jScrollPane_Product.setBorder(BorderFactory.createTitledBorder("Danh s??ch s???n ph???m"));
		bQuanLiProduct.setBounds(5, 65, 1510, 240);

		updateTableProduct();

		table_Product.addMouseListener(this);
		btnHienBang.addActionListener(this);
		btnSave.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnXoaTrang.addActionListener(this);
		btnXoa.addActionListener(this);
		btnQuayLai.addActionListener(this);
		btnSearch.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object object = e.getSource();
		if (object.equals(btnQuayLai)) {
			dispose();
			new FrmHome().setVisible(true);
		} else if (object.equals(btnHienBang)) {
			DeleteTableProduct();
			updateTableProduct();
		} else if (object.equals(btnSave)) {
			try {
				saveAction();
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (object.equals(btnUpdate)) {
			try {
				Update_Action();
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (object.equals(btnXoaTrang)) {
			XoaTrang_Action();
		}
		else if (object.equals(btnXoa)) {
			try {
				delete_Action();
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if (object.equals(btnSearch)) {
			try {
				Seach_Action();
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}
	
	private void Seach_Action() throws RemoteException {
		if (txtSeach.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "B???n ch??a nh???p m?? t??m");
		} else {
			String id = txtSeach.getText().toString();
			Product product = productDao.getProduct(id);
			if (product!=null) {
				DeleteTableProduct();
				String rowProduct[] = { product.getIdProduct(), product.getName(), product.getType(),
						product.getPrice() + "", product.getAmount() + "", product.getSupplier(), product.getStatus() };
				data_ModelProduct.addRow(rowProduct);
			}
		}
	}

	private void delete_Action() throws RemoteException {
		int row = table_Product.getSelectedRow();
		if (row!=-1) {
			int confirm = JOptionPane.showConfirmDialog(this, "B???n c?? mu???n xo?? s???n ph???m n??y kh??ng?", "Ch?? ??",
					JOptionPane.YES_NO_OPTION);
			if (confirm == JOptionPane.YES_OPTION) {
				String id = table_Product.getValueAt(row, 0).toString();
				productDao.deleteProduct(id);
				data_ModelProduct.removeRow(row);
			}
		} else {
			JOptionPane.showMessageDialog(this, "B???n ch??a ch???n s???n ph???m c???n x??a");
		}
	}

	private void XoaTrang_Action() {
		txtMaSP.setText(null);
		txtTenSP.setText(null);
		txtSoLuong.setText(null);
		cmbLoai.setSelectedItem(null);
		txtDonGia.setText(null);
		txtNCC.setText(null);
		cmbTT.setSelectedItem(null);
		txtMaSP.requestFocus();
	}

	private void Update_Action() throws RemoteException {
		int row = table_Product.getSelectedRow();
		if (row != -1) {
			String maSP = table_Product.getValueAt(row, 0).toString();
			String tenSP = txtTenSP.getText().trim();
			String loai = cmbLoai.getSelectedItem().toString();
			double donGia = Double.parseDouble(txtDonGia.getText());
			int soLuong = Integer.parseInt(txtSoLuong.getText());
			String ncc = txtNCC.getText().trim();
			String hienTrang = cmbTT.getSelectedItem().toString();

			Product product = new Product(maSP, tenSP, loai, donGia, soLuong, ncc, hienTrang);
			if (valib_Data()) {
				if (productDao.updateProduct(product)) {
					JOptionPane.showMessageDialog(this, "C???p nh???t th??nh c??ng");
					table_Product.setValueAt(product.getName(), row, 1);
					table_Product.setValueAt(product.getType(), row, 2);
					table_Product.setValueAt(product.getPrice(), row, 3);
					table_Product.setValueAt(product.getAmount(), row, 4);
					table_Product.setValueAt(product.getSupplier(), row, 5);
					table_Product.setValueAt(product.getStatus(), row, 6);
				} else {
					JOptionPane.showMessageDialog(this, "C???p nh???t th???t b???i");
				}
			}
		} else {
			JOptionPane.showMessageDialog(this, "B???n ch??a ch???n s???n ph???m c???n c???p nh???t");
		}
	}

	private void saveAction() throws RemoteException {
		String maSP = txtMaSP.getText().trim();
		String tenSP = txtTenSP.getText().trim();
		String loai = cmbLoai.getSelectedItem().toString();
		double donGia = Double.parseDouble(txtDonGia.getText());
		int soLuong = Integer.parseInt(txtSoLuong.getText());
		String ncc = txtNCC.getText().trim();
		String hienTrang = "??ang kinh doanh";

		Product product = new Product(maSP, tenSP, loai, donGia, soLuong, ncc, hienTrang);
		if (valib_Data()) {
			if (productDao.createProduct(product)) {
				JOptionPane.showMessageDialog(this, "Th??m th??nh c??ng");
				String rowProduct[] = { product.getIdProduct(), product.getName(), product.getType(),
						product.getPrice() + "", product.getAmount() + "", product.getSupplier(), product.getStatus() };
				data_ModelProduct.addRow(rowProduct);
			} else {
				JOptionPane.showMessageDialog(this, "Th??m th???t b???i, m?? tr??ng");
			}
		}

	}

	private boolean valib_Data() {
		return true;
	}

	private void DeleteTableProduct() {
		DefaultTableModel dm = (DefaultTableModel) table_Product.getModel();
		dm.getDataVector().removeAllElements();

	}

	private void updateTableProduct() {
		try {
			products.clear();
			products = productDao.getProducts();
			for (Product product : products) {

				String rowProduct[] = { product.getIdProduct(), product.getName(), product.getType(),
						product.getPrice() + "", product.getAmount() + "", product.getSupplier(), product.getStatus() };
				data_ModelProduct.addRow(rowProduct);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		Object object = e.getSource();
		if (object.equals(table_Product)) {
			int row = table_Product.getSelectedRow();
			txtMaSP.setText(table_Product.getValueAt(row, 0).toString());
			txtTenSP.setText(table_Product.getValueAt(row, 1).toString());
			txtSoLuong.setText(table_Product.getValueAt(row, 4).toString());
			cmbLoai.setSelectedItem(table_Product.getValueAt(row, 2).toString());

			txtDonGia.setText(table_Product.getValueAt(row, 3).toString());
			txtNCC.setText(table_Product.getValueAt(row, 5).toString());
			cmbTT.setSelectedItem(table_Product.getValueAt(row, 6).toString());
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
