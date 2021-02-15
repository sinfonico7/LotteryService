package com.lottery.lotteryservice.dl;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.lottery.lotteryservice.utils.DataUtils;

import javax.persistence.*;

import java.io.Serializable;

import static com.lottery.lotteryservice.utils.DataUtils.randomValue;

@Table(name = "lines")
@Entity
public class Line implements Serializable {

    @JsonIgnore
    @ManyToOne
    Ticket ticket;

    @Id
    @Column(name = "id_line")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @Column(name = "first_value")
    private int firstValue;

    @Column(name = "second_value")
    private int secondValue;

    @Column(name = "third_value")
    private int thirdValue;

    @Column(name = "line_points")
    private Integer linePoints;


    public Line(){}

    public Line(Ticket ticket){
        this.ticket = ticket;
        linePoints  = 0;
        firstValue  = randomValue(0,2);
        secondValue = randomValue(0,2);
        thirdValue  = randomValue(0,2);
    }


    public Integer getLinePoints() {
        return linePoints;
    }

    public void setLinePoints(Integer linePoints) {
        this.linePoints = linePoints;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public int getFirstValue() {
        return firstValue;
    }

    public void setFirstValue(int firstValue) {
        this.firstValue = firstValue;
    }

    public int getSecondValue() {
        return secondValue;
    }

    public void setSecondValue(int secondValue) {
        this.secondValue = secondValue;
    }

    public int getThirdValue() {
        return thirdValue;
    }

    public void setThirdValue(int thirdValue) {
        this.thirdValue = thirdValue;
    }
}
