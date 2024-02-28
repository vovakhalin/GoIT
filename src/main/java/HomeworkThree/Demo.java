package HomeworkThree;

import java.io.File;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.FileReader;

public class Demo {

    public static void main(String[] args){

        File file = new File("src/main/java/HomeworkThree/Files/file.txt");
        if(file.exists()) {

            String regexOne = "^\\(\\d{3}\\) \\d{3}-\\d{4}$";
            String regexTwo = "^\\d{3}-\\d{3}-\\d{4}$";

            Pattern patternOne = Pattern.compile(regexOne);
            Pattern patternTwo = Pattern.compile(regexTwo);

            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null) {
                    Matcher matcher1 = patternOne.matcher(line);
                    Matcher matcher2 = patternTwo.matcher(line);

                    if (matcher1.matches() || matcher2.matches()) {
                        System.out.println(line);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("File doesn't exist");
        }
    }

    File fileJson = new File("src/main/java/HomeworkThree/Files/file_2.txt");
}
