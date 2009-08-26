package com.parabolika.irc.message.parser;

import com.parabolika.irc.message.IRCMessage;

public interface IRCMessageParser {
	IRCMessage parse(String message);
}
