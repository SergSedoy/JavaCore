package javaCore.inputOutput1_2;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Main {
    public static void main(String[] args) {
        GameProgress gameProgress = new GameProgress(5, 9, 32, 789.9);
        GameProgress gameProgress1 = new GameProgress(3, 4, 14, 89.7);
        GameProgress gameProgress2 = new GameProgress(1, 19, 132, 5789.4);

        saveGame("D://Games/savegames/save.dat", gameProgress);
        saveGame("D://Games/savegames/save1.dat", gameProgress1);
        saveGame("D://Games/savegames/save2.dat", gameProgress2);

        zipFiles("D://Games/savegames/zip.zip", "D://Games/savegames/save.dat", "D://Games/savegames/save1.dat", "D://Games/savegames/save2.dat");
    }

    public static void saveGame(String path, GameProgress gameProgress) {
        try (FileOutputStream fos = new FileOutputStream(path);
             ObjectOutputStream ois = new ObjectOutputStream(fos)) {
            ois.writeObject(gameProgress);
            System.out.println("Игра успешно сохранена!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void zipFiles(String path, String save, String save1, String save2) {
        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(path))) {
            try (FileInputStream fis = new FileInputStream(save)) {
                ZipEntry entry = new ZipEntry("save.dat");
                zos.putNextEntry(entry);
                byte[] b = new byte[fis.available()];
                fis.read(b);
                zos.write(b);
                zos.closeEntry();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

            try (FileInputStream fis = new FileInputStream(save1)) {
                ZipEntry entry = new ZipEntry("save1.dat");
                zos.putNextEntry(entry);
                byte[] b = new byte[fis.available()];
                fis.read(b);
                zos.write(b);
                zos.closeEntry();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

            try (FileInputStream fis = new FileInputStream(save2)) {
                ZipEntry entry = new ZipEntry("save2.dat");
                zos.putNextEntry(entry);
                byte[] b = new byte[fis.available()];
                fis.read(b);
                zos.write(b);
                zos.closeEntry();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        File del = new File(save);
        if (del.delete()) System.out.println("файл " + save.substring(20) + " удален!");

        File del1 = new File(save1);
        if (del1.delete()) System.out.println("файл " + save1.substring(20) + " удален!");

        File del2 = new File(save2);
        if (del2.delete()) System.out.println("файл " + save2.substring(20) + " удален!");
    }
}
