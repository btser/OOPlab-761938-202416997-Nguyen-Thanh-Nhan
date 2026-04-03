import javax.swing.JOptionPane;

public class Ex2_2_6 {
    public static void main (String[] args)
    {
            String message = "Chọn dạng phương trình:" + "\n";
            message += "1. Phương trình bậc nhất một ẩn\n";
            message += "2. Hệ phương trình bậc nhất hai ẩn\n";
            message += "3. Phương trình bậc hai một ẩn\n";
        
        String choice = JOptionPane.showInputDialog(null, message, JOptionPane.QUESTION_MESSAGE);
        
        if ("1".equals(choice))
        {
            String strNum1, strNum2;
            strNum1 = JOptionPane.showInputDialog(null, "Nhập a: ", "Input the first number", JOptionPane.INFORMATION_MESSAGE);

            double num1 = Double.parseDouble(strNum1);

            strNum2 = JOptionPane.showInputDialog(null, "Nhập b: ", "Input the second number", JOptionPane.INFORMATION_MESSAGE);
        
            double num2 = Double.parseDouble(strNum2);

            if(num1 == 0)
            {
                if(num2 == 0)
                {
                    String result = "Phương trình có vô số nghiệm.\n";
                    JOptionPane.showMessageDialog(null, result);
                }else{
                    String result = "Phương trình vô nghiệm.\n";
                    JOptionPane.showMessageDialog(null, result);
                }
            }else
            {
                String result = "Phương trình có nghiệm là: " + ((0 - num2) / num1) + "\n";
                JOptionPane.showMessageDialog(null, result);
            }

        }else if ("2".equals(choice))
        {
            double a11 = Double.parseDouble(JOptionPane.showInputDialog("Nhập a11:"));
            double a12 = Double.parseDouble(JOptionPane.showInputDialog("Nhập a12:"));
            double b1  = Double.parseDouble(JOptionPane.showInputDialog("Nhập b1:"));
            double a21 = Double.parseDouble(JOptionPane.showInputDialog("Nhập a21:"));
            double a22 = Double.parseDouble(JOptionPane.showInputDialog("Nhập a22:"));
            double b2  = Double.parseDouble(JOptionPane.showInputDialog("Nhập b2:"));

            double D = a11 * a22 - a21 * a12;
            double D1 = b1 * a22 - b2 * a12;
            double D2 = a11 * b2 - a21 * b1;

            if (D != 0) {
                double x1 = D1 / D;
                double x2 = D2 / D;
                JOptionPane.showMessageDialog(null, "Hệ có nghiệm duy nhất:\nx1 = " + x1 + "\nx2 = " + x2);
            } else {
                if (D1 == 0 && D2 == 0) {
                    JOptionPane.showMessageDialog(null, "Hệ có vô số nghiệm");
                } else {
                    JOptionPane.showMessageDialog(null, "Hệ vô nghiệm");
                }
            }
        }else if ("3".equals(choice))
        {
            double a = Double.parseDouble(JOptionPane.showInputDialog("Nhập a:"));
            double b = Double.parseDouble(JOptionPane.showInputDialog("Nhập b:"));
            double c = Double.parseDouble(JOptionPane.showInputDialog("Nhập c:"));

            if (a == 0) {
                if (b == 0) {
                    if (c == 0) JOptionPane.showMessageDialog(null, "Phương trình vô số nghiệm");
                    else JOptionPane.showMessageDialog(null, "Phương trình vô nghiệm");
                } else {
                    JOptionPane.showMessageDialog(null, "Nghiệm x = " + (-c / b));
                }
            } else {
                double delta = b * b - 4 * a * c;
                if (delta > 0) {
                    double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                    double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                    JOptionPane.showMessageDialog(null, "Phương trình có 2 nghiệm phân biệt:\nx1 = " + x1 + "\nx2 = " + x2);
                } else if (delta == 0) {
                    double x = -b / (2 * a);
                    JOptionPane.showMessageDialog(null, "Phương trình có nghiệm kép:\nx = " + x);
                } else {
                    JOptionPane.showMessageDialog(null, "Phương trình vô nghiệm thực");
                }
            }
        }
        System.exit(0);
    }
}

