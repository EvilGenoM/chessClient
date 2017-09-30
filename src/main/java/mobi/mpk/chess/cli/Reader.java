package mobi.mpk.chess.cli;

import com.google.gson.Gson;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Reader extends Thread {

    private DataInputStream in;

    public Reader(DataInputStream in){
        this.in = in;
    }

    public void run(){
        try {

            String line;
            Gson gson = new Gson();

            while (true) {
                line = in.readUTF();
                Request request = gson.fromJson(line, Request.class);

                System.out.println(request.text);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
