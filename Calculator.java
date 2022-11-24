import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
class calculator extends JFrame implements ActionListener {
    static JFrame jFrame;

    static JTextField jTextField;
    static JButton button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, buttonadd, buttonsub, buttondiv, buttonmul, buttone, buttoneq, buttoneq1;
    String num1, num2, result;

    static calculator calc;

    static JPanel jPanel;

    calculator() {
        num1 = num2 = result = "";
    }

    private static void createButtons() {

        button0 = new JButton("0");
        button1 = new JButton("1");
        button2 = new JButton("2");
        button3 = new JButton("3");
        button4 = new JButton("4");
        button5 = new JButton("5");
        button6 = new JButton("6");
        button7 = new JButton("7");
        button8 = new JButton("8");
        button9 = new JButton("9");

        buttoneq1 = new JButton("=");

        buttonadd = new JButton("+");
        buttonsub = new JButton("-");
        buttondiv = new JButton("/");
        buttonmul = new JButton("*");
        buttoneq = new JButton("AC");

        buttone = new JButton(".");
    }

    private static void addActionListeners() {
        button9.addActionListener(calc);
        button8.addActionListener(calc);
        button7.addActionListener(calc);
        button6.addActionListener(calc);
        button5.addActionListener(calc);
        button4.addActionListener(calc);
        button3.addActionListener(calc);
        button2.addActionListener(calc);
        button1.addActionListener(calc);
        button0.addActionListener(calc);
        buttone.addActionListener(calc);
        buttoneq.addActionListener(calc);
        buttoneq1.addActionListener(calc);
        buttonmul.addActionListener(calc);
        buttondiv.addActionListener(calc);
        buttonsub.addActionListener(calc);
        buttonadd.addActionListener(calc);
    }

    private static void addButtons() {
        jPanel.add(jTextField);
        jPanel.add(button0);
        jPanel.add(button1);
        jPanel.add(button2);
        jPanel.add(button3);
        jPanel.add(button4);
        jPanel.add(button5);
        jPanel.add(button6);
        jPanel.add(button7);
        jPanel.add(button8);
        jPanel.add(button9);
        jPanel.add(buttonadd);
        jPanel.add(buttonsub);
        jPanel.add(buttonmul);
        jPanel.add(buttondiv);
        jPanel.add(buttone);
        jPanel.add(buttoneq);
        jPanel.add(buttoneq1);

        jPanel.setBackground(Color.white);

        jFrame.add(jPanel);
    }


    public static void main(String args[]) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        jFrame = new JFrame("SE BONUS Calculator");

        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());


        calc = new calculator();

        jTextField = new JTextField(20);

        jTextField.setEditable(false);
        jTextField.setBackground(Color.yellow);
        createButtons();


        jPanel = new JPanel();

        addActionListeners();
        addButtons();

        jFrame.setSize(500, 500);
        jFrame.show();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        double partialResult;
        if ((str.charAt(0) >= '0' && str.charAt(0) <= '9') || str.charAt(0) == '.') {
            if (!num2.equals(""))
                result = result + str;
            else
                num1 = num1 + str;
            jTextField.setText(num1 + num2 + result);
        } else if (str.charAt(0) == 'C') {
            num1 = num2 = result = "";

            jTextField.setText(num1 + num2 + result);
        } else if (str.charAt(0) == '=') {

            if (num2.equals("+")) {
                partialResult = (Double.parseDouble(num1) + Double.parseDouble(result));
            } else if (num2.equals("-")) {
                partialResult = (Double.parseDouble(num1) - Double.parseDouble(result));
            } else if (num2.equals("/")) {
                partialResult = (Double.parseDouble(num1) / Double.parseDouble(result));
            } else {
                partialResult = (Double.parseDouble(num1) * Double.parseDouble(result));
            }

            jTextField.setText(num1 + num2 + result + "=" + partialResult);

            num1 = Double.toString(partialResult);

            num2 = result = "";
        } else {
            if (num2.equals("") || result.equals(""))
                num2 = str;
            else {

                if (num2.equals("+")) {
                    partialResult = (Double.parseDouble(num1) + Double.parseDouble(result));
                } else if (num2.equals("-")) {
                    partialResult = (Double.parseDouble(num1) - Double.parseDouble(result));
                } else if (num2.equals("/")) {
                    partialResult = (Double.parseDouble(num1) / Double.parseDouble(result));
                } else {
                    partialResult = (Double.parseDouble(num1) * Double.parseDouble(result));
                }

                num1 = Double.toString(partialResult);

                num2 = str;

                result = "";
            }

            jTextField.setText(num1 + num2 + result);
        }
    }
}
