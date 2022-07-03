package br.com.aws.soap.demo.controllers;

import br.com.aws.soap.demo.mapper.DemoMapper;
import br.com.aws.soap.demo.provider.api.DemoApi;
import br.com.aws.soap.demo.provider.controller.*;
import br.com.aws.soap.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tempuri.Address;
import org.tempuri.Person;
import org.tempuri.PersonIdentification;


import java.util.List;

@RestController
@RequestMapping(value = "/v1")
public class DemoController extends BaseController implements DemoApi {

    @Autowired
    private DemoService demoService;

    @Autowired
    private DemoMapper demoMapper;

    @Override
    public ResponseEntity<PersonRepresentation> findPerson(String id) {
        Person person = demoService.getFindPerson(id);
        return createResponse(demoMapper.toPersonRepresentation(person));
    }

    @Override
    public ResponseEntity<ListPersonIdentificationsRepresentation> getListByName(String name) {
        List<PersonIdentification> listaPersonIdentifications = demoService.getListByName(name);
        return createResponse(new ListPersonIdentificationsRepresentation()
                .personIdentifications(demoMapper.toLisPersonIdentificationstRepresentation(listaPersonIdentifications))
        );
    }

    @Override
    public ResponseEntity<AddressRepresentation> lookupCity(String zipCode) {
        Address address = demoService.lookupCity(zipCode);
        return createResponse(demoMapper.toAddressRepresentation(address));
    }

    @Override
    public ResponseEntity<StandardSuccessRepresentation> addInteger(AddIntegerRepresentation request) {
        Long resultado = demoService.addInteger(request.getPrimeiroValor(), request.getSegundoValor());
        return createResponseSuccess(HttpStatus.CREATED, "A soma foi realizada e o resultado é " + resultado + ".");
    }

}
