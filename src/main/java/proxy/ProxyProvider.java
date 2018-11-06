package proxy;

import model.ServiceInterface;

import java.lang.reflect.InvocationHandler;

final public class ProxyProvider {

    private ProxyProvider() {
        // just a helper class
    }

    public static ServiceInterface createProxy(Object targetObject) {

        // obtain the class loader
        // class loader is the same as for the targetObject
        ClassLoader classLoader = targetObject.getClass().getClassLoader();

        // specify proxy targeted interfaces
        // proxy targeted interfaces can contain but  is not mandatory to contain also the targetObject implemented interfaces
        Class<?>[] interfaces = new Class[]{ServiceInterface.class};

        // build an invocation handler used for all methods invoked on proxy
        InvocationHandler handler = new InvocationHandlerThatAddsLogging(targetObject);

        // build the proxy
        return (ServiceInterface) java.lang.reflect.Proxy.newProxyInstance(classLoader, interfaces, handler);

    }

}
