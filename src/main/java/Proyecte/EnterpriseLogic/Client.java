package Proyecte.EnterpriseLogic;

public class Client {
    public String name;
    public String ci;
    public String address;


    public Client() {
    }


    public Client(String name, String ci, String address) {
        this.name = name;
        this.ci = ci;
        this.address = address;
    }

    public String getName(){
        return name;
    }

    public String getAddress(){
        return address;
    }

    public String getCi(){
        return ci;
    }

    public void setCi(String ci){
        this.ci = ci;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAddress(String address){
        this.address = address;
    }
}
