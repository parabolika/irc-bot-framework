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

package com.parabolika.irc.message;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.parabolika.irc.message.IRCMessage;
import com.parabolika.irc.message.impl.ChatMessage;
import com.parabolika.irc.message.impl.JoinMessage;
import com.parabolika.irc.message.impl.NickMessage;
import com.parabolika.irc.message.impl.NumericalMessage;
import com.parabolika.irc.message.impl.PartMessage;
import com.parabolika.irc.message.impl.PingMessage;
import com.parabolika.irc.message.parser.IRCMessageParser;
import com.parabolika.irc.message.parser.impl.ParserDelegator;

public class IRCMessageParserTest {
	private IRCMessageParser parser = new ParserDelegator();

	@Test
	public void canParsePing() {
		IRCMessage message = parser.parse("PING some.host");
		assertTrue(message instanceof PingMessage);
	}

	@Test
	public void canParseChat() {
		IRCMessage message = parser.parse(":someone!somebody@some.host PRIVMSG #somechannel :somemessage");
		assertTrue(message instanceof ChatMessage);
	}

	@Test
	public void canParseNick() {
		IRCMessage message = parser.parse(":old NICK new");
		assertTrue(message instanceof NickMessage);
	}

	@Test
	public void canParseJoin() {
		IRCMessage message = parser.parse(":someone!some@host JOIN :#somechan");
		assertTrue(message instanceof JoinMessage);
	}

	@Test
	public void canParsePart() {
		IRCMessage message = parser.parse(":someone!some@host PART #somechan");
		assertTrue(message instanceof PartMessage);
	}

	@Test
	public void canParseNumerical() {
		IRCMessage message = parser.parse(":mitb.moparisthebest.com 500 somedata");
		assertTrue(message instanceof NumericalMessage);
	}
}
