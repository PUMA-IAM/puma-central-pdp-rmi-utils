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
import java.util.List;

import puma.util.timing.MetricsProvider;

public interface CentralPUMAPDPMgmtRemote extends Remote, MetricsProvider {
	
	/**
	 * Returns the status of this Central PUMA PDP.
	 * 
	 * @return
	 */
	public String getStatus() throws RemoteException;
	
	/**
	 * Loads the given policy into the Central PUMA PDP policy.
	 * 
	 * Note that the given policy should have id "central-puma-policy" in order
	 * for this to be used in the future.
	 * 
	 * @param policy
	 */
	public void loadCentralPUMAPolicy(String policy) throws RemoteException;
	
	/**
	 * Returns the current Central PUMA PDP policy.
	 */
	public String getCentralPUMAPolicy() throws RemoteException;
	
	/**
	 * Reloads the policies in the Central PUMA PDP policy according to the
	 * policies in the PAP.
	 */
	public void reload() throws RemoteException;

	/**
	 * Loads the given policy into the Central PUMA PDP policy for the given tenant identifier.
	 * 
	 * Note that the tenant must be an existing tenant and that the policy will apply to all 
	 * subjects of that tenant once it is deployed
	 * 
	 * Note also that this operation will replace any existing policy fot the given tenant
	 * 
	 * @param tenantIdentifier The identifier (parseable to Long) that identifies the tenant. A XACML policy will be created which incorporates the given policy.  
	 * @param policy This will be the only policy, besides the application and central policy, which the tenant subjects will apply to.
	 */
	public void loadTenantPolicy(String tenantIdentifier, String policy) throws RemoteException;
	
	/**
	 * 
	 * @return List of all identifiers of tenants which have deployed policies
	 * @throws RemoteException
	 */
	public List<String> getIdentifiers() throws RemoteException;
}
