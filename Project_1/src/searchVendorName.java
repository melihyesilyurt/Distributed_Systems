import java.rmi.Remote;
import java.rmi.RemoteException;

public interface searchVendorName extends Remote{
    public String searchNewVendorName(String vendorName) throws RemoteException;
}




