package Multithreading.hw4;

import java.io.File;

public class Main {

    public static void main(String[] args) {

        File folderIn = new File("/home/kevin/test1");
        File folderOut = new File("/home/kevin/test2");
        String extension = "txt";

        File[] files = folderIn.listFiles((dir, name) -> name.endsWith(extension));

        if (files == null || files.length == 0) {
            System.out.println("No files with extension " + extension);
            return;
        }

        if (!folderOut.exists()) {
            folderOut.mkdirs();
        }

        FileService.setTotalFiles(files.length);
        FileService.resetCounter();

        for (File file : files) {
            FileService fileService = new FileService(file, new File(folderOut, file.getName()));
            Thread thread = new Thread(fileService);
            thread.start();
        }
    }
}
