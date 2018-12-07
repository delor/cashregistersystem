package me.plich.cashregistersystem.service;

import me.plich.cashregistersystem.model.Customer;
import me.plich.cashregistersystem.model.Device;
import me.plich.cashregistersystem.repository.CustomerRepository;
import me.plich.cashregistersystem.repository.DeviceRepository;
import me.plich.cashregistersystem.repository.LocationRepository;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class OrderPdfGenerator {

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    DeviceRepository deviceRepository;
    @Autowired
    LocationRepository locationRepository;

    public PDDocument CustomerOrder(Long customerID, Long deviceID) throws IOException {

        Customer customer = customerRepository.findById(customerID).get();
        Device device = deviceRepository.findById(deviceID).get();

            PDDocument document = new PDDocument();
            PDPage page = new PDPage();
            document.addPage(page);

            PDPageContentStream contentStream = new PDPageContentStream(document, page);

            contentStream.setFont(PDType1Font.COURIER, 12);
            contentStream.beginText();
            contentStream.showText("Zgłoszenie podatnika");
            contentStream.newLine();
            contentStream.newLine();

            contentStream.showText("Urząd skarbowy: "+customer.getTaxOffice());
            contentStream.showText("Dane podatnika:");
            contentStream.showText("Nazwa: "+customer.getName());
            contentStream.showText("NIP: "+customer.getNip());
            contentStream.showText("Ulica: "+customer.getStreet());
            contentStream.showText("Numer domu: "+customer.getHouseNumber());
            contentStream.showText("Numer lokalu: "+customer.getFlatNumber());
            contentStream.showText("Kod pocztowy: "+customer.getZipCode());
            contentStream.showText("Miasto: "+customer.getPlace());
            contentStream.showText("Województwo: "+customer.getVoivodeship());
            contentStream.showText("Telefon: "+customer.getTelephone());

            contentStream.showText("Urządzenie:");
            contentStream.newLine();
            contentStream.showText("Producent: "+device.getProducer());
            contentStream.showText("Model: "+ device.getModel());
            contentStream.showText("Numer unikatowy: "+ device.getUniqueNumber());
            contentStream.showText("Numer fabryczny: "+ device.getSerialNumber());
            contentStream.showText("Data fiskalizacji: "+ device.getDateOfFiscalization());

            contentStream.showText("Miejsce instalacji:");
            contentStream.newLine();
            contentStream.showText("Nazwa: "+device.getLocation().getName());
            contentStream.showText("Ulica: "+device.getLocation().getStreet());
            contentStream.showText("Numer domu: "+device.getLocation().getHouseNumber());
            contentStream.showText("Numer lokalu: "+device.getLocation().getFlatNumber());
            contentStream.showText("Kod pocztowy: "+device.getLocation().getZipCode());
            contentStream.showText("Miasto: "+device.getLocation().getPlace());
            contentStream.showText("Województwo: "+device.getLocation().getVoivodeship());


            contentStream.endText();
            contentStream.close();

            document.save("zgloszenie_podatnika.pdf");
            document.close();


        return document;

    }
}
