/*******************************************************************************
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/

package com.parabolika.irc.message.impl;

import com.parabolika.irc.event.enums.IRCEventTypes;
import com.parabolika.irc.message.IRCWritableMessage;
import com.parabolika.irc.message.MessageVisitor;
import com.parabolika.irc.message.annotate.EventType;

@EventType(IRCEventTypes.CHANNEL)
public class ChatMessage implements IRCWritableMessage {
	private String sender = null;
	private String receiver = null;
	private String text = null;

	public ChatMessage(String receiver, String text) {
		this(null, receiver, text);
	}

	public ChatMessage(String sender, String receiver, String text) {
		this.sender = sender;
		this.receiver = receiver;
		this.text = text;
	}

	public void accept(MessageVisitor visitor) {
		visitor.visit(this);
	}

	public String getSender() {
		return sender;
	}

	public String getReceiver() {
		return receiver;
	}

	public String getText() {
		return text;
	}

	public String getOutputString() {
		return "PRIVMSG " + receiver + " :" + text;
	}
}
