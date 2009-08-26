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

@EventType(IRCEventTypes.NONE)
public class UserMessage implements IRCWritableMessage {
	private String userName = null;
	private String hostName = null;
	private String serverName = null;
	private String realName = null;

	public UserMessage(String userName, String hostName, String serverName, String realName) {
		this.userName = userName;
		this.hostName = hostName;
		this.serverName = serverName;
		this.realName = realName;
	}

	public void accept(MessageVisitor visitor) {
		visitor.visit(this);
	}

	public String getUserName() {
		return userName;
	}

	public String getHostName() {
		return hostName;
	}

	public String getServerName() {
		return serverName;
	}

	public String getRealName() {
		return realName;
	}

	public String getOutputString() {
		return "USER " + getUserName() + " " + getHostName() + " " + getServerName() + " :" + getRealName();
	}
}
