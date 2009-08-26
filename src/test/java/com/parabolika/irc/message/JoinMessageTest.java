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

import com.parabolika.irc.message.impl.JoinMessage;
import com.parabolika.irc.message.parser.impl.ParserDelegator;

public class JoinMessageTest {
	@Test
	public void testOutputIsValid() {
		JoinMessage message = new JoinMessage("#somechan");
		assertEquals(message.getOutputString(), "JOIN #somechan");
	}

	@Test
	public void testCanAddNumberSign() {
		JoinMessage message = new JoinMessage("somechan");
		assertEquals(message.getChannel(), "#somechan");
	}

	@Test
	public void testCanParseMessage() {
		String message = ":someone!some@host JOIN :#somechan";
		JoinMessage join = (JoinMessage) new ParserDelegator().parse(message);
		assertEquals(join.getJoiner(), "someone");
		assertEquals(join.getChannel(), "#somechan");
	}
}
