package Writer;

import model.Poem;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {
    public static void write(){
        File destFile = new File(Poem.getFirstname()+"_"+ Poem.getLastname()+"_"+ Poem.getTitle().replaceAll(" ","_"));
        try {
            if(destFile.createNewFile()){
                try(BufferedWriter bw = new BufferedWriter(new FileWriter(destFile))) {
                    bw.write(Poem.getPoem().toString());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
