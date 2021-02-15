package com.lottery.lotteryservice.bl;

import com.lottery.lotteryservice.bt.IRules;
import com.lottery.lotteryservice.dl.Line;
import com.lottery.lotteryservice.dl.Ticket;
import com.lottery.lotteryservice.enums.StatusEnum;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("classic_rules")
public class ClassicRules implements IRules {

    @Override
    public Ticket calculate(Ticket ticket) {
        ticket.getLines().forEach(line -> {
            if ((line.getFirstValue() + line.getSecondValue() + line.getThirdValue()) == 2){
                line.setLinePoints(10);
            }else if ((line.getFirstValue() == line.getSecondValue()) && (line.getSecondValue() == line.getThirdValue())){
                line.setLinePoints(5);
            }else if ((line.getFirstValue() != line.getSecondValue()) && (line.getFirstValue() != line.getThirdValue())){
                line.setLinePoints(1);
            }else {
                line.setLinePoints(0);
            }
        });
        ticket.setTotalPoints(ticket.getLines().stream().mapToInt(Line::getLinePoints).sum());
        ticket.setStatus(StatusEnum.CHECKED);
        return ticket;
    }
}
