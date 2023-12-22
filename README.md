# Compound Word Finder

## Overview
This Java application aims to identify the longest and second longest compounded words within a text file containing a list of alphabetically sorted words. A compounded word is defined as a word that can be constructed by concatenating shorter words from the same list.

## Execution Steps
1. **Clone Repository:** Clone this repository containing the Java source code.
2. **Open in IDE:** Import the project into an Integrated Development Environment (IDE) such as IntelliJ IDEA or Eclipse.
3. **Specify File Path:** Replace `"D:\\Path\\To\\Your\\File.txt"` in the `main` method with the actual file path containing the word list.
4. **Run Application:** Execute the `CompoundWordFinder.java` file to run the program.

## Approach
- **File Handling:** The program utilizes BufferedReader to read the word list from a text file.
- **Word Processing:** It splits words based on whitespace separators and stores them in a list.
- **Compound Word Identification:** The `findCompoundWords` method identifies compounded words by iterating through the word list, using a set-based approach to check concatenation possibilities.
- **Selection of Longest Compounded Words:** After identifying compounded words, it iterates through them to determine the longest and second longest compounds.
- **Time Measurement:** Time is recorded using `System.currentTimeMillis()` to calculate processing time.

## Design Decisions
- **Data Structures:** ArrayList and HashSet are employed for efficient word storage and checking.
- **Algorithm:** Dynamic programming is used to efficiently determine compounded words within the word list.
- **Error Handling:** Basic error handling is implemented for file reading failures.

## Note
- Ensure the input file follows the correct format, with words separated by spaces or a specified delimiter.
- This README assumes familiarity with Java programming and IDE usage.

