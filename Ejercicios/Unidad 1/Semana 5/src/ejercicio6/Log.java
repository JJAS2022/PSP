package ejercicio6;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Log implements Runnable{
    private String path = "C:\\Users\\jjase\\Desktop\\log.txt";
    private PrintWriter pW;

    public Log() {
        try {
            pW = new PrintWriter (new BufferedWriter( new FileWriter(path)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            enterLog(i);
        }
        pW.flush();
    }

    private synchronized void enterLog(int i) {
        Thread thread = Thread.currentThread();
        String threadName = thread.getName();
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("HH:mm:ss yyyy/MM/dd");

        pW.printf("ID: %s - %s\n", threadName, dateFormat.format(date));
        pW.printf("Este es mi mensaje número %d\n", i);
    }
}
