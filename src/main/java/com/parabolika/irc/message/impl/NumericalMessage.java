package com.parabolika.irc.message.impl;

import com.parabolika.irc.event.enums.IRCEventTypes;
import com.parabolika.irc.message.IRCMessage;
import com.parabolika.irc.message.MessageVisitor;
import com.parabolika.irc.message.annotate.EventType;

@EventType(IRCEventTypes.SERVER)
public class NumericalMessage implements IRCMessage {
	private String host = null;

	private int number = -1;
	private String data = null;

	public NumericalMessage(String host, int number, String data) {
		this.host = host;
		this.number = number;
		this.data = data;
	}

	public void accept(MessageVisitor visitor) {
		visitor.visit(this);
	}

	public String getHost() {
		return host;
	}

	public int getNumber() {
		return number;
	}

	public String getData() {
		return data;
	}
}
