import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class JPPFileCreation
{

//        File file = createOrAccessFile("JPPExample.jpp");
//        String textToAddToFile = "Testing";
//        writeToFile(file, textToAddToFile);
//        readFromFile(file);
//        clearFile(file);
//        String textToAddToFile2 = "After Clear";
//        writeToFile(file, textToAddToFile2);
//        readFromFile(file);
//        clearFile(file);

    public File createOrAccessFile(String filePathAndName) {

        try {

            File file = new File(filePathAndName);

            if (file.createNewFile()) {

                System.out.println("file created");

            } else {

                System.out.println("file already created");

            }

            return file;

        } catch (IOException e) {

            System.out.println("IOException occurred");
            e.printStackTrace();

            return null;

        }

    }
    public void readFromFile(File file)
    {

        try
        {

            Scanner fileReader = new Scanner(file);

            while (fileReader.hasNextLine())
            {

                System.out.println(fileReader.nextLine());

            }

        }
        catch (FileNotFoundException e)
        {

            e.printStackTrace();

        }

    }

    public void writeToFile(File file, String text)
    {

        try {
            FileWriter writer = new FileWriter(file, true);
            writer.write(text);
            writer.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    public void clearFile(File file)
    {

        try
        {
            FileWriter writer = new FileWriter(file, false); // 'false' disables append mode
            writer.close(); // This clears the file
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

}
