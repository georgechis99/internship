package com.arobs.intenrship.lab7.ex3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EncryptDecrypt {
    public static final String directoryPath = "C:\\Users\\george.chis\\Desktop\\Internship\\homework\\" +
            "Week 1\\Lab7\\src\\com\\arobs\\intenrship\\lab7\\ex3\\";
    public static final String plainTextFileName = "plainText.txt";
    private static String encryptedTextFileName = "";
    private static String decryptedTextFileName = "";
    private static File plainTextFile;
    private static File encryptedTextFile;
    private static File decryptedTextFile;

    public static void main(String[] args) {

        String plainTextPath = directoryPath + plainTextFileName;
        plainTextFile = new File(plainTextPath);

        try {
            encryptDecript(args[0], args[1]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("WRONG ARGUMENTS RUNTIME EXCEPTION");
        }

    }

    public static String encryptLine(String plainText, int shift) {
        String encryptedLine = "";
        for (int i = 0; i < plainText.length(); i++) {
            char c = (char) (plainText.charAt(i) + shift);
            encryptedLine += c;
        }
        return encryptedLine;
    }

    public static String decryptLine(String encryptedText, int shift) {
        String decryptedLine = "";
        for (int i = 0; i < encryptedText.length(); i++) {
            char c = (char) (encryptedText.charAt(i) - shift);
            decryptedLine += c;
        }
        return decryptedLine;
    }

    public static void encryptDecript(String operation, String filename) {
        switch (operation) {
            case "encrypt":
                encryptedTextFileName = filename;
                encryptedTextFile = createOrLocateFile(filename);
                if (encryptedTextFile == null) {
                    System.out.println("Error at creating encryption file file...");
                    break;
                }

                try {
                    Scanner scanner = new Scanner(plainTextFile);
                    FileWriter writer = new FileWriter(encryptedTextFile);
                    while (scanner.hasNextLine()) {
                        String encryptedLine = encryptLine(scanner.nextLine(), 1);
                        writer.write(encryptedLine);
                    }
                    scanner.close();
                    writer.close();
                } catch (FileNotFoundException e) {
                    System.out.println("Error at reading from plain text file...");
                } catch (IOException e) {
                    System.out.println("Error at writing to encrypted file...");
                }
                System.out.println("Encrypted successfully!");
                break;

            case "decrypt":
                encryptedTextFile = createOrLocateFile(encryptedTextFileName);
                decryptedTextFileName = filename;
                decryptedTextFile = createOrLocateFile(filename);
                if (decryptedTextFile == null) {
                    System.out.println("Error at creating decryption file file...");
                    break;
                }

                try {
                    Scanner scanner = new Scanner(encryptedTextFile);
                    FileWriter writer = new FileWriter(decryptedTextFile);
                    while (scanner.hasNextLine()) {
                        String decryptedLine = decryptLine(scanner.nextLine(), 1);
                        writer.write(decryptedLine);
                    }
                    scanner.close();
                    writer.close();
                } catch (FileNotFoundException e) {
                    System.out.println("Error at reading from encrypted file...");
                } catch (IOException e) {
                    System.out.println("Error at writing to decrypted file...");
                }
                System.out.println("Decrypted successfully!");
                break;

            default:
                System.out.println("Command line argument not valid... (provide 'encrypt' or 'decrypt')");
                break;
        }
    }

    public static File createOrLocateFile(String filename) {
        String fullPath = directoryPath + filename;
        File file = new File(fullPath);
        try {
            if (!file.createNewFile()) {
                System.out.println("File located successfully");
            } else {
                System.out.println("File created successfully");
            }
            return file;
        } catch (IOException e) {
            System.out.println("Command line argument not valid... (provide valid file name)");
        }
        return null;
    }

//    public static void encryptFile() {
//        encryptedTextFile = new File(directoryPath + "encrypted.enc");
//        try {
//            if (!encryptedTextFile.createNewFile()) {
//                System.out.println("File .enc located");
//            } else {
//                System.out.println("File .enc created");
//            }
//
//            FileWriter writer = new FileWriter(encryptedTextFile);
//            Scanner scanner = new Scanner(plainTextFile);
//
//
//        } catch (IOException e) {
//            System.out.println("encrypted.enc could not be created...");
//        }
//    }
//
//    public static void decryptFile() {
//        decryptedTextFile = new File(directoryPath + "decrypted.dec");
//        try {
//            if (!decryptedTextFile.createNewFile()) {
//                System.out.println("File .dec located");
//            } else {
//                System.out.println("File .dec created");
//            }
//
//            FileWriter writer = new FileWriter(decryptedTextFile);
//            Scanner scanner = new Scanner(encryptedTextFile);
//            while (scanner.hasNextLine()) {
//                String decryptedLine = decryptLine(scanner.nextLine(), 1);
//                writer.write(decryptedLine);
//            }
//            scanner.close();
//            writer.close();
//
//            System.out.println("Decrypted successfully!");
//
//        } catch (IOException e) {
//            System.out.println("decrypted.dec could not be created...");
//        }
//    }
}
