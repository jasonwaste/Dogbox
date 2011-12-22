/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dogboxvip;

/**
 *
 * @author jasonwaste
 */
public class Command implements Mod
{
    private boolean kitAuth;
    private boolean jasonAuth;

    public Command()
    {
        kitAuth = false;
        jasonAuth = false;
       // onTopic("#channel", "topic", "setBy", new Dogbox());
    }


    public void onPrivateMessage(String sender, String login, String hostname,
            String message, Dogbox d)
    {
        if(sender.equalsIgnoreCase(d.getNickserv()))
        {
            
        }
        else if((login.contentEquals("jasonwaste")
                && hostname.equalsIgnoreCase("redache.co.uk")
                        ) || (login.contentEquals("toitoils"
                        ) && hostname.equalsIgnoreCase("central.aber.ac.uk")))
        {
            String [] splitMess = message.split(" ");

            if (message.equalsIgnoreCase("do one")) d.leave();
            if (message.startsWith("auth_me"))
            {
                // auth code
            }
            if (message.startsWith("identify"))
            {
                identifyMe(sender, splitMess, d);
            }
            if (message.startsWith("join_channel"))
            {
                join(sender, splitMess, d);
            }
            if (message.startsWith("load_module"))
            {
                d.load(sender, message);
            }
            else if(message.startsWith("kill_module"))
            {
                d.killMod(sender, message);
            }
            else if(message.startsWith("say~"))
            {
                say(sender, message, d);
            }
            else if (message.startsWith("pm~"))
            {
                pm(sender, message, d);
            }
            else if(message.equals("list_modules"))
            {
                d.list(sender);
            }
            else if(message.startsWith("ops"))
            {
                ops(sender, splitMess, d);
            }
            else if(message.equalsIgnoreCase("help")) d.help(sender);
        }
    }

    public void onMessage(String channel, String sender, String login, 
            String hostname, String message, Dogbox d)
    {
    
    }

    public void onAction(String sender, String login, String hostname, 
            String target, String action, Dogbox d)
    {}

    public void onNotice(String sourceNick, String sourceLogin, 
            String sourceHostname, String target, String notice, Dogbox d)
    {}

    public void onJoin(String channel, String sender, String login, 
            String hostname, Dogbox d)
    {}

    public void onPart(String channel, String sender, String login, 
            String hostname, Dogbox d)
    {}

    public void onNickChange(String oldNick, String login, String hostname, 
            String newNick, Dogbox d)
    {}

    public void onKick(String channel, String kickerNick, String kickerLogin,
            String kickerHostname, String recipientNick, String reason,
            Dogbox d)
    {}

    public void onQuit(String sourceNick, String sourceLogin, 
            String sourceHostname, String reason, Dogbox d)
    {}

    public void onTopic(String channel, String topic, String setBy, Dogbox d)
    {
        int i = 0;
        while (i < 5 ) {System.out.print("Why don't I work?? D:"); i++;}
    }

    public void onMode(String channel, String sourceNick, String sourceLogin, 
            String sourceHostname, String mode, Dogbox d)
    {}

    public void onUserMode(String targetNick, String sourceNick, 
            String sourceLogin, String sourceHostname, String mode, Dogbox d)
    {}

    public void onOp(String channel, String sourceNick, String sourceLogin, 
            String sourceHostname, String recipient, Dogbox d)
    {}

    public void onDeop(String channel, String sourceNick, String sourceLogin, 
            String sourceHostname, String recipient, Dogbox d)
    {}

    public void onVoice(String channel, String sourceNick, String sourceLogin, 
            String sourceHostname, String recipient, Dogbox d)
    {}

    public void onDeVoice(String channel, String sourceNick, String sourceLogin,
            String sourceHostname, String recipient, Dogbox d)
    {}

    public void onSetChannelBan(String channel, String sourceNick,
            String sourceLogin, String sourceHostname, String hostmask,
            Dogbox d)
    {}

    public void onRemoveChannelBan(String channel, String sourceNick,
            String sourceLogin, String sourceHostname, String hostmask,
            Dogbox d)
    {}

    public void onSetInviteOnly(String channel, String sourceNick, 
            String sourceLogin, String sourceHostname, Dogbox d)
    {}

    public void onRemoveInviteOnly(String channel, String sourceNick, 
            String sourceLogin, String sourceHostname, Dogbox d)
    {}

    public void onSetModerated(String channel, String sourceNick, 
            String sourceLogin, String sourceHostname, Dogbox d)
    {}

    public void onRemoveModerated(String channel, String sourceNick, 
            String sourceLogin, String sourceHostname, Dogbox d)
    {}

    public void onInvite(String targetNick, String sourceNick, 
            String sourceLogin, String sourceHostname, String channel, Dogbox d)
    {}

    public void onDccSendRequest(String sourceNick, String sourceLogin,
            String sourceHostname, String filename, long address, int port,
            int size, Dogbox d)
    {}

    public void onDccChatRequest(String sourceNick, String sourceLogin, 
            String sourceHostname, long address, int port, Dogbox d)
    {}

    public void setActiveChannel(String channel) 
    {
    }

    public String getActiveChannel() 
    {
        return "channel is irrelevant";
    }

    public String getName() {
        return "Command";
    }

    public void help(String send, Dogbox d)
    {
        d.sendMessage(send, "///////////////////////////////");
        d.sendMessage(send, "Default Commands:");
        d.sendMessage(send, "join_channel <channel>");
        d.sendMessage(send, "load_module <module> <channel>" );
        d.sendMessage(send, "kill_module <module> <channel>");
        d.sendMessage(send, "list_modules  (lists currently loaded modules)");
        d.sendMessage(send, "say~<channel>~ <message>" );
        d.sendMessage(send, "peem~<nick>~ <message>" );
        d.sendMessage(send, "help");
        d.sendMessage(send, "///////////////////////////////");
        d.sendMessage(send, "Module Commands:");
    }

    private void identifyMe(String sender, String [] splits, Dogbox d)
    {
        if (splits.length!=2) d.sendMessage(sender, "Invalid syntax."
                            + " Use identify password");
                else d.sendMessage(d.getNickserv(), "identify "+splits[1]);
    }

    private void join(String sender, String [] splits, Dogbox d)
    {
        if(splits.length!=2)
        {
            d.sendMessage(sender, "Invalid syntax."
                    + " Use join_channel <channel>");
        }
        else
        {
            d.joinChannel(splits[1]);
        }
    }

    private void ops(String sender, String [] splits, Dogbox d)
    {
        if (splits.length!=2) d.sendMessage(sender, "Invalid syntax. "
                        + "Please use 'ops <channel>'");
        else d.op(splits[1], sender);
    }

    /////////////////////////////////////////////////////////////////////

    public void say(String sender, String message, Dogbox d)
    {
        String [] saye = message.split("~");
        if (saye.length != 3) d.sendMessage(sender, "Invalid syntax."
                + " Please use say~<channel>~<message>.");
        else d.sendMessage(saye[1], saye[2]);
    }

    /////////////////////////////////////////////////////////////////////

    private void pm(String sender, String message, Dogbox d)
    {
        String [] peem = message.split("~");
        if (peem.length != 3) d.sendMessage(sender, "Invalid syntax."
                + " Please use pm~<nick>~<message>.");
        else d.sendMessage(peem[1], peem[2]);
    }
}
