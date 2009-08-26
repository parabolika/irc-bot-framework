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

package com.parabolika.irc.system.impl;

import java.util.ArrayList;
import java.util.Collection;

import com.parabolika.irc.event.IRCEvent;
import com.parabolika.irc.event.IRCEventListener;
import com.parabolika.irc.event.annotate.IRCEventHook;
import com.parabolika.irc.event.enums.IRCEventTypes;
import com.parabolika.irc.event.impl.IRCEventImpl;
import com.parabolika.irc.event.impl.PingEventListener;
import com.parabolika.irc.io.IRCDataStream;
import com.parabolika.irc.message.IRCMessage;
import com.parabolika.irc.message.impl.ChatMessage;
import com.parabolika.irc.message.impl.JoinMessage;
import com.parabolika.irc.message.impl.NickMessage;
import com.parabolika.irc.message.impl.UserMessage;
import com.parabolika.irc.message.parser.IRCMessageParser;
import com.parabolika.irc.message.parser.impl.ParserDelegator;
import com.parabolika.irc.system.IRCSystem;

public class IRCSystemImpl implements IRCSystem {
	private Collection<IRCEventListener> eventListeners = new ArrayList<IRCEventListener>();
	private IRCMessageParser parser = new ParserDelegator();
	private IRCDataStream stream = null;

	public IRCSystemImpl(IRCDataStream stream) {
		this.stream = stream;
		addEventListener(new PingEventListener());
	}

	public void run() {
		String readLine = null;
		while((readLine = stream.read()) != null) {
			IRCMessage message = parser.parse(readLine);
			if(message != null) {
				relayEvent(new IRCEventImpl(message));
			}
		}
	}

	public void joinChannel(String channel) {
		stream.write(new JoinMessage(channel));
	}

	public void setUser(String userName, String hostName, String serverName, String realName) {
		stream.write(new UserMessage(userName, hostName, serverName, realName));
	}

	public void setNick(String newNick) {
		stream.write(new NickMessage(newNick));
	}

	public void sendMessage(String receiver, String text) {
		stream.write(new ChatMessage(receiver, text));
	}

	public void addEventListener(IRCEventListener listener) {
		eventListeners.add(listener);
	}

	public void removeEventListener(IRCEventListener listener) {
		eventListeners.remove(listener);
	}

	private void relayEvent(IRCEvent event) {
		IRCEventTypes type = event.getType();
		for(IRCEventListener listener : eventListeners) {
			IRCEventTypes[] acceptedTypes = listener.getClass().getAnnotation(IRCEventHook.class).value();
			for(IRCEventTypes acceptedType : acceptedTypes) {
				if(type.equals(acceptedType)) {
					listener.onEvent(this, event);
				}
			}
		}
	}

	public IRCDataStream getDataStream() {
		return stream;
	}
}
