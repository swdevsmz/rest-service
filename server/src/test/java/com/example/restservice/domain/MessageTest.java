package com.example.restservice.domain;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class MessageTest {

    @Test
    public void testMessage(){
        Message message = new Message();
        message.setText("Hello");
        assertEquals("Hello", message.getText());
    }

}
