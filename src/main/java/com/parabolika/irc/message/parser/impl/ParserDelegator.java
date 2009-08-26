package com.parabolika.irc.message.parser.impl;

import com.parabolika.irc.message.IRCMessage;
import com.parabolika.irc.message.parser.IRCMessageParser;

public class ParserDelegator implements IRCMessageParser {
	public IRCMessageParser[] availableParsers = new IRCMessageParser[] {
			new StandardMessageParser(),
			new NumericalMessageParser(),
	};

	public IRCMessage parse(String message) {
		for(IRCMessageParser parser : availableParsers) {
			IRCMessage possibleMessage = parser.parse(message);
			if(possibleMessage != null) {
				return possibleMessage;
			}
		}
		return null;
	}
}
