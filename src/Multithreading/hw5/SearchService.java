package Multithreading.hw5;

import java.io.File;

public class SearchService {
    private final File[] dirQueue = new File[1000];
    private int queueStart = 0;
    private int queueEnd = 0;
    private final Object queueLock = new Object();

    private final String[] results = new String[1000];
    private int resultCount = 0;
    private final Object resultLock = new Object();

    private final String targetName;
    private final int THREAD_COUNT = 4;

    public SearchService(String rootPath, String targetName) {
        this.targetName = targetName;
        File root = new File(rootPath);
        if (root.exists() && root.isDirectory()) {
            dirQueue[queueEnd++] = root;
        }
    }

    public void startSearch() {
        Thread[] threads = new Thread[THREAD_COUNT];

        for (int i = 0; i < THREAD_COUNT; i++) {
            threads[i] = new Thread(new SearchTask(dirQueue, queueLock, this, results, resultLock, targetName));
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException ignored) {}
        }

        System.out.println("Files founded:");
        for (int i = 0; i < resultCount; i++) {
            System.out.println(results[i]);
        }
    }

    public File getNextDirectory() {
        synchronized (queueLock) {
            if (queueStart < queueEnd) {
                return dirQueue[queueStart++];
            }
            return null;
        }
    }

    public void addDirectory(File dir) {
        synchronized (queueLock) {
            if (queueEnd < dirQueue.length) {
                dirQueue[queueEnd++] = dir;
            }
        }
    }

    public void addResult(String path) {
        synchronized (resultLock) {
            if (resultCount < results.length) {
                results[resultCount++] = path;
            }
        }
    }
}