/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Helper.ConnectionDb;
import java.sql.*;
import Model.NhanVien;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author datdo
 */
public class NhanVienDAO {

    // llay bang ghi nhan vien
    public NhanVien readFormResultSet(ResultSet rs) throws SQLException {
        NhanVien model = new NhanVien();
        model.setMaNV(rs.getString("MaNV"));
        model.setMatKhau(rs.getString("MatKhau"));
        model.setHoTen(rs.getString("HoTen"));
        model.setVaiTro(rs.getBoolean("VaiTro"));
        return model;
    }

    //truy van 
    public List<NhanVien> select(String sql, Object...args) {
        List<NhanVien> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = ConnectionDb.executeQuery(sql,args);
                while (rs.next()) {
                    list.add(readFormResultSet(rs));
                }
            } finally {
                //close connecton
                rs.getStatement().getConnection().close();

            }
        } catch (SQLException ex) {
            throw new RuntimeException();
        }
        return list;
    }

    // them nhan vien
    public void insert(NhanVien nv) {
        String sql = "INSERT INTO NhanVien (MaNV, MatKhau, HoTen, VaiTro) VALUES (?, ?, ?, ?)";
        ConnectionDb.executeUpdate(sql,
                //object
                nv.getMaNV(),
                nv.getMatKhau(),
                nv.getHoTen(),
                nv.isVaiTro());
    }

    /// cap nhat nhanvien
    public void update(NhanVien nv) {
        String sql = "UPDATE NhanVien SET MatKhau=?, HoTen=?, VaiTro=? WHERE MaNV=?";
        ConnectionDb.executeUpdate(sql,
                nv.getMatKhau(),
                nv.getHoTen(),
                nv.isVaiTro(),
                nv.getMaNV());
    }

    // xoa nhanVien
    public void delete(String maNV) {
        String sql = "delete form NhanVien where MaNV = ?";
        ConnectionDb.executeUpdate(sql, maNV);
    }

    // lay danh sach nhan vien
    public List<NhanVien> select() {
        String sql = "select * from NhanVien";
        return select(sql);
    }

    // finbyID
    public NhanVien findById(String id) {
        String sql = "select  * from NhanVien where MaNV =?";
        List<NhanVien> list = select(sql, id);
        return list.size() > 0 ? list.get(0) : null;
    }
}
