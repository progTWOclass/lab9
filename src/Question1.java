import java.io.FileInputStream;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Question1 {
    public static void main(String[] args) throws FileNotFoundException {

        System.out.println("this program will read the contents of words.txt");

        Scanner inputStream = null;
        //PrintWriter outputStream = null;

        try{
            inputStream = new Scanner(new FileInputStream("words.txt"));
            //outputStream - new PrintWriter(new FileOutputStream("words.txt", true));

        }catch(FileNotFoundException fNFE){
            System.out.println("File words.txt not found");
            System.exit(0);
        }

        String words = null;
        int mostLetters = 0;
        int countLetters = 1;
        while(inputStream.hasNextLine()){
            words = inputStream.nextLine();

            for(int i = 0; i < words.length()-1; i++){
                if(words.charAt(i) == words.charAt(i+1)){
                    countLetters++;
                }else{
                    countLetters = 1;
                }

                if(countLetters > mostLetters){
                    mostLetters = countLetters;
                }
            }
            //System.out.println(words);
        }
        System.out.println(words + " has the most consecutive same letters with " + mostLetters);
        inputStream.close();
    }
}
