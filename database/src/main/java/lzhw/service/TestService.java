package lzhw.service;

import lzhw.model.Test;
import org.springframework.beans.factory.Aware;

public class TestService implements Aware {
    private  Test test;
    public void setTest(Test test) {
        this.test = test;
    }
    public void print(){
        System.out.println("this his test service"+test);
    }
}
