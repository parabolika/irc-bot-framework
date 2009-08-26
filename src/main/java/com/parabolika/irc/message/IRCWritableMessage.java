package com.parabolika.irc.message;

public interface IRCWritableMessage extends IRCMessage {
	String getOutputString();
}
