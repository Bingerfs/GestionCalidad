package Proyecte.ApplicationLogic.DTOMappers;

public class ClientDto {
    public final String name;
    public final String address;
    public final String ci;
    
    public ClientDto(String name, String address, String ci){
        this.name= name;
        this.address=address;
        this.ci=ci;
    }

    public String getName(){
        return name;
    }
    public String getCi(){
        return ci;
    }
}