import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);

            System.out.println("Enter file path you wish to copy");
            String origin = sc.nextLine();

            System.out.println("Enter file path you wish to copy to");
            String destination = sc.nextLine();

            FileInputStream fis = new FileInputStream(origin);
            FileOutputStream fos = new FileOutputStream(destination);

            int byteData;
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);
            }

            File file = new File(destination);
            if (file.exists()) {
                System.out.println("File successfully copied.");
                fos.close();
                fis.close();

                if (file.delete()) {
                    System.out.println("File successfully deleted.");
                }
            }
            sc.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Error: File not found. " + e.getMessage());
        }
        catch (IOException e) {
            System.out.println("Error: IO. " + e.getMessage());
        }
    }
}