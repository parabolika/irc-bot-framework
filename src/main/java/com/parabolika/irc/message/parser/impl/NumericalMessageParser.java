package com.parabolika.irc.message.parser.impl;

import java.util.regex.Matcher;

import com.parabolika.irc.message.IRCMessage;
import com.parabolika.irc.message.impl.NumericalMessage;
import com.parabolika.irc.message.parser.IRCMessageParser;
import com.parabolika.irc.message.parser.IRCParserConstants;

public class NumericalMessageParser implements IRCMessageParser {
	public IRCMessage parse(String message) {
		Matcher numericalMatcher = IRCParserConstants.PATTERN_NUMERICAL_RESPONSE.matcher(message);
		if(numericalMatcher.matches()) {
			return new NumericalMessage(numericalMatcher.group(1),
					Integer.parseInt(numericalMatcher.group(2)), numericalMatcher.group(3));
		}
		return null;
	}
}
