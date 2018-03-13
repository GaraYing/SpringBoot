package com.springboot.vo;

import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;

@Entity
public class Worker {

    @Id
    @GeneratedValue
    private Integer workerId;

    @Column(nullable = false)
    private String workName;

    @Column(nullable = false)
    private Integer workerAge;

    public Integer getWorkerId() {
        return workerId;
    }

    public void setWorkerId(Integer workerId) {
        this.workerId = workerId;
    }

    public String getWorkName() {
        return workName;
    }

    public void setWorkName(String workName) {
        this.workName = workName;
    }

    public Integer getWorkerAge() {
        return workerAge;
    }

    public void setWorkerAge(Integer workerAge) {
        this.workerAge = workerAge;
    }

    public Worker() {
    }

    public Worker(String workName, Integer workerAge) {
        this.workName = workName;
        this.workerAge = workerAge;
    }
}
