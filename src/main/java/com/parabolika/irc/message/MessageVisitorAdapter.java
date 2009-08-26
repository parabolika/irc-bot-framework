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

import com.parabolika.irc.message.impl.ChatMessage;
import com.parabolika.irc.message.impl.JoinMessage;
import com.parabolika.irc.message.impl.NickMessage;
import com.parabolika.irc.message.impl.NumericalMessage;
import com.parabolika.irc.message.impl.PartMessage;
import com.parabolika.irc.message.impl.PingMessage;
import com.parabolika.irc.message.impl.UserMessage;

public class MessageVisitorAdapter implements MessageVisitor {
	public void visit(JoinMessage message) { }
	public void visit(PartMessage message) { }
	public void visit(NickMessage message) { }
	public void visit(PingMessage message) { }
	public void visit(UserMessage message) { }
	public void visit(ChatMessage message) { }
	public void visit(NumericalMessage message) { }
}
