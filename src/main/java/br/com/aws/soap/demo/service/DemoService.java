package br.com.aws.soap.demo.service;

import br.com.aws.soap.demo.exception.DemoException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tempuri.*;

import java.util.List;
import java.util.Objects;

@Service
public class DemoService {

    @Autowired
    SOAPDemoSoap wsDemoSoap;

    public Person getFindPerson(String id) {
        if (Objects.nonNull(id) && StringUtils.isNoneBlank(id)) {
            return wsDemoSoap.findPerson(id.trim());
        } else {
            throw new DemoException("Id não informado.");
        }
    }

    public List<PersonIdentification> getListByName(String name) {
        if (Objects.nonNull(name) && StringUtils.isNoneBlank(name)) {
            return wsDemoSoap.getListByName(name.trim()).getPersonIdentifications();
        } else {
            throw new DemoException("Nome não informado.");
        }
    }

    public Address lookupCity(String zipCode) {
        if (Objects.nonNull(zipCode) && StringUtils.isNoneBlank(zipCode)) {
            return wsDemoSoap.lookupCity(zipCode.trim());
        } else {
            throw new DemoException("Código não informado.");
        }
    }

    public Long addInteger(Long primeiroValor, Long segundoValor) {
        if (Objects.nonNull(primeiroValor) && Objects.nonNull(segundoValor)) {
            return wsDemoSoap.addInteger(primeiroValor, segundoValor);
        } else {
            throw new DemoException("Favor informar os dois valores para a operação.");
        }
    }

}
