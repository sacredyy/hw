package hw4;

import java.io.*;
import java.util.Arrays;




public class FileService {

    public static void moveFile(File fileF, File fileT) throws IOException{
        try (InputStream is = new FileInputStream(fileF);
        OutputStream os = new FileOutputStream(fileT)) {
            is.transferTo(os);
        }
    }

    public static String transferFile (File folder, File folderTarget, String extension) throws IOException{
            File[] files = folder.listFiles();

            if (!folderTarget.exists()){
                folderTarget.mkdirs();
            }

            for (int i = 0; i < files.length; i++) {
                if (files[i].isFile()) {
                    String tempName = files[i].getName();
                    String[] tempExt = tempName.split("\\.");
                    if (tempExt[1].equals(extension)) {
                        File fileTarget = new File(folderTarget, tempName);
                        moveFile(files[i], fileTarget);
                    }
                }
            }
            return "Files copyed succesfully";
    }
}
