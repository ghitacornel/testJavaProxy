package proxy;

import model.ServiceInterface;

import java.lang.reflect.InvocationHandler;

public class ProxyFactory {

    /**
     * Create a proxy over an actual targeted object<br>
     * Observe there is no correlation enforced between the Proxy class and targeted object actual class
     *
     * @param targetObject the target object
     * @return a proxy over the target object
     */
    public static ServiceInterface createProxy(Object targetObject) {

        // obtain the class loader
        // class loader is the same as for the targetObject
        ClassLoader classLoader = targetObject.getClass().getClassLoader();

        // specify proxy targeted interfaces
        // proxy targeted interfaces must contain all interfaces the proxy can be cast to
        Class<?>[] interfaces = new Class[]{ServiceInterface.class};

        // build an invocation handler used for all methods invoked on proxy
        InvocationHandler handler = new CustomInvocationHandler(targetObject);

        // build the proxy
        return (ServiceInterface)
                java.lang.reflect.Proxy.
                        newProxyInstance(classLoader, interfaces, handler);

    }

}
