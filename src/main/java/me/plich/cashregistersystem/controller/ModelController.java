package me.plich.cashregistersystem.controller;


import me.plich.cashregistersystem.dto.DeviceDto;
import me.plich.cashregistersystem.dto.ModelDto;
import me.plich.cashregistersystem.dto.OrderDto;
import me.plich.cashregistersystem.exception.ModelNotFoundException;
import me.plich.cashregistersystem.mapper.ModelsMapper;
import me.plich.cashregistersystem.model.Model;
import me.plich.cashregistersystem.repository.ModelRepository;
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
@RequestMapping("/models")
public class ModelController {

    private ModelRepository modelRepository;
    private ModelsMapper modelsMapper;

    @Autowired
    public ModelController(ModelRepository modelRepository, ModelsMapper modelsMapper) {
        this.modelRepository = modelRepository;
        this.modelsMapper = modelsMapper;
    }

    @GetMapping
    public ResponseEntity<CollectionModel<ModelDto>> getAllModels() {
        List<Model> modelsList = modelRepository.findAll();
        List<ModelDto> modelsDtoList = modelsList.stream()
                .map(model -> modelsMapper.convertModelToModelDto(model))
                .collect(Collectors.toList());
        modelsDtoList.forEach(modelDto -> modelDto.add(WebMvcLinkBuilder.linkTo(ModelController.class).slash(modelDto.getId()).withSelfRel()));
        Link modelsLink = WebMvcLinkBuilder.linkTo(ModelController.class).withRel("models");
        Link producersLink = WebMvcLinkBuilder.linkTo(ProducerController.class).withRel("producers");
        CollectionModel<ModelDto> resource = new CollectionModel<>(modelsDtoList, modelsLink, producersLink);
        return new ResponseEntity(resource, HttpStatus.OK);
    }

    @GetMapping("/{modelId}")
    public ResponseEntity<EntityModel<ModelDto>> getModels(@PathVariable Long modelId) {
        Model model = modelRepository.findById(modelId)
                .orElseThrow(() -> new ModelNotFoundException(modelId));
        ModelDto modelDto = modelsMapper.convertModelToModelDto(model);
        Link selfLink = WebMvcLinkBuilder.linkTo(ModelController.class).slash(modelId).withSelfRel();
        Link modelsLink = WebMvcLinkBuilder.linkTo(ModelController.class).withRel("models");
        Link producersLink = WebMvcLinkBuilder.linkTo(ProducerController.class).withRel("producers");
        EntityModel<ModelDto> resource = new EntityModel<>(modelDto, selfLink, modelsLink, producersLink);
        return new ResponseEntity<>(resource, HttpStatus.OK);
    }
}
