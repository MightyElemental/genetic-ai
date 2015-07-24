package net.wolfgangts.irc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;

import net.minegeek360.ai.language.LanguageInterpreter;

public class IrcClient
{

	private BufferedWriter			writer;
	private BufferedReader			reader;
	private String					server		= "irc.freenode.net";
	private String					pass; 
	private String					nick;
	private Socket					socket;
	private ArrayList<IrcChannel>	channels	= new ArrayList<IrcChannel>();

	/*
	 * Thread to read from the server.
	 */
	private Thread reading = new Thread()
	{
		public void run()
		{
			while (true)
			{
				String line;
				try
				{
					line = reader.readLine();

					parseData(line);
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}

			}
		}
	};
	/***
	 * @param username username/nick for the IrcClient
	 * @param password password for the IrcClient if required
	 */
	public IrcClient(String username)
	{
		this.nick = username;

		try
		{
			// Connect to server.
			this.socket = new Socket(this.server, 6667);

			try
			{
				// Get in and output streams
				this.writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
				this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

				// Send credentials
				if(this.pass != null)
					rawSend("PASS " + this.pass);
				rawSend("USER " + this.nick + " 8 * : " + this.nick);
				rawSend("NICK " + this.nick);


				this.reading.start();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public IrcClient (String username, String password)
	{
		this(username);
		this.pass = password;
	}

	public void joinChannel(String channelname)
	{
		this.channels.add(new IrcChannel(channelname, this));
	}

	protected void parseData(String line)
	{
		LanguageInterpreter.interperate(line);
		
		if (line.startsWith("PING"))
		{
			rawSend("PONG " + line.split(" ")[1]);
		}

		System.out.println(line);
	}

	public void rawSend(String data)
	{
		try
		{
			this.writer.write(data + "\r\n");
			this.writer.flush();
			System.out.println(data);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
