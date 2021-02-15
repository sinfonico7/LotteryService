package com.lottery.lotteryservice.bl;

import com.lottery.lotteryservice.dl.Ticket;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClassicRulesTest {

    //Unit testinng
    @Test
    void calculateAndValueMustBe10() {
        ClassicRules rules = new ClassicRules();
        Ticket ticket = new Ticket(1);
        ticket.getLines().get(0).setFirstValue(0);
        ticket.getLines().get(0).setSecondValue(1);
        ticket.getLines().get(0).setThirdValue(1);
        assertEquals(10,rules.calculate(ticket).getLines().get(0).getLinePoints());
        assertEquals(10,ticket.getTotalPoints());
    }

    @Test
    void calculateAndValueMustBe5() {
        ClassicRules rules = new ClassicRules();
        Ticket ticket = new Ticket(1);
        ticket.getLines().get(0).setFirstValue(1);
        ticket.getLines().get(0).setSecondValue(1);
        ticket.getLines().get(0).setThirdValue(1);
        assertEquals(5,rules.calculate(ticket).getLines().get(0).getLinePoints());
        assertEquals(5,ticket.getTotalPoints());
    }

    @Test
    void calculateAndValueMustBe1() {
        ClassicRules rules = new ClassicRules();
        Ticket ticket = new Ticket(1);
        ticket.getLines().get(0).setFirstValue(0);
        ticket.getLines().get(0).setSecondValue(1);
        ticket.getLines().get(0).setThirdValue(2);
        assertEquals(1,rules.calculate(ticket).getLines().get(0).getLinePoints());
        assertEquals(1,ticket.getTotalPoints());

    }
}