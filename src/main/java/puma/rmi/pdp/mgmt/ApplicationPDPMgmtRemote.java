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
package puma.rmi.pdp.mgmt;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ApplicationPDPMgmtRemote extends Remote {
	
	/**
	 * Returns the id of this Application PDP (probably related to the id 
	 * of this node).
	 */
	public String getId() throws RemoteException;
	
	/**
	 * Returns the status of this Application PDP.
	 * 
	 * @return
	 */
	public String getStatus() throws RemoteException;
	
	/**
	 * Loads the given policy into the application policy.
	 * 
	 * Note that the given policy should have id "application-policy" in order
	 * for this to be used in the future.
	 * 
	 * @param policy
	 */
	public void loadApplicationPolicy(String policy) throws RemoteException;
	
	/**
	 * Returns the current application policy.
	 */
	public String getApplicationPolicy() throws RemoteException;
	
	/**
	 * Reloads the policies in the application policy according to the
	 * policies in the PAP.
	 */
	public void reload() throws RemoteException;
	
	/**
	 * Enable access for the application PDP to a remote database. The database location is initialized at the server hosting the application PDP using the puma.attr.db.connection parameter.
	 * @param enabled True if the application PDP may access a remote database, false otherwise
	 * @throws RemoteException
	 */
	public void setRemoteDBAccess(Boolean enabled) throws RemoteException;

}
