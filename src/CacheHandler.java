import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

public class CacheHandler implements InvocationHandler {
    private final Object original;
    private final Map<Integer, Integer> cache;

    public CacheHandler(Object original){
        this.original = original;
        this.cache = new CacheMap<>();
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(args == null || args.length == 0)
            throw new IllegalArgumentException("Function requires the parameter");

        if(method.isAnnotationPresent(Cache.class)){
            int arg = (int)args[0];
            Integer result = cache.get(arg);
            System.out.println("Looking for the result " + arg + " in cache");
            if(result == null){
                System.out.println("The result " + arg + " not found");
                result = (Integer)method.invoke(original, arg);
                cache.put(arg, result);
                System.out.println("Calculated result " + result + " added in cache");
            }else {
                System.out.println("The result " + result + " is found and taken from cache");
            }
            return result;
        }
        // System.out.println("The result " + original + " is taken from cache");

        return method.invoke(original, args);
    }
}
