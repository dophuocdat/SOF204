/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Helper.ConnectionDb;
import Model.NguoiHoc;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author datdo
 */
public class NguoiHocDAO {

    private NguoiHoc readFromResultSet(ResultSet rs) throws SQLException {
         NguoiHoc entity=new NguoiHoc();
        try {
         entity.setMaNH(rs.getString("MaNH"));
         entity.setHoTen(rs.getString("HoTen"));
         entity.setNgaySinh(rs.getDate("NgaySinh"));
         entity.setGioiTinh(rs.getBoolean("GioiTinh"));
         entity.setDienThoai(rs.getString("DienThoai"));
         entity.setEmail(rs.getString("Email"));
         entity.setGhiChu(rs.getString("GhiChu"));
         entity.setMaNV(rs.getString("MaNV"));
         entity.setNgayDK(rs.getDate("NgayDK"));
         
        } catch (Exception e) {
            e.printStackTrace();
        }
        return entity;
    }

    private List<NguoiHoc> select(String sql, Object... args) {
        List<NguoiHoc> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = ConnectionDb.executeQuery(sql, args);
                while (rs.next()) {
                    list.add(readFromResultSet(rs));
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);

        }
        return list;
    }

    public void insert(NguoiHoc hv) {
        String sql = "INSERT INTO NguoiHoc (MaNH, HoTen, NgaySinh, GioiTinh, DienThoai, Email, GhiChu, MaNV) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        ConnectionDb.executeUpdate(sql,
                hv.getMaNH(),
                hv.getHoTen(),
                hv.getNgaySinh(),
                hv.isGioiTinh(),
                hv.getDienThoai(),
                hv.getEmail(),
                hv.getGhiChu(),
                hv.getMaNV()
        );
    }

    public void update(NguoiHoc model) {
        String sql = "UPDATE NguoiHoc SET HoTen=?, NgaySinh=?, GioiTinh=?, DienThoai=?, Email=?, GhiChu=?,MaNV=? WHERE MaNH=?";
        ConnectionDb.executeUpdate(sql,
                model.getHoTen(),
                model.getNgaySinh(),
                model.isGioiTinh(),
                model.getDienThoai(),
                model.getEmail(),
                model.getGhiChu(),
                model.getMaNV(),
                model.getMaNH());
    }

    // Xóa bảng ghi khoi CSDL
    public void delete(String id) {
        String sql = "Delete from NguoiHoc where MaNH=?";
        ConnectionDb.executeUpdate(sql, id);
    }

    public List<NguoiHoc> select() {
        String sql = "Select * from NguoiHoc";
        return select(sql);
    }

    // truy van nguoi hoc theo keyword
    public List<NguoiHoc> selectByKeyWord(String key) {
        String sql = "Select * from NguoiHoc where HoTen like ?";
        return select(sql, "%" + key + "%");
    }

    // truy xuat tat ca hoc vien khong hoc khoa hoc maKH
    public List<NguoiHoc> selectByCourse(Integer makh, String keyWord) {
        String sql = "Select * from NguoiHoc where HoTen Like ? And MaNH not in (Select MaNH from HocVien where MaKH =?)";
        return select(sql,"%"+keyWord+"%",makh);
    }
    
    // truy van nguoi hoc theo maNH
    public NguoiHoc findById(String manh){
        String sql ="Select * from NguoiHoc where MaNH = ?";
        List<NguoiHoc> list = select(sql, manh);
        return list.size()>0?list.get(0):null;
    }
    
     public List allMaNguoiHoc(){
        List<String> list = new ArrayList<>();
         try {
            ResultSet rs = null;
            try {
                String sql = "select MaNH from NguoiHoc";
                rs = ConnectionDb.executeQuery(sql);
                while (rs.next()) {
                   list.add(rs.getString("MaNH"));
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return list;
    }
}

