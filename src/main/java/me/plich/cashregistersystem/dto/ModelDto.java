package me.plich.cashregistersystem.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.hateoas.RepresentationModel;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class ModelDto extends RepresentationModel<ModelDto> {


    private Long id;


    private String name;


    private ProducerDto producer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProducerDto getProducer() {
        return producer;
    }

    public void setProducer(ProducerDto producer) {
        this.producer = producer;
    }

    @Override
    public String toString() {
        return "ModelDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", producer=" + producer +
                '}';
    }
}
