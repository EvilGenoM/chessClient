package mobi.mpk.chess.cli;

import com.google.gson.Gson;
import mobi.mpk.chess.Config;

import java.io.IOException;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {

    private int port = Config.PORT;
    private String adress = Config.IP;
    private DataInputStream in;
    private DataOutputStream out;

    public Client(){
        try{
            Socket socket = new Socket(adress, port);
            System.out.println("Вы подключились!");

            out = new DataOutputStream(socket.getOutputStream());
            in = new DataInputStream(socket.getInputStream());

            Scanner read = new Scanner(System.in);
            System.out.println("Введите имя:");

            Reader reader = new Reader(in);
            reader.start();

            Gson gson = new Gson();
            String line;

            while(true){
                line = read.nextLine();

                Request request = new Request("", line);

                String gsonString = gson.toJson(request);

                out.writeUTF(gsonString);

                if(line.equals("exit")) break;
            }

            in.close();
            out.close();
            socket.close();

        } catch (IOException ex){
            System.out.println(ex);
        }
    }

}
