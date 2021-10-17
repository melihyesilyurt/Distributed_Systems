import java.rmi.Remote;
import java.rmi.RemoteException;

public interface searchPersonID extends Remote{
    public String searchNewPersonID(int personID) throws RemoteException;
}
