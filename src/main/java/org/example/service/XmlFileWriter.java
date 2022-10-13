package org.example.service;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * This class is responsible for writing the list in a txt-file.
 */
public class XmlFileWriter {
    /**
     * It is responsible for creating a txt file and writing the deposit information of each person in the txt-file.
     *
     * @param list Takes a list of deposit information as an input parameter.
     */
    public static void writer(List<String> list) throws IOException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //Creating objects using reflection in Java
        //Without using reflection: RandomAccessFile raf = new RandomAccessFile("C:\\Users\\Eniac\\Desktop\\ttt.txt", "rw");
        Class randomAccessFileClass = RandomAccessFile.class;
        Constructor constructor = randomAccessFileClass.getConstructor(String.class, String.class);
        Object o = constructor.newInstance("C:\\Users\\Eniac\\Desktop\\Interest.txt", "rw");
        RandomAccessFile raf = (RandomAccessFile) o;
        for (String s : list) {
            raf.writeBytes(s + "\n");
        }
    }
}
