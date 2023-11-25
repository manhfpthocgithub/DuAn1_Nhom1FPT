/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import java.awt.Image;
import java.io.File;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;

/**
 *
 * @author admin
 */
public class XImages {

    public static Image getAppIcon() {
        URL url = XImages.class.getResource("/Images/fpt.png");
        return new ImageIcon(url).getImage();
    }

    public static void save(File src) {
        File dst = new File("\\JAVA_3\\DuAnMau_PH35488\\src\\Images", src.getName());
        if (!dst.getParentFile().exists()) {
            dst.getParentFile().mkdir(); // tạo thư mục nếu chưa tồn tại 
        }
        try {
            Path from = Paths.get(src.getAbsolutePath());
            Path to = Paths.get(dst.getAbsolutePath());
            Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static ImageIcon read(String fileName) {
        File path = new File("\\JAVA_3\\DuAnMau_PH35488\\src\\Images", fileName);
        return new ImageIcon(path.getAbsolutePath());
    }

}
