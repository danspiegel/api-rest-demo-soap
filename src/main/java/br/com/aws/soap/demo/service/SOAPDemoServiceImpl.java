package br.com.aws.soap.demo.service;

import br.com.aws.soap.demo.config.WSProperties;
import br.com.aws.soap.demo.exception.DemoException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.tempuri.*;

@Slf4j
@Service
public class SOAPDemoServiceImpl implements SOAPDemoSoap {

    @Autowired
    private WebServiceTemplate wsTemplate;

    @Autowired
    private WSProperties wsProperties;

    @Override
    public Address lookupCity(String zip) {
        try {
            LookupCity lookupCity = new LookupCity();
            lookupCity.setZip(zip);
            LookupCityResponse response =  (LookupCityResponse) wsTemplate.marshalSendAndReceive(wsProperties.getServiceUrl(), lookupCity);
            return response.getLookupCityResult();
        } catch(Exception e) {
            log.error("Ocorreu um erro ao chamar o serviço SOAP lookupCity. " + e.getMessage());
            throw new DemoException("Ocorreu um erro ao chamar o serviço SOAP lookupCity. " + e.getMessage());
        }
    }

    @Override
    public QueryByNameDataSet queryByName(String name) {
        try {
            QueryByName queryByName = new QueryByName();
            queryByName.setName(name);
            QueryByNameResponse response = (QueryByNameResponse) wsTemplate.marshalSendAndReceive(wsProperties.getServiceUrl(), queryByName);
            return response.getQueryByNameResult();
        } catch(Exception e) {
            log.error("Ocorreu um erro ao chamar o serviço SOAP queryByName. " + e.getMessage());
            throw new DemoException("Ocorreu um erro ao chamar o serviço SOAP queryByName. " + e.getMessage());
        }
    }

    @Override
    public long addInteger(Long arg1, Long arg2) {
        try {
            AddInteger addInteger = new AddInteger();
            addInteger.setArg1(arg1);
            addInteger.setArg2(arg2);
            AddIntegerResponse response = (AddIntegerResponse) wsTemplate.marshalSendAndReceive(wsProperties.getServiceUrl(), addInteger);
            return response.getAddIntegerResult();
        } catch(Exception e) {
            log.error("Ocorreu um erro ao chamar o serviço SOAP addInteger. " + e.getMessage());
            throw new DemoException("Ocorreu um erro ao chamar o serviço SOAP addInteger. " + e.getMessage());
        }
    }

    @Override
    public DataSet getByName(String name) {
        try {
            GetByName objName = new GetByName();
            objName.setName(name);
            GetByNameResponse response = (GetByNameResponse) wsTemplate.marshalSendAndReceive(wsProperties.getServiceUrl(), objName);
            return response.getGetByNameResult();
        } catch(Exception e) {
            log.error("Ocorreu um erro ao chamar o serviço SOAP getByName. " + e.getMessage());
            throw new DemoException("Ocorreu um erro ao chamar o serviço SOAP getByName. " + e.getMessage());
        }
    }

    @Override
    public ByNameDataSet getDataSetByName(String name) {
        try {
            GetDataSetByName objDataSetName = new GetDataSetByName();
            objDataSetName.setName(name);
            GetDataSetByNameResponse response = (GetDataSetByNameResponse) wsTemplate.marshalSendAndReceive(wsProperties.getServiceUrl(), objDataSetName);
            return response.getGetDataSetByNameResult();
        } catch(Exception e) {
            log.error("Ocorreu um erro ao chamar o serviço SOAP getDataSetByName. " + e.getMessage());
            throw new DemoException("Ocorreu um erro ao chamar o serviço SOAP getDataSetByName. " + e.getMessage());
        }
    }

    @Override
    public String mission() {
        try {
            Mission mission = new Mission();
            MissionResponse response = (MissionResponse) wsTemplate.marshalSendAndReceive(wsProperties.getServiceUrl(), mission);
            return response.getMissionResult();
        } catch(Exception e) {
            log.error("Ocorreu um erro ao chamar o serviço SOAP mission. " + e.getMessage());
            throw new DemoException("Ocorreu um erro ao chamar o serviço SOAP mission. " + e.getMessage());
        }
    }

    @Override
    public long divideInteger(Long arg1, Long arg2) {
        try {
            DivideInteger divideInteger = new DivideInteger();
            divideInteger.setArg1(arg1);
            divideInteger.setArg2(arg2);
            DivideIntegerResponse response = (DivideIntegerResponse) wsTemplate.marshalSendAndReceive(wsProperties.getServiceUrl(), divideInteger);
            return response.getDivideIntegerResult();
        } catch(Exception e) {
            log.error("Ocorreu um erro ao chamar o serviço SOAP divideInteger. " + e.getMessage());
            throw new DemoException("Ocorreu um erro ao chamar o serviço SOAP divideInteger. " + e.getMessage());
        }
    }

    @Override
    public Person findPerson(String id) {
        try {
            FindPerson findPerson = new FindPerson();
            findPerson.setId(id);
            FindPersonResponse response = (FindPersonResponse) wsTemplate.marshalSendAndReceive(wsProperties.getServiceUrl(), findPerson);
            return response.getFindPersonResult();
        } catch(Exception e) {
            log.error("Ocorreu um erro ao chamar o serviço SOAP findPerson. " + e.getMessage());
            throw new DemoException("Ocorreu um erro ao chamar o serviço SOAP findPerson. " + e.getMessage());
        }
    }

    @Override
    public ArrayOfPersonIdentificationPersonIdentification getListByName(String name) {
        try {
            GetListByName objListName = new GetListByName();
            objListName.setName(name);
            GetListByNameResponse response = (GetListByNameResponse) wsTemplate.marshalSendAndReceive(wsProperties.getServiceUrl(), objListName);
            return response.getGetListByNameResult();
        } catch(Exception e) {
            log.error("Ocorreu um erro ao chamar o serviço SOAP getListByName. " + e.getMessage());
            throw new DemoException("Ocorreu um erro ao chamar o serviço SOAP getListByName. " + e.getMessage());
        }
    }

}
