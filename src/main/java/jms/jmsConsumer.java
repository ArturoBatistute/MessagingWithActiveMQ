package jms;

import java.util.Scanner;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.naming.NamingException;

public class jmsConsumer {

	private final jmsConnection jmsConnection = new jmsConnection();
	private static final String QUEUE_NAME = "test";

	@SuppressWarnings("resource")
	public void consumeUniqueMessage() throws NamingException, JMSException {

		final Session session = jmsConnection.start(QUEUE_NAME);
		final MessageConsumer messageConsumer = session.createConsumer(jmsConnection.destinationQueue);
		final Message message = messageConsumer.receive();

		System.out.println(message);

		new Scanner(System.in).nextLine();

		jmsConnection.closeConnections();
	}
}
