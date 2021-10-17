import java.io.Serializable;

public class Receipt implements Serializable {
    private int serial_number;
    private int personID;
    private String vendorName;

    public Receipt() {
        serial_number = 0;
        vendorName= "";
        personID = 0;
    }
    public Receipt(int serial_number, int personID, String vendorName)
    {
       setSerial_number(serial_number);
       setPersonID(personID);
       setVendorName(vendorName);
    }

    public int getSerial_number() {
        return serial_number;
    }

    public void setSerial_number(int serial_number) {
        this.serial_number = serial_number;
    }

    public int getPersonID() {
        return personID;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }
}
