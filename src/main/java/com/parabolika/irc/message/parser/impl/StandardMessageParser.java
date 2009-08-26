package com.parabolika.irc.message.parser.impl;

import java.util.regex.Matcher;

import com.parabolika.irc.message.IRCMessage;
import com.parabolika.irc.message.impl.ChatMessage;
import com.parabolika.irc.message.impl.JoinMessage;
import com.parabolika.irc.message.impl.NickMessage;
import com.parabolika.irc.message.impl.PartMessage;
import com.parabolika.irc.message.impl.PingMessage;
import com.parabolika.irc.message.parser.IRCMessageParser;
import com.parabolika.irc.message.parser.IRCParserConstants;

public class StandardMessageParser implements IRCMessageParser {
	public IRCMessage parse(String message) {
		Matcher pingMatcher = IRCParserConstants.PATTERN_PING.matcher(message);
		if(pingMatcher.matches()) {
			return new PingMessage(pingMatcher.group(1));
		}
		Matcher joinMatcher = IRCParserConstants.PATTERN_JOIN.matcher(message);
		if(joinMatcher.matches()) {
			return new JoinMessage(joinMatcher.group(1), joinMatcher.group(2));
		}
		Matcher partMatcher = IRCParserConstants.PATTERN_PART.matcher(message);
		if(partMatcher.matches()) {
			return new PartMessage(partMatcher.group(1), partMatcher.group(2));
		}
		Matcher nickMatcher = IRCParserConstants.PATTERN_NICK.matcher(message);
		if(nickMatcher.matches()) {
			return new NickMessage(nickMatcher.group(1), nickMatcher.group(2));
		}
		Matcher chatMatcher = IRCParserConstants.PATTERN_CHAT.matcher(message);
		if(chatMatcher.matches()) {
			return new ChatMessage(chatMatcher.group(1), chatMatcher.group(2), chatMatcher.group(3));
		}
		return null;
	}
}
