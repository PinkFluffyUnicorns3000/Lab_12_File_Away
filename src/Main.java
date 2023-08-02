import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;


import static java.nio.file.StandardOpenOption.CREATE;

public class Main
{
    public static void main(String[] args)
    {
        JFileChooser chooser = new JFileChooser();
        File selectedFile;
        String rec = "";
        int chars = 0;
        int lines = 0;
        int words = 0;
        String line;

        try {
            File workingDirectory = new File(System.getProperty("user.dir"));
            chooser.setCurrentDirectory(workingDirectory);
            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath();
                InputStream in =
                        new BufferedInputStream(Files.newInputStream(file, CREATE));
                BufferedReader reader =
                        new BufferedReader(new InputStreamReader(in));

                while (reader.ready()) {
                    rec = reader.readLine();
                    lines++;
                    line = rec;
                    chars += line.length();
                    String[] wordsArray = line.split("\\s+");
                    words += wordsArray.length;
                }
                reader.close();
                System.out.println("\n\nTitle : " + selectedFile.getName());
                System.out.println("Lines in file : " + lines);
                System.out.println("Words in file : " + words);
                System.out.println("Characters in file : " + chars);


            } else
            {
                System.out.println("No file selected!!! ... exiting.\nRun the program again and select a file.");
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found!!!");
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}

