import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IDE
{

    public static void main(String[] args) {
        JFrame mainFrame = new JFrame("Java Plus Plus IDE");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(null);

        JTextArea refactoringArea = new JTextArea();
        refactoringArea.setBounds(100, 100, 1200, 500);
        refactoringArea.setVisible(true);

        mainFrame.add(refactoringArea);

        mainFrame.setSize(1400, 1000);
        mainFrame.setLocation(100, 25);

        mainFrame.setVisible(true);

    }

}
