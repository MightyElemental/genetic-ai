package net.wolfgangts.irc;

public class IrcChannel
{
	private String		channelName;
	private IrcClient	Irc;

	public IrcChannel(String channelName, IrcClient irc)
	{
		this.channelName = channelName;
		this.Irc = irc;
		
		Irc.rawSend("JOIN #" + this.channelName);
	}

	public void Send(String message)
	{
		Irc.rawSend("PRIVMSG #" + this.channelName + " :" + message);
	}
}

