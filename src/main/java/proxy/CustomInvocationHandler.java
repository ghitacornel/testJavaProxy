package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * This {@link InvocationHandler} will log to console the execution of any
 * method on the targetObject.<br>
 * It acts as a proxy for the original object but is in fact only a handler, the
 * actual proxy is created via {@link Proxy} class
 */
public class CustomInvocationHandler implements InvocationHandler {

    final private Object targetObject;

    /**
     * @param targetObject the object for which the Proxy is created
     */
    CustomInvocationHandler(Object targetObject) {
        this.targetObject = targetObject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {

        Object result;
        try {

            // log before
            System.out.println(this + " proxy executed before method " + method.getName());

            // invoke method on original object
            // SMELLS like REFLECTION
            result = method.invoke(targetObject, args);

        } catch (Exception e) {

            // log exception
            throw new RuntimeException("unexpected invocation exception: " + e.getMessage());

        } finally {

            // log after
            System.out.println(this + " proxy executed after method " + method.getName());

        }

        // return an altered result
        // observe again to correlation between
        // what the handler returns
        // what the targeted method returns
        // or what the proxy "implemented" interfaces enforce
        return result + " through proxy";

    }

}
