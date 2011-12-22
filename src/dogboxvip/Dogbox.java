package dogboxvip;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jibble.pircbot.*;
/**
 *
 * @author jasonwaste
 */
public class Dogbox extends PircBot
{
    
    private ArrayList<Object> modules;
    private String nickserv;

    public Dogbox(){}
    public Dogbox(String name, String whois, String nickserv)
    {
        this.setName(name);
        this.setLogin(name.toLowerCase());
        this.setVersion(whois);
        this.nickserv = nickserv;
        modules = new ArrayList<Object>();
        Command c = new Command();
        modules.add(c);
    }
    
    @Override
    protected void onMessage(String channel, String sender, String login,
            String hostname, String message)
    {
        Object [] params = { channel, sender, login, hostname, message, this };
        callMethods("onMessage", modules, params);
    }

    @Override
    protected void onAction(String sender, String login, String hostname,
               String target, String action)
    {
        Object [] params = { sender, login, hostname, target, action, this };
        callMethods("onAction", modules, params);
    }

    @Override
    protected void onNotice(String sourceNick, String sourceLogin,
            String sourceHostname, String target, String notice)
    {
        Object [] params = { sourceNick, sourceLogin, sourceHostname, target,
            notice, this };
        callMethods("onNotice", modules, params);
    }

    @Override
    protected void onUserList(String channel, User[] users)
    {
        
    }

    @Override
    protected void onJoin(String channel, String sender, String login,
               String hostname)
    {
        Object [] params = { channel, sender, login, hostname, this };
        callMethods("onJoin", modules, params);
    }

    @Override
    protected void onPart(String channel, String sender, String login,
            String hostname)
    {
        Object [] params = { channel, sender, login, hostname, this };
        callMethods("onPart", modules, params);
    }

    @Override
    protected void onNickChange(String oldNick, String login, String hostname,
               String newNick)
    {
        Object [] params = { oldNick, login, hostname, newNick, this };
        callMethods("onNickChange", modules, params);
    }

    @Override
    protected void onKick(String channel, String kickerNick, String kickerLogin,
               String kickerHostname, String recipientNick, String reason)
    {
        Object [] params = { channel, kickerNick, kickerLogin, kickerHostname,
                recipientNick, reason, this };
        callMethods("onKick", modules, params);
    }

    @Override
    protected void onQuit(String sourceNick, String sourceLogin,
               String sourceHostname, String reason)
    {
        Object [] params = { sourceNick, sourceLogin, sourceHostname, reason,
                this };
        callMethods("onQuit", modules, params);
    }

    @Override
    protected void onTopic(String channel, String topic, String setBy,
               long date, boolean changed)
    {
        Object [] params = { channel, topic, setBy, this };
        callMethods("onTopic", modules, params);
    }

    @Override
    protected void onMode(String channel, String sourceNick, String sourceLogin,
                      String sourceHostname, String mode)
    {
        Object [] params = { channel, sourceNick, sourceLogin, sourceHostname,
                mode, this };
        callMethods("onMode", modules, params);
    }

    @Override
    protected void onUserMode(String targetNick, String sourceNick,
               String sourceLogin, String sourceHostname, String mode)
    {
        Object [] params = { targetNick, sourceNick, sourceLogin, sourceHostname,
            mode, this };
        callMethods("onUserMode", modules, params);
    }

    @Override
    protected void onOp(String channel, String sourceNick, String sourceLogin,
               String sourceHostname, String recipient)
    {
        Object [] params = { channel, sourceNick, sourceLogin, sourceHostname,
            recipient, this };
        callMethods("onOp", modules, params);
    }

    @Override
    protected void onDeop(String channel, String sourceNick, String sourceLogin,
               String sourceHostname, String recipient)
    {
        Object [] params = { channel, sourceNick, sourceLogin, sourceHostname,
            recipient, this };
        callMethods("onDeop", modules, params);
    }

    @Override
    protected void onVoice(String channel, String sourceNick,
            String sourceLogin, String sourceHostname, String recipient)
    {
        Object [] params = { channel, sourceNick, sourceLogin, sourceHostname,
            recipient, this };
        callMethods("onVoice", modules, params);
    }

    @Override
    protected void onDeVoice(String channel, String sourceNick,
            String sourceLogin, String sourceHostname, String recipient)
    {
        Object [] params = { channel, sourceNick, sourceLogin, sourceHostname,
            recipient, this };
        callMethods("onDeVoice", modules, params);
    }

    @Override
    protected void onSetChannelBan(String channel, String sourceNick,
               String sourceLogin, String sourceHostname, String hostmask)
    {
        Object [] params = { channel, sourceNick, sourceLogin, sourceHostname,
            hostmask, this };
        callMethods("onSetChannelBan", modules, params);
    }

    @Override
    protected void onRemoveChannelBan(String channel, String sourceNick,
                String sourceLogin, String sourceHostname, String hostmask)
    {
        Object [] params = { channel, sourceNick, sourceLogin, sourceHostname,
            hostmask, this };
        callMethods("onRemoveChannelBan", modules, params);
    }

