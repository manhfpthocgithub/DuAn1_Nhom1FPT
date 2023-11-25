/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;


import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author admin
 */
public class JdbcHelper {

    private static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static String dburl = "jdbc:sqlserver://localhost;database=DUAN1_NHOM1";
    private static String user = "sa";
    private static String pass = "12345manh";

    //nạp driver
    static {
        try {
            Class.forName(driver);
            System.out.println("ban da cai dirver jdbc");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    //xây dựng PreparedStatement
    //@param sql là câu lệnh sql chứa có thể chứa tham số. Nó có thể là 1 lời, 1 thủ tục lưu
    //@param args là danh sách các giá trị được cung cấp cho các tham số trong câu lệnh sql
    //@return là PreparedStatement tạo được
    //@throw java.sql.SQLException là lỗi sai cú pháp
    public static PreparedStatement getStmt(String sql, Object... args) throws SQLException {
        Connection ct = DriverManager.getConnection(dburl, user, pass);
        PreparedStatement pstmt = null;
        if (sql.trim().startsWith("{")) {
            pstmt = ct.prepareCall(sql);
        } else {
            pstmt = ct.prepareStatement(sql);
        }
        for (int i = 0; i < args.length; i++) {
            pstmt.setObject(i + 1, args[i]);
        }
        return pstmt;
    }

    //Thực hiện câu lệnh SQL thao tác (INSERT INTO, UPDATE ,DELETE )hoặc thủ tục lưu thao tác dữ liệu
    //@param sql là câu lệnh sql chứa có thể chứa tham số. Nó có thể là 1 lời, 1 thủ tục lưu
    //@param args là danh sách các giá trị được cung cấp cho các tham số trong câu lệnh sql
    public static int update(String sql, Object... args) {
        try {
            PreparedStatement stmt = getStmt(sql, args);
            try {
                return stmt.executeUpdate();
            } finally {
                stmt.getConnection().close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //Thực hiện câu lệnh SQL truy vấn (SELECT) hoặc thủ tục lưu truy vấn dữ liệu
    //@param sql là câu lệnh sql chứa có thể chứa tham số. Nó có thể là 1 lời, 1 thủ tục lưu
    //@param args là danh sách các giá trị được cung cấp cho các tham số trong câu lệnh sq
    public static ResultSet query(String sql, Object... args) {
        try {
            PreparedStatement stmt = getStmt(sql, args);
            return stmt.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //Trả về 1 object , 1 đối tượng bất kì
    public static Object value(String sql, Object... args) {
        try {
            ResultSet rs = query(sql, args);
            if (rs.next()) {
                return rs.getObject(0);
            }
            rs.getStatement().getConnection().close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}

