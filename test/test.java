/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import DAO.ChuyenDeDAO;
import DAO.HocVienDAO;
import DAO.KhoaHocDAO;
import DAO.NguoiHocDAO;
import DAO.NhanVienDAO;
import Helper.ConnectionDb;
import Model.ChuyenDe;
import Model.HocVien;
import Model.KhoaHoc;
import Model.NguoiHoc;
import Model.NhanVien;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author datdo
 */
public class test {

    public static void main(String[] args) throws SQLException {
        /*Test Function readResultSet*/
//        ChuyenDeDAO da = new ChuyenDeDAO();
//        NhanVienDAO dao = new NhanVienDAO();
//          List<ChuyenDe> list = new ArrayList<>();
//          List<NhanVien> list1 = new ArrayList<>();
//        ConnectionDb cndb = new ConnectionDb();
//        String sql = "Select * From NhanVien";
//        ResultSet rs = null;
//        rs = cndb.executeQuery(sql);
//        while(rs.next()){
//           list1.add(dao.readFormResultSet(rs));
//        }
//        for (NhanVien nv : list1) {
//            System.out.println(nv);
//        }

        /*Test Select */
 /*String sql = "Select * From ChuyenDe";
      List<ChuyenDe> list = new ArrayList<>();
      list = da.select(sql, args);
        for (ChuyenDe chuyenDe : list) {
            System.out.println(chuyenDe);
        }
         */
 /*Test findById*/
//    String id = "SER01";
//     List<ChuyenDe> list = new ArrayList<>();
//        System.out.println(da.findById(id));
//        Calendar cal = Calendar.getInstance();
//           Calendar cal2 = Calendar.getInstance();
//        java.util.Date date =  DateHelper.toDate("2003/12/05");
//          cal2.setTime(date);
//           System.out.println( LocalDate.now());
//           
//        int y = cal.get(cal.YEAR);
//        System.out.println(date);
//        System.out.println(cal2.get(cal2.YEAR));
//        System.out.println(2022- cal2.get(cal2.DAY_OF_YEAR));
//    }
// Định dạng thời gian
//        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
//
//        Calendar c1 = Calendar.getInstance();
//        Calendar c2 = Calendar.getInstance();
//
//        // Định nghĩa 2 mốc thời gian ban đầu
//        Date date1 = Date.valueOf("2011-06-15");
//        Date date2 = Date.valueOf("2011-07-30");
//
//        c1.setTime(date1);
//        c2.setTime(date2);
//
//        // Công thức tính số ngày giữa 2 mốc thời gian:
//        long noDay = (c2.getTime().getTime() - c1.getTime().getTime()) / (24 * 3600 * 1000);
//
//        System.out.print("Số ngày giữa " + dateFormat.format(c1.getTime())
//
//                + " và " + dateFormat.format(c2.getTime()) + ": ");
//
//        System.out.println(noDay);
//
//        
//        NguoiHocDAO dao = new NguoiHocDAO();
//        List<String> list = new ArrayList<>();
//        list = dao.allMaNguoiHoc();
//        for (String s : list) {
//            System.out.println(s);
//        }
//
//    }
//        NguoiHocDAO dao = new NguoiHocDAO();
//         List<NguoiHoc> list1 = new ArrayList<>();
//       ConnectionDb cndb = new ConnectionDb();
//        String sql = "Select * From NguoiHoc";
//        ResultSet rs = null;
//        rs = cndb.executeQuery(sql);
//        list1 = dao.select();
//        for (NguoiHoc nguoiHoc : list1) {
//            System.out.println(nguoiHoc);
//        }
//        ChuyenDeDAO d =new ChuyenDeDAO();
//        List<ChuyenDe> list = new ArrayList<>();
//        ResultSet rs = null;
//         list = d.select();
//         for (ChuyenDe cd : list) {
//             System.out.println(cd);
//        }
//        
//        KhoaHocDAO khDAO = new KhoaHocDAO();
//        ChuyenDe cd = new ChuyenDe("001", "java", 100000, 90, "ji", "123");
//        List<KhoaHoc> list = khDAO.selectByChuyenDe("JAV01");
//        for (KhoaHoc khoaHoc : list) {
//            System.out.println(khoaHoc);
//        }
//        HocVienDAO dao = new HocVienDAO();
//         List<HocVien> list = dao.selectByKhoaHoc(1);
//         for (HocVien hocVien : list) {
//             System.out.println(hocVien);
//            
//        }
//      HocVienDAO hvdao = new HocVienDAO();
//      Integer a = 2;
//      List<HocVien> list = hvdao.selectByKhoaHoc(a);
//        for (HocVien hocVien : list) {
//            System.out.println(hocVien);
//            
//        }
        ResultSet rs = null;
         String sql = "Select hv.*, nh.HoTen From HocVien hv "
                    + "inner join NguoiHoc nh on nh.MaNH = hv.MaNH Where MaKH =?";
            rs = ConnectionDb.executeQuery(sql, 10);
            while(rs.next()){
                System.out.println(rs);
            }
    }

}
