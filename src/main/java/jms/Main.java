package jms;

import javax.jms.JMSException;
import javax.naming.NamingException;

public class Main {

	private final static JmsConsumerQueue consumer = new JmsConsumerQueue();
	private final static JmsProducerQueue producer = new JmsProducerQueue();
	private final static JmsProducerTopic producerTopic = new JmsProducerTopic();
	private final static JmsConsumerTopic consumerTopic = new JmsConsumerTopic();

	public static void main(String[] args) throws NamingException, JMSException {

		// consumer.consumeUniqueMessage();
		// consumer.consumeMultipleMessages();
		// producer.produceUniqueMessage();
		// producerTopic.produceUniqueMessage();
		consumerTopic.consumeMultipleMessages();
	}
}
