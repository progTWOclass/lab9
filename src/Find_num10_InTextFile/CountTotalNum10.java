package Find_num10_InTextFile;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
public class CountTotalNum10 {
    public static void main(String[] args){
        //reading the text file that we created and start
        try{
            BufferedReader reader = new BufferedReader(new FileReader("numbers.txt"));
            String textFile;
            int counter = 0;
            while((textFile = reader.readLine()) != null){
                System.out.println(textFile);

                //we can also use StringTokenizer
                //trim remove beginning and end spaces if it exists
                //Matches one or more occurrences Any whitespace character (space, tabs, newline)
                String[] splitNum = textFile.trim().split("\\s+");
                for (String s : splitNum) {
                    if (s.equals("10")) {
                        counter++;
                    }
                }
            }
            System.out.println("the number 10 came up " + counter + " time(s)");
            reader.close();

        }catch(FileNotFoundException fNFE){
            System.err.println("File not found");
        } catch(IOException iOE){
            System.out.println("problem with the text file");
        }
    }
}
