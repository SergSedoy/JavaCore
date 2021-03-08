package javaCore.inputOutput1_1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        String srcPath = "D://Games/src/";
        String recPath = "D://Games/rec/";
        String tempPath = "D://Games/temp/";
        String savegamesPath = "D://Games/savegames/";

        createDir(srcPath, stringBuilder);
        createDir(recPath, stringBuilder);
        createDir(tempPath, stringBuilder);
        createDir(savegamesPath, stringBuilder);

        createDir(srcPath + "main/", stringBuilder);
        createDir(srcPath + "test/", stringBuilder);

        createDir(recPath + "drawables/", stringBuilder);
        createDir(recPath + "vectors/", stringBuilder);
        createDir(recPath + "icons/", stringBuilder);

        createFile(srcPath + "main/Main.java", stringBuilder);
        createFile(srcPath + "main/Utils.java", stringBuilder);
        createFile(tempPath + "temp.txt", stringBuilder);

        try (FileOutputStream fos = new FileOutputStream(tempPath + "temp.txt", true)) {
            fos.write(stringBuilder.toString().getBytes());
        } catch (IOException e) {
            stringBuilder.append(e.getMessage());
            System.out.println(e.getMessage());
        }
    }

    public static void createDir(String path, StringBuilder stringBuilder) {
        File dir = new File(path);
        if (dir.mkdir())
            stringBuilder.append("каталог создан ")
                    .append(dir)
                    .append("\n");
    }

    public static void createFile(String path, StringBuilder stringBuilder) {
        File file = new File(path);
        try {
            if (file.createNewFile()) {
                stringBuilder.append("файл создан ")
                        .append(file)
                        .append("\n");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
