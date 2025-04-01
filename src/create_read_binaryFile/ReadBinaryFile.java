package create_read_binaryFile;
import java.io.EOFException;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.IOException;
public class ReadBinaryFile {
    public static void main (String [] args){
        //reading the binary file that we just created and find the max and min value
        try{
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("Lab9Q2.dat"));

            int maxNumber = Integer.MIN_VALUE;//initialize to the smallest integer -2,147,483,647
            int minNumber = Integer.MAX_VALUE;//initialize to the biggest integer 2,147,483,647

            while (true) {
                try {
                    int number = inputStream.readInt();
                    System.out.println(number);
                    minNumber = Math.min(minNumber, number);//find the smallest number between 2,147,483,647 and number
                    maxNumber = Math.max(maxNumber, number);//find the biggest number between -2,147,483,647 and number
                } catch (EOFException e) {
                    break;
                }
            }
            System.out.println("min number : " + minNumber);
            System.out.println("max number: " + maxNumber);
            inputStream.close();

        }catch(IOException iOE){
            System.err.println("file does not exist");
        }
    }
}
