import java.nio.file.Path;
import java.nio.file.Paths;

public class Rust {
    private static Path libs = Paths.get("/home/tardis3/ScriptPrototype/src/main/resources/libs/");
    public static void main(String[] args) {
        fun1();
        fun2();
        fun3();
    }
    static void fun1(){
        //Path lib = libs.normalize().resolve("lib1/target/debug/liblib1.so").toAbsolutePath();
        Path lib = Paths.get("/home/tardis3/ScriptPrototype/src/main/resources/libs/lib1/target/debug/liblib1.so");
        System.load(lib.toString());
        System.out.println(lib1());
    }

    static void fun2() {
        Path lib = Paths.get("/home/tardis3/ScriptPrototype/src/main/resources/libs/lib2/target/debug/liblib2.so");
        System.load(lib.toString());
        System.out.println(lib2());
    }

    static void fun3() {
        System.out.println("fun3");
    }

    private static native String lib1();
    private static native String lib2();
}