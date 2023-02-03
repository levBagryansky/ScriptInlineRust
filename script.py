import subprocess
import os

os.system("cd ~/ScriptPrototype")
os.system("rm -r build")
os.mkdir("build")
os.chdir("build/")

os.system("javac ../src/main/java/Generate.java -d ./")
os.system("java Generate")
os.system("javac Rust.java")
os.system("java Rust")

os.chdir("../")
#list_dir = subprocess.Popen(["cd", "./"])
#list_dir.wait()