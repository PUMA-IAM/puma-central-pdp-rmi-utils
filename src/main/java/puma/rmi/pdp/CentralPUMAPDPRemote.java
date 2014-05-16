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
