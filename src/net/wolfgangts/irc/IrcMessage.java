package net.wolfgangts.irc;

public class IrcMessage
{
	private String rawData;
	private String sender;
	private String rawChannel;
	private String rawMessage;
	private IrcChannel channel;
	private IrcClient Irc;
	
	public IrcMessage(String raw, IrcClient irc)
	{
		this.rawData = raw;
		this.Irc = irc;
	}

}
