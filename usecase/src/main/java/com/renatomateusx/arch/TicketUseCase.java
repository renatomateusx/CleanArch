package com.renatomateusx.arch;

import com.renatomateusx.arch.User.ITicketOut;
import com.renatomateusx.arch.ports.TicketAdapter;
import com.renatomateusx.arch.ticket.ITicket;
import com.renatomateusx.arch.ticket.dto.TicketIn;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TicketUseCase implements ITicket {

    public TicketUseCase(){}

    @Autowired
    private ITicketOut ticketOut;

    @Autowired
    private TicketAdapter ticketAdapter;

    @Override
    public TicketIn openTicket(TicketIn ticket) {
        return ticketAdapter.toInput(ticketOut.openTicket(ticketAdapter.toOutput(ticket)));
    }

    @Override
    public List<TicketIn> listTickets() {
        return ticketAdapter.toInputList(ticketOut.listTickets());
    }
}
