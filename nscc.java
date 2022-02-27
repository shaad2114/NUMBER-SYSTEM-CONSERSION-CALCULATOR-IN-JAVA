import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class nscc {
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JButton CONVERTButton;
    private JPanel Main;
    private JButton resetButton;
    private JTree tree1;

    public static void main(String[] args) {
        JFrame frame = new JFrame("nscc");
        frame.setContentPane(new nscc().Main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setBackground(Color.black);
        frame.setVisible(true);
        frame.setSize(600,400);

    }

    public nscc() {
        CONVERTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = textField1.getText();
                int base = Integer.parseInt(textField2.getText());
                int tobase = Integer.parseInt(textField3.getText());
                int d;
                TODEC TODEC = new TODEC();

                Integer i = Integer.valueOf(nscc.TODEC.toDeci(str, base));

                if (tobase == 10) {
                    d = i;
                }
                DECTO DECTO = new DECTO();
                textField4.setText(String.valueOf(DECTO.fromDeci(tobase, i)));
            }
        });
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText("");
                textField2.setText("");
                textField3.setText("");
                textField4.setText("");
            }
        });
    }

    public void setData(nscc data) {
    }

    public void getData(nscc data) {
    }

    public boolean isModified(nscc data) {
        return false;
    }

    static class DECTO {
        // THIS FUNCTION WILL CONVERT TO CHAR
        static char reVal(int num) {
            if (num >= 0 && num <= 9)
                return (char) (num + 48);
            else
                return (char) (num + 55);
        }
        // this will convert decimal to any base
        static String fromDeci(int tobase, int i) {
            String s = "";

            // this loop will calcaulate
            while (i > 0) {
                s += reVal(i % tobase);
                i /= tobase;
            }
            StringBuilder ix = new StringBuilder();

            // append a string into StringBuilder input1
            ix.append(s);

            // Reverse the result
            return new String(ix.reverse());
        }
    }

    public static class TODEC {
        private static String str;
        private static int base;

        // this function will convert char to decimal
        static int val(char c) {
            if (c >= '0' && c <= '9')
                return (int) c - '0';
            else
                return (int) c - 'A' + 10;
        }

        // this function will convert any base to decimal
        public static int toDeci(String str, int base){
            int len = str.length();
            int power = 1;             // Initialize power of base
            int num = 0;              // Initialize result
            int i;

            // This loop will calculate
            for (i = len - 1; i >= 0; i--) {
                // A digit in input number must be less than number's base
                if (val(str.charAt(i)) >= base) {
                    System.out.println("Invalid Number");
                    return -1;
                }
                    num += val(str.charAt(i)) * power;
                    power = power * base;
                }

                return num;
            }
        }
}