    @Override
    protected void onSetInviteOnly(String channel, String sourceNick,
            String sourceLogin, String sourceHostname)
    {
        Object [] params = { channel, sourceNick, sourceLogin, sourceHostname,
            this };
        callMethods("onSetInviteOnly", modules, params);
    }

    @Override
    protected void onRemoveInviteOnly(String channel, String sourceNick,
               String sourceLogin, String sourceHostname)
    {
        Object [] params = { channel, sourceNick, sourceLogin, sourceHostname,
            this };
        callMethods("onRemoveInviteOnly", modules, params);
    }

    @Override
    protected void onSetModerated(String channel, String sourceNick,
            String sourceLogin, String sourceHostname)
    {
        Object [] params = { channel, sourceNick, sourceLogin, sourceHostname,
            this };
        callMethods("onSetModerated", modules, params);
    }

    @Override
    protected void onRemoveModerated(String channel, String sourceNick,
               String sourceLogin, String sourceHostname)
    {
        Object [] params = { channel, sourceNick, sourceLogin, sourceHostname,
            this };
        callMethods("onRemoveModerated", modules, params);
    }

    @Override
    protected void onInvite(String targetNick, String sourceNick,
            String sourceLogin, String sourceHostname, String channel)
    {
        Object [] params = { targetNick, sourceNick, sourceLogin,
            sourceHostname, channel, this };
        callMethods("onInvite", modules, params);
    }

    @Override
    protected void onDccSendRequest(String sourceNick, String sourceLogin,
               String sourceHostname, String filename, long address,
               int port, int size)
    {
        Object [] params = { sourceNick, sourceLogin, sourceHostname, filename,
                address, port, size, this };
        callMethods("onDccSendRequest", modules, params);
    }

    @Override
    protected void onDccChatRequest(String sourceNick, String sourceLogin,
               String sourceHostname, long address, int port)
    {
        Object [] params = { sourceNick, sourceLogin, sourceHostname, address,
                port, this };
        callMethods("onDccChatRequest", modules, params);
    }

    @Override
    protected void onVersion(String sourceNick, String sourceLogin,
            String sourceHostname, String target)
    {
        super.onVersion(sourceNick, sourceLogin, sourceHostname, target);
    }

    @Override
    protected void onPing(String sourceNick, String sourceLogin,
            String sourceHostname, String target, String pingValue)
    {
        super.onPing(sourceNick, sourceLogin, sourceHostname, target,
                pingValue);
    }

    @Override
    protected void onFinger(String sourceNick, String sourceLogin,
            String sourceHostname, String target)
    {
        super.onFinger(sourceNick, sourceLogin, sourceHostname, target);
    }

    @Override
    protected void onPrivateMessage(String sender, String login,
            String hostname, String message)
    {
        Object[] params = {sender, login, hostname, message, this};
        callMethods("onPrivateMessage", modules, params);
          
	if (!sender.equals("jasonwaste") ||!sender.equals("jinglewaste"))
	{
            sendMessage("jasonwaste", "<"+sender+"> "+message);
            sendMessage("jinglewaste","<"+sender+"> "+message);
	}
    }

    ///////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////

    private void callMethods(String name, Object o, String first)
    {

            try {
                Method meff = o.getClass().getDeclaredMethod(name,
                        String.class);
                meff.setAccessible(true);
                meff.invoke(o, first);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(Dogbox.class.getName()).log(Level.SEVERE,
                        null, ex);
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(Dogbox.class.getName()).log(Level.SEVERE,
                        null, ex);
            } catch (InvocationTargetException ex) {
                Logger.getLogger(Dogbox.class.getName()).log(Level.SEVERE,
                        null, ex);
            } catch (NoSuchMethodException ex) {
                Logger.getLogger(Dogbox.class.getName()).log(Level.SEVERE,
                        null, ex);
            } catch (SecurityException ex) {
                Logger.getLogger(Dogbox.class.getName()).log(Level.SEVERE,
                        null,ex);
            }
        }

    private void callMethods(String name, ArrayList<Object> mods,
            Object [] params)
    {
        Class[] classes = new Class[params.length];
        for (int i = 0; i < params.length; i++)
        {
            classes[i] = params[i].getClass();
        }
        for (Object z: mods)
        {
            try
            {
                Method meff = z.getClass().getDeclaredMethod(name, classes);
                meff.setAccessible(true);
                meff.invoke(z, params);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(Dogbox.class.getName()).log(Level.SEVERE,
                        null, ex);
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(Dogbox.class.getName()).log(Level.SEVERE,
                        null, ex);
            } catch (InvocationTargetException ex) {
                Logger.getLogger(Dogbox.class.getName()).log(Level.SEVERE,
                        null, ex);
            } catch (NoSuchMethodException ex) {
                Logger.getLogger(Dogbox.class.getName()).log(Level.SEVERE,
                        null, ex);
            } catch (SecurityException ex) {
                Logger.getLogger(Dogbox.class.getName()).log(Level.SEVERE,
                        null, ex);
            }
        }
    }

