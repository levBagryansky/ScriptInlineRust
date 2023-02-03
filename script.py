import shutil
import os
from termcolor import colored

def print_cyan(str):
    print(colored(str, "cyan"))

workdir = os.path.expanduser('~/ScriptPrototype')

os.chdir(workdir)
print_cyan("create libs in resources")
os.chdir("src/main/resources/libs")
for folder in os.listdir("./"):
    os.chdir(folder)
    print_cyan("build '" + folder + "' lib")
    os.system("cargo build")
    os.chdir("../")

os.chdir(workdir)
#os.system("rm -r build")
if not os.path.exists("build"):
  os.mkdir("build")
os.chdir("build/")

os.system("javac ../src/main/java/Generate.java -d ./")

print_cyan("Generate Rust.java")
os.system("java Generate")

print_cyan("Compile Rust.java")
os.system("javac Rust.java")

print_cyan("Perform Rust.class")
os.system("java Rust")

os.chdir("../")
#list_dir = subprocess.Popen(["cd", "./"])
#list_dir.wait()