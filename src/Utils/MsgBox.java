/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;



import java.awt.Component;
import javax.swing.JOptionPane;

public class MsgBox {

    //Hiển thị thông báo cho người dùng
    //parent là cửa sổ chứa thông báo
    //message là thông báo
    public static void alert(Component parent, String message) {
        JOptionPane.showMessageDialog(parent, message,
                "Hệ Thống Quản Lý Đào Tạo", JOptionPane.INFORMATION_MESSAGE);
    }

    //Hiển thị thông báo và yêu cầu người dùng xác nhận
    //parent là cửa sổ chứa thông báo
    //message là thông báo
    // return là kết quả nhận được true/false
    public static boolean confirm(Component parent, String message) {
        int ketqua = JOptionPane.showConfirmDialog(parent, message,
                "Hệ Thống Quản Lý Đào Tạo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        return ketqua == JOptionPane.YES_OPTION;
    }

    //Hiển thị thông báo yêu cầu nhập dữ liệu
    //parent là cửa sổ chứa thông báo
    //message là thông báo
    //return là kêt quả nhận được tự người sử dụng nhập vào
    public static String prompt (Component parent, String message) {
        return JOptionPane.showInputDialog(parent, message,
                "Hệ Thống Quản Lý Đào Tạo", JOptionPane.INFORMATION_MESSAGE);
    }

  

    
}

