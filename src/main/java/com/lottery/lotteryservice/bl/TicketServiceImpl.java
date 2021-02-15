package com.lottery.lotteryservice.bl;

import com.lottery.lotteryservice.bt.IRules;
import com.lottery.lotteryservice.bt.ITicketRepository;
import com.lottery.lotteryservice.bt.ITicketService;
import com.lottery.lotteryservice.dl.Ticket;
import com.lottery.lotteryservice.enums.StatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
@Service
public class TicketServiceImpl implements ITicketService {

    @Autowired
    private ITicketRepository repository;



    @Override
    public Ticket create(Ticket ticket) {
        return repository.save(ticket);
    }

    @Override
    public List<Ticket> getAll() {
        return repository.findAll();
    }

    @Override
    public Ticket getTicketById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Ticket amendTicket(Ticket ticket) {

        return repository.save(ticket);
    }

    @Override
    public boolean getStatusById(Long id) {
        return false;
    }

    @Autowired
    @Qualifier("classic_rules")
    private IRules rules;

    @Override
    public Ticket checkPoints(Ticket ticket) throws Exception {
        Ticket ticketChecked = getTicketById(ticket.getId());
        if (ticketChecked != null && ticketChecked.getStatus() != StatusEnum.CHECKED){
            create(rules.calculate(ticketChecked));
        }else{
            throw new Exception("Sorry, Ticket doesn't exist or already checked");
        }
        return ticketChecked;
    }
}
