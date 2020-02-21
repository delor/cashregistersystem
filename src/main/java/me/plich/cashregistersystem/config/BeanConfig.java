package me.plich.cashregistersystem.config;




import me.plich.cashregistersystem.service.DataStoreProviderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class BeanConfig {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("me.plich.fisserwis.generated.datastore");
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

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }



}