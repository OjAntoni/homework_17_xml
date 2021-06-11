import Console.Meeter;
import Parser.DOMparser.DOMparser;
import Parser.Parser;
import Parser.SAXParser.*;
import Writer.Writer;
import model.Poem;

public class Main {
    public static void main(String[] args) {
        String path = Meeter.meet();
        try {
            Meeter.check(path);
            int option = Meeter.selectOption();
            Parser parser;
            if(option==1){
                parser = new MySAXparser();
            }
            else {
                parser = new DOMparser();
            }
            parser.startParsing(Meeter.getXMLfile());
            Writer.write();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
