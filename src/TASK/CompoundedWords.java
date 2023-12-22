package TASK;
//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//public class CompoundedWords{
//    public static void main(String[] args) {
//            long startTime = System.currentTimeMillis(); // Start time
//
//            List<String> words = readWordsFromFile("D:\\Impledge Recruitment\\Impledge_Recruitment_TASK\\src\\TASK\\Input_02.txt"); // Replace with actual file name
//
//            if (words != null && !words.isEmpty()) {
//                List<String> compoundedWords = findAllConcatenatedWordsInADict(words);
//
//                // Find longest and second longest compounded words
//                String longest = "";
//                String secondLongest = "";
//
//                for (String word : compoundedWords) {
//                    if (word.length() > longest.length()) {
//                        secondLongest = longest;
//                        longest = word;
//                    } else if (word.length() > secondLongest.length()) {
//                        secondLongest = word;
//                    }
//                }
//
//                // Display results
//                System.out.println("Longest Compound Word: " + longest);
//                System.out.println("Second Longest Compound Word: " + secondLongest);
//
//                // Calculate and display time taken
//                long endTime = System.currentTimeMillis();
//                long timeTaken = endTime - startTime;
//                System.out.println("Time taken to process file: " + timeTaken + " milliseconds");
//            } else {
//                System.out.println("No words found in the file or file not found.");
//            }
//        }
//
//
//        public static List<String> readWordsFromFile(String fileName) {
//        List<String> words = new ArrayList<>();
//
//        try {
//            BufferedReader reader = new BufferedReader(new FileReader(fileName));
//            String line;
//
//            while ((line = reader.readLine()) != null) {
//                // Assuming words are separated by spaces or any other delimiter
//                String[] lineWords = line.split("\\s+"); // Adjust the delimiter as per file format
//                for (String word : lineWords) {
//                    words.add(word);
//                }
//            }
//
//            reader.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//            return null;
//        }
//
//        return words;
//    }
//
//    public static List<String> findAllConcatenatedWordsInADict(List<String> words) {
//        Set<String> set = new HashSet<>();
//        List<String> result = new ArrayList<>();
//
//        for (String word : words) {
//            set.add(word);
//        }
//
//        for (String word : words) {
//            int sz = word.length();
//            boolean[] flags = new boolean[sz + 1];
//            flags[0] = true;
//
//            for (int i = 0; i < sz; i++) {
//                if (!flags[i]) {
//                    continue;
//                }
//                for (int k = i + 1; k <= sz; k++) {
//                    if (k - i < sz && set.contains(word.substring(i, k))) {
//                        flags[k] = true;
//                    }
//                }
//                if (flags[sz]) {
//                    result.add(word);
//                    break;
//                }
//            }
//        }
//        return result;
//    }
//}


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
