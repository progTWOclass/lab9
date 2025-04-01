import java.io.*;

public class FindAverageDoubleNum {
    public static void main(String[] args){
        //creating the text file that contains double numbers as a string
        try{
            PrintWriter printDoubleNum = new PrintWriter(new FileOutputStream("doubleNum.txt"));

            for(int i = 0; i < 20; i++){
                double randNum = (Math.random()*20) + 1;
                String numbers = String.valueOf(randNum);
                String format = String.format("%.2f", randNum);
                printDoubleNum.println(format);
            }

            System.out.println("text file with double numbers created successfully");
            printDoubleNum.close();
        }catch(IOException IOE){
            System.out.println("problem with the file. cannot create the text file");
        }

        //reading the text file and start calculating the average of the those numbers
        try{
            BufferedReader read = new BufferedReader(new FileReader("doubleNum.txt"));
            double calculatedAverage = calculateAverage(read);
            System.out.printf("your average is %.2f", calculatedAverage);
            read.close();

        }catch(FileNotFoundException fNFE){
            System.out.println("File not found");
        }catch (IOException iOE){
            System.out.println("cannot open file. problem with the file");
        }
    }

    //method
    public static double calculateAverage(BufferedReader read) throws IOException {
        String fileContent;
        double sum = 0;
        int count = 0;
        while ((fileContent = read.readLine()) != null){
            double number = Double.parseDouble(fileContent);
            System.out.println(fileContent);
            sum += number;
            count++;
        }
        System.out.printf("your sum is %.2f\n", sum);
        return sum / count;
    }
}
