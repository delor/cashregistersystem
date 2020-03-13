package me.plich.cashregistersystem.config;




import me.plich.cashregistersystem.service.DataStoreProviderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class BeanConfig {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("me.plich.cashregistersystem.generated.datastore");
        return marshaller;
    }
    @Bean
    public DataStoreProviderService soapConnector(Jaxb2Marshaller marshaller) {
        DataStoreProviderService client = new DataStoreProviderService();
        client.setDefaultUri("https://datastore.ceidg.gov.pl/CEIDG.DataStore/services/DataStoreProvider201901.svc");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }

//    @Bean
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.any())
//                .paths(PathSelectors.any())
//                .build();
//    }



}