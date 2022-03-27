package jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.naming.NamingException;

public class JmsProducerTopic {

	private final JmsConnectionTopic jmsConnection = new JmsConnectionTopic();
	private static final String TOPIC_NAME = "store";

	public void produceUniqueMessage() throws NamingException, JMSException {

		final Session session = jmsConnection.start(TOPIC_NAME, null);
		final MessageProducer messageProducer = session.createProducer(jmsConnection.destinationQueue);
		final Message message = session.createTextMessage("Sup from a messaging producer topic");

		messageProducer.send(message);

		jmsConnection.closeConnections();

	}
}
