package create_read_binaryFile;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
public class CreateBinaryFile {
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        ObjectOutputStream outputStream = null;
        try{
            outputStream = new ObjectOutputStream(new FileOutputStream("Lab9Q2.dat"));

            while(true) {
                System.out.println("Please enter a whole number: (enter # to stop)");
                String endLoop = input.nextLine();
                if(endLoop.equals("#")){
                    break;
                }

                try{
                    int number = Integer.parseInt(endLoop);
                    outputStream.writeInt(number);
                }catch (NumberFormatException nFE){
                    System.out.println("Not an a whole number. Please enter a whole number");
                }
            }
            System.out.println("Your file has been created with whole numbers");

        }catch(IOException iOE){
            System.err.println("Input file not created");
        }finally {

            try {
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException iOE) {
                System.err.println("File not closed properly");
            }
        }
    }
}
