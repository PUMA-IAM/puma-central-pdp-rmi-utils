package puma.centralpdp.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import oasis.names.tc.xacml._2_0.context.schema.os.RequestType;

import com.sun.xacml.ctx.CachedAttribute;
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
	public ResponseCtx evaluate(RequestType request,
			List<CachedAttribute> cachedAttributes) throws RemoteException;

}
