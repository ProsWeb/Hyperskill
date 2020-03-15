//Download and unpack the following archive:
// https://stepik.org/media/attachments/lesson/91426/basedir.zip﻿.
//
//        If you open it, you will see a hierarchy of files.
//
//        Write a program that finds
//        the deepest file (or a directory) in this hierarchy.
//
//        Enter the name of the file you will get.
//
//        The required format example:
//
//        FAf9SDqa5h

import java.io.File;

public class DeepestFile {

    public static void main(String[] args) {
        String pathToDir = "/home/snake/Downloads/basedir";
        File baseDir = new File(pathToDir);
        System.out.println(findDeepestItem(baseDir));
    }

    private static int deepestLevel = 0;
    private static String deepestItem = "";

    static String findDeepestItem(final File folder) {
        int currentLevel;
        String result;
        File[] folderEntries = folder.listFiles();

        for (File entry : folderEntries) {

            if (entry.isDirectory()) {
                findDeepestItem(entry);
            }

            currentLevel = countMatches(entry.getPath());

            if (deepestLevel < currentLevel) {
                deepestLevel = currentLevel;
                deepestItem = entry.getPath();
            }
        }

        result = deepestLevel + " " + deepestItem;

        return result;
    }

    private static int countMatches(final String path) {
        int number = 0;
        String[] array = path.split("");

        for (int i = 0; i < path.length(); i++) {
            if ("/".contentEquals(array[i])) {
                number++;
            }
        }

        return number;
    }
}
