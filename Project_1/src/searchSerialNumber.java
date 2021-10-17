import java.rmi.Remote;
import java.rmi.RemoteException;

public interface searchSerialNumber extends Remote{
    public String searchNewSerialNumber(int serialNumber) throws RemoteException;
}
