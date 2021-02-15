package com.lottery.lotteryservice.dl;

import com.lottery.lotteryservice.enums.StatusEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ticket")
public class Ticket implements Serializable {

    @Transient
    Logger logger = LoggerFactory.getLogger(Ticket.class);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ticket")
    private Long id;

    @Column(name = "status")
    private StatusEnum status;

    @OneToMany(mappedBy = "ticket", cascade = {CascadeType.PERSIST})
    private List<Line> lines;

    @Column(name = "total_points")
    private Integer totalPoints;




    public  Ticket(){
        logger.info("Generando ticket sin lineas");
    }

    public  Ticket(int numberOfLines){
        logger.info("Generando ticket");
        lines = new ArrayList<>();
        status = StatusEnum.UNCHEKED;
        totalPoints = 0;
        for (int i = 0 ; i < numberOfLines ; i++) {
            lines.add(new Line(this));
        }
        logger.info( String.format("Ticket Generado: %s",toString()));
    }



    public Integer getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(Integer totalPoints) {
        this.totalPoints = totalPoints;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public List<Line> getLines() {
        return lines;
    }

    public void setLines(List<Line> lines) {
        this.lines = lines;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        lines.forEach(line -> {
            sb.append(String.format("[%s][%s][%s]",line.getFirstValue(),line.getSecondValue(),line.getThirdValue())).append("\n");
        });
        return sb.toString();
    }
}
