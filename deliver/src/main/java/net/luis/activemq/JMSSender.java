package net.luis.activemq;

import java.util.List;
import java.util.Random;

import javax.jms.BytesMessage;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.apache.log4j.Logger;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;


public class JMSSender {
	private static final Logger logger = Logger.getLogger(JMSSender.class);
	private JmsTemplate jmsTemplate;  
    private List<Destination> senderQueueList;  
    
    public List<Destination> getSenderQueueList() {
		return senderQueueList;
	}
	public void setSenderQueueList(List<Destination> senderQueueList) {
		this.senderQueueList = senderQueueList;
	}
	public JmsTemplate getJmsTemplate() {  
        return jmsTemplate;  
    }
    public void setJmsTemplate(JmsTemplate jmsTemplate) { 
        this.jmsTemplate = jmsTemplate;  
    }  
    
	public void sendMessage(Object object) {  
		jmsTemplate.convertAndSend(getSendDestination(), object);
    }
	private Destination getSendDestination(){
		Destination _destination;
		if(senderQueueList != null){
			Random ra =new Random();
			_destination = senderQueueList.get(ra.nextInt(senderQueueList.size()));
		}else{
			_destination = jmsTemplate.getDefaultDestination();
		}
		return _destination;
	}
    /**
     * 使用默认队列名称发送文本消息
     * @param message
     */
    public void simpleSend(String message){
        System.out.println("-----生产者发了一个消息：" + message);
    	jmsTemplate.send(new MessageCreator(){
			@Override
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage(message);
			}
    	});
    }
    /**
     * 使用默认队列名称发送字节消息
     * @param message
     */
    public void sendByteMessage(byte[] message){
    	sendByteMessageWithQueue(getSendDestination(),message);
    }
    /**
     * 指定队列名称，发送字节消息
     * @param message
     */
    public void sendByteMessageWithQueue(Destination destination,byte[] message){
    	jmsTemplate.send(destination,new MessageCreator(){
			@Override
			public Message createMessage(Session session) throws JMSException {
				BytesMessage bytesMessage = session.createBytesMessage();
				bytesMessage.writeBytes(message);
				return bytesMessage;
			}
    	});
    }
    /**
     * 指定队列名称，发送文本消息消息
     * @param destination
     * @param message
     */
    public void sendTextMessageWithQueue(Destination queue,String message){
    	jmsTemplate.send(queue, new MessageCreator(){
			@Override
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage(message);
			}
    	});
    }
}
