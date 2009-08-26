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

public interface MessageVisitor {
	void visit(JoinMessage message);
	void visit(PartMessage message);
	void visit(NickMessage message);
	void visit(PingMessage message);
	void visit(UserMessage message);
	void visit(ChatMessage message);
	void visit(NumericalMessage message);
}
