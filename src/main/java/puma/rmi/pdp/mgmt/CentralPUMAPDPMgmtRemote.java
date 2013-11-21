package puma.rmi.pdp.mgmt;

import java.rmi.Remote;
import java.rmi.RemoteException;

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

}
