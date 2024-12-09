import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class IDE implements ActionListener
{

    JMenuItem loadItem;
    JMenuItem saveItem;
    JFrame mainFrame;

    public void initIDE()
    {

        mainFrame = new JFrame("Java Plus Plus IDE");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(null);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setSize(1400, 1000);
        mainFrame.setLocation(100, 25);

        JTextArea refactoringArea = new JTextArea();
        JScrollPane refactoringAreaScroll = new JScrollPane(refactoringArea);

        JPanel refactoringAreaPanel = new JPanel();
        refactoringAreaPanel.setLayout(new BorderLayout());
        refactoringAreaPanel.add(refactoringAreaScroll, BorderLayout.CENTER);
        refactoringAreaPanel.setBounds(100, 100, 1200, 450);

        mainFrame.add(refactoringAreaPanel);

        JTextArea outputArea = new JTextArea();
        JScrollPane outputAreaScroll = new JScrollPane(outputArea);

        JPanel outputAreaPanel = new JPanel();
        outputAreaPanel.setLayout(new BorderLayout());
        outputAreaPanel.add(outputAreaScroll, BorderLayout.CENTER);
        outputAreaPanel.setBounds(100, 650, 1200, 250);

        mainFrame.add(outputAreaPanel);

        JMenuBar menuBar = initMenuBar();

        mainFrame.setJMenuBar(menuBar);

        mainFrame.setVisible(true);

    }

    public JMenuBar initMenuBar()
    {

        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");

        loadItem = new JMenuItem("Load");
        loadItem.addActionListener(this);

        saveItem = new JMenuItem("Save");
        saveItem.addActionListener(this);

        fileMenu.add(loadItem);
        fileMenu.add(saveItem);

        menuBar.add(fileMenu);

        JMenu editMenu = new JMenu("Edit");

        menuBar.add(editMenu);

        return menuBar;

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {

        if (e.getSource() == loadItem)
        {

            System.out.println("load file");

            JFileChooser fileChooser = new JFileChooser();

            fileChooser.setCurrentDirectory(new File("."));
            fileChooser.showOpenDialog(null);

        }
        else if (e.getSource() == saveItem)
        {
            System.out.println("save file");
        }
        else
        {
            System.out.println("error");
        }

    }
}