    public void killMod(String send, String mess)
    {
        String [] splits = mess.split(" ");
        if(splits.length!=3)
        {
            sendMessage(send, "Invalid syntax."
                            + " Use kill_module <module> <channel>");
        }
        else
        {
            boolean killed = false;
            for (Object mod: modules)
            {
                try {
                    Method getName = mod.getClass().getDeclaredMethod(
                            "getName");
                            Method getChannel = mod.getClass(
                                    ).getDeclaredMethod("getActiveChannel");
                            getName.setAccessible(true);
                            getChannel.setAccessible(true);
                            String name = (String) getName.invoke(mod);
                            String lennahc = (String) getChannel.invoke(mod);
                            if (name.equalsIgnoreCase(splits[1]) &&
                                    lennahc.equalsIgnoreCase(splits[2]))
                            {
                                modules.remove(mod);
                                killed = true;
                            }
                        } catch (IllegalAccessException ex) {
                            Logger.getLogger(Dogbox.class.getName()).log(
                                    Level.SEVERE, null, ex);
                        } catch (IllegalArgumentException ex) {
                            Logger.getLogger(Dogbox.class.getName()).log(
                                    Level.SEVERE, null, ex);
                        } catch (InvocationTargetException ex) {
                            Logger.getLogger(Dogbox.class.getName()).log(
                                    Level.SEVERE, null, ex);
                        } catch (NoSuchMethodException ex) {
                            Logger.getLogger(Dogbox.class.getName()).log(
                                    Level.SEVERE, null, ex);
                        } catch (SecurityException ex) {
                            Logger.getLogger(Dogbox.class.getName()).log(
                                    Level.SEVERE, null, ex);
                        }
                    }
            if (killed)
            {
                this.sendMessage(send, "Module " + splits[1]
                        +   " is no longer running in "+splits[2]);
            }
            else sendMessage(send, "Failed to kill module "+splits[1]);
        }
    }

    public void load(String send, String mess)
    {
        String [] splits = mess.split(" ");
        if(splits.length!=3)
        {
            sendMessage(send, "Invalid syntax."
                            + " Use load_module <module> <channel>");
        }
        else if (splits[1].equalsIgnoreCase("Command")) sendMessage(
                send, "Instantiation of Command.java is prohibited.");
        else
        {
            try {
                try {
                    Object o = Class.forName("dogboxvip."+splits[1]
                                    ).newInstance();
                    callMethods("setActiveChannel", o, splits[2]);
                    if(modules.add(o))
                    {
                        sendMessage(send, "Loaded module "
                                        +splits[1]+".");
                    }
                            else sendMessage(send,
                                    "Something has gone horribly wrong :(");
                        } catch (InstantiationException ex) {
                            sendMessage(send,
                                    "InstantiationException has occured.");
                        } catch (IllegalAccessException ex) {
                            sendMessage(send,
                                    "IllegalAccessException has occured.");
                        }
                    } catch (ClassNotFoundException ex) {
                            sendMessage(send,
                                    "Class "+splits[1]+" does not exist.");
                    }
                }
    }

    public void list(String sender)
    {
        sendMessage(sender, "List of loaded modules:");
        for (Object mod: modules)
        {
            try {
                Method get = mod.getClass().getDeclaredMethod("getName");
                get.setAccessible(true);
                String name = (String) get.invoke(mod);
                Method chan = mod.getClass().getDeclaredMethod(
                        "getActiveChannel");
                chan.setAccessible(true);
                String nahc = (String) chan.invoke(mod);

                sendMessage(sender, name+" in "+nahc);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(Dogbox.class.getName()).log(Level.SEVERE,
                        null, ex);
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(Dogbox.class.getName()).log(Level.SEVERE,
                        null, ex);
            } catch (InvocationTargetException ex) {
                Logger.getLogger(Dogbox.class.getName()).log(Level.SEVERE,
                        null, ex);
            } catch (NoSuchMethodException ex) {
                Logger.getLogger(Dogbox.class.getName()).log(Level.SEVERE,
                        null, ex);
            } catch (SecurityException ex) {
                Logger.getLogger(Dogbox.class.getName()).log(Level.SEVERE,
                        null, ex);
            }
        }
    }

    public void help(String send)
    {
        for (Object mod: modules)
        {
            try {
                Method help = mod.getClass().getDeclaredMethod("help",
                        String.class,
                        Dogbox.class);
                help.setAccessible(true);
                help.invoke(mod, send, this);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(Dogbox.class.getName()).log(Level.SEVERE,
                        null, ex);
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(Dogbox.class.getName()).log(Level.SEVERE,
                        null, ex);
            } catch (InvocationTargetException ex) {
                Logger.getLogger(Dogbox.class.getName()).log(Level.SEVERE,
                        null, ex);
            } catch (NoSuchMethodException ex) {
                Logger.getLogger(Dogbox.class.getName()).log(Level.SEVERE,
                        null, ex);
            } catch (SecurityException ex) {
                Logger.getLogger(Dogbox.class.getName()).log(Level.SEVERE,
                        null, ex);
            }
        }
    }

    public String getNickserv()
    {
        return nickserv;
    }

    public ArrayList<Object> getModules()
    {
        return modules;
    }

    public void leave()
    {
        this.disconnect();
        System.exit(0);
    }
}
