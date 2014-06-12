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
package puma.rmi.pdp;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import com.sun.xacml.ctx.EncodedCachedAttribute;
import com.sun.xacml.ctx.ResponseCtx;

public interface CentralPUMAPDPRemote extends Remote {

	/**
	 * Evaluates the given XACML request with given cached attributes and returns the result.
	 * 
	 * @param request
	 * @param cachedAttributes
	 * @return
	 * @throws RemoteException
	 */
	public ResponseCtx evaluate(List<EncodedCachedAttribute> encodedCachedAttributes) throws RemoteException;
	
	public boolean ping() throws RemoteException;

}
