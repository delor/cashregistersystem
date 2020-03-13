package me.plich.cashregistersystem.controller;

import me.plich.cashregistersystem.dto.ModelDto;
import me.plich.cashregistersystem.dto.ProducerDto;
import me.plich.cashregistersystem.exception.ProducerNotFoundException;
import me.plich.cashregistersystem.mapper.ProducerMapper;
import me.plich.cashregistersystem.model.Producer;
import me.plich.cashregistersystem.repository.ProducerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/producers")
public class ProducerController {

    private ProducerRepository producerRepository;
    private ProducerMapper producerMapper;

    @Autowired
    public ProducerController(ProducerRepository producerRepository, ProducerMapper producerMapper) {
        this.producerRepository = producerRepository;
        this.producerMapper = producerMapper;
    }

    @GetMapping
    public ResponseEntity<CollectionModel<ProducerDto>> getAllProducers() {
        List<Producer> producersList = producerRepository.findAll();
        List<ProducerDto> producersDtoList = producersList.stream()
                .map(producer -> producerMapper.convertProducerToProducerDto(producer))
                .collect(Collectors.toList());
        producersDtoList.forEach(producerDto -> producerDto.add(WebMvcLinkBuilder.linkTo(ProducerController.class).slash(producerDto.getId()).withSelfRel()));
        Link modelsLink = WebMvcLinkBuilder.linkTo(ModelController.class).withRel("models");
        Link producersLink = WebMvcLinkBuilder.linkTo(ProducerController.class).withRel("producers");
        CollectionModel<ProducerDto> resource = new CollectionModel<>(producersDtoList,producersLink, modelsLink);
        return new ResponseEntity(resource, HttpStatus.OK);
    }

    @GetMapping("/{producerId}")
    public ResponseEntity<EntityModel<ProducerDto>> getProducer(@PathVariable Long producerId) {
        Producer producer = producerRepository.findById(producerId)
                .orElseThrow(() -> new ProducerNotFoundException(producerId));
        ProducerDto producerDto = producerMapper.convertProducerToProducerDto(producer);
        Link selfLink = WebMvcLinkBuilder.linkTo(ProducerController.class).slash(producerId).withSelfRel();
        Link modelsLink = WebMvcLinkBuilder.linkTo(ModelController.class).withRel("models");
        Link producersLink = WebMvcLinkBuilder.linkTo(ProducerController.class).withRel("producers");
        EntityModel<ProducerDto> resource = new EntityModel<>(producerDto, selfLink,producersLink, modelsLink);
        return new ResponseEntity<>(resource, HttpStatus.OK);
    }
}
