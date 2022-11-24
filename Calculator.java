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
    calculator()
    {
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


    public static void main(String args[]) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        jFrame = new JFrame("SE BONUS Calculator");

        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());


         calc = new calculator();

        jTextField = new JTextField(20);

        jTextField.setEditable(false);
        jTextField.setBackground(Color.yellow);
        createButtons();
        

        jPanel = new JPanel();

        //addActionListeners();
        //addButtons();

        jFrame.setSize(500, 500);
        jFrame.show();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
    }
}
