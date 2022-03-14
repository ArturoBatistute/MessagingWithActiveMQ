package jms;

import javax.jms.JMSException;
import javax.naming.NamingException;

public class Main {

	private final static jmsConsumer consumer = new jmsConsumer();

	public static void main(String[] args) throws NamingException, JMSException {

		// consumer.consumeUniqueMessage();
		consumer.consumeMultipleMessages();
	}
}
