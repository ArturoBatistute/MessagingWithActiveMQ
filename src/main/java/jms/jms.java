package jms;

import java.util.Scanner;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class jms {

	private static Session session;
	private static Connection connection;
	private static Destination destinationQueue;
	private static InitialContext context;

	@SuppressWarnings("resource")
	public static void main(String[] args) throws NamingException, JMSException {

		context = new InitialContext();

		final ConnectionFactory factory = (ConnectionFactory) context.lookup("ConnectionFactory");

		connection = factory.createConnection();
		destinationQueue = (Destination) context.lookup("test");

		connection.start();

		session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

		final MessageConsumer messageConsumer = session.createConsumer(destinationQueue);

		final Message message = messageConsumer.receive();

		System.out.println(message);

		new Scanner(System.in).nextLine();

		closeConnections();
	}

	private static void closeConnections() throws JMSException, NamingException {

		session.close();
		connection.close();
		context.close();
	}
}
