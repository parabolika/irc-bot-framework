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

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.parabolika.irc.message.impl.ChatMessage;
import com.parabolika.irc.message.parser.impl.ParserDelegator;

public class ChatMessageTest {
	@Test
	public void testOutputIsValid() {
		ChatMessage message = new ChatMessage("someone", "hello");
		assertEquals(message.getOutputString(), "PRIVMSG someone :hello");
	}

	@Test
	public void testCanParseMessage() {
		String message = ":someone!somebody@some.host PRIVMSG #somechannel :somemessage";
		ChatMessage chat = (ChatMessage) new ParserDelegator().parse(message);
		assertEquals(chat.getReceiver(), "#somechannel");
		assertEquals(chat.getSender(), "someone");
		assertEquals(chat.getText(), "somemessage");
	}
}
