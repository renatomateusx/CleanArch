package com.renatomateusx.arch.ticket;

import com.renatomateusx.arch.ticket.dto.TicketIn;

import java.util.List;

public interface ITicket {
    TicketIn openTicket(TicketIn ticket);
    List<TicketIn> listTickets();
}
