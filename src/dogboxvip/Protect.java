package dogboxvip;

import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 *
 * @author jasonwaste
 */
public class Protect implements Mod
{
    private String channel;
    private FileWriter fw;
    private BufferedWriter out;
    private FileWriter wf;
    private BufferedWriter tou;

    public Protect()
    {

    }

    public void onPrivateMessage(String sender, String login, String hostname,
            String message, Dogbox d)
    {
        if (message.startsWith("invite"))
        {
            String [] splits = message.split(" ");
            if (splits.length!=3) d.sendMessage(sender, "invalid syntax. "
                    + "'invite <nick> <channel>'");
            else d.sendInvite(splits[1], splits[2]);
        }
    }

    public void onMessage(String channel, String sender, String login,
            String hostname, String message, Dogbox d)
    {
      
    }

    public void onAction(String sender, String login, String hostname,
            String target, String action, Dogbox d)
    {
    }

    public void onNotice(String sourceNick, String sourceLogin,
            String sourceHostname, String target, String notice, Dogbox d)
    {
    }

    public void onJoin(String channel, String sender, String login,
            String hostname, Dogbox d)
    {
    }

    public void onPart(String channel, String sender, String login,
            String hostname, Dogbox d)
    {
    }

    public void onNickChange(String oldNick, String login, String hostname,
            String newNick, Dogbox d)
    {
    }

    public void onKick(String channel, String kickerNick, String kickerLogin,
            String kickerHostname, String recipientNick, String reason,
            Dogbox d)
    {
        if (channel.equals(getActiveChannel()))
        {
            if (recipientNick.equalsIgnoreCase("jasonwaste") ||
                    recipientNick.equals("jinglewaste")||
                    recipientNick.equalsIgnoreCase("Kit"))
            {
                d.deOp(channel, kickerNick);
                d.sendInvite(recipientNick, channel);
            }
        }
    }

    public void onQuit(String sourceNick, String sourceLogin,
            String sourceHostname, String reason, Dogbox d)
    {
    }

    public void onTopic(String channel, String topic, String setBy,
             Dogbox d)
    {
    }

    public void onMode(String channel, String sourceNick, String sourceLogin,
            String sourceHostname, String mode, Dogbox d)
    {
    }

    public void onUserMode(String targetNick, String sourceNick,
            String sourceLogin, String sourceHostname, String mode, Dogbox d)
    {
    }

    public void onOp(String channel, String sourceNick, String sourceLogin,
            String sourceHostname, String recipient, Dogbox d)
    {
    }

    public void onDeop(String channel, String sourceNick, String sourceLogin,
            String sourceHostname, String recipient, Dogbox d)
    {
        if (channel.equalsIgnoreCase(getActiveChannel()))
        {
            if (recipient.equalsIgnoreCase("jasonwaste") || recipient.equals(
                    "jinglewaste")|| recipient.equalsIgnoreCase("Kit"))
            {
                d.op(channel, recipient);
            }
        }
    }

    public void onVoice(String channel, String sourceNick, String sourceLogin,
            String sourceHostname, String recipient, Dogbox d)
    {
    }

    public void onDeVoice(String channel, String sourceNick, String sourceLogin,
            String sourceHostname, String recipient, Dogbox d)
    {
        if (channel.equalsIgnoreCase(getActiveChannel()))
        {
            if (recipient.equalsIgnoreCase("jasonwaste")||
                    recipient.equals("jinglewaste") ||
                    recipient.equalsIgnoreCase("Kit"))
            {
                d.voice(channel, recipient);
            }
        }
    }

    public void onSetChannelBan(String channel, String sourceNick,
            String sourceLogin, String sourceHostname, String hostmask,
            Dogbox d)
    {
        if (channel.equalsIgnoreCase(this.getActiveChannel()))
        {
            if (hostmask.contains("edach") || hostmask.contains("oitoi"))
            {
                d.unBan(channel, hostmask);
            }
        }
    }

    public void onRemoveChannelBan(String channel, String sourceNick,
            String sourceLogin, String sourceHostname, String hostmask,
            Dogbox d)
    {
    }

    public void onSetInviteOnly(String channel, String sourceNick,
            String sourceLogin, String sourceHostname, Dogbox d)
    {
    }

    public void onRemoveInviteOnly(String channel, String sourceNick,
            String sourceLogin, String sourceHostname, Dogbox d)
    {
    }

    public void onSetModerated(String channel, String sourceNick,
            String sourceLogin, String sourceHostname, Dogbox d)
    {
    }

    public void onRemoveModerated(String channel, String sourceNick,
            String sourceLogin, String sourceHostname, Dogbox d)
    {
    }

    public void onInvite(String targetNick, String sourceNick,
            String sourceLogin, String sourceHostname, String channel, Dogbox d)
    {
    }

    public void onDccSendRequest(String sourceNick, String sourceLogin,
            String sourceHostname, String filename, long address, int port,
            int size, Dogbox d)
    {
    }

    public void onDccChatRequest(String sourceNick, String sourceLogin,
            String sourceHostname, long address, int port, Dogbox d)
    {
    }

    public void setActiveChannel(String channel) {
        this.channel = channel;
    }

    public String getActiveChannel() {
        return channel;
    }

    public String getName() {
        return "Protect";
    }

    public void help(String sender, Dogbox d) {
        d.sendMessage(sender, "invite <nick> <module> : Protect.java");
    }

    ///////////////////////////////////////////////////////////////////////

    
}
