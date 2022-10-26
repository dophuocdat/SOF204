/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helper;

import java.awt.Color;
import static java.awt.Color.pink;
import static java.awt.Color.white;
import java.security.cert.TrustAnchor;
import java.text.SimpleDateFormat;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author datdo
 */
public class UtilityHelper {

    public static boolean checkPass(JPasswordField txt) {
        txt.setBackground(Color.white);
        if (txt.getPassword().length > 2 && txt.getPassword().length < 17) {
            return true;
        } else {
            txt.setBackground(Color.pink);
            // display notifications
            DialogHelper.alert(txt.getRootPane(), txt.getName() + " Mật khẩu gồm 5 kí tự, chữ thường, chữ hoa hoặc số");
            return false;
        }
    }

    public static boolean checkNullPass(JPasswordField txt) {
        txt.setBackground(Color.white);
        if (txt.getPassword().length > 0) {
            return true;
        } else {
            txt.setBackground(Color.pink);
            // display notifications
            return false;
        }
    }

    public static boolean checkMaCD(JTextField txt) {
        txt.setBackground(Color.WHITE);
        String id = txt.getText();
        // a-z  A-Z 0-9 3-50 kí tự
            String rgx = "[a-zA-Z0-9]{5,10}";
        if (id.matches(rgx)) {
            return true;
        } else {
            txt.setBackground(Color.pink);
            // display notifications
            DialogHelper.alert(txt.getRootPane(), txt.getName() + " phải từ 5-10 kí tự.");

            return false;
        }
    }

    public static boolean checkName(JTextField txt) {
        txt.setBackground(Color.white);
        String name = txt.getText();

        if (!name.equals(null)) {
            return true;
        } else {
            txt.setBackground(Color.pink);
            // display notifications
            DialogHelper.alert(txt.getRootPane(), txt.getName() + " phải là tên tiếng việt hoặc không đấu\ntừ 3-25 kí tự");
            return false;
        }
    }

    public static boolean checkMoTaCD(JTextArea txt) {
        txt.setBackground(Color.white);
        String MT = txt.getText();
        //String rgx = "^[A-Za-z]";
        if (!MT.equals(null)) {
            return true;
        } else {
            txt.setBackground(Color.pink);
            //display notifications
            DialogHelper.alert(txt.getRootPane(), txt.getName() + "Phải từ 3-255 kí tự.");
            return false;
        }

    }

    public static boolean checkThoiLuong(JTextField txt) {
        txt.setBackground(Color.white);
        try {
            int h = Integer.parseInt(txt.getText());
            if (h >= 0) {
                return true;
            } else {
                txt.setBackground(Color.pink);
                // display notifications
                DialogHelper.alert(txt.getRootPane(), txt.getName() + "Phải lớn hơn bằng 0.");

                return false;
            }
        } catch (Exception e) {
            txt.setBackground(Color.pink);
            // display notifications
            DialogHelper.alert(txt.getRootPane(), txt.getName() + "Phải là số nguyên");
            return false;
        }
    }

    public static boolean checkHocPhi(JTextField txt) {
        txt.setBackground(Color.white);
        try {
            float hp = Float.parseFloat(txt.getText());
            if (hp >= 0) {
                return true;
            } else {
                txt.setBackground(Color.pink);
                // display notifications
                DialogHelper.alert(txt.getRootPane(), txt.getName() + " Phải lớn hơn bằng 0.");

                return false;
            }
        } catch (Exception e) {
            txt.setBackground(Color.pink);
            // display notifications
            DialogHelper.alert(txt.getRootPane(), txt.getName() + " Phải là số thực.");

            return false;
        }
    }

    public static boolean checkNullText(JTextField txt) {
        txt.setBackground(Color.white);
        if (txt.getText().trim().length() > 0) {
            return true;
        } else {
            txt.setBackground(Color.pink);
            // display notifications
            DialogHelper.alert(txt.getRootPane(), "Không được để trống " + txt.getName());

            return false;
        }
    }

