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

package com.parabolika.irc.event.impl;

import com.parabolika.irc.event.IRCEvent;
import com.parabolika.irc.event.enums.IRCEventTypes;
import com.parabolika.irc.message.IRCMessage;
import com.parabolika.irc.message.annotate.EventType;

public class IRCEventImpl implements IRCEvent {
	public IRCEventTypes type = null;
	public IRCMessage message = null;

	public IRCEventImpl(IRCMessage message) {
		this.message = message;
		this.type = message.getClass().getAnnotation(EventType.class).value();
	}

	public IRCEventTypes getType() {
		return type;
	}

	public IRCMessage getMessage() {
		return message;
	}
}
