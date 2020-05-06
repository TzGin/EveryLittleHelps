package priv.TzGin.proxy.dynamicproxy.myproxy.proxy;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

public class MyClassLoader extends ClassLoader {

    private File classPathFile;

    public MyClassLoader() {
        String classPath = MyClassLoader.class.getResource("").getPath();
        this.classPathFile = new File(classPath);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String className = MyClassLoader.class.getPackage().getName() + "." + name;
        if (classPathFile != null) {
            File classFile = new File(classPathFile, name.replaceAll("\\.", "/") + ".class");
            if (classFile.exists()) {
                FileInputStream fis = null;
                ByteArrayOutputStream bout = null;
                try {
                    fis = new FileInputStream(classFile);
                    bout = new ByteArrayOutputStream();
                    byte[] buff = new byte[1014];
                    int len;
                    while ((len = fis.read(buff)) != -1) {
                        bout.write(buff, 0, len);
                    }
                    return defineClass(className, bout.toByteArray(), 0, bout.size());
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        return super.findClass(name);
    }
}
