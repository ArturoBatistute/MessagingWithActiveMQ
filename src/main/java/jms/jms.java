package jms;

import java.util.Scanner;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class jms {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws NamingException, JMSException {

		final InitialContext context = new InitialContext();
		final ConnectionFactory factory = (ConnectionFactory) context.lookup("ConnectionFactory");
		final Connection connection = factory.createConnection();

		connection.start();

		new Scanner(System.in).nextLine();

		connection.close();
		context.close();
	}
}
