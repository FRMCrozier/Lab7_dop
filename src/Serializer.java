import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Serializer {

    /**
     * Методы работы с байтами
     */

    public static byte[] hexToByte(String hex) {
        int l = hex.length();
        byte[] data = new byte[l / 2];
        for (int i = 0; i < l; i += 2) {
            data[i / 2] = (byte) ((Character.digit(hex.charAt(i), 16) << 4)
                    + Character.digit(hex.charAt(i + 1), 16));
        }
        return data;
    }

    public String getObjBytes(ArrayList list) {
        byte[] bytes = list.toString().getBytes(StandardCharsets.UTF_8);
        char[] value = new char[2*bytes.length];
        String hex = "0123456789ABCDEF";
        for (int i = 0; i < bytes.length; i++)
        {
            int b = bytes[i] & 0xff;
            value[2*i] = hex.charAt(b >>> 4);
            value[2*i + 1] = hex.charAt(b & 15);
        }
        return String.valueOf(value);
    }

    /**
     * Реализация сериализации (без использования библиотек) и сохранения в бинарный файл
     */

    public void SaveSerialize(String filename, ArrayList list) {
        String data = getObjBytes(list);
        try {
            FileOutputStream f = new FileOutputStream(filename);
            copyFile(filename);
            f.write(data.getBytes());
            f.close();
            copyFile(filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Реализация десериализации (без использования библиотек) и загрузки данных
     */

    public ArrayList LoadDeserialize(String file) throws IOException {
        FileInputStream f = new FileInputStream(file);
        byte[] array = f.readAllBytes();

        f.close();
        String str = new String(array, StandardCharsets.UTF_8);
        array = hexToByte(str);
        String st = new String(array, StandardCharsets.UTF_8);
        String[] strings = st.split(",");
        MoviesForCinema movies = new MoviesForCinema();
        return movies.getFromLoadString(strings);
    }

    /**
     * Реализация метода очистки данных
     */
    public void Clear(ArrayList list) {
        list.clear();
    }

    /**
     * Получение имени файла резервной копии
     */
    public String getNameCopyFile() {
        String tm = String.valueOf(System.currentTimeMillis());
        tm = "reservCopy_" + tm + "_";
        return tm;
    }

    /**
     * Резервное копирование
     */
    private void copyFile(String filename) throws IOException {
        String filename2 = getNameCopyFile();
        File f1 = new File(filename);
        File f2 = new File(filename2 + filename);
        FileChannel sourceChannel;
        FileChannel destChannel;
        sourceChannel = new FileInputStream(f1).getChannel();
        destChannel = new FileOutputStream(f2).getChannel();
        destChannel.transferFrom(sourceChannel, 0, sourceChannel.size());

    }


}
