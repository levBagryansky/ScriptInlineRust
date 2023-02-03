// This is the interface to the JVM that we'll call the majority of our
// methods on.
use jni::JNIEnv;

use jni::objects::{JClass};

use jni::sys::jstring;

#[no_mangle]
pub extern "system" fn Java_Rust_lib1(env: JNIEnv,
                                             _class: JClass)
                                             -> jstring {
    // Then we have to create a new Java string to return. Again, more info
    // in the `strings` module.
    let output = env.new_string(format!("rust lib1"))
        .expect("Couldn't create java string!");

    //print!("Hello from rust code\n");
    // Finally, extract the raw pointer to return.
    output.into_raw()
}
