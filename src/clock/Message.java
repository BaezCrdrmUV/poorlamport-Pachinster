

package clock;
/**
 *
 * @author Alex
 */
public class Message {

    /**
     * @param args the command line arguments
     */
    int Time;
    int SenderID;

    public Message(int Time, int SenderID) {
        this.Time = Time;
        this.SenderID = SenderID;
    }

    @Override
    public String toString() {
        return "Message{" + "Time=" + Time + ", SenderID=" + SenderID + '}';
    }
    
    
    
}