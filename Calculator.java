import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
class calculator extends JFrame implements ActionListener {
    static JFrame jPanel;

    static JTextField jTextField;
    static JButton button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, buttonadd, buttonsub, buttondiv, buttonmul, buttone, buttoneq, buttoneq1;
    String num1, num2, result;

    static calculator calc;

    //static JPanel jPanel;

    calculator() {
        num1 = num2 = result = "";
    }

    private static void createButtons() {

        button0 = new JButton("0");
        button0.setBounds(50, 470, 60, 60);
        button1 = new JButton("1");
        button1.setBounds(50, 370, 60, 60);
        button2 = new JButton("2");
        button2.setBounds(120, 370, 60, 60);
        button3 = new JButton("3");
        button3.setBounds(190, 370, 60, 60);
        button4 = new JButton("4");
        button4.setBounds(50, 270, 60, 60);
        button5 = new JButton("5");
        button5.setBounds(120, 270, 60, 60);
        button6 = new JButton("6");
        button6.setBounds(190, 270, 60, 60);
        button7 = new JButton("7");
        button7.setBounds(50, 170, 60, 60);
        button8 = new JButton("8");
        button8.setBounds(120, 170, 60, 60);
        button9 = new JButton("9");
        button9.setBounds(190, 170, 60, 60);

        buttoneq1 = new JButton("=");
        buttoneq1.setBounds(120, 470, 130, 60);

        buttonadd = new JButton("+");
        buttonadd.setBounds(260, 470, 60, 60);
        buttonsub = new JButton("-");
        buttonsub.setBounds(260, 370, 60, 60);
        buttondiv = new JButton("/");
        buttondiv.setBounds(260, 170, 60, 60);
        buttonmul = new JButton("*");
        buttonmul.setBounds(260, 270, 60, 60);
        buttoneq = new JButton("AC");
        buttoneq.setBounds(60, 570, 100, 60);

        buttone = new JButton("CLEAR");
        buttone.setBounds(210, 570, 100, 60);
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

        //jFrame.add(jPanel);
    }


    public static void main(String args[]) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        jPanel = new JFrame("SE BONUS Calculator");

        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());


        calc = new calculator();

        jTextField = new JTextField(20);
        jTextField.setBounds(40, 50, 290, 60);

        jTextField.setEditable(false);
        jTextField.setBackground(Color.yellow);
        createButtons();


        //jPanel = new JPanel();

        addActionListeners();
        addButtons();

        jPanel.setLayout(null);
        jPanel.setSize(370, 700);
        jPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jPanel.setResizable(false);
        jPanel.setVisible(true);
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
