package me.plich.cashregistersystem.service;




import me.plich.cashregistersystem.generated.datastore.ArrayOfstring;
import me.plich.cashregistersystem.generated.datastore.GetMigrationData201901;
import me.plich.cashregistersystem.generated.datastore.GetMigrationData201901Response;
import me.plich.cashregistersystem.generated.datastore.ObjectFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import javax.xml.bind.JAXBElement;

public class DataStoreProviderService extends WebServiceGatewaySupport {


    public GetMigrationData201901Response getCompanyData(){
        GetMigrationData201901 request = new GetMigrationData201901();
        ObjectFactory factory = new ObjectFactory();

        JAXBElement<String> key = factory.createGetMigrationData201901AuthToken("KLUCZ DO API CEIDG");
        ArrayOfstring check = new ArrayOfstring();
        check.getString().add(0,"5210322238");
        JAXBElement<ArrayOfstring> nip = factory.createGetMigrationData201901NIP(check);
        System.out.println("NIP: "+nip.getValue().getString().toString());
        System.out.println("key: "+key.getValue());
        request.setNIP(nip);
        request.setCity(factory.createGetMigrationData201901City(null));
        request.setREGON(factory.createGetMigrationData201901REGON(null));
        request.setNIPSC(factory.createGetMigrationData201901NIPSC(null));
        request.setREGONSC(factory.createGetMigrationData201901REGONSC(null));
        request.setName(factory.createGetMigrationData201901Name(null));
        request.setProvince(factory.createGetMigrationData201901Province(null));
        request.setCounty(factory.createGetMigrationData201901County(null));
        request.setCommune(factory.createGetMigrationData201901Commune(null));
        request.setStreet(factory.createGetMigrationData201901Street(null));
        request.setPostcode(factory.createGetMigrationData201901Postcode(null));
        request.setDateFrom(factory.createGetMigrationData201901DateFrom(null));
        request.setDateTo(factory.createGetMigrationData201901MigrationDateTo(null));
        request.setPKD(factory.createGetMigrationData201901PKD(null));
        request.setStatus(factory.createGetMigrationData201901Status(null));
        request.setUniqueId(factory.createGetMigrationData201901UniqueId(null));
        request.setMigrationDateFrom(factory.createGetMigrationData201901DateFrom(null));
        request.setMigrationDateTo(factory.createGetMigrationData201901MigrationDateTo(null));
        request.setAuthToken(key);
        //GetMigrationData201901Response response = (GetMigrationData201901Response) getWebServiceTemplate().marshalSendAndReceive(request);

        GetMigrationData201901Response response =
                (GetMigrationData201901Response) getWebServiceTemplate().marshalSendAndReceive(request,
                        new SoapActionCallback("http://tempuri.org/IDataStoreProvider201901/GetMigrationData201901"));


        return response;
    }
}
