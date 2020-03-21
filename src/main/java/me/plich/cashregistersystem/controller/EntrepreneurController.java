package me.plich.cashregistersystem.controller;


import me.plich.cashregistersystem.dto.EntrepreneurInputDto;
import me.plich.cashregistersystem.dto.EntrepreneurOutputDto;
import me.plich.cashregistersystem.mapper.EntrepreneurOutputMapper;
import me.plich.cashregistersystem.model.EntrepreneurOutput;
import me.plich.cashregistersystem.service.DataStoreProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/entrepreneur")
public class EntrepreneurController {

    private EntrepreneurOutputMapper entrepreneurOutputMapper;
    private DataStoreProviderService dataStoreProviderService;

    @Autowired
    public EntrepreneurController(DataStoreProviderService dataStoreProviderService, EntrepreneurOutputMapper entrepreneurOutputMapper) {
        this.dataStoreProviderService = dataStoreProviderService;
        this.entrepreneurOutputMapper = entrepreneurOutputMapper;
    }

    @PostMapping
    public ResponseEntity<EntrepreneurOutputDto> getEntrepreneurData(@RequestBody EntrepreneurInputDto entrepreneurInputDto) {
        System.out.println(entrepreneurInputDto.getNip());
        EntrepreneurOutput entrepreneurOutput = dataStoreProviderService.getCompanyData(entrepreneurInputDto.getNip());
        System.out.println("controler entrepreunerOutput "+entrepreneurOutput);
        EntrepreneurOutputDto response = entrepreneurOutputMapper.convertEntrepreneurOutputToEntrepreneurOutputDto(entrepreneurOutput);
        System.out.println(response);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
