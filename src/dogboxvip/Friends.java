/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dogboxvip;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

/**
 *
 * @author jasonwaste
 */
public class Friends implements Mod
{
    private String channel;

    public Friends()
    {
    }

    public void onPrivateMessage(String sender, String login, String hostname,
            String message, Dogbox d)
    {
        String splits[] = message.split(" ");
        if (message.startsWith("add_friend"))
        {
            if (splits.length != 2)
            {
                d.sendMessage(sender, "Invalid syntax. "
                        + "Please use 'add_friend <nick>");
            }
            else
            {
               if(addFriend(splits[1])) d.sendMessage(sender,
                       "Added "+splits[1]+" to friends.");
               else d.sendMessage(sender,
                       "Failed to add "+splits[1]+" to friends.");
            }
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
        if (channel.equalsIgnoreCase(this.getActiveChannel()))
        {
            if(checkFriend(sender))
            {
                d.op(channel, sender);
            }
        }
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
        
    }

    public void onQuit(String sourceNick, String sourceLogin, 
            String sourceHostname, String reason, Dogbox d)
    {
    }

    public void onTopic(String channel, String topic, String setBy, Dogbox d)
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
    }

    public void onVoice(String channel, String sourceNick, String sourceLogin, 
            String sourceHostname, String recipient, Dogbox d)
    {
    }

    public void onDeVoice(String channel, String sourceNick, String sourceLogin,
            String sourceHostname, String recipient, Dogbox d)
    {
    }

    public void onSetChannelBan(String channel, String sourceNick,
            String sourceLogin, String sourceHostname, String hostmask,
                Dogbox d)
    {
    }

    public void onRemoveChannelBan(String channel, String sourceNick,
            String sourceLogin, String sourceHostname,
            String hostmask, Dogbox d)
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
            String sourceHostname, String filename, long address,
            int port, int size, Dogbox d)
    {
    }

    public void onDccChatRequest(String sourceNick, String sourceLogin, 
            String sourceHostname, long address, int port, Dogbox d)
    {
    }

    ///////////////////////////////////////////////////////////////////////
    private boolean addFriend(String newfriend)
    {
        try
	{
		FileWriter fw = new FileWriter("friends.txt",true);
		BufferedWriter out = new BufferedWriter(fw);
		out.write(newfriend+"\n");
		out.close();
		return true;
	}
	catch (Exception e)
	{
		return false;
	}
    }

    public boolean checkFriend(String sender)
    {
        boolean isFriend = false;
        try
        {
            FileInputStream fis = new FileInputStream("friends.txt");
            DataInputStream dis = new DataInputStream(fis);
            BufferedReader br = new BufferedReader(new InputStreamReader(dis));
            String strLine;
            while ((strLine = br.readLine()) != null)
            {
		if (strLine.equalsIgnoreCase(sender)) isFriend = true;
            }
            dis.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
  	}
        return isFriend;
    }

    public void setActiveChannel(String channel) {
        this.channel = channel;
    }

    public String getActiveChannel() {
        return channel;
    }

    public String getName() {
        return "Friends";
    }

    public void help(String sender, Dogbox d) {
        d.sendMessage(sender, "add_friend <nick> : Friends.java");
    }
}


