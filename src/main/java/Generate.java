import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Generate {
    public static void main(String[] args) throws IOException {
        File sample = new File("/home/tardis3/ScriptPrototype/src/main/resources/Samples/Rust.java");
        FileReader reader = new FileReader(sample);
        char[] con = new char[(int) sample.length()];
        reader.read(con);
        File generated = new File("./Rust.java");
        FileWriter writer = new FileWriter(generated);
        writer.write(con);
        //System.out.println(con);
        writer.close();
    }
}
