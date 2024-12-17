import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class JPPFileCreation
{

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
    public String readFromFile(File file)
    {

        StringBuilder fileString = new StringBuilder();

        try
        {

            Scanner fileReader = new Scanner(file);

            while (fileReader.hasNextLine())
            {

                fileString.append(fileReader.nextLine());
                fileString.append(System.getProperty("line.separator"));

            }

            return fileString.toString();

        }
        catch (FileNotFoundException e)
        {

            e.printStackTrace();

        }

        return null;

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
