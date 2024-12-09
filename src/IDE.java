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
    JTextArea refactoringArea;
    JPPFileCreation jpp;

    public void initIDE()
    {

        mainFrame = new JFrame("Java Plus Plus IDE");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(null);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setSize(1400, 1000);
        mainFrame.setLocation(100, 25);

        refactoringArea = new JTextArea();
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

        jpp = new JPPFileCreation();

        if (e.getSource() == loadItem)
        {

            JFileChooser fileChooser = new JFileChooser();

            fileChooser.setCurrentDirectory(new File("."));
            int response = fileChooser.showOpenDialog(null);

            if (response == JFileChooser.APPROVE_OPTION)
            {

                File file = jpp.createOrAccessFile(fileChooser.getSelectedFile().getPath());
                String fileText = jpp.readFromFile(file);
                refactoringArea.setText(fileText);

            }

        }
        else if (e.getSource() == saveItem)
        {

            JFileChooser fileChooser = new JFileChooser();

            fileChooser.setCurrentDirectory(new File("."));
            int response = fileChooser.showSaveDialog(null);

            if (response == JFileChooser.APPROVE_OPTION)
            {

                String refactoringAreaText = refactoringArea.getText();

                File file = jpp.createOrAccessFile(fileChooser.getSelectedFile().getPath());
                jpp.clearFile(file);
                jpp.writeToFile(file, refactoringAreaText);

            }

        }
        else
        {

            System.out.println("error");

        }

    }
}
