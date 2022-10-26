/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Helper.ConnectionDb;
import Model.ChuyenDe;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.QuanLyKhoaHoc;

/**
 *
 * @author datdo
 */
public class ChuyenDeDAO {

    /*sua private lai*/
    public ChuyenDe readResulSet(ResultSet rs) throws SQLException {
        ChuyenDe CD = new ChuyenDe();
        CD.setMaCD(rs.getString("MaCD"));
        CD.setHinh(rs.getString("Hinh"));
        CD.setHocPhi(rs.getDouble("HocPhi"));
        CD.setMoTa(rs.getString("MoTa"));
        CD.setTenCD(rs.getString("TenCD"));
        CD.setThoiLuong(rs.getInt("ThoiLuong"));
        return CD;
    }

    public List<ChuyenDe> select(String sql, Object... args) {
        List<ChuyenDe> list = new ArrayList<>();
        ResultSet rs = null;
        try {
            try {
                rs = ConnectionDb.executeQuery(sql, args);
                while (rs.next()) {
                    list.add(readResulSet(rs));
                }
            } finally {
                rs.getStatement().getConnection().close();
            }

        } catch (SQLException ex) {
            throw new RuntimeException();
        }
        return list;
    }

    public void insert(ChuyenDe cd) {
        String sql = "INSERT INTO ChuyenDe (MaCD, TenCD, HocPhi, ThoiLuong, Hinh, MoTa) VALUES (?, ?, ?, ?, ?, ?)";
        ConnectionDb.executeUpdate(sql,
                cd.getMaCD(),
                cd.getTenCD(),
                cd.getHocPhi(),
                cd.getThoiLuong(),
                cd.getHinh(),
                cd.getMoTa()
        );
    }

    public void update(ChuyenDe cd) {
        String sql = "UPDATE ChuyenDe SET TenCD=?, HocPhi=?, ThoiLuong=?, Hinh=?, MoTa=? WHERE MaCD=?";
        ConnectionDb.executeUpdate(sql,
                cd.getTenCD(),
                cd.getHocPhi(),
                cd.getThoiLuong(),
                cd.getHinh(),
                cd.getMoTa(),
                cd.getMaCD()
        );
    }

//    public void delete(String id) {
//        String sql = "DELETE FROM ChuyenDe WHERE MaCD=?";
//        String sqlCall = "{call DeleteCD (?)}";
//        ConnectionDb.executeUpdate(sqlCall, id);
//    }
    
    public boolean delete(String id){
          String sqlCall = "{call DeleteCD (?)}";
           String sql = "DELETE FROM ChuyenDe WHERE MaCD=?";
        return ConnectionDb.executeUpdateDelete(sql, id);
    }

    public List<ChuyenDe> select() {
        String sql = "SELECT * FROM ChuyenDe";
        return select(sql); // return LIst
    }

    public ChuyenDe findById(String id) {
        String sql = "SELECT * FROM ChuyenDe WHERE MaCD=?";
        List<ChuyenDe> list = select(sql, id);
        return list.size() > 0 ? list.get(0) : null;
    }
}
