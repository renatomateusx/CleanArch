package com.renatomateusx.arch.ports;

import com.renatomateusx.arch.User.dto.TicketOut;
import com.renatomateusx.arch.ticket.dto.TicketIn;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@Component
@ConstructorBinding
public class TicketAdapter {


    public TicketOut toOutput(TicketIn ticket){
        return new TicketOut(ticket.getId(), ticket.getName(), ticket.getStatus(), ticket.getSubject(), ticket.getMessage(), ticket.getStatus());
    }

    public TicketIn toInput(TicketOut ticket){
        return new TicketIn(ticket.getId(), ticket.getName(), ticket.getEmail(), ticket.getSubject(), ticket.getMessage(), ticket.getStatus());
    }

    public List<TicketIn> toInputList(List<TicketOut> ticketList){
        List<TicketIn> list =  ticketList.stream()
                .map(ticket -> new TicketIn(ticket.getId(), ticket.getName(), ticket.getEmail(), ticket.getSubject(), ticket.getMessage(), ticket.getStatus()))
                .collect(Collectors.toList());
        return list;
    }


}
