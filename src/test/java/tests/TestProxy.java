package tests;

import model.ServiceInterface;
import model.ServiceImplementation;
import org.junit.Assert;
import org.junit.Test;
import proxy.InvocationHandlerThatAddsLogging;
import proxy.ProxyProvider;

import java.lang.reflect.InvocationHandler;

public class TestProxy {

    // create the object that will be accessed through a Proxy
    private ServiceInterface originalObject = new ServiceImplementation();

    @Test
    public void testProxy() {

        // access original object directly
        Assert.assertEquals(originalObject.toString() + " executed", originalObject.execute());

        // create the proxy
        ServiceInterface proxyObject = ProxyProvider.createProxy(originalObject);

        // verify the proxy
        Assert.assertNotNull(proxyObject);

        // verify the proxy behaviour
        // verify the proxy added behavior by observing the console
        Assert.assertEquals(originalObject.execute() + " through proxy", proxyObject.execute());

    }
}
