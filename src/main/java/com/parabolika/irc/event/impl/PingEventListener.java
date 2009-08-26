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
import com.parabolika.irc.event.IRCEventListener;
import com.parabolika.irc.event.annotate.IRCEventHook;
import com.parabolika.irc.event.enums.IRCEventTypes;
import com.parabolika.irc.message.MessageVisitor;
import com.parabolika.irc.message.MessageVisitorAdapter;
import com.parabolika.irc.message.impl.PingMessage;
import com.parabolika.irc.system.IRCSystem;

@IRCEventHook({ IRCEventTypes.SERVER })
public class PingEventListener implements IRCEventListener {
	public void onEvent(final IRCSystem system, IRCEvent event) {
		MessageVisitor pingVisitor = new MessageVisitorAdapter() {
			@Override
			public void visit(PingMessage message) {
				system.getDataStream().write(message);
			}
		};
		event.getMessage().accept(pingVisitor);
	}
}
