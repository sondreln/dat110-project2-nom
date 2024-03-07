package no.hvl.dat110.broker;

import java.util.Collection;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import no.hvl.dat110.common.TODO;
import no.hvl.dat110.common.Logger;
import no.hvl.dat110.messagetransport.Connection;

public class Storage {

	// data structure for managing subscriptions
	// maps from a topic to set of subscribed users
	protected ConcurrentHashMap<String, Set<String>> subscriptions;
	
	// data structure for managing currently connected clients
	// maps from user to corresponding client session object
	
	protected ConcurrentHashMap<String, ClientSession> clients;

	public Storage() {
		subscriptions = new ConcurrentHashMap<String, Set<String>>();
		clients = new ConcurrentHashMap<String, ClientSession>();
	}

	public Collection<ClientSession> getSessions() {
		return clients.values();
	}

	public Set<String> getTopics() {

		return subscriptions.keySet();

	}

	// get the session object for a given user
	// session object can be used to send a message to the user
	
	public ClientSession getSession(String user) {

		ClientSession session = clients.get(user);

		return session;
	}

	public Set<String> getSubscribers(String topic) {

		return (subscriptions.get(topic));

	}

	public void addClientSession(String user, Connection connection) {

		ClientSession session = new ClientSession(user, connection);
		clients.put(user, session);


		// TODO: add corresponding client session to the storage
		// See ClientSession class
		
		//throw new UnsupportedOperationException(TODO.method());
		
	}

	public void removeClientSession(String user) {

		clients.remove(user);

		// TODO: disconnet the client (user) 
		// and remove client session for user from the storage
		
		//throw new UnsupportedOperationException(TODO.method());
		
	}

	public void createTopic(String topic) {

		subscriptions.put(topic, ConcurrentHashMap.newKeySet());

		// TODO: create topic in the storage

		//throw new UnsupportedOperationException(TODO.method());
	
	}

	public void deleteTopic(String topic) {

		subscriptions.remove(topic);

		// TODO: delete topic from the storage

		//throw new UnsupportedOperationException(TODO.method());
		
	}

	public void addSubscriber(String user, String topic) {

		Set<String> set = subscriptions.get(topic);
		set.add(user);
		subscriptions.put(topic, set);


		// TODO: add the user as subscriber to the topic
		
		//throw new UnsupportedOperationException(TODO.method());
		
	}

	public void removeSubscriber(String user, String topic) {

		Set<String> set = subscriptions.get(topic);
		set.remove(user);
		subscriptions.put(topic, set);


		// TODO: remove the user as subscriber to the topic

		//throw new UnsupportedOperationException(TODO.method());
	}
}
