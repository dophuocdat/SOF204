/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Helper.ConnectionDb;
import Helper.UtilityHelper;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author datdo
 */
public class ThongKeDAO {

    /* return 1 <Object[]> list : Năm - số lượng - ngày người đầu tiên đk - ngày người cc đk*/
    public List<Object[]> getNguoiHoc() {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "{call sp_ThongKeNguoiHoc}";
                rs = ConnectionDb.executeQuery(sql);
                while (rs.next()) {
                    Object[] model = {
                        rs.getInt("Nam"),
                        rs.getInt("SoLuong"),
                        rs.getDate("DauTien"),
                        rs.getDate("CuoiCung")
                    };
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException e) {
            throw new RuntimeException();

        }
        return list;
    }

    /*@return <Object[]> list : mã NH - họ và tên - điểm - xếp loại*/
    public List<Object[]> getBangDiem(Integer makh) {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "{call sp_BangDiem(?)}";
                rs = ConnectionDb.executeQuery(sql, makh);
                while (rs.next()) {
                    Object[] model = {
                        rs.getString("MaNH"),
                        rs.getString("HoTen"),
                        rs.getDouble("Diem"),
                        UtilityHelper.getRank(rs.getDouble("Diem"))
                    };
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();

            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        return list;
    }

    /*    @return <Object[]> list : tên chuyên đề - số HV - điểm thấp nhất - điểm cao nhất - điểm trung bình*/
    public List<Object[]> getDiemTheoChuyenDe() {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "{call sp_ThongKeDiem}";
                rs = ConnectionDb.executeQuery(sql);
                while (rs.next()) {
                    Object[] model = {
                        rs.getString("ChuyenDe"),
                        rs.getInt("SoHV"),
                        rs.getDouble("ThapNhat"),
                        rs.getDouble("CaoNhat"),
                        rs.getFloat("TrungBinh")
                    };
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }

    /*    @return <Object[]> list : tên chuyên đề - số KH - số HV - doanh thu - HP cao nhất - HP thấp nhất - HP trung bình*/
    public List<Object[]> getDoanhThu(int nam) {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "{call sp_ThongKeDoanhThu (?)}";
                rs = ConnectionDb.executeQuery(sql, nam);
                while (rs.next()) {
                    Object[] model = {
                        rs.getString("ChuyenDe"),
                        rs.getInt("SoKH"),
                        rs.getInt("SoHV"),
                        rs.getDouble("DoanhThu"),
                        rs.getDouble("ThapNhat"),
                        rs.getDouble("CaoNhat"),
                        rs.getDouble("TrungBinh")
                    };
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public List<Integer> getNamKhaiGiang() {
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "select distinct year(NgayKG) as nam from KhoaHoc order by year(NgayKG) desc";
                rs = ConnectionDb.executeQuery(sql);
                while (rs.next()) {
                    int year = rs.getInt(1);
                    list.add(year);
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
