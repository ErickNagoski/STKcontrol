package util;

import Class.ErrorLog;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Logs {
    private static File file= new File("logs.txt");

    public static void writeLog(ErrorLog log) throws IOException {
        if(!file.exists()){
            file.createNewFile();
        }

        try (FileOutputStream fos = new FileOutputStream(file);
             ObjectOutputStream oos = new ObjectOutputStream(fos)){
            oos.writeObject(log);
            System.out.println("erro adicionado");
        }catch (IOException e){
            System.out.println("não gravou");
        }
    }

}
