PROXY as software design pattern

Understand PROXY design pattern https://en.wikipedia.org/wiki/Proxy_pattern

PROXY versus other software design patterns

Understand PROXY design pattern vs other similar design patterns

https://stackoverflow.com/questions/350404/how-do-the-proxy-decorator-adapter-and-bridge-patterns-differ

java.lang.reflect.Proxy is an implementation of PROXY software design pattern

Remember :

- Java Reflection

See :

- java.lang.ClassLoader
- java.lang.Class
- java.lang.reflect.Method
- java.lang.reflect.Method#invoke
- java.lang.reflect.Proxy
- java.lang.reflect.InvocationHandler

Exercise :

Test a java reflection Proxy
Add a Proxy between an Interface X and an implementing Class Y
Enhance a Y class declared method using a proxy, proxy which add some logs

Observe

a Proxy can add all sort of other behaviors like : changing the result returned by the proxied method / throwing new exceptions / throwing new exceptions not declared by the proxied method / delegation of work to any kind of other classes, even classes which do not implement the proxied interface
usage of Java Reflection elements

Info :

proxies can be used for providing automatic logging, security checks, transactional behavior and others
AOP is build around the Proxy design pattern
