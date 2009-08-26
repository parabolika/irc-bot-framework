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

package com.parabolika.irc.system;

import com.parabolika.irc.event.IRCEventListener;
import com.parabolika.irc.io.IRCDataStream;

public interface IRCSystem extends Runnable {
	IRCDataStream getDataStream();

	void addEventListener(IRCEventListener listener);
	void removeEventListener(IRCEventListener listener);

	void setUser(String userName, String hostName, String serverName, String realName);
	void setNick(String newNick);
	void joinChannel(String channel);
	void sendMessage(String receiver, String text);

	void run();
}
