package util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import Class.ErrorLog;

public class Logs {
    private static File file;

    public Logs() {
        this.file = new File("logs.txt");
    }

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
