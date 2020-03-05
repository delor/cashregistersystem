package me.plich.cashregistersystem.mapper;

import me.plich.cashregistersystem.dto.ProducerDto;
import me.plich.cashregistersystem.model.Producer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProducerMapper {

    Producer convertProducerDtoToProducer(ProducerDto producerDto);
    ProducerDto convertProducerToProducerDto(Producer producer);
}
