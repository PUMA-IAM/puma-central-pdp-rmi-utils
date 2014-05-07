package puma.rmi;

import java.net.MalformedURLException;
import java.rmi.server.RMIClassLoaderSpi;

public class AltRMIClassLoader extends RMIClassLoaderSpi {

	@Override
	public String getClassAnnotation(Class<?> arg0) {
		// Dit is de kardjoeffel die we eigenlijk moeten hebben. Dit moet
		// gewoonweg null teruggeven.
		return null;
	}

	public Class<?> loadClass(String codebase, String name,
			ClassLoader defaultLoader) throws MalformedURLException,
			ClassNotFoundException {
		return sun.rmi.server.LoaderHandler.loadClass(codebase, name,
				defaultLoader);
	}

	public Class<?> loadProxyClass(String codebase, String[] interfaces,
			ClassLoader defaultLoader) throws MalformedURLException,
			ClassNotFoundException {
		return sun.rmi.server.LoaderHandler.loadProxyClass(codebase,
				interfaces, defaultLoader);
	}

	public ClassLoader getClassLoader(String codebase)
			throws MalformedURLException {
		return sun.rmi.server.LoaderHandler.getClassLoader(codebase);
	}

}
