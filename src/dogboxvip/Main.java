/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dogboxvip;

import java.io.IOException;
import org.jibble.pircbot.IrcException;
import org.jibble.pircbot.NickAlreadyInUseException;

/**
 *
 * @author jasonwaste
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NickAlreadyInUseException, 
            IOException, IrcException
    {
        if (args.length < 4)
        {
            System.out.println("Please enter four arguments."
                + "<botname> <server> <version> <nickOfNickserv> ");
        }
        else
        {
                
                Dogbox db = new Dogbox(args[0], args[2], args[3]);
                db.setVerbose(true);
                db.connect(args[1]);
                
        }
       }
   }
