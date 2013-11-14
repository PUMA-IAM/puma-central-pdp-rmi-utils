package puma.rmi.pdp.mgmt;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PDPRegistryRemote extends Remote {
	
	/**
	 * Registers this ApplicationPDP at the PDP registry.
	 * 
	 * @param applicationPDP
	 */
	public void register(ApplicationPDPMgmtRemote applicationPDP)  throws RemoteException;
	
	/**
	 * Deregisters this ApplicationPDP at the PDP registry.
	 *  
	 * @param applicationPDP
	 */
	public void deregister(ApplicationPDPMgmtRemote applicationPDP) throws RemoteException;

}
