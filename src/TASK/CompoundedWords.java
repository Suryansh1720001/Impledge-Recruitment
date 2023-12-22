package TASK;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CompoundedWords {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        // Name the input file you want to read - Input_02.txt
        List<String> wordList = readWordsFromFile("D:\\Impledge Recruitment\\Impledge_Recruitment_TASK\\src\\TASK\\Input_02.txt");

        if (wordList != null && !wordList.isEmpty()) {
            List<String> compoundWords = findCompoundWords(wordList);

            String longestCompound = "";
            String secondLongestCompound = "";

            for (String word : compoundWords) {
                if (word.length() > longestCompound.length()) {
                    secondLongestCompound = longestCompound;
                    longestCompound = word;
                } else if (word.length() > secondLongestCompound.length()) {
                    secondLongestCompound = word;
                }
            }

            System.out.println("Longest Compound Word: " + longestCompound);
            System.out.println("Second Longest Compound Word: " + secondLongestCompound);

            long end = System.currentTimeMillis();
            long elapsedTime = end - start;
            System.out.println("Time taken to process file: " + elapsedTime + " milliseconds");
        } else {
            System.out.println("No words found in the file or file not found.");
        }
    }

    public static List<String> readWordsFromFile(String filePath) {
        List<String> words = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] lineWords = line.split("\\s+");
                for (String word : lineWords) {
                    words.add(word);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return words;
    }

    public static List<String> findCompoundWords(List<String> words) {
        Set<String> wordSet = new HashSet<>();
        List<String> result = new ArrayList<>();

        for (String word : words) {
            wordSet.add(word);
        }

        for (String word : words) {
            int size = word.length();
            boolean[] flags = new boolean[size + 1];
            flags[0] = true;

            for (int i = 0; i < size; i++) {
                if (!flags[i]) {
                    continue;
                }
                for (int j = i + 1; j <= size; j++) {
                    if (j - i < size && wordSet.contains(word.substring(i, j))) {
                        flags[j] = true;
                    }
                }
                if (flags[size]) {
                    result.add(word);
                    break;
                }
            }
        }
        return result;
    }
}
