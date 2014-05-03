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
