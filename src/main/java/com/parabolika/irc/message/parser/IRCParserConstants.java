package com.parabolika.irc.message.parser;

import java.util.regex.Pattern;

public interface IRCParserConstants {
	static final Pattern PATTERN_PING = Pattern.compile("^PING (.+)$");
	static final Pattern PATTERN_JOIN = Pattern.compile("^:([^\\s!]+)![^\\s]+ JOIN :(#.+)$");
	static final Pattern PATTERN_PART = Pattern.compile("^:([^\\s!]+)![^\\s]+ PART (#.+)$");
	static final Pattern PATTERN_NICK = Pattern.compile("^:([^\\s]+) NICK (.+)$");
	static final Pattern PATTERN_CHAT = Pattern.compile("^:([^!]+)![^\\s]+ PRIVMSG (#[^\\s]+) :(.+)$");

	static final Pattern PATTERN_NUMERICAL_RESPONSE = Pattern.compile("^:([^\\s]+) (\\d+) (.+)$");
}
