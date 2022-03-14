package jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.naming.NamingException;

public class jmsProducer {

	private final jmsConnection jmsConnection = new jmsConnection();
	private static final String QUEUE_NAME = "test";

	public void produceUniqueMessage() throws NamingException, JMSException {

		final Session session = jmsConnection.start(QUEUE_NAME);
		final MessageProducer messageProducer = session.createProducer(jmsConnection.destinationQueue);
		final Message message = session.createTextMessage("Sup from a messaging producer");

		messageProducer.send(message);

		jmsConnection.closeConnections();
	}
}
