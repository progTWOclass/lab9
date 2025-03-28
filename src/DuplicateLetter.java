import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class DuplicateLetter {
    public static void main(String[] args){

        System.out.println("this program will read the contents of words.txt");

        String mostDoubleLetter = null;//store the current word with the most consecutive duplicate letters
        int maxDoubleLetters = 0;//store the total count of duplicate letters in the current word

        //BufferedReader is better for reading large files instead of scanner
        try
        {
            BufferedReader read = new BufferedReader(new FileReader("words.txt"));
            String words;

            while( (words = read.readLine()) != null){

                int countDuplicateLetters = 0;
                int maxCountDuplicateLetters = 0;
                for(int i = 0; i < words.length()-1; i++){
                    if(words.charAt(i) == words.charAt(i+1)){
                        countDuplicateLetters++;
                        i++;//move past the duplicate letters so that it doesn't get counted again with the next letter
                    }else{
                        countDuplicateLetters = 0;//reset count to 0
                    }
                    maxCountDuplicateLetters = Math.max(maxCountDuplicateLetters, countDuplicateLetters);
                }

                if(maxCountDuplicateLetters > maxDoubleLetters){
                    maxDoubleLetters = maxCountDuplicateLetters;
                    mostDoubleLetter = words;
                }
            }
            System.out.println(mostDoubleLetter + " has the most consecutive double letters with " + maxDoubleLetters + " double letters");
            read.close();

        }catch(IOException iOE){
            System.out.println("File words.txt not found");
            System.exit(0);
        }
    }
}
