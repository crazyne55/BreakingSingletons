import java.lang.reflect.Constructor;

public class ReflectionDestruction {
    public static void main(String[] args) {
        LazyInitSingleton instanceOne = LazyInitSingleton.getInstance();
        LazyInitSingleton instanceTwo = null;

        try {
            Constructor[] constructors = LazyInitSingleton.class.getDeclaredConstructors();
            for (Constructor constructor : constructors) {
                constructor.setAccessible(true);
                instanceTwo = (LazyInitSingleton) constructor.newInstance();
                break;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(instanceOne.hashCode());
        System.out.println(instanceTwo.hashCode());
    }
}
