/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helper;

import Model.NhanVien;
import java.awt.Image;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;

/**
 *
 * @author datdo
 */
public class imageHelper {

    public static final ImageIcon APP_ICON1;
    public static final Image APP_ICON;
    public static final ImageIcon TAB_UPDATE;
    public static final ImageIcon TAB_LIST;
    public static final ImageIcon TAB_NH;
    public static final ImageIcon TAB_HV;
        public static final ImageIcon TAB_BD;
            public static final ImageIcon TAB_THD;
                public static final ImageIcon TAB_DT;




    static {
        String file = "/Icons/fpt.png";
        APP_ICON = new ImageIcon(imageHelper.class.getResource(file)).getImage();
        APP_ICON1 = new ImageIcon(imageHelper.class.getResource(file));
        TAB_UPDATE = new ImageIcon("src\\Icons\\Edit.png");
        TAB_LIST = new ImageIcon("src\\Icons\\Lists.png");
        TAB_NH = new ImageIcon("src\\Icons\\Users.png");
        TAB_HV = new ImageIcon("src\\Icons\\Usergroup.png");
         TAB_BD = new ImageIcon("src\\Icons\\Numbered list.png");
        TAB_THD = new ImageIcon("src\\Icons\\Clien list.png");
        TAB_DT = new ImageIcon("src\\Icons\\Coins.png");
    }

    public static boolean saveLogo(File file) {
        /*Kiem tra file ton tai hay chua; neu chua thi tao folder moi        */
        File dir = new File("image");
        if (!dir.exists()) {
            dir.mkdirs();
        }
        File newFile = new File(dir, file.getName());
        try {
            Path sourPath = Paths.get(file.getAbsolutePath()); // get path file
            Path destination = Paths.get(newFile.getAbsolutePath());
            Files.copy(sourPath, destination, StandardCopyOption.REPLACE_EXISTING);
            //System.out.println("coppy succesully");
            return true;
        } catch (Exception e) {
            System.out.println("Coppy false");
            return false;
        }
    }

    public static ImageIcon readImage(String fileName) {
        File path = new File("image", fileName);
        Image img = new ImageIcon(path.getAbsolutePath()).getImage().getScaledInstance(180, 180, Image.SCALE_DEFAULT);
        ImageIcon icon = new ImageIcon(img);
        return icon;
    }

    // luu thông tin nguoi su dung sau khi dang nhap
    public static NhanVien USER = null;

    // xoa thong tin nguoi dung khi có yeu cau dang xuat
    public static void logout() {
        imageHelper.USER = null;
    }

    public static boolean authenticated() {
        return imageHelper.USER != null;
    }

}
