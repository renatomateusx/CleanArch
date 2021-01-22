package com.renatomateusx.arch;

import com.renatomateusx.arch.User.ITicketOut;
import com.renatomateusx.arch.User.dto.TicketOut;
import com.renatomateusx.arch.ports.TicketAdapter;
import com.renatomateusx.arch.ticket.dto.TicketIn;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RunWith(MockitoJUnitRunner.class)
public class TicketUseCaseTest {

    @InjectMocks
    private TicketUseCase subject;

    @Mock
    private ITicketOut ticketOut;
    @Mock
    private TicketAdapter ticketAdapter;



    @Test
    public void crateTicket(){
        UUID uuidOne = UUID.randomUUID();
        TicketOut ticketMockOut = new TicketOut(uuidOne, "Renato Moura", "renatomateusx@gmail.com", "Test", "Message Test", "create");
        TicketIn ticketIn = new TicketIn(uuidOne, "Renato Moura", "renatomateusx@gmail.com", "Test", "Message Test", "created");
        Mockito.when(ticketOut.openTicket(ticketAdapter.toOutput(ticketIn))).thenReturn(ticketMockOut);
        Mockito.when(ticketAdapter.toInput(ticketMockOut)).thenReturn(ticketIn);
        subject.openTicket(ticketIn);
        Assertions.assertTrue(ticketIn.getId() == uuidOne);

    }

    @Test
    public void listTickets(){
        List<TicketOut> listTickets = new ArrayList<>();
        UUID uuidOne = UUID.randomUUID();
        UUID uuidTwo = UUID.randomUUID();
        listTickets.add(new TicketOut(uuidOne, "Renato Moura", "renatomateusx@gmail.com", "Test", "Message Test", "nothing"));
        listTickets.add(new TicketOut(uuidTwo, "Renato Moura", "renatomateusx@gmail.com", "Test", "Message Test", "nothing"));

        List<TicketIn> listTicketIn = new ArrayList<>();
        listTicketIn.add(new TicketIn(uuidOne, "Renato Moura", "renatomateusx@gmail.com", "Test", "Message Test", "nothing"));
        listTicketIn.add(new TicketIn(uuidTwo, "Renato Moura", "renatomateusx@gmail.com", "Test", "Message Test", "nothing"));

        Mockito.when(ticketOut.listTickets()).thenReturn(listTickets);
        Mockito.when(ticketAdapter.toInputList(listTickets)).thenReturn(listTicketIn);
        subject.listTickets();
        Assertions.assertTrue(listTickets.stream().findFirst().get().getId() == listTicketIn.stream().findFirst().get().getId());

    }


}
