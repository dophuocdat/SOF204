/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import Helper.DialogHelper;
import Helper.imageHelper;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.Timer;

/**
 *
 * @author datdo
 */
public class Educational_System extends javax.swing.JFrame {

    /**
     * Creates new form Educational_System
     */
    public Educational_System() {
        initComponents();
        init();
    }

    private void init() {
        ImageIcon APP_ICON = new ImageIcon("D:\\SOF204\\Assignment\\src\\Icons\\fpt.png");
        setIconImage(APP_ICON.getImage());
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        new Timer(1000, new ActionListener() {
            SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");

            @Override
            public void actionPerformed(ActionEvent e) {
                jlbClock.setText(sdf.format(new Date()));
            }
        }).start();

        ScreenHello();
        Login();

    }

    private void ScreenHello() {
        new ScreenHello(this, true).setVisible(true);
    }

    private void Login() {
        for (JInternalFrame jif : jDesktopPanel.getAllFrames()) {
            jif.dispose();
        }
        new Login(this, true).setVisible(true);
    }

    private void logoff() {
        imageHelper.logout();
        openLogin();
    }

    private void openChuyenDe() {
        if (imageHelper.authenticated()) {
            QuanLyChuyenDe qlcd = new QuanLyChuyenDe();
            OpenX(qlcd);
        } else {
            DialogHelper.alert(this, "Vui lòng đăng nhập");
        }
    }

    private void OpenX(JInternalFrame x) {
        for (JInternalFrame jif : jDesktopPanel.getAllFrames()) {
            jif.dispose();
        }
        int ScreenW = this.getWidth();
        int ScreenH = this.getHeight();
        int desktopH = jDesktopPanel.getHeight();
//        System.out.println(ScreenW);
//        System.out.println(ScreenH);
//        System.out.println(jDesktopPanel.getHeight());
        x.setLocation((ScreenW / 2 - x.getWidth() / 2), (desktopH / 2 - x.getHeight() / 2));
        jDesktopPanel.add(x);
        x.setVisible(true);
    }

    public void openNguoiHoc() {
        if (imageHelper.authenticated()) {
            QuanLyNguoiHoc qlnh = new QuanLyNguoiHoc();
            OpenX(qlnh);
        } else {
            DialogHelper.alert(this, "Vui lòng đăng nhập");
        }
    }

    public void openKhoaHoc() {
        if (imageHelper.authenticated()) {
            QuanLyKhoaHoc qlkh = new QuanLyKhoaHoc();
            OpenX(qlkh);
        } else {
            DialogHelper.alert(this, "Vui lòng đăng nhập");
        }
    }

    private void openNhanVien() {
        if (imageHelper.authenticated()) {
            QuanLyNhanVien qlnv = new QuanLyNhanVien();
            OpenX(qlnv);
        } else {
            DialogHelper.alert(this, "Vui lòng đăng nhập");
        }
    }

    private void openThongKe(int index) {
        if (imageHelper.authenticated()) {
            QuanLyThongKe qltk = new QuanLyThongKe(index);
            OpenX(qltk);
        } else {
            DialogHelper.alert(this, "Vui lòng đăng nhập!");
        }
    }

    private void openLogin() {
        for (JInternalFrame frmchild : jDesktopPanel.getAllFrames()) {
            frmchild.dispose();
        }
        new Login(this, true).setVisible(true);
    }

    private void openAbout() {
        new AboutUs(this, true).setVisible(true);
    }

