package javaCore.inputOutput1_1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();

        File dir = new File("D://Games/src");
        if (dir.mkdir())
            stringBuilder.append("каталог создан ")
                    .append(dir)
                    .append("\n");

        File dir1 = new File("D://Games/rec");
        if (dir1.mkdir())
            stringBuilder.append("каталог создан ")
                    .append(dir1)
                    .append("\n");

        File dir2 = new File("D://Games/savegames");
        if (dir2.mkdir())
            stringBuilder.append("каталог создан ")
                    .append(dir2)
                    .append("\n");

        File dir3 = new File("D://Games/temp");
        if (dir3.mkdir())
            stringBuilder.append("каталог создан ")
                    .append(dir3)
                    .append("\n");

        File src = new File("D://Games/src/main");
        if (src.mkdir())
            stringBuilder.append("каталог создан ")
                    .append(src)
                    .append("\n");

        File test = new File("D://Games/src/test");
        if (test.mkdir())
            stringBuilder.append("каталог создан ")
                    .append(test)
                    .append("\n");

        File fileOne = new File("D://Games/src/main/Main.java");
        try {
            if (fileOne.createNewFile())
                stringBuilder.append("файл создан ")
                        .append(fileOne)
                        .append("\n");
        } catch (IOException e) {
            stringBuilder.append(e.getMessage());
            System.out.println(e.getMessage());
        }

        File fileTwo = new File("D://Games/src/main/Utils.java");
        try {
            if (fileTwo.createNewFile())
                stringBuilder.append("файл создан ")
                        .append(fileTwo)
                        .append("\n");
        } catch (IOException e) {
            stringBuilder.append(e.getMessage());
            System.out.println(e.getMessage());
        }

        File dir4 = new File("D://Games/rec/drawables");
        if (dir4.mkdir())
            stringBuilder.append("каталог создан ")
                    .append(dir4)
                    .append("\n");

        File dir5 = new File("D://Games/rec/vectors");
        if (dir5.mkdir())
            stringBuilder.append("каталог создан ")
                    .append(dir5)
                    .append("\n");

        File dir6 = new File("D://Games/rec/icons");
        if (dir6.mkdir())
            stringBuilder.append("каталог создан ")
                    .append(dir6)
                    .append("\n");

        File file3 = new File("D://Games/temp/temp.txt");
        try {
            if (file3.createNewFile())
                stringBuilder.append("файл создан ")
                        .append(file3)
                        .append("\n");
        } catch (IOException e) {
            stringBuilder.append(e.getMessage());
            System.out.println(e.getMessage());
        }

        try (FileOutputStream fos = new FileOutputStream("D://Games/temp/temp.txt", true)) {
            fos.write(stringBuilder.toString().getBytes());
        } catch (IOException e) {
            stringBuilder.append(e.getMessage());
            System.out.println(e.getMessage());
        }
    }
}
