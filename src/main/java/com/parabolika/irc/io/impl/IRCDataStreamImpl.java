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

package com.parabolika.irc.io.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import com.parabolika.irc.io.IRCDataStream;
import com.parabolika.irc.message.IRCWritableMessage;

public class IRCDataStreamImpl implements IRCDataStream {
	private BufferedReader reader = null;
	private BufferedWriter writer = null;

	public IRCDataStreamImpl(String host) throws UnknownHostException, IOException {
		this(host, 6667);
	}

	public IRCDataStreamImpl(String host, int port) throws UnknownHostException, IOException {
		this(new Socket(host, port));
	}

	public IRCDataStreamImpl(Socket socket) throws IOException {
		reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
	}

	public String read() {
		try {
			return reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void write(IRCWritableMessage message) {
		try {
			writer.write(message.getOutputString() + "\r\n");
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
