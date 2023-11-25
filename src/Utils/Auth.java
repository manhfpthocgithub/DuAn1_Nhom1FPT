/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;


import Entity.NguoiDung;

/**
 *
 * @author admin
 */
//Hỗ trợ quản lý thông tin đang nhập
public class Auth {
    
    //đối tượng này chứa thông tin người sử dụng sau khi đăng nhập
   public static NguoiDung user = null;
   
   //dối tượng này xóa thông tin người sử dụng khi có yêu cầu đăng xuất 
   public static void xoa(){
     Auth.user = null;
   }
   //kiểm tra 1 thông tin nào đó đã đăng nhập hay chưa
   public static boolean isDangNhap(){
    return Auth.user != null;
   }
   //phân loại vai trò
   public static boolean isQuanLy(){
    return Auth.isDangNhap() && user.isVaiTro();
   }
}

