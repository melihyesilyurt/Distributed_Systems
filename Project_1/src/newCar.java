
import java.rmi.Remote;
import java.rmi.RemoteException;



/**
 *
 * @author Melih
 */
public interface newCar extends Remote{
    public int addNewCar(Car car) throws RemoteException;
}
