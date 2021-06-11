package Console;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Optional;
import java.util.Scanner;

public class Meeter {
    public static File XMLfile;

    public static String meet(){
        Scanner s = new Scanner(System.in);
        System.out.print("Введите путь к файлу xml: ");
        return s.nextLine();
    }

    public static void check(String path) throws FileNotFoundException {
        File file = new File(path);
        while (file.isDirectory()){
            Optional<File[]> opt = Optional.ofNullable(file.listFiles());
            if(opt.get().length==0) {
                throw new FileNotFoundException("Nothing to show here...");
            } else {
                if(opt.get().length>1){
                    throw new FileNotFoundException("Too much files...");
                } else {
                    file = opt.get()[0];
                }
            }
        }
        if(file.getName().endsWith(".xml")) XMLfile = file;
        else throw new FileNotFoundException("No XML file there...");
    }

    public static int selectOption(){
        Scanner s = new Scanner(System.in);
        System.out.print("Введите метод для парсинга (1-SAX, 2-Dom): ");
        int option = s.nextInt();
        return (option==1 || option==2) ? option : 1;
    }

    public static File getXMLfile(){
        return XMLfile;
    }


}
