/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Helper.ConnectionDb;
import Model.KhoaHoc;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author datdo
 */
public class KhoaHocDAO {

    // đoc từ 1 bản ghi 
    public KhoaHoc readFromResultSet(ResultSet rs) throws SQLException {
        KhoaHoc model = new KhoaHoc();
        model.setMaKH(rs.getInt("MaKH"));
        model.setHocPhi(rs.getDouble("HocPhi"));
        model.setThoiLuong(rs.getInt("ThoiLuong"));
        model.setNgayKG(rs.getDate("NgayKG"));
        model.setGhiChu(rs.getString("GhiChu"));
        model.setMaNV(rs.getString("MaNV"));
        model.setNgayTao(rs.getDate("NgayTao"));
        model.setMaCD(rs.getString("MaCD"));
        return model;
    }

    // truy van lay rs
    public List<KhoaHoc> select(String sql, Object... args) {
        List<KhoaHoc> list = new ArrayList<>();
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
        } catch (SQLException e) {
            throw new RuntimeException();

        }
        return list;
    }

    public void insert(KhoaHoc model) {
        String sql = "INSERT INTO KhoaHoc (MaCD, HocPhi, ThoiLuong, NgayKG, GhiChu, MaNV) VALUES (?, ?, ?, ?, ?, ?)";
        ConnectionDb.executeUpdate(sql,
                model.getMaCD(),
                model.getHocPhi(),
                model.getThoiLuong(),
                model.getNgayKG(),
                model.getGhiChu(),
                model.getMaNV());
    }

    public void update(KhoaHoc model) {
        String sql = "UPDATE KhoaHoc SET MaCD=?, HocPhi=?, ThoiLuong=?, NgayKG=?, GhiChu=?, MaNV=? WHERE MaKH=?";
        ConnectionDb.executeUpdate(sql,
                model.getMaCD(),
                model.getHocPhi(),
                model.getThoiLuong(),
                model.getNgayKG(),
                model.getGhiChu(),
                model.getMaNV(),
                model.getMaKH());
    }

    public void delete(Integer MaKH) {
        String sql = "Delete from KhoaHoc Where MaKH=?";
        ConnectionDb.executeUpdate(sql, MaKH);
    }

    public List<KhoaHoc> select() {
        String sql = "select * from KhoaHoc";
        return select(sql);
    }

    public KhoaHoc findById(Integer maKH) {
        String sql = "Select * from KhoaHoc Where MaKH=?";
        List<KhoaHoc> list = select(sql, maKH);
        return list.size() > 0 ? list.get(0) : null;
    }

    public List<KhoaHoc> selectByChuyenDe(String maCD) throws SQLException {
        String sql = "select * from KhoaHoc where MaCD=?";
      
        return select(sql, maCD);
    }
}
