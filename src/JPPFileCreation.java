import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class JPPFileCreation
{

    public static void main(String[] args)
    {

        File file = createOrAccessFile("JPPExample.jpp");
        readFromFile(file);

    }
    public static File createOrAccessFile(String filePathAndName) {

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
    public static void readFromFile(File file)
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

}
