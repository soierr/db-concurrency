package db.concurrency.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import static javax.persistence.GenerationType.SEQUENCE;


@Data
@Entity
public class Request {
    @Id
    /*@GeneratedValue(strategy=SEQUENCE, generator="REQUEST_SEQ")
    @SequenceGenerator(sequenceName = "REQUEST_SEQ", name = "REQUEST_SEQ")*/
    private int code;
    private String name;
    private long sla;
}
