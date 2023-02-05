import java.io.*;
import java.nio.file.Files;

public class Generate {
    public static void main(String[] args) throws IOException {
        JavaFile rust = new JavaFile();
        rust.AddLib("lib1");
        rust.AddLib("lib2");
        rust.AddLib("lib3");
    }

    public static class JavaFile extends File {
        public JavaFile() throws IOException {
            super("./Rust.java");

            File sample = new File("/home/tardis3/ScriptPrototype/src/main/resources/Samples/EmptyForm.txt");
            FileReader reader = new FileReader(sample);
            char[] content = new char[(int) sample.length()];
            reader.read(content);
            reader.close();
            FileWriter writer = new FileWriter(this, false);
            writer.write(content);
            writer.close();
        }

        public void AddLib(String name) throws IOException {
            String content = new String(Files.readAllBytes(this.toPath()));
            final int last_index = content.lastIndexOf('}');
            content = content.substring(0, last_index);
            content = content.concat(
                    "\n    static void fun_" + name + "(){\n" +
                            "        final Path lib = libs.resolve(\""+ name + "/target/debug/lib" + name + ".so\");\n" +
                            "        System.load(lib.toString());\n" +
                            "        System.out.println(" + name + "());\n" +
                            "    }\n" +
                            "    private static native String " + name + "();\n" +
                            "}\n"
            );
            FileWriter writer = new FileWriter(this, false);
            writer.write(content);
            writer.close();
        }
    }
}
