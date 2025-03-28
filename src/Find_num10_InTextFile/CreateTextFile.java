package Find_num10_InTextFile;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class CreateTextFile {
    public static void main (String[] args){
        try{
            PrintWriter printNumber = new PrintWriter(new FileOutputStream("numbers.txt"));

            for(int i = 0; i < 20; i++){
                int randomNum = (int) (Math.random() * 15) + 1;
                String number = String.valueOf(randomNum);
                printNumber.print(number + " ");
            }
            System.out.println("number.txt file created successfully.");
            printNumber.close();

        }catch(IOException iOE){
            System.err.println("file not created. something went wrong");
        }
    }
}
