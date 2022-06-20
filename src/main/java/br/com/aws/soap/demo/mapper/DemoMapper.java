package br.com.aws.soap.demo.mapper;

import br.com.aws.soap.demo.provider.controller.AddressRepresentation;
import br.com.aws.soap.demo.provider.controller.PersonIdentificationRepresentation;
import br.com.aws.soap.demo.provider.controller.PersonRepresentation;
import org.mapstruct.*;
import org.tempuri.Address;
import org.tempuri.Person;
import org.tempuri.PersonIdentification;

import java.util.List;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL,
        componentModel = "spring")
public interface DemoMapper {

    @Mappings({
            @Mapping(target = "dob", expression = "java(person.getDOB().toString())"),
            @Mapping(target = "ssn", expression = "java(person.getSSN())")
    })
    PersonRepresentation toPersonRepresentation(Person person);

    AddressRepresentation toAddressRepresentation(Address address);

    @Mappings({
            @Mapping(target = "id", expression = "java(personIdentification.getID())"),
            @Mapping(target = "dob", expression = "java(personIdentification.getDOB().toString())"),
            @Mapping(target = "ssn", expression = "java(personIdentification.getSSN())")
    })
    PersonIdentificationRepresentation toPersonIdentificationRepresentation(PersonIdentification personIdentification);

    @IterableMapping(qualifiedByName = "ListPersonIdentifications")
    List<PersonIdentificationRepresentation> toLisPersonIdentificationstRepresentation(List<PersonIdentification> listPersonIdentification);

    @Named("ListPersonIdentifications")
    default PersonIdentificationRepresentation map(PersonIdentification personIdentification) {
        return this.toPersonIdentificationRepresentation(personIdentification);
    }

}
