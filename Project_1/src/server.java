import java.io.*;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Melih Yesilyurt
 */

public class server extends UnicastRemoteObject implements newCar,newReceipt,searchSerialNumber,searchPersonID, Serializable,searchMark,searchVendorName
{
    private static void startServer(){
        System.out.println("CARS\n");
        File file1 = new File ("cars.dat");
        if(!file1.exists()) {
            try {
                file1.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            FileReader fReader = new FileReader(file1);
            String line;
            BufferedReader bReader = new BufferedReader(fReader);
            while((line=bReader.readLine()) != null) {
                String[] record = line.split("&");
                System.out.println("Mark: "+ record[0]+ "\n" + "Model: "+ record[1]+ "\n" + "Color: "+ record[2]+ "\n" + "Year: "+ record[3]+ "\n" + "Weight: "+ record[4]+ "\n" + "Price: "+ record[5]+ "\n" + "Serial Number: "+ record[6]+ "\n\n");
            }
            bReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("\n\nRECEİPTS\n");
        File file2 = new File ("receipts.dat");
        if(!file2.exists()) {
            try {
                file2.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            FileReader fReader = new FileReader(file2);
            String line;
            BufferedReader bReader = new BufferedReader(fReader);
            while((line=bReader.readLine()) != null) {
                String[] record = line.split("&");
                System.out.println("Serial Number of Car: "+ record[0]+ "\n" + "Person ID of buyer: "+ record[1]+ "\n" + "Vendor Name: "+ record[2] + "\n\n");
            }
            bReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public server() throws RemoteException
    {
        super();
    }

    @Override
    public int addNewCar(Car car) throws RemoteException {
        System.out.println("Adding new car to DataBase...");
        try {
            writeCarFile(car);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }
    private void writeCarFile(Car car) throws IOException  {
        File file = new File ("cars.dat");
        if(!file.exists()) {
            file.createNewFile();
        }
        FileWriter fWriter = new FileWriter(file,true);
        BufferedWriter bWriter = new BufferedWriter(fWriter);
        bWriter.write(car.getBrand()+ "&"+ car.getModel() + "&" + car.getColor() + "&"+ car.getYear()+"&"+car.getWeight()+"&"+car.getPrice()+"&"+car.getSerial_number()+"\n");
        bWriter.close();
    }

    @Override
    public int addNewReceipt(Receipt receipt) throws RemoteException {
        System.out.println("Adding new sale receipt to DataBase");
        try {
            writeReceiptFile(receipt);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }
    private void writeReceiptFile(Receipt receipt) throws IOException  {
        File file = new File ("receipts.dat");
        if(!file.exists()) {
            file.createNewFile();
        }
        FileWriter fWriter = new FileWriter(file,true);
        BufferedWriter bWriter = new BufferedWriter(fWriter);
        bWriter.write(receipt.getSerial_number()+ "&"+ receipt.getPersonID() + "&" + receipt.getVendorName() +"\n");
        bWriter.close();
    }

    @Override
    public String searchNewSerialNumber(int serialNumber) throws RemoteException {
        System.out.println("Searching for cars in DataBase.");
        try {
           return searchSerialNumber(serialNumber);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
    private String searchSerialNumber(int serialNumber) throws IOException {
        File file = new File ("cars.dat");
        FileReader fReader = new FileReader(file);
        String line;
        String answer= "";
        BufferedReader bReader = new BufferedReader(fReader);

        while((line=bReader.readLine()) != null) {
            String[] record = line.split("&");
            if(Integer.parseInt(record[6])==serialNumber)
            {
                answer += "Mark: "+ record[0]+ "\n" + "Model: "+ record[1]+ "\n" + "Color: "+ record[2]+ "\n" + "Year: "+ record[3]+ "\n" + "Weight: "+ record[4]+ "\n" + "Price: "+ record[5]+ "\n" + "Serial Number: "+ record[6]+ "\n\n";
            }
        }
        bReader.close();
        return answer;
    }

    @Override
    public String searchNewPersonID(int personID) throws RemoteException {
        System.out.println("Searching for Sale receipts in DataBase.");
        try {
            return searchPersonID(personID);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
    private String searchPersonID (int personID) throws IOException
    {
        File file = new File ("receipts.dat");
        FileReader fReader = new FileReader(file);
        String line;
        String answer= "";
        BufferedReader bReader = new BufferedReader(fReader);

        while((line=bReader.readLine()) != null) {
            String[] record = line.split("&");
            if(Integer.parseInt(record[1])==personID)
            {
                answer += "Serial Number of Car: "+ record[0]+ "\n" + "Person ID of buyer: "+ record[1]+ "\n" + "Vendor Name: "+ record[2] + "\n\n";
            }
        }
        bReader.close();
        return answer;
    }

    @Override
    public String searchNewMark(String Mark) throws RemoteException {
        System.out.println("Searching for cars in DataBase.");
        try {
            return searchMark(Mark);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
    private String searchMark(String Mark) throws IOException
    {
        File file = new File ("cars.dat");
        FileReader fReader = new FileReader(file);
        String line;
        String answer= "";
        BufferedReader bReader = new BufferedReader(fReader);

        while((line=bReader.readLine()) != null) {
            String[] record = line.split("&");
            if(record[0].equals(Mark))
            {
                answer += "Mark: "+ record[0]+ "\n" + "Model: "+ record[1]+ "\n" + "Color: "+ record[2]+ "\n" + "Year: "+ record[3]+ "\n" + "Weight: "+ record[4]+ "\n" + "Price: "+ record[5]+ "\n" + "Serial Number: "+ record[6]+ "\n\n";
            }
        }
        bReader.close();
        return answer;
    }

    @Override
    public String searchNewVendorName(String vendorName) throws RemoteException {
        System.out.println("Searching for Sale receipts in DataBase.");
        try {
            return searchVendorName(vendorName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
    private String searchVendorName(String vendorName) throws IOException {
        File file = new File ("receipts.dat");
        FileReader fReader = new FileReader(file);
        String line;
        String answer= "";
        BufferedReader bReader = new BufferedReader(fReader);

        while((line=bReader.readLine()) != null) {
            String[] record = line.split("&");
            if(record[2].equals(vendorName))
            {
                answer += "Serial Number of Car: "+ record[0]+ "\n" + "Person ID of buyer: "+ record[1]+ "\n" + "Vendor Name: "+ record[2] + "\n\n";
            }
        }
        bReader.close();
        return answer;
    }

    public static void main (String args[]) throws RemoteException
    {
        startServer();
        try
        {
            Registry reg = LocateRegistry.createRegistry(4444);
            reg.rebind("hi_server",new server());
            System.out.println("Server is running");
        }
        catch(RemoteException e)
        {
            System.out.println("Exception "+e);
        }
    }
}