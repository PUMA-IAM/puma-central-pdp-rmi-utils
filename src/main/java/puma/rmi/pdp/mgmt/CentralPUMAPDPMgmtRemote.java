package puma.rmi.pdp.mgmt;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface CentralPUMAPDPMgmtRemote extends Remote {
	
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
