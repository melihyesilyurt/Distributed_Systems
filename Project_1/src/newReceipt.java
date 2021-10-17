import java.rmi.Remote;
import java.rmi.RemoteException;

public interface newReceipt extends Remote{
    public int addNewReceipt(Receipt receipt) throws RemoteException;
}
