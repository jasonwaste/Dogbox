package dogboxvip;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jasonwaste
 */
public class Log implements Mod
{
    private String channel;
    private FileWriter fw;
    private BufferedWriter out;
    private FileWriter wf;
    private BufferedWriter tou;

    public Log()
    {

    }

    public void onPrivateMessage(String sender, String login, String hostname,
            String message, Dogbox d)
    {
        try {
            wf = new FileWriter(sender + "PMlog.txt", true);
            tou = new BufferedWriter(wf);
            logThat(sender, message, tou);
            tou.close();
        } catch (IOException ex) {
            Logger.getLogger(Log.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void onMessage(String channel, String sender, String login,
            String hostname, String message, Dogbox d)
    {
        if (channel.equalsIgnoreCase(this.getActiveChannel()))
        {
            try {
                fw = new FileWriter(channel + "log.txt", true);
                out = new BufferedWriter(fw);
                logThat(sender, message, out);
                out.close();
                } catch (IOException ex) {
                Logger.getLogger(Log.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
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

    ///////////////////////////////////////////////////////////////////////

    private void logThat(String sender, String message, BufferedWriter buff)
            throws IOException
    {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        Date date = new Date();
        String datee = dateFormat.format(date);
        buff.write(datee+" <"+sender+"> "+message+"\n");
    }

    public void setActiveChannel(String channel) {
        this.channel = channel;
    }

    public String getActiveChannel() {
        return channel;
    }

    public String getName() {
        return "Log";
    }

    public void help(String sender, Dogbox d) {

    }

}
