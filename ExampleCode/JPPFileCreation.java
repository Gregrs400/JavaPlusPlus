import java.io.File;
import java.io.IOException;

public class JPPFileCreation
{

    public static void main(String[] args)
    {
        try
        {

            File file = new File("JPPExample.jpp");

            if (file.createNewFile())
            {

                System.out.println("file created");

            }
            else
            {

                System.out.println("file already created");

            }

        }
        catch (IOException e)
        {

            System.out.println("IOException occurred");
            e.printStackTrace();

        }
    }

}
