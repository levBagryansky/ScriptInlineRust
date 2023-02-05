import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Rust {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Method[] methods = Rust.class.getDeclaredMethods();
        for (Method method: methods) {
            if (method.getName().startsWith("fun")){
                method.invoke(null);
            }
        }
    }

    final private static Path libs = Paths.get(System.getProperty("user.home")
            + "/ScriptPrototype/src/main/resources/libs/");

    static void fun1(){
        final Path lib = libs.resolve("lib1/target/debug/liblib1.so");
        System.load(lib.toString());
        System.out.println(lib1());
    }
    private static native String lib1();

    static void fun2() {
        final Path lib = libs.resolve("lib2/target/debug/liblib2.so");
        System.load(lib.toString());
        System.out.println(lib2());
    }
    private static native String lib2();

    static void fun3() {
        final Path lib = libs.resolve("lib3/target/debug/liblib3.so");
        System.load(lib.toString());
        System.out.println(lib3());
    }
    private static native String lib3();
}
