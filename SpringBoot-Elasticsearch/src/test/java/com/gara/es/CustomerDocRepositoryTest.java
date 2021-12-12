package com.gara.es;

import com.gara.es.es.doc.CustomerDoc;
import com.gara.es.repository.CustomerDocRepository;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;

public class CustomerDocRepositoryTest extends EsDemoApplicationTests {

    private static final Random random = new Random();

    @Resource
    private CustomerDocRepository customerDocRepository;

    @Test
    public void testCreateIndex(){

    }

    @Test
    public void testInsertData(){
        for (int i = 0; i < 100; i++) {
            CustomerDoc customerDoc = new CustomerDoc();
            customerDoc.setId((long) (i+1));
            customerDoc.setCode(random.nextInt(100)+"");
            customerDoc.setLevel(random.nextInt(1000)+"");
            customerDoc.setSecondLevel("");
            customerDoc.setAge(random.nextInt(100));
            customerDoc.setSex((int) (10* Math.random())%2);
            customerDoc.setFirstName(random.nextInt(1000)+ UUID.randomUUID().toString().substring(30));
            customerDoc.setLastName(random.nextInt(1000)+ UUID.randomUUID().toString().substring(25));
            customerDoc.setBirthDate(LocalDateTime.now());
            customerDoc.setCreateDate(LocalDateTime.now());
            customerDoc.setUpdateDate(LocalDateTime.now());
            customerDoc.setCreatedBy("sys");
            customerDoc.setUpdatedBy("sys");
            customerDocRepository.save(customerDoc);
        }
    }

    public static void main(String[] args) {
        int i = (int) (10 * Math.random()) % 2;
        System.out.println("i = " + i);
    }
}