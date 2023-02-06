import sys
import os
from termcolor import colored

def print_cyan(str):
  print(colored(str, "cyan"))

if len(sys.argv) != 2:
  print_cyan("One argument <name> is required. <name> must be start by  'lib'")
  quit()

name = sys.argv[1]
if not name.startswith("lib"):
  print_cyan("<name> must start with")
  quit()
workdir = os.path.expanduser('~/ScriptPrototype')
os.chdir(workdir)
print_cyan("Create " + name +" lib")
os.chdir("src/main/resources/libs")
if os.path.exists(name):
  print_cyan("Lib " + name + " already exists")
  quit()
else:
  os.mkdir(name)
os.chdir(name)
os.mkdir("src")
os.chdir("src")

file1 = open("lib.rs", "w")
file1.write("use jni::JNIEnv;\n" +
            "\n" +
            "use jni::objects::{JClass};\n" +
            "\n" +
            "use jni::sys::jstring;\n" +
            "\n" +
            "#[no_mangle]\n" +
            "pub extern \"system\" fn Java_Rust_" + name + "(env: JNIEnv,\n" +
            "                                             _class: JClass)\n" +
            "                                             -> jstring {\n" +
            "    // Then we have to create a new Java string to return. Again, more info\n" +
            "    // in the `strings` module.\n" +
            "    let output = env.new_string(format!(\"rust "+ name + "\"))\n" +
            "        .expect(\"Couldn't create java string!\");\n" +
            "\n" +
            "    //print!(\"Hello from rust code\\n\");\n" +
            "    // Finally, extract the raw pointer to return.\n" +
            "    output.into_raw()\n" +
            "}\n")

os.chdir("../")
file2 = open("Cargo.toml", "w")
file2.write("[package]\n" +
            "name = \"" + name + "\"\n" +
            "version = \"0.1.0\"\n" +
            "edition = \"2021\"\n" +
            "\n" +
            "[dependencies]\n" +
            "jni = \"0.20.0\"\n" +
            "\n" +
            "[lib]\n" +
            "crate-type = [\"cdylib\"]")
print_cyan("Created")
