package com.renatomateusx.arch.Ticket;

import com.renatomateusx.arch.User.ITicketOut;
import com.renatomateusx.arch.User.dto.TicketOut;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Service
public class TicketService implements ITicketOut {
    public TicketService(){}

    @Value("${ticket.url}")
    private String uri;
    @Value("${ticket.url}")
    private String uriListTickets;
    @Value("${ticket.name}")
    private String userName;
    @Value("${ticket.pass}")
    private String password;


    @Autowired
    private RestTemplate restTemplate;

    private String getBase64Credentials(){
        String plainCreds = userName + ":" + password;
        byte[] plainCredsBytes = plainCreds.getBytes();
        byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
        return new String(base64CredsBytes);
    }

    private HttpEntity<String> getRequest(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + getBase64Credentials());
        return new HttpEntity<String>(headers);
    }


    @Override
    public TicketOut openTicket(TicketOut ticket) {
        MultiValueMap<String, String> body = new LinkedMultiValueMap<String, String>();
        body.add("body", ticket.getMessage());
        body.add("priority", "urgent");
        body.add("subject", ticket.getSubject());
        HttpEntity<?> httpEntity = getRequest();
        ResponseEntity<TicketOut> response = restTemplate.postForEntity(uri, httpEntity, TicketOut.class, body);
        return response.getBody();
    }

    @Override
    public List<TicketOut> listTickets() {
        MultiValueMap<String, String> body = new LinkedMultiValueMap<String, String>();      ;
        HttpEntity<?> httpEntity = getRequest();
        ResponseEntity<List<TicketOut>> response = restTemplate.exchange(uriListTickets, HttpMethod.GET, httpEntity, new ParameterizedTypeReference<List<TicketOut>>() {});
        return response.getBody();
    }
}
