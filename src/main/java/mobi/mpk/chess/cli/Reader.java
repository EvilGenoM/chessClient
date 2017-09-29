package mobi.mpk.chess.cli;

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

            while (true) {
                line = in.readUTF();
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
