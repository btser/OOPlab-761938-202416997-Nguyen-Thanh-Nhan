import javax.swing.JOptionPane;

public class Ex2_2_5 {

    public static void main(String[] args)
    {
        String strNum1, strNum2;
        strNum1 = JOptionPane.showInputDialog(null, "Please input the first number: ", "Input the first number", JOptionPane.INFORMATION_MESSAGE);

        double num1 = Double.parseDouble(strNum1);

        strNum2 = JOptionPane.showInputDialog(null, "Please input the second number: ", "Input the second number", JOptionPane.INFORMATION_MESSAGE);
        
        double num2 = Double.parseDouble(strNum2);

        String result = "The sum of " + strNum1 + " and " + strNum2 + " is: " + (num1 + num2) + "\n";
        result += "The difference of " + strNum1 + " and " + strNum2 + " is: " + (num1 - num2) + "\n";
        result += "The product of" + strNum1 + " and " + strNum2 + " is: " + (num1 * num2) + "\n";

        if (num2 == 0)
            result += "Cannot divide by zero!";
        else
            result += "The quotient of " + strNum1 + " and " + strNum2 + " is: " + (num1 / num2);

        JOptionPane.showMessageDialog(null, result, "result", JOptionPane.INFORMATION_MESSAGE);
    }
