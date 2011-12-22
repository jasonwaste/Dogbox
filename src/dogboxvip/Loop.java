package dogboxvip;

/**
 *
 * @author jasonwaste
 */
public class Loop implements Mod
{
    private String channel;

    public Loop()
    {

    }

    public void onPrivateMessage(String sender, String login, String hostname,
            String message, Dogbox d)
    {

    }

    public void onMessage(String channel, String sender, String login,
            String hostname, String message, Dogbox d)
    {
        if (channel.equalsIgnoreCase(this.getActiveChannel()))
        {
            if(message.equals("dogbox!") || message.startsWith(
                    "..."))d.sendMessage(channel, sender+"!");
    
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

    public void setActiveChannel(String channel) {
        this.channel = channel;
    }

    public String getActiveChannel() {
        return channel;
    }

    public String getName() {
        return "Loop";
    }

    public void help(String sender, Dogbox d) {

    }
}