    public static boolean checkNullText(JTextArea txt) {
        txt.setBackground(Color.white);
        if (txt.getText().trim().length() > 0) {
            return true;
        } else {
            txt.setBackground(Color.pink);
            // display notifications
            DialogHelper.alert(txt.getRootPane(), "Không được để trống " + txt.getName());

            return false;
        }
    }

    // check ma nguoi hoc
    public static boolean checkMaNH(JTextField txt) {
        txt.setBackground(Color.white);
        String id = txt.getText();
        String rgx = "[a-zA-Z0-9]{7}";
        if (id.matches(rgx)) {
            return true;
        } else {
            txt.setBackground(Color.pink);
            DialogHelper.alert(txt.getRootPane(), txt.getName() + " Phải có 7 kí tự\n chữ thường, chữ hoa hoặc số");
            return false;
        }
    }

    public static boolean isValidDate(String date) {
        if (date == null) {
            return false;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
        if (date.trim().length() != dateFormat.toPattern().length()) {
            return false;
        }
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(date.trim());

        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static boolean checkDate(JTextField txt) {
        txt.setBackground(Color.white);
        String date = txt.getText();
        if (isValidDate(date)) {
            return true;
        } else {
            txt.setBackground(Color.pink);
            DialogHelper.alert(txt.getRootPane(), txt.getName() + " không đúng định dạng dd/mm/yyyy");
            return false;
        }
    }

    public static boolean checkSDT(JTextField txt) {
        txt.setBackground(Color.white);
        String sdt = txt.getText();
        String rgx = "(086|096|097|098|032|033|034|035|036|037|038|039|089|090|093|070|079|077|078|076|088|091|094|083|084|085|081|082|092|056|058|099|059)[0-9]{7}";
        if (sdt.matches(rgx)) {
            return true;
        } else {
            txt.setBackground(Color.pink);
            DialogHelper.alert(txt.getRootPane(), txt.getName() + " Phải gồm 10 chữ số\n Đúng các đầu số của nhà mạng.");
            return false;
        }
    }

    public static boolean checkEmail(JTextField txt) {
        txt.setBackground(Color.white);
        String email = txt.getText();
        String rgx = "^[a-zA-Z][a-zA-Z0-9_\\.]{2,32}@[a-zA-Z0-9]{2,10}(\\.[a-zA-Z0-9]{2,4}){1,2}$";
        if (email.matches(rgx)) {
            return true;
        } else {
            txt.setBackground(Color.pink);
            DialogHelper.alert(txt.getRootPane(), txt.getName() + " Không đúng định dạng.");
            return false;
        }
    }
    public static boolean checkMaNV(JTextField txt) {
        txt.setBackground(white);
        String id = txt.getText();
        String rgx = "[a-zA-Z0-9]{1,15}";
        if (id.matches(rgx)) {
            return true;
        } else {
            txt.setBackground(pink);
            DialogHelper.alert(txt.getRootPane(), txt.getName() + " phải có 1-15 kí tự\nchữ hoa, thường không dấu hoặc số.");
            return false;
        }
    }
   public static String getRank(double diem) {
        String xepLoai = "Xuất sắc";
        if (diem < 0) {
            xepLoai = "Chưa nhập";

        } else if (diem < 3) {
            xepLoai = "Kém";

        } else if (diem < 5) {
            xepLoai = "Yếu";

        } else if (diem < 6.5) {

            xepLoai = "Trung bình";

        } else if (diem < 7.5) {
            xepLoai = "Khá";

        } else if (diem < 9) {
            xepLoai = "Giỏi";

        }
        return xepLoai;
    }
   public static boolean checkDiem(JTextField txt){
       txt.setBackground(white);
       try {
           float d = Float.parseFloat(txt.getText());
           if((d >= 10 && d <=10 || d == -1)){
               return true;
           }
           else{
               txt.setBackground(pink);
               DialogHelper.alert(txt.getRootPane(),txt.getName() + " Phải là trong khoảng 0-10 hoặc chưa nhập (-1).");
               return false;
           }
           
       } catch (NumberFormatException e) {
           DialogHelper.alert(txt.getRootPane(), txt.getName() +" Phải là số thực.");
           return false;
       }
   }
}
