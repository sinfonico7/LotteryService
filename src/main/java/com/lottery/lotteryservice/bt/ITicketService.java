package com.lottery.lotteryservice.bt;

import com.lottery.lotteryservice.dl.Ticket;

import java.util.List;

public interface ITicketService {

    Ticket create(Ticket ticket);

    List<Ticket> getAll();

    Ticket getTicketById(Long id);

    Ticket amendTicket(Ticket ticket);

    boolean getStatusById(Long id);

    Ticket checkPoints(Ticket ticket) throws Exception;

}
