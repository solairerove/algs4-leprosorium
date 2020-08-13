package com.github.solairerove.algs4.leprosorium.simple_string;

/**
 * given a string and positive integer as key, write a method,
 * that return new string by shifting every letter in the input string
 * by k positions in the alphabet, where k is key.
 * <p>
 * <-
 * string = cdz
 * key = 2
 * <p>
 * result = zab
 */
public class CaesarCipherEncryptor {
    public static void main(String... args) {
        System.out.printf("%s\n", (char) 122);

        System.out.printf("%s -> %s : %s\n", "xyz", 2, decrypt("xyz", 2));
    }

    private static String decrypt(String s, int key) {
        char[] newLetters = new char[s.length()];
        int newKey = key % 26;

        for (int i = 0; i < s.length(); ++i) {
            newLetters[i] = getNewLetter(s.charAt(i), newKey);
        }

        return new String(newLetters);
    }

    private static char getNewLetter(char letter, int key) {
        int newLetterCode = letter + key;

        // if <= z ? letter : a + code % z
        return newLetterCode <= 122 ? (char) newLetterCode : (char) (96 + newLetterCode % 122);
    }
}
