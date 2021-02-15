package com.lottery.lotteryservice.bt;

import com.lottery.lotteryservice.dl.Ticket;

public interface IRules {

    Ticket calculate(Ticket ticket);

}
