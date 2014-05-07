package puma.rmi;

import java.net.MalformedURLException;
import java.rmi.server.RMIClassLoaderSpi;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Iterator;
import java.util.ServiceLoader;

public class AltRMIClassLoader extends RMIClassLoaderSpi {
	
	/** "default" provider instance */
    private static final RMIClassLoaderSpi defaultProvider =
        newDefaultProviderInstance();

    /** provider instance */
    private static final RMIClassLoaderSpi provider =
        AccessController.doPrivileged(
            new PrivilegedAction<RMIClassLoaderSpi>() {
                public RMIClassLoaderSpi run() { return initializeProvider(); }
            });

	
	public AltRMIClassLoader() {}

	@Override
	public String getClassAnnotation(Class<?> arg0) {
		// Dit is de kardjoeffel die we eigenlijk moeten hebben. Dit moet gewoonweg null teruggeven.
		return null;
	}

	@Override
	public ClassLoader getClassLoader(String codebase)
			throws MalformedURLException {
		return provider.getClassLoader(codebase);
	}

	@Override
	public Class<?> loadClass(String codebase, String name,
			ClassLoader defaultLoader) throws MalformedURLException,
			ClassNotFoundException {
		return provider.loadClass(
                codebase != null ? codebase.toString() : null, name, null);
	}

	@Override
	public Class<?> loadProxyClass(String codebase, String[] interfaces,
			ClassLoader defaultLoader) throws MalformedURLException,
			ClassNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
     * Creates an instance of the default provider class.
     */
    private static RMIClassLoaderSpi newDefaultProviderInstance() {
        return new RMIClassLoaderSpi() {
            @SuppressWarnings("restriction")
			public Class<?> loadClass(String codebase, String name,
                                      ClassLoader defaultLoader)
                throws MalformedURLException, ClassNotFoundException
            {
                return sun.rmi.server.LoaderHandler.loadClass(
                    codebase, name, defaultLoader);
            }

            @SuppressWarnings("restriction")
			public Class<?> loadProxyClass(String codebase,
                                           String[] interfaces,
                                           ClassLoader defaultLoader)
                throws MalformedURLException, ClassNotFoundException
            {
                return sun.rmi.server.LoaderHandler.loadProxyClass(
                    codebase, interfaces, defaultLoader);
            }

            @SuppressWarnings("restriction")
			public ClassLoader getClassLoader(String codebase)
                throws MalformedURLException
            {
                return sun.rmi.server.LoaderHandler.getClassLoader(codebase);
            }

            @SuppressWarnings("restriction")
			public String getClassAnnotation(Class<?> cl) {
                return sun.rmi.server.LoaderHandler.getClassAnnotation(cl);
            }
        };
    }
    
    /**
     * Chooses provider instance, following above documentation.
     *
     * This method assumes that it has been invoked in a privileged block.
     */
    private static RMIClassLoaderSpi initializeProvider() {
        /*
         * First check for the system property being set:
         */
        String providerClassName =
            System.getProperty("java.rmi.server.RMIClassLoaderSpi");

        if (providerClassName != null) {
            if (providerClassName.equals("default")) {
                return defaultProvider;
            }

            try {
                Class<? extends RMIClassLoaderSpi> providerClass =
                    Class.forName(providerClassName, false,
                                  ClassLoader.getSystemClassLoader())
                    .asSubclass(RMIClassLoaderSpi.class);
                return providerClass.newInstance();

            } catch (ClassNotFoundException e) {
                throw new NoClassDefFoundError(e.getMessage());
            } catch (IllegalAccessException e) {
                throw new IllegalAccessError(e.getMessage());
            } catch (InstantiationException e) {
                throw new InstantiationError(e.getMessage());
            } catch (ClassCastException e) {
                Error error = new LinkageError(
                    "provider class not assignable to RMIClassLoaderSpi");
                error.initCause(e);
                throw error;
            }
        }

        /*
         * Next look for a provider configuration file installed:
         */
        Iterator<RMIClassLoaderSpi> iter =
            ServiceLoader.load(RMIClassLoaderSpi.class,
                               ClassLoader.getSystemClassLoader()).iterator();
        if (iter.hasNext()) {
            try {
                return iter.next();
            } catch (ClassCastException e) {
                Error error = new LinkageError(
                    "provider class not assignable to RMIClassLoaderSpi");
                error.initCause(e);
                throw error;
            }
        }

        /*
         * Finally, return the canonical instance of the default provider.
         */
        return defaultProvider;
    }

}
