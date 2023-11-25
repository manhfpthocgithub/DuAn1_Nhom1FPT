/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.KhachHang;
import Utils.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class KhachHangDAO extends DuAn1DAO<KhachHang, Integer> {

    final String INSERT_SQL = "INSERT INTO tblKhachHang(TenKhachHang,LoaiKhachHang,GioiTinhKH,NgaySinhKH,SoDienThoaiKH,EmailKH,DiaChiKH,TrangThaiKH,GhiChuKH)\n"
            + "VALUES (?,?,?,?,?,?,?,?,?)";
    final String UPDATE_SQL = "UPDATE tblKhachHang SET TenKhachHang = ?,LoaiKhachHang= ?,GioiTinhKH =? ,NgaySinhKH = ?,SoDienThoaiKH  = ?,EmailKH = ?, DiaChiKH = ?,TrangThaiKH = ?, GhiChuKH =? WHERE MaKhachHang = ? ";
    final String SELECT_ALL_SQL = "SELECT * FROM tblKhachHang WHERE TrangThaiKH = 1";
    final String SELECT_BY_ID_SQL = "SELECT * FROM tblKhachHang WHERE MaKhachHang = ?";

    @Override
    public void insert(KhachHang entity) {
        JdbcHelper.update(INSERT_SQL, entity.getTenKhachHang(), entity.getLoaiKhachHang(),
                entity.isGioiTinhKH(), entity.getNgaySinhKH(), entity.getSoDienThoaiKH(),
                entity.getEmailKH(), entity.getDiaChiKH(), entity.isTrangThaiKH(), entity.getGhiChuKH());
    }

    @Override
    public void update(KhachHang entity) {
        JdbcHelper.update(UPDATE_SQL, entity.getTenKhachHang(), entity.getLoaiKhachHang(), entity.isGioiTinhKH(), entity.getNgaySinhKH(),
                entity.getSoDienThoaiKH(), entity.getEmailKH(), entity.getDiaChiKH(), entity.isTrangThaiKH(), entity.getGhiChuKH(),
                entity.getMaKhachHang());

    }

    @Override
    public List<KhachHang> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public KhachHang selectById(Integer id) {
        List<KhachHang> list = selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<KhachHang> selectBySql(String sql, Object... args) {
        List<KhachHang> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                KhachHang entity = new KhachHang();
                entity.setMaKhachHang(rs.getInt("MaKhachHang"));
                entity.setTenKhachHang(rs.getString("TenKhachHang"));
                entity.setLoaiKhachHang(rs.getString("LoaiKhachHang"));
                entity.setGioiTinhKH(rs.getBoolean("GioiTinhKH"));
                entity.setNgaySinhKH(rs.getDate("NgaySinhKH"));
                entity.setSoDienThoaiKH(rs.getString("SoDienThoaiKH"));
                entity.setEmailKH(rs.getString("EmailKH"));
                entity.setDiaChiKH(rs.getString("DiaChiKH"));
                entity.setTrangThaiKH(rs.getBoolean("TrangThaiKH"));
                entity.setGhiChuKH(rs.getString("GhiChuKH"));
                list.add(entity);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public List<KhachHang> selectByKeyword(String keyword) {
        String sql = "SELECT * FROM tblKhachHang WHERE TrangThaiKH = 1 AND TenKhachHang Like ? ";
        return this.selectBySql(sql, "%" + keyword + "%");
    }

    final String loaiKhachHang = "SELECT LoaiKhachHang FROM  tblKhachhang";

    public List<String> selectAllLoaiKH() {
        List<String> listLoaiKH = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(loaiKhachHang);
            while (rs.next()) {
                String loaiKH = rs.getString("LoaiKhachHang");
                listLoaiKH.add(loaiKH);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return listLoaiKH;
    }

    final String gioiTinhKH = "SELECT \n"
            + "CASE GioiTinhKH \n"
            + "WHEN  1 THEN N'Nam'\n"
            + "WHEN  0 THEN N'Nữ'\n"
            + "END GioiTinhKH\n"
            + "FROM tblKhachHang ";

    public List<String> selectAllGioiTinhKH() {
        List<String> listGioiTinhKH = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(gioiTinhKH);
            while (rs.next()) {
                String gioiTinhKH = rs.getString("GioiTinhKH");
                listGioiTinhKH.add(gioiTinhKH);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return listGioiTinhKH;
    }

    final String trangThaiKH = "SELECT \n"
            + "CASE TrangThaiKH\n"
            + "WHEN  1 THEN N'Đang hoạt động'\n"
            + "WHEN  0 THEN N'Ngừng hoạt động'\n"
            + "END TrangThaiKH\n"
            + "FROM tblKhachHang";

    public List<String> selectAllTrangThaiKH() {
        List<String> listTrangThaiKH = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(trangThaiKH);
            while (rs.next()) {
                String trangThaiKH = rs.getString("TrangThaiKH");
                listTrangThaiKH.add(trangThaiKH);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return listTrangThaiKH;
    }

    public List<KhachHang> filterByLoaiKH(String loaiKhachHang) {
        String sql = "SELECT * FROM tblKhachHang WHERE TrangThaiKH = 1 AND LoaiKhachHang = ?";
        return selectBySql(sql, loaiKhachHang);
    }
    
     public List<KhachHang> filterByGioiTinhKH(Integer gioiTinhKH) {
        String sql = "SELECT * FROM tblKhachHang WHERE TrangThaiKH = 1 AND GioiTinhKH = ?";
        return selectBySql(sql, gioiTinhKH);
    }
     
      public List<KhachHang> filterByTrangThaiKH(Integer trangThaiKH) {
        String sql = "SELECT * FROM tblKhachHang WHERE TrangThaiKH = ?";
        return selectBySql(sql, trangThaiKH);
    }

       public List<KhachHang> filterByLoaiVaGioiTinh(String loaiKhachHang,Integer gioiTinhKH) {
        String sql = "SELECT * FROM tblKhachHang WHERE TrangThaiKH = 1 AND GioiTinhKH = ? AND LoaiKhachHang = ?";
        return selectBySql(sql, loaiKhachHang,gioiTinhKH);
    }
}
