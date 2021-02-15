package com.lottery.lotteryservice.pl;

import com.lottery.lotteryservice.bt.ITicketService;
import com.lottery.lotteryservice.dl.Line;
import com.lottery.lotteryservice.dl.Ticket;
import com.lottery.lotteryservice.enums.StatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ticketController {

    @Autowired
    ITicketService ticketService;

    @PostMapping("/ticket")
    public ResponseEntity<Ticket> addTicket(@RequestParam(value = "lines") int lines){
        return new ResponseEntity<>(ticketService.create(new Ticket(lines)), HttpStatus.CREATED);
    }

    @GetMapping("/ticket")
    public ResponseEntity<List<Ticket>> getAllTickets(){
        return new ResponseEntity<List<Ticket>>(ticketService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/ticket/{id}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable Long id){
        return new ResponseEntity<Ticket>(ticketService.getTicketById(id), HttpStatus.OK);
    }

    @PutMapping("/ticket/{id}")
    public Ticket amendTicketById(@PathVariable Long id,@RequestBody List<Line> lines){
        Ticket ticket = ticketService.getTicketById(id);
        ticket.setLines(lines);
        return ticketService.create(ticket);
    }

    @PutMapping("/status/{id}")
    public ResponseEntity<StatusEnum> checkTicketStatusById(@PathVariable Long id){
        Ticket ticket = ticketService.getTicketById(id);
        return new ResponseEntity<StatusEnum>(ticket.getStatus(), HttpStatus.OK);
    }

    @PostMapping("/check")
    public Ticket checkTicket(@RequestBody Ticket ticket) throws Exception {
        Ticket entity = ticketService.checkPoints(ticket);
        return entity;
    }
}
