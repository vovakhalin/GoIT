package HomeworkThree;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.HashMap;
import java.util.Map;

public class Demo {

    public static void main(String[] args){
        File fileTelephon = new File("src/main/java/HomeworkThree/Files/file.txt");
        printTelephon(fileTelephon);

        File fileGson = new File("src/main/java/HomeworkThree/Files/file_2.txt");
        List<Person> persons = readFromFile(fileGson);
        writeToJson(persons, "src/main/java/HomeworkThree/Files/user.json");

        File fileWords = new File("src/main/java/HomeworkThree/Files/words.txt");

        Map<String, Integer> wordFrequency = countWord(fileWords);
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    public static void printTelephon(File name) {
        if(name.exists()) {

            String regexOne = "^\\(\\d{3}\\) \\d{3}-\\d{4}$";
            String regexTwo = "^\\d{3}-\\d{3}-\\d{4}$";

            Pattern patternOne = Pattern.compile(regexOne);
            Pattern patternTwo = Pattern.compile(regexTwo);

            try (BufferedReader br = new BufferedReader(new FileReader(name))) {
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
    public static List<Person> readFromFile(File name) {
        List<Person> users = new ArrayList<>();

        if(name.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(name))) {
                String line;
                boolean firstLine = true;
                String[] headers = null;

                while ((line = br.readLine()) != null) {
                    if(firstLine) {
                        headers = line.split(" ");
                        firstLine = false;
                    } else {
                        String[] userData = line.split(" ");
                        if (userData.length == headers.length) {
                            users.add(new Person(userData[0], Integer.parseInt(userData[1])));
                        }
                    }

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("File doesn't exist");
        }
        return users;
    }
    public static void writeToJson(List<Person> users, String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(users, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Map<String, Integer> countWord(File name) {
        Map<String, Integer> wordFrequency = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(name))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split(" ");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wordFrequency;
    }



}
