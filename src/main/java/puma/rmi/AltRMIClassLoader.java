/*******************************************************************************
 * Copyright 2014 KU Leuven Research and Developement - iMinds - Distrinet 
 * 
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 * 
 *        http://www.apache.org/licenses/LICENSE-2.0
 * 
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 *    
 *    Administrative Contact: dnet-project-office@cs.kuleuven.be
 *    Technical Contact: maarten.decat@cs.kuleuven.be
 *    Author: maarten.decat@cs.kuleuven.be
 ******************************************************************************/
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
