import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

/**
 *
 * @author Melih Yesilyurt
 */
public class client {

    public static void main(String args[]) throws RemoteException {
        Scanner reader = new Scanner(System.in);
        client c = new client();
        while (true) {
            System.out.println("What do you want to do?\n");
            System.out.println("1-) Add new car");
            System.out.println("2-) Add new sale receipt");
            System.out.println("3-) Search for car using serial number");
            System.out.println("4-) Search for sale receipt using ID number");
            System.out.println("5-) Search for car using mark");
            System.out.println("6-) Search for sale receipt using vendor name");
            System.out.println("Press 0 to Exit. ");
            int number = reader.nextInt();
            if (number == 1) {
                System.out.println("Adding new car...");
                c.sendNewCarData();
            } else if (number == 2) {
                System.out.println("Adding new sales receipt...");
                c.sendNewReceiptData();
            } else if (number == 3) {
                System.out.println("Searching for car receipt using serial number...");
                c.searchCarWithSerialNumber();
            } else if (number == 4) {
                System.out.println("Searching for sale receipt using ID number...");
                c.searchReceiptWithPersonID();
            } else if (number == 5) {
                System.out.println("Searching for sale receipt using mark...");
                c.searchCarWithMark();
            } else if (number == 6) {
                System.out.println("Searching for sale receipt using vendor name...");
                c.searchReceiptWithVendorName();
            } else if (number == 0) {
                System.out.println("Exiting the application...");
                break;
            } else {
                System.out.println("Lütfen (1-6) arasında bir sayı giriniz.");
            }
        }
    }

    private void sendNewCarData() throws RemoteException {
        try {
            Registry reg = LocateRegistry.getRegistry("localhost", 4444);
            newCar car = (newCar) reg.lookup("hi_server");
            Car cars = new Car();
            Scanner reader = new Scanner(System.in);

            System.out.println("\nPlease enter the mark of the car.");
            String brand = reader.nextLine();
            cars.setBrand(brand);

            System.out.println("\nPlease enter the model of the car.");
            String model = reader.nextLine();
            cars.setModel(model);

            System.out.println("\nPlease enter the color of the car.");
            String color = reader.nextLine();
            cars.setColor(color);

            System.out.println("\nPlease enter the year of manufacture of the car.");
            int year = reader.nextInt();
            cars.setYear(year);

            System.out.println("\nPlease enter the weight (kg) of the car.");
            int weight = reader.nextInt();
            cars.setWeight(weight);

            System.out.println("\nPlease enter the price of the car.");
            int price = reader.nextInt();
            cars.setPrice(price);

            System.out.println("\nPlease enter the serial number of the car.");
            int serial_number = reader.nextInt();
            cars.setSerial_number(serial_number);

            car.addNewCar(cars);
            System.out.println("\n New car has been added.");
        } catch (NotBoundException | RemoteException e) {
            System.out.println("Exception" + e);
        }
    }
    private void sendNewReceiptData() throws RemoteException {
        try {
            Registry reg = LocateRegistry.getRegistry("localhost", 4444);
            newReceipt receipt = (newReceipt) reg.lookup("hi_server");
            Receipt receipts = new Receipt();
            Scanner reader = new Scanner(System.in);

            System.out.println("\nPlease enter the vendor name.");
            String vendorName = reader.nextLine();
            receipts.setVendorName(vendorName);

            System.out.println("\nPlease enter the serial number of the car.");
            int serial_number = reader.nextInt();
            receipts.setSerial_number(serial_number);

            System.out.println("\nPlease enter the buyers ID number.");
            int personID = reader.nextInt();
            receipts.setPersonID(personID);
            System.out.println("\n New sale receipt added.");

            receipt.addNewReceipt(receipts);
        } catch (NotBoundException | RemoteException e) {
            System.out.println("Exception" + e);
        }

    }
    private void searchCarWithSerialNumber() throws RemoteException {
        try {
            Registry reg = LocateRegistry.getRegistry("localhost", 4444);
            searchSerialNumber serialNumber = (searchSerialNumber) reg.lookup("hi_server");

            Scanner reader = new Scanner(System.in);

            System.out.println("\nPlease enter the serial number to search.");
            int serial_number = reader.nextInt();

            System.out.println("Records you want: \n" + serialNumber.searchNewSerialNumber(serial_number));
        } catch (NotBoundException | RemoteException e) {
            System.out.println("Exception" + e);
        }

    }
    private void searchReceiptWithPersonID() throws RemoteException {
        try {
            Registry reg = LocateRegistry.getRegistry("localhost", 4444);
            searchPersonID personID = (searchPersonID) reg.lookup("hi_server");

            Scanner reader = new Scanner(System.in);

            System.out.println("\nPlease enter the person ID to search.");
            int personId = reader.nextInt();

            System.out.println("Records you want: \n" + personID.searchNewPersonID(personId));
        } catch (NotBoundException | RemoteException e) {
            System.out.println("Exception" + e);
        }
    }
    private void searchCarWithMark() throws RemoteException {
        try {
            Registry reg = LocateRegistry.getRegistry("localhost", 4444);
            searchMark mark = (searchMark) reg.lookup("hi_server");

            Scanner reader = new Scanner(System.in);

            System.out.println("\nPlease enter the car mark to search.");
            String markName = reader.nextLine();

            System.out.println("Records you want: \n" + mark.searchNewMark(markName));
        } catch (NotBoundException | RemoteException e) {
            System.out.println("Exception" + e);
        }
    }
    private void searchReceiptWithVendorName() throws RemoteException {
        try {
            Registry reg = LocateRegistry.getRegistry("localhost", 4444);
            searchVendorName vendorName = (searchVendorName) reg.lookup("hi_server");

            Scanner reader = new Scanner(System.in);

            System.out.println("\nPlease enter the vendor name to search.");
            String vendor = reader.nextLine();

            System.out.println("Records you want: \n" + vendorName.searchNewVendorName(vendor));
        } catch (NotBoundException | RemoteException e) {
            System.out.println("Exception" + e);
        }
    }
}
