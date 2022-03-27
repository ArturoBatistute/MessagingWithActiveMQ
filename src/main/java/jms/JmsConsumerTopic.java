package jms;

import java.util.Scanner;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.naming.NamingException;

public class JmsConsumerTopic {

	private final JmsConnectionTopic jmsConnection = new JmsConnectionTopic();
	private static final String TOPIC_NAME = "store";
	private static final String TOPIC_ID = "store";

	@SuppressWarnings("resource")
	public void consumeMultipleMessages() throws NamingException, JMSException {

		final Session session = jmsConnection.start(TOPIC_NAME, TOPIC_ID);
		final MessageConsumer messageConsumer = session.createDurableSubscriber((Topic) jmsConnection.destinationQueue,
				"signature");

		messageConsumer.setMessageListener(new MessageListener() {

			public void onMessage(Message message) {

				final TextMessage textMessage = (TextMessage) message;

				try {

					System.out.println(textMessage.getText());

				} catch (final JMSException e) {

					e.printStackTrace();
				}
			}
		});

		new Scanner(System.in).nextLine();

		jmsConnection.closeConnections();
	}
}
