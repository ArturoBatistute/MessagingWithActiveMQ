package jms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Session;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class JmsConnection {

	private static Session session;
	private static Connection connection;
	private static InitialContext context;
	public Destination destinationQueue;

	public Session start(String queueName) throws NamingException, JMSException {

		context = new InitialContext();

		final ConnectionFactory factory = (ConnectionFactory) context.lookup("ConnectionFactory");

		connection = factory.createConnection();

		destinationQueue = (Destination) context.lookup(queueName);

		connection.start();

		session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

		return session;
	}

	public void closeConnections() throws JMSException, NamingException {

		session.close();
		connection.close();
		context.close();
	}
}
