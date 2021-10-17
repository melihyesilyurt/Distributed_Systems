import java.rmi.Remote;
import java.rmi.RemoteException;

public interface searchMark extends Remote{
    public String searchNewMark(String Mark) throws RemoteException;
}
