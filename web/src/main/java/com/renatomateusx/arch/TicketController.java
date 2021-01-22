package com.renatomateusx.arch;

import com.renatomateusx.arch.ticket.ITicket;
import com.renatomateusx.arch.ticket.dto.TicketIn;
import com.renatomateusx.arch.ticket.dto.TicketRequestWebDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RefreshScope
@RestController
@RequestMapping("/v1/ticket")
@Api(value = "Tickets")
class TicketController {
    public TicketController(){}
    @Autowired
    private ITicket ticket;

    @ApiOperation(value = "Open Ticket")
    @PostMapping("/openTicket")
    public ResponseEntity<HttpStatus> saveUser(@RequestBody TicketRequestWebDTO requestTicketWebDTO){
        ticket.openTicket(requestTicketWebDTO.toInput());
        return ResponseEntity.ok(HttpStatus.CREATED);
    }
    @ApiOperation(value = "Get All Tickets")
    @GetMapping("/listTickets")
    public ResponseEntity<List<TicketIn>> getAll(){
        return ResponseEntity.ok(ticket.listTickets());
    }
}
