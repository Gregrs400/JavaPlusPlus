import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class IDE implements ActionListener
{

    JMenuItem loadItem;
    JMenuItem saveItem;
    JMenuItem runItem;
    JFrame mainFrame;
    JTextArea refactoringArea;
    JTextArea outputArea;
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

        outputArea = new JTextArea();
        outputArea.setFocusable(false);
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

        JMenu codeMenu = new JMenu("Code");

        runItem = new JMenuItem("Run");
        runItem.addActionListener(this);

        codeMenu.add(runItem);

        menuBar.add(codeMenu);

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

            saveToFile();

        }
        else if (e.getSource() == runItem)
        {

            String currentFilePath = saveToFile();

            Interpreter interpreter = new Interpreter();

            String currentFileJavaString = interpreter.interpret(currentFilePath);

            String destinationFilePath = "src\\ExampleCode\\Test.java";

            jpp.writeToFile(jpp.createOrAccessFile(destinationFilePath), currentFileJavaString);

            try {
                // Compile the Test.java file
                Process compileProcess = Runtime.getRuntime().exec("javac " + destinationFilePath);
                compileProcess.waitFor();

                // Run the compiled Test.class file
                Process runProcess = Runtime.getRuntime().exec("java " + destinationFilePath);
                BufferedReader reader = new BufferedReader(new InputStreamReader(runProcess.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null) {
                    outputArea.append(line);
                }
                runProcess.waitFor();
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }

        }
        else
        {

            System.out.println("error");

        }

    }
    public String saveToFile()
    {

        JFileChooser fileChooser = new JFileChooser();

        fileChooser.setCurrentDirectory(new File("."));
        int response = fileChooser.showSaveDialog(null);

        if (response == JFileChooser.APPROVE_OPTION)
        {

            String refactoringAreaText = refactoringArea.getText();

            String chosenFilePath = fileChooser.getSelectedFile().getPath();
            File file = jpp.createOrAccessFile(chosenFilePath);
            jpp.clearFile(file);
            jpp.writeToFile(file, refactoringAreaText);

            return chosenFilePath;
        }

        return null;

    }
}
