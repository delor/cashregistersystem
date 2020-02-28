package me.plich.cashregistersystem.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import me.plich.cashregistersystem.model.View;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class ModelDto {

    @JsonView(View.Public.class)
    private Long id;

    @JsonView(View.Public.class)
    private String name;

    @JsonView(View.Public.class)
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
