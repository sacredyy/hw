package Multithreading.hw5;

import java.io.File;

public class SearchTask implements Runnable {
    private final File[] dirQueue;
    private final Object queueLock;
    private final SearchService service;
    private final String[] results;
    private final Object resultLock;
    private final String targetName;

    public SearchTask(File[] dirQueue, Object queueLock,
                      SearchService service, String[] results,
                      Object resultLock, String targetName) {
        this.dirQueue = dirQueue;
        this.queueLock = queueLock;
        this.service = service;
        this.results = results;
        this.resultLock = resultLock;
        this.targetName = targetName;
    }

    @Override
    public void run() {
        while (true) {
            File dir = service.getNextDirectory();
            if (dir == null) break;

            File[] files = dir.listFiles();
            if (files == null) continue;

            for (File file : files) {
                if (file.isDirectory()) {
                    service.addDirectory(file);
                } else if (file.getName().equals(targetName)) {
                    service.addResult(file.getAbsolutePath());
                }
            }
        }
    }
}
