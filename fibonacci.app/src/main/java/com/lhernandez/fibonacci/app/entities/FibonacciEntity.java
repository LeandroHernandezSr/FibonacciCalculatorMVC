package com.lhernandez.fibonacci.app.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "numbers")
public class FibonacciEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer number;
    @Column(name = "nth-numbers")
    private Long nthNumber;
    private Integer occurrences;

    public Long getId(){
        return this.id;
    }

    public void setId(Long id){
        this.id=id;
    }

    public Integer getNumber(){
        return this.number;
    }

    public void setNumber(Integer number){
        this.number=number;
    }


    public Long getNthNumber(){
        return this.nthNumber;
    }


    public void setNthNumber(Long nthNumber){
        this.nthNumber=nthNumber;
    }

    public Integer getOccurrences() {
        return occurrences;
    }

    public void setOccurrences(Integer occurrences) {
        this.occurrences = occurrences;
    }
    
}