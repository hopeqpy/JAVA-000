import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.lang.reflect.Method;

/**
 * @program: JAVA-000
 * @description: helloclass 加载
 * @create: 2020-10-21 22:41
 */
public class HelloClassLoader extends ClassLoader {

    public static void main(String[] args) throws Exception{
        Class<?> clazz = new HelloClassLoader().findClass("Hello");
        Object obj = clazz.getDeclaredConstructor().newInstance();
        Method hello = clazz.getDeclaredMethod("hello");
        hello.invoke(obj);
        System.out.println("类加载器：" + clazz.getClassLoader());
    }

    @Override
    protected Class<?> findClass(String name) {
        try {
            InputStream is = HelloClassLoader.class.getResourceAsStream("Hello.xlass");
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int b;
            while((b = is.read()) != -1){
                byteArrayOutputStream.write(b);
            }
            byteArrayOutputStream.close();
            is.close();
            byte[] bytes = byteArrayOutputStream.toByteArray();
            for (int i = 0; i < bytes.length; i++) {
                bytes[i] = (byte)(255 - bytes[i]);
            }
            return defineClass(name,bytes,0, bytes.length);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
