package com.parabolika.irc.message.impl;

import com.parabolika.irc.message.IRCWritableMessage;
import com.parabolika.irc.message.MessageVisitor;

public class PartMessage implements IRCWritableMessage {
	private String parter = null;
	private String channel = null;

	public PartMessage(String channel) {
		this(null, channel);
	}

	public PartMessage(String parter, String channel) {
		this.parter = parter;
		this.channel = channel;
	}

	public void accept(MessageVisitor visitor) {
		visitor.visit(this);
	}

	public String getParter() {
		return parter;
	}

	public String getChannel() {
		return channel;
	}

	public String getOutputString() {
		return "PART " + channel;
	}
}
