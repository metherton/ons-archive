package com.ethertons.web;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class AlertServiceImpl implements AlertService {

    public AlertServiceImpl() {
        
    }
    
	@Autowired
	JmsTemplate jmsTemplate;	
	
	@Override
	public void sendHelloAlert(final String hello) {
		// TODO Auto-generated method stub

	    
	    jmsTemplate.send(new MessageCreator() {
							public Message createMessage(Session session) throws JMSException {
								return session.createObjectMessage(hello);
							}
						}
					);
	}

}

//}
