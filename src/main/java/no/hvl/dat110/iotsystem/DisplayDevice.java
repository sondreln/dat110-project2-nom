package no.hvl.dat110.iotsystem;

import no.hvl.dat110.client.Client;
import no.hvl.dat110.messages.Message;
import no.hvl.dat110.messages.PublishMsg;
import no.hvl.dat110.common.TODO;

public class DisplayDevice {
	
	private static final int COUNT = 10;
		
	public static void main (String[] args) {
		
		System.out.println("Display starting ...");
		
		// TODO - START
				
		// create a client object and use it to
		
		// - connect to the broker - use "display" as the username
		Client client = new Client("display", "localhost", 8080);
		client.connect();

		// - create the temperature topic on the broker
		client.createTopic("temperature");

		// - subscribe to the topic
		client.subscribe("temperature");

		// - receive messages on the topic
		for (int i = 0; i < COUNT; i++) {
			Message message = client.receive();
			System.out.println(message.toString());
		}
		// - unsubscribe from the topic
		client.unsubscribe("temperature");

		// - disconnect from the broker
		client.disconnect();
		
		// TODO - END
		
		System.out.println("Display stopping ... ");
		
		//throw new UnsupportedOperationException(TODO.method());
		
	}
}
