package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Container;

import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.hibernate.hql.ast.origin.hql.parse.HQLParser.new_key_return;
import org.hibernate.hql.ast.origin.hql.resolve.GeneratedHQLResolver.intermediateIndexOperation_return;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import dao.BillDao;
import dao.ProductBuyDao;
import dao.ProductDao;
import model.Bill;
import model.Employee;
import model.Product;
import model.ProductBuy;

import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Component;

public class FrmSell extends JFrame implements ActionListener, MouseListener {

	private JPanel contentPane;
	private DefaultTableModel data_ModelProduct;
	private JTable table_Product;
	private JTextField txtSeach;

	private Container pnlListProduct1;
	private Object btnExit;
	private JTextField txtTenKH;

	private ProductDao productDao;
	private BillDao billDao;
	private ProductBuyDao productBuyDao;
	
	private List<Product> products = new ArrayList<Product>();

	private List<ProductBuy> productBuys = new ArrayList<>();

	private JButton btnQuayLai;
	private JButton btnSearch;
	private JButton btnHienBang;
	private DefaultTableModel data_ModelProductBuy;
	private JTable table_ProductBuy;
	private JPanel pnlCTHD;
	private JTextField txtMaHD;
	private JButton btnLuuHoaDon;
	private JLabel lblTongTien;
	private JLabel lblMaNV;
	private JButton btnXoaTrang;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmSell frame = new FrmSell();
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
	public FrmSell() {
		SecurityManager securityManager = System.getSecurityManager();
		if (securityManager == null) {
			System.setProperty("java.security.policy", "rmi/policy.policy");
			System.setSecurityManager(new SecurityManager());
		}
		try {
			productDao = (ProductDao) Naming.lookup("rmi://localhost:1000/productDao");
			billDao = (BillDao) Naming.lookup("rmi://localhost:1000/billDao");
			productBuyDao = (ProductBuyDao) Naming.lookup("rmi://localhost:1000/productBuyDao");

		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		setTitle("Bán hàng");
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

		JLabel lblTittle = new JLabel("Bán hàng");
		lblTittle.setFont(new Font("Times New Roman", Font.BOLD, 35));
		lblTittle.setBounds(640, 10, 211, 40);
		pnlInfo.add(lblTittle);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(762, 80, 746, 227);
		pnlInfo.add(panel);
		panel.setLayout(null);

		Box bQuanLiNhanVien_1 = Box.createHorizontalBox();
		bQuanLiNhanVien_1.setBounds(10, 10, 726, 207);
		panel.add(bQuanLiNhanVien_1);

		String[] headers_SPBuy = { "Mã sản phẩm", "Tên sản phẩm", "Số lượng", "Đơn giá", "Thành tiền" };

		data_ModelProductBuy = new DefaultTableModel(headers_SPBuy, 0);
		JScrollPane jScrollPane_ProductBuy = new JScrollPane(table_ProductBuy = new JTable(data_ModelProductBuy));
		jScrollPane_ProductBuy.setBorder(BorderFactory.createTitledBorder("Danh sách sản phẩm mua"));
		bQuanLiNhanVien_1.add(jScrollPane_ProductBuy);

		JLabel lblNewLabel = new JLabel("Mã nhân viên: ");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setBounds(36, 138, 179, 35);
		pnlInfo.add(lblNewLabel);

		lblMaNV = new JLabel("");
		lblMaNV.setForeground(Color.RED);
		lblMaNV.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblMaNV.setBounds(238, 138, 454, 35);
		pnlInfo.add(lblMaNV);

		JLabel lblTnKhchHng = new JLabel("Tên khách hàng: ");
		lblTnKhchHng.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblTnKhchHng.setBounds(36, 209, 192, 35);
		pnlInfo.add(lblTnKhchHng);

		txtTenKH = new JTextField();
		txtTenKH.setFont(new Font("Times New Roman", Font.BOLD, 25));
		txtTenKH.setBounds(238, 208, 446, 35);
		pnlInfo.add(txtTenKH);
		txtTenKH.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Tổng tiền: ");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_2.setBounds(36, 272, 179, 35);
		pnlInfo.add(lblNewLabel_2);

		lblTongTien = new JLabel("VND");
		lblTongTien.setForeground(Color.RED);
		lblTongTien.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblTongTien.setBounds(238, 272, 454, 35);
		pnlInfo.add(lblTongTien);

		btnLuuHoaDon = new JButton("Lưu hóa đơn");
		btnLuuHoaDon.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnLuuHoaDon.setBounds(263, 352, 200, 40);
		pnlInfo.add(btnLuuHoaDon);

		JButton btnInHan = new JButton("In hóa đơn");
		btnInHan.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnInHan.setBounds(710, 352, 200, 40);
		pnlInfo.add(btnInHan);

		btnQuayLai = new JButton("Quay lại");
		btnQuayLai.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnQuayLai.setBounds(963, 352, 159, 40);
		pnlInfo.add(btnQuayLai);

		JLabel lblMHan = new JLabel("Mã hóa đơn: ");
		lblMHan.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblMHan.setBounds(36, 70, 170, 35);
		pnlInfo.add(lblMHan);

		txtMaHD = new JTextField();
		txtMaHD.setFont(new Font("Times New Roman", Font.BOLD, 25));
		txtMaHD.setColumns(10);
		txtMaHD.setBounds(238, 70, 446, 35);
		pnlInfo.add(txtMaHD);
		
		btnXoaTrang = new JButton("Xóa trắng");
		btnXoaTrang.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnXoaTrang.setBounds(499, 352, 170, 40);
		pnlInfo.add(btnXoaTrang);

		JPanel pnlListProduct = new JPanel();
		pnlListProduct.setBorder(UIManager.getBorder("ToolTip.border"));
		pnlListProduct.setBackground(SystemColor.inactiveCaptionBorder);
		pnlListProduct.setBounds(2, 457, 1518, 313);
		contentPane.add(pnlListProduct);
		pnlListProduct.setLayout(null);

		JLabel lblTimKiem = new JLabel("Tìm kiếm: ");
		lblTimKiem.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblTimKiem.setBounds(29, 10, 111, 45);
		pnlListProduct.add(lblTimKiem);

		txtSeach = new JTextField();
		txtSeach.setFont(new Font("Times New Roman", Font.BOLD, 22));
		txtSeach.setBounds(140, 20, 314, 30);
		pnlListProduct.add(txtSeach);
		txtSeach.setColumns(10);

		btnSearch = new JButton("Tìm kiếm");
		btnSearch.setFont(new Font("Times New Roman", Font.BOLD, 22));
		btnSearch.setBounds(464, 20, 130, 30);
		pnlListProduct.add(btnSearch);

		Box bDSProduct;
		pnlListProduct.add(bDSProduct = Box.createHorizontalBox());

		btnHienBang = new JButton("Hiện bảng");
		btnHienBang.setFont(new Font("Times New Roman", Font.BOLD, 22));
		btnHienBang.setBounds(616, 20, 160, 30);
		pnlListProduct.add(btnHienBang);

		String[] headers_NV = { "Mã sản phẩm", "Tên sản phẩm", "Loại sản phẩm", "Đơn giá", "Số lượng", "Nhà cung cấp",
				"Tình trạng" };
		data_ModelProduct = new DefaultTableModel(headers_NV, 0);
		JScrollPane jScrollPane_Product;
		bDSProduct.add(jScrollPane_Product = new JScrollPane(table_Product = new JTable(data_ModelProduct)));
		jScrollPane_Product.setBorder(BorderFactory.createTitledBorder("Danh sách sản phẩm"));
		bDSProduct.setBounds(5, 65, 1510, 240);
		
		lblMaNV.setText(FrmLogin.getIdUSER());

		updateTableProduct();
		table_Product.addMouseListener(this);

		btnQuayLai.addActionListener(this);
		btnSearch.addActionListener(this);
		btnHienBang.addActionListener(this);
		btnLuuHoaDon.addActionListener(this);
		btnXoaTrang.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object object = e.getSource();
		if (object.equals(btnQuayLai)) {
			dispose();
			new FrmHome().setVisible(true);
		} else if (object.equals(btnSearch)) {
			try {
				Seach_Action();
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (object.equals(btnHienBang)) {
			DeleteTableProduct();
			updateTableProduct();
		}
		else if (object.equals(btnLuuHoaDon)) {
			try {
				SaveBillAction();
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if (object.equals(btnXoaTrang)) {
			XoaTrang();
			DeleteTableProductBuy();
		}

	}
	
	private void DeleteTableProductBuy() {
		DefaultTableModel dm = (DefaultTableModel) table_ProductBuy.getModel();
		dm.getDataVector().removeAllElements();

	}
	private void XoaTrang() {
		txtMaHD.setText(null);
		txtTenKH.setText(null);
		lblTongTien.setText(null);
		txtMaHD.requestFocus();
		
	}
	
	private void SaveBillAction() throws RemoteException {
		String maHD = txtMaHD.getText().trim();
		String maNV = lblMaNV.getText();
		String tenKH = txtTenKH.getText().trim();
		LocalDate localDate = LocalDate.now();
		
		int ngay = localDate.getDayOfMonth();
		int thang = localDate.getMonthValue();
		int nam = localDate.getYear()-1900;
		
		Date ngayLapHD = new Date(nam, thang, ngay);
		
		double tongTien = updateSumMoney();
		
		Bill bill = new Bill(maHD, new Employee(maNV), tenKH, ngayLapHD, tongTien);
		if (productBuys.size()==0) {
			JOptionPane.showMessageDialog(this, "Bạn chưa nhập thông tin sản phẩm khách hàng mua!");
		} else {
			if (valibData()) {
				if (billDao.createBill(bill)) {
					JOptionPane.showMessageDialog(this, "Lưu thành công");
					for (ProductBuy productBuy : productBuys) {
						productBuy.setBill(bill);
						productBuy.setIdProductBuy(productBuy.getBill().getIdBill()+productBuy.getProduct().getIdProduct());
						productBuyDao.createProductBuy(productBuy);
					}
				} else {
					JOptionPane.showMessageDialog(this, "Lưu thất bại");
				}
			}
		}
		
	}
	
	private boolean valibData() {
		if (txtMaHD.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Bạn chưa nhập mã hóa đơn");
			return false;
		}
		return true;
	}

	private void chonSanPham() {
		SpinnerNumberModel sModel = new SpinnerNumberModel(0, 0, 100000, 1);

		pnlCTHD = new JPanel();
		pnlCTHD.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel jLabel = new JLabel("Số lượng: ");
		jLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		pnlCTHD.add(jLabel);

		JSpinner spinner = new JSpinner(sModel);
		spinner.setFont(new Font("Times New Roman", Font.BOLD, 20));
		pnlCTHD.add(spinner);

		int row = table_Product.getSelectedRow();
		int option = JOptionPane.showOptionDialog(null, pnlCTHD, "Chi tiết đơn hàng", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, null, null);

		if (option == JOptionPane.CANCEL_OPTION) {

		} else if (option == JOptionPane.OK_OPTION) {
			String maSP = table_Product.getValueAt(row, 0).toString();
			try {
				Product product = productDao.getProduct(maSP);
				int soLuong = Integer.parseInt(spinner.getValue().toString());
				ProductBuy productBuy = new ProductBuy(product, product.getName(), soLuong, product.getPrice());
				productBuys.add(productBuy);
				String[] rowSPB = { productBuy.getProduct().getIdProduct(), productBuy.getNameProduct(), soLuong + "",
						productBuy.getPrice() + "", productBuy.getMoney() + "" };
				data_ModelProductBuy.addRow(rowSPB);
				lblTongTien.setText(updateSumMoney()+"");
				
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
	private double updateSumMoney() {
		double sum =0;
		for (ProductBuy productBuy : productBuys) {
			sum = sum +productBuy.getMoney();
		}
		return sum;
	}

	private void Seach_Action() throws RemoteException {
		if (txtSeach.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Bạn chưa nhập mã tìm");
		} else {
			String id = txtSeach.getText().toString();
			Product product = productDao.getProduct(id);
			if (product != null) {
				DeleteTableProduct();
				String rowProduct[] = { product.getIdProduct(), product.getName(), product.getType(),
						product.getPrice() + "", product.getAmount() + "", product.getSupplier(), product.getStatus() };
				data_ModelProduct.addRow(rowProduct);
			}
		}
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
		Object object = e.getSource();
		if (object.equals(table_Product)) {
			chonSanPham();
			
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
