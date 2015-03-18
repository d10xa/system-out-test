import sun.misc.BASE64Decoder;

import java.io.*;
import java.lang.reflect.Method;

public class Task3 {
    public static void main(String[] args) {
        InputStreamCloner inputStreamCloner = null;
        try {
            inputStreamCloner = new InputStreamCloner(System.in);
            try {
                runMain(new Base64ClassReader(inputStreamCloner.getClone()).makeClass(), args[0]);
            } catch (Throwable e) {
                System.out.println("error");
            }
            try {
                runMain(new Base64ClassReader(inputStreamCloner.getClone()).makeClass(), args[1]);
            } catch (Throwable e) {
                System.out.println("error");
            }
        } catch (Throwable e) {
            System.out.println("error");
        }
    }

    private static void runMain(Class c, String arg) {
        Method meth = null;
        PrintStream err = System.err;
        System.setErr(System.out);
        try {
            meth = c.getMethod("main", String[].class);
            String[] params = new String[]{arg};
            meth.invoke(null, (Object) params);
        } catch (Exception e) {
            System.out.println("error");
        }
        System.setErr(err);
    }
}

class InputStreamCloner {

    InputStream inputStream;
    ByteArrayOutputStream baos = new ByteArrayOutputStream();

    public InputStreamCloner(InputStream inputStream) throws IOException {
        this.inputStream = inputStream;
        byte[] buffer = new byte[1024];
        int len;
        while ((len = System.in.read(buffer)) > -1) {
            baos.write(buffer, 0, len);
        }
        baos.flush();
    }

    public InputStream getClone() throws IOException {
        return new ByteArrayInputStream(baos.toByteArray());
    }
}

class Base64ClassReader {

    private InputStream inputStream;

    public Base64ClassReader(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public Class makeClass() {
        return new ByteArrayClassLoader(readByteClass()).findClass("");
    }

    private byte[] readByteClass() {
        sun.misc.BASE64Decoder decoder = new BASE64Decoder();
        try {
            return decoder.decodeBuffer(inputStream);
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}

class ByteArrayClassLoader extends ClassLoader {

    private byte[] bytes;

    public ByteArrayClassLoader(byte[] ba) {
        this.bytes = ba;
    }

    public Class findClass(String name) {
        return defineClass(bytes, 0, bytes.length);
    }

}