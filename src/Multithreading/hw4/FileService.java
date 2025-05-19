package Multithreading.hw4;

import java.io.*;
import java.util.concurrent.atomic.AtomicInteger;

public class FileService implements Runnable {

    private static AtomicInteger copiedCount = new AtomicInteger(0);
    private static int totalFiles;

    private File fileIn;
    private File fileOut;

    public FileService(File fileIn, File fileOut) {
        this.fileIn = fileIn;
        this.fileOut = fileOut;
    }

    public static void setTotalFiles(int total) {
        totalFiles = total;
    }

    public static void resetCounter() {
        copiedCount.set(0);
    }

    public void copyFile() throws IOException {
        try (InputStream is = new FileInputStream(fileIn);
             OutputStream os = new FileOutputStream(fileOut)) {
            is.transferTo(os);
        }
    }

    @Override
    public void run() {
        try {
            copyFile();
            int copied = copiedCount.incrementAndGet();
            double progress = 100.0 * copied / totalFiles;
            System.out.printf("Copied %d of %d files (%.2f%%)\n", copied, totalFiles, progress);
        } catch (IOException e) {
            System.err.println("Error during copying " + fileIn.getName());
            e.printStackTrace();
        }
    }
}


