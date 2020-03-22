package me.plich.cashregistersystem.service;

import me.plich.cashregistersystem.exception.EntrepreneurNotFoundException;
import me.plich.cashregistersystem.exception.InvalidNipNumberException;
import me.plich.cashregistersystem.generated.datastore.ArrayOfstring;
import me.plich.cashregistersystem.generated.datastore.GetMigrationData201901;
import me.plich.cashregistersystem.generated.datastore.GetMigrationData201901Response;
import me.plich.cashregistersystem.generated.datastore.ObjectFactory;
import me.plich.cashregistersystem.generated.datastore.POJOfromXSD.InformacjaOWpisieTyp;
import me.plich.cashregistersystem.generated.datastore.POJOfromXSD.WynikWyszukiwania;
import me.plich.cashregistersystem.model.EntrepreneurOutput;
import me.plich.cashregistersystem.utils.Utils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.util.List;
import java.util.stream.Collectors;

public class DataStoreProviderService extends WebServiceGatewaySupport {
//do refaktoru - złamanie SRP
    @Value("${spring.application.DataStoreApiKey}")
    String apiKey;

    public EntrepreneurOutput getCompanyData(String nip){
        boolean validNip = Utils.isNipValid(nip);
        if(!validNip) {
            throw new InvalidNipNumberException(nip);
        }
        GetMigrationData201901 request = new GetMigrationData201901();
        ObjectFactory factory = new ObjectFactory();
        JAXBElement<String> key = factory.createGetMigrationData201901AuthToken(apiKey);
        ArrayOfstring check = new ArrayOfstring();
        check.getString().add(0,nip);
        JAXBElement<ArrayOfstring> nipNumber = factory.createGetMigrationData201901NIP(check);
        request.setNIP(nipNumber);
        request.setAuthToken(key);


        GetMigrationData201901Response response =
                (GetMigrationData201901Response) getWebServiceTemplate().marshalSendAndReceive(request,
                        new SoapActionCallback("http://tempuri.org/IDataStoreProvider201901/GetMigrationData201901"));

        StringReader reader = new StringReader(response.getGetMigrationData201901Result().getValue());
        WynikWyszukiwania searchResult = null;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(WynikWyszukiwania.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            searchResult = (WynikWyszukiwania) jaxbUnmarshaller.unmarshal(reader);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        List<InformacjaOWpisieTyp> listOfActive = searchResult.getInformacjaOWpisie().stream()
                .filter(informacjaOWpisieTyp -> informacjaOWpisieTyp.getDaneDodatkowe().getStatus().equalsIgnoreCase("Aktywny"))
                .collect(Collectors.toList());
        EntrepreneurOutput entrepreneurOutput = null;
        if(listOfActive.size() == 0) {
            throw new EntrepreneurNotFoundException(nip);
        } else {
            InformacjaOWpisieTyp item = listOfActive.get(0);
            entrepreneurOutput =  EntrepreneurOutput.newEntrepreneurOutput()
                    .adresPocztyElektronicznej(item.getDaneKontaktowe().getAdresPocztyElektronicznej())
                    .imie(item.getDanePodstawowe().getImie())
                    .nazwisko(item.getDanePodstawowe().getNazwisko())
                    .nip(item.getDanePodstawowe().getNIP())
                    .regon(item.getDanePodstawowe().getREGON())
                    .telefon(item.getDaneKontaktowe().getTelefon())
                    .firma(item.getDanePodstawowe().getFirma())
                    .ulica(item.getDaneAdresowe().getAdresGlownegoMiejscaWykonywaniaDzialalnosci().getUlica())
                    .budynek(item.getDaneAdresowe().getAdresGlownegoMiejscaWykonywaniaDzialalnosci().getBudynek())
                    .lokal(item.getDaneAdresowe().getAdresGlownegoMiejscaWykonywaniaDzialalnosci().getLokal())
                    .kodPocztowy(item.getDaneAdresowe().getAdresGlownegoMiejscaWykonywaniaDzialalnosci().getKodPocztowy())
                    .miejscowosc(item.getDaneAdresowe().getAdresGlownegoMiejscaWykonywaniaDzialalnosci().getMiejscowosc())
                    .build();
        }
        return entrepreneurOutput;
    }
}