    public static void openWebPage(String url) {
        try {
            Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
            if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
                desktop.browse(new URI(url));
            }

            throw new NullPointerException();
        } catch (IOException | NullPointerException | URISyntaxException e) {

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupMenu = new javax.swing.JPopupMenu();
        ChuyenDe = new javax.swing.JMenuItem();
        KhoaHoc = new javax.swing.JMenuItem();
        NguoiHoc = new javax.swing.JMenuItem();
        DangXuat = new javax.swing.JMenuItem();
        jToolBar1 = new javax.swing.JToolBar();
        jbtLogOut = new javax.swing.JButton();
        jbtExit = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JToolBar.Separator();
        jbtChuyenDe = new javax.swing.JButton();
        jbtKhoaHoc = new javax.swing.JButton();
        jbtNguoiHoc = new javax.swing.JButton();
        jSeparator8 = new javax.swing.JToolBar.Separator();
        jbtHuongDan = new javax.swing.JButton();
        jDesktopPanel = new javax.swing.JDesktopPane();
        jlbClock = new javax.swing.JLabel();
        jlbInfo = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jmnLogin = new javax.swing.JMenuItem();
        jmnLogOut = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jmnChange_pw = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jmnExit = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jmnNguoiHoc = new javax.swing.JMenuItem();
        jmnChuyenDe = new javax.swing.JMenuItem();
        jmnKhoaHoc = new javax.swing.JMenuItem();
        jmn_empManager = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jmnNguoiHocNam = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jmnBangDiemKhoa = new javax.swing.JMenuItem();
        jmnDiemtungkhoahoc = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        jmnDoanhThuChuyenDe = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jmnHuongDanSuDung = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        jmnGioiThieuSanPham = new javax.swing.JMenuItem();

        ChuyenDe.setText("Chuyên Đề");
        popupMenu.add(ChuyenDe);

        KhoaHoc.setText("Khóa học");
        popupMenu.add(KhoaHoc);

        NguoiHoc.setText("Người học");
        popupMenu.add(NguoiHoc);

        DangXuat.setText("Đăng Xuất");
        popupMenu.add(DangXuat);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Educational System");

        jToolBar1.setRollover(true);

        jbtLogOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Exit.png"))); // NOI18N
        jbtLogOut.setText("Đăng xuất");
        jbtLogOut.setFocusable(false);
        jbtLogOut.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtLogOut.setPreferredSize(new java.awt.Dimension(90, 70));
        jbtLogOut.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbtLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtLogOutActionPerformed(evt);
            }
        });
        jToolBar1.add(jbtLogOut);

        jbtExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Stop.png"))); // NOI18N
        jbtExit.setText("Kết thúc");
        jbtExit.setFocusable(false);
        jbtExit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtExit.setPreferredSize(new java.awt.Dimension(90, 70));
        jbtExit.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbtExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtExitActionPerformed(evt);
            }
        });
        jToolBar1.add(jbtExit);
        jToolBar1.add(jSeparator6);

        jbtChuyenDe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Lists.png"))); // NOI18N
        jbtChuyenDe.setText("Chuyên đề");
        jbtChuyenDe.setFocusable(false);
        jbtChuyenDe.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtChuyenDe.setPreferredSize(new java.awt.Dimension(90, 70));
        jbtChuyenDe.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbtChuyenDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtChuyenDeActionPerformed(evt);
            }
        });
        jToolBar1.add(jbtChuyenDe);

        jbtKhoaHoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Certificate.png"))); // NOI18N
        jbtKhoaHoc.setText("Khóa học");
        jbtKhoaHoc.setFocusable(false);
        jbtKhoaHoc.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtKhoaHoc.setPreferredSize(new java.awt.Dimension(90, 70));
        jbtKhoaHoc.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbtKhoaHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtKhoaHocActionPerformed(evt);
            }
        });
        jToolBar1.add(jbtKhoaHoc);

        jbtNguoiHoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Conference.png"))); // NOI18N
        jbtNguoiHoc.setText("Người học");
        jbtNguoiHoc.setFocusable(false);
        jbtNguoiHoc.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtNguoiHoc.setPreferredSize(new java.awt.Dimension(90, 70));
        jbtNguoiHoc.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbtNguoiHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtNguoiHocActionPerformed(evt);
            }
        });
        jToolBar1.add(jbtNguoiHoc);
        jToolBar1.add(jSeparator8);

        jbtHuongDan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Globe.png"))); // NOI18N
        jbtHuongDan.setText("Hướng dẫn");
        jbtHuongDan.setFocusable(false);
        jbtHuongDan.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtHuongDan.setPreferredSize(new java.awt.Dimension(90, 70));
        jbtHuongDan.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbtHuongDan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtHuongDanActionPerformed(evt);
            }
        });
        jToolBar1.add(jbtHuongDan);

        jDesktopPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jDesktopPanelMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jDesktopPanelLayout = new javax.swing.GroupLayout(jDesktopPanel);
        jDesktopPanel.setLayout(jDesktopPanelLayout);
        jDesktopPanelLayout.setHorizontalGroup(
            jDesktopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jDesktopPanelLayout.setVerticalGroup(
            jDesktopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 301, Short.MAX_VALUE)
        );

        jlbClock.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Alarm.png"))); // NOI18N
        jlbClock.setText("2:21 Am");

        jlbInfo.setForeground(new java.awt.Color(51, 51, 255));
        jlbInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Info.png"))); // NOI18N
        jlbInfo.setText("Hệ thống quản lý đào tạo");

        jMenuBar1.setName(""); // NOI18N

        jMenu1.setText("Hệ thống");
        jMenu1.setMargin(new java.awt.Insets(5, 5, 5, 5));

        jmnLogin.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jmnLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Key.png"))); // NOI18N
        jmnLogin.setText("Đăng Nhập");
        jmnLogin.setMargin(new java.awt.Insets(5, 5, 5, 5));
        jmnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnLoginActionPerformed(evt);
            }
        });
        jMenu1.add(jmnLogin);

        jmnLogOut.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jmnLogOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Exit.png"))); // NOI18N
        jmnLogOut.setText("Đăng Xuất");
        jmnLogOut.setMargin(new java.awt.Insets(5, 5, 5, 5));
        jmnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnLogOutActionPerformed(evt);
            }
        });
        jMenu1.add(jmnLogOut);
        jMenu1.add(jSeparator1);

        jmnChange_pw.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_K, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jmnChange_pw.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Refresh.png"))); // NOI18N
        jmnChange_pw.setText("Đổi mật khẩu");
        jmnChange_pw.setMargin(new java.awt.Insets(5, 5, 5, 5));
        jmnChange_pw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnChange_pwActionPerformed(evt);
            }
        });
        jMenu1.add(jmnChange_pw);
        jMenu1.add(jSeparator2);

        jmnExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jmnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Stop.png"))); // NOI18N
        jmnExit.setText("Thoát");
        jmnExit.setMargin(new java.awt.Insets(5, 5, 5, 5));
        jmnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnExitActionPerformed(evt);
            }
        });
        jMenu1.add(jmnExit);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Quản lý");
        jMenu2.setMargin(new java.awt.Insets(5, 5, 5, 5));

        jmnNguoiHoc.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_1, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jmnNguoiHoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Conference.png"))); // NOI18N
        jmnNguoiHoc.setText("Người học");
        jmnNguoiHoc.setMargin(new java.awt.Insets(5, 5, 5, 5));
        jmnNguoiHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnNguoiHocActionPerformed(evt);
            }
        });
        jMenu2.add(jmnNguoiHoc);

        jmnChuyenDe.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_2, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jmnChuyenDe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Lists.png"))); // NOI18N
        jmnChuyenDe.setText("Chuyên đề");
        jmnChuyenDe.setMargin(new java.awt.Insets(5, 5, 5, 5));
        jmnChuyenDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnChuyenDeActionPerformed(evt);
            }
        });
        jMenu2.add(jmnChuyenDe);

        jmnKhoaHoc.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_3, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jmnKhoaHoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Certificate.png"))); // NOI18N
        jmnKhoaHoc.setText("Khóa học");
        jmnKhoaHoc.setMargin(new java.awt.Insets(5, 5, 5, 5));
        jmnKhoaHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnKhoaHocActionPerformed(evt);
            }
        });
        jMenu2.add(jmnKhoaHoc);

        jmn_empManager.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_4, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jmn_empManager.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Usergroup.png"))); // NOI18N
        jmn_empManager.setText("Quản lý nhân viên");
        jmn_empManager.setMargin(new java.awt.Insets(5, 5, 5, 5));
        jmn_empManager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmn_empManagerActionPerformed(evt);
            }
        });
        jMenu2.add(jmn_empManager);

        jMenuBar1.add(jMenu2);

        jMenu4.setText("Thống kê");
        jMenu4.setMargin(new java.awt.Insets(5, 5, 5, 5));

        jmnNguoiHocNam.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_1, java.awt.event.InputEvent.ALT_DOWN_MASK));
        jmnNguoiHocNam.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Clien list.png"))); // NOI18N
        jmnNguoiHocNam.setText("Người học từng năm");
        jmnNguoiHocNam.setMargin(new java.awt.Insets(5, 5, 5, 5));
        jmnNguoiHocNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnNguoiHocNamActionPerformed(evt);
            }
        });
        jMenu4.add(jmnNguoiHocNam);
        jMenu4.add(jSeparator3);

        jmnBangDiemKhoa.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_2, java.awt.event.InputEvent.ALT_DOWN_MASK));
        jmnBangDiemKhoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Card file.png"))); // NOI18N
        jmnBangDiemKhoa.setText("Bảng điểm khóa");
        jmnBangDiemKhoa.setMargin(new java.awt.Insets(5, 5, 5, 5));
        jmnBangDiemKhoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnBangDiemKhoaActionPerformed(evt);
            }
        });
        jMenu4.add(jmnBangDiemKhoa);

        jmnDiemtungkhoahoc.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_3, java.awt.event.InputEvent.ALT_DOWN_MASK));
        jmnDiemtungkhoahoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Bar chart.png"))); // NOI18N
        jmnDiemtungkhoahoc.setText("Điểm từng khóa học");
        jmnDiemtungkhoahoc.setMargin(new java.awt.Insets(5, 5, 5, 5));
        jmnDiemtungkhoahoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnDiemtungkhoahocActionPerformed(evt);
            }
        });
        jMenu4.add(jmnDiemtungkhoahoc);
        jMenu4.add(jSeparator4);

        jmnDoanhThuChuyenDe.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_4, java.awt.event.InputEvent.ALT_DOWN_MASK));
        jmnDoanhThuChuyenDe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Dollar.png"))); // NOI18N
        jmnDoanhThuChuyenDe.setText("Doanh thu từng chuyên đề");
        jmnDoanhThuChuyenDe.setMargin(new java.awt.Insets(5, 5, 5, 5));
        jmnDoanhThuChuyenDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnDoanhThuChuyenDeActionPerformed(evt);
            }
        });
        jMenu4.add(jmnDoanhThuChuyenDe);

        jMenuBar1.add(jMenu4);

        jMenu6.setText("Trợ giúp");
        jMenu6.setMargin(new java.awt.Insets(5, 5, 5, 5));

        jmnHuongDanSuDung.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        jmnHuongDanSuDung.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Globe.png"))); // NOI18N
        jmnHuongDanSuDung.setText("Hướng dẫn sử dụng");
        jmnHuongDanSuDung.setMargin(new java.awt.Insets(5, 5, 5, 5));
        jmnHuongDanSuDung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnHuongDanSuDungActionPerformed(evt);
            }
        });
        jMenu6.add(jmnHuongDanSuDung);
        jMenu6.add(jSeparator5);

        jmnGioiThieuSanPham.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        jmnGioiThieuSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Brick house.png"))); // NOI18N
        jmnGioiThieuSanPham.setText("Giới thiệu sản phẩm");
        jmnGioiThieuSanPham.setMargin(new java.awt.Insets(5, 5, 5, 5));
        jmnGioiThieuSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnGioiThieuSanPhamActionPerformed(evt);
            }
        });
        jMenu6.add(jmnGioiThieuSanPham);

        jMenuBar1.add(jMenu6);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 673, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jDesktopPanel)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlbInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jlbClock, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDesktopPanel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbClock)
                    .addComponent(jlbInfo))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmnChange_pwActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnChange_pwActionPerformed
        // TODO add your handling code here:
        if (imageHelper.authenticated()) {
            new DoiMatKhau(this, true).setVisible(true);
        } else {
            DialogHelper.alert(this, "Vui lòng đăng nhập trước khi đổi mật khẩu!");
        }

    }//GEN-LAST:event_jmnChange_pwActionPerformed

    private void jmnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnExitActionPerformed
        // TODO add your handling code here:
        if (DialogHelper.confirm(this, "Bạn có muốn thoát khỏi chương trình.")) {
            System.exit(0);
        }
    }//GEN-LAST:event_jmnExitActionPerformed

    private void jmnNguoiHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnNguoiHocActionPerformed
        openNguoiHoc();
    }//GEN-LAST:event_jmnNguoiHocActionPerformed

    private void jmnChuyenDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnChuyenDeActionPerformed
        // TODO add your handling code here:
        openChuyenDe();
    }//GEN-LAST:event_jmnChuyenDeActionPerformed

    private void jmnKhoaHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnKhoaHocActionPerformed
        openKhoaHoc();
    }//GEN-LAST:event_jmnKhoaHocActionPerformed

    private void jmnNguoiHocNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnNguoiHocNamActionPerformed
        // TODO add your handling code here:
        openThongKe(0);
    }//GEN-LAST:event_jmnNguoiHocNamActionPerformed

    private void jmnBangDiemKhoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnBangDiemKhoaActionPerformed
        // TODO add your handling code here:
        openThongKe(1);
    }//GEN-LAST:event_jmnBangDiemKhoaActionPerformed

    private void jmnDiemtungkhoahocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnDiemtungkhoahocActionPerformed
        // TODO add your handling code here:
        openThongKe(2);
    }//GEN-LAST:event_jmnDiemtungkhoahocActionPerformed

    private void jmnDoanhThuChuyenDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnDoanhThuChuyenDeActionPerformed
        // TODO add your handling code here:
        openThongKe(3);

    }//GEN-LAST:event_jmnDoanhThuChuyenDeActionPerformed

    private void jmnHuongDanSuDungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnHuongDanSuDungActionPerformed
        // TODO add your handling code here:
        openWebPage("https://ap.poly.edu.vn/");
    }//GEN-LAST:event_jmnHuongDanSuDungActionPerformed

    private void jmnGioiThieuSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnGioiThieuSanPhamActionPerformed
        // TODO add your handling code here:
        openAbout();
    }//GEN-LAST:event_jmnGioiThieuSanPhamActionPerformed

    private void jbtLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtLogOutActionPerformed
        // TODO add your handling code here:'
        logoff();
    }//GEN-LAST:event_jbtLogOutActionPerformed

    private void jmnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnLoginActionPerformed
        // TODO add your handling code here:
        openLogin();
    }//GEN-LAST:event_jmnLoginActionPerformed

    private void jmnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnLogOutActionPerformed
        // TODO add your handling code here:
        logoff();
    }//GEN-LAST:event_jmnLogOutActionPerformed

    private void jmn_empManagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmn_empManagerActionPerformed
        // TODO add your handling code here:
        openNhanVien();
    }//GEN-LAST:event_jmn_empManagerActionPerformed

    private void jbtExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtExitActionPerformed
        // TODO add your handling code here:
        if (DialogHelper.confirm(this, "Bạn có muốn thoát khỏi chương trình.")) {
            System.exit(0);
        }
    }//GEN-LAST:event_jbtExitActionPerformed

    private void jbtChuyenDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtChuyenDeActionPerformed
        // TODO add your handling code here:
        openChuyenDe();
    }//GEN-LAST:event_jbtChuyenDeActionPerformed

    private void jbtKhoaHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtKhoaHocActionPerformed
        // TODO add your handling code here:
        openKhoaHoc();
    }//GEN-LAST:event_jbtKhoaHocActionPerformed

    private void jbtNguoiHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtNguoiHocActionPerformed
        // TODO add your handling code here:
        openNguoiHoc();
    }//GEN-LAST:event_jbtNguoiHocActionPerformed

    private void jDesktopPanelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDesktopPanelMouseReleased
        // TODO add your handling code here:
        if (evt.isPopupTrigger()) {
            popupMenu.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_jDesktopPanelMouseReleased

    private void jbtHuongDanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtHuongDanActionPerformed
        openWebPage("https://ap.poly.edu.vn/");
    }//GEN-LAST:event_jbtHuongDanActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Educational_System.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Educational_System.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Educational_System.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Educational_System.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Educational_System().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem ChuyenDe;
    private javax.swing.JMenuItem DangXuat;
    private javax.swing.JMenuItem KhoaHoc;
    private javax.swing.JMenuItem NguoiHoc;
    private javax.swing.JDesktopPane jDesktopPanel;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JToolBar.Separator jSeparator6;
    private javax.swing.JToolBar.Separator jSeparator8;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JButton jbtChuyenDe;
    private javax.swing.JButton jbtExit;
    private javax.swing.JButton jbtHuongDan;
    private javax.swing.JButton jbtKhoaHoc;
    private javax.swing.JButton jbtLogOut;
    private javax.swing.JButton jbtNguoiHoc;
    private javax.swing.JLabel jlbClock;
    private javax.swing.JLabel jlbInfo;
    private javax.swing.JMenuItem jmnBangDiemKhoa;
    private javax.swing.JMenuItem jmnChange_pw;
    private javax.swing.JMenuItem jmnChuyenDe;
    private javax.swing.JMenuItem jmnDiemtungkhoahoc;
    private javax.swing.JMenuItem jmnDoanhThuChuyenDe;
    private javax.swing.JMenuItem jmnExit;
    private javax.swing.JMenuItem jmnGioiThieuSanPham;
    private javax.swing.JMenuItem jmnHuongDanSuDung;
    private javax.swing.JMenuItem jmnKhoaHoc;
    private javax.swing.JMenuItem jmnLogOut;
    private javax.swing.JMenuItem jmnLogin;
    private javax.swing.JMenuItem jmnNguoiHoc;
    private javax.swing.JMenuItem jmnNguoiHocNam;
    private javax.swing.JMenuItem jmn_empManager;
    private javax.swing.JPopupMenu popupMenu;
    // End of variables declaration//GEN-END:variables
}
