package simulator;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 *
 * @author Andrew "AnarH" Skrypnik
 */
public class Client {

    public static void main(String[] ar) {
        try {
            // открываем сокет и коннектимся к localhost:3128
            // получаем сокет сервера
            Socket s = new Socket("localhost", 3128  );

            // берём поток вывода и выводим туда первый аргумент
            // заданный при вызове, адрес открытого сокета и его порт
            Aircraft a = new Aircraft();
            
            String arr = a.version;
            arr = arr + "\n" + s.getInetAddress().getHostAddress()
                    + ":" + s.getLocalPort();
            s.getOutputStream().write(arr.getBytes());

            // читаем ответ
            byte buf[] = new byte[64 * 1024];
            int r = s.getInputStream().read(buf);
            String data = new String(buf, 0, r);

            // выводим ответ в консоль
            System.out.println(data);
        } catch (Exception e) {
            System.out.println("init error: " + e);
        } // вывод исключений
    }
}
