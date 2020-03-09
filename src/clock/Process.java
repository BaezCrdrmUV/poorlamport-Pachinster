/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clock;


/**
 *
 * @author Alex
 */
public class Process {
    int ID;
    int Time = 0;
    int MessageCount = 0;
    Message[] Messages = new Message[255];

    public Process(int ID) {
        this.ID = ID;
    }
    
    
    public void RecieveMessage(Message message){
        Time++;
        if(message.Time > this.Time){
            this.Time = message.Time;
        } else {
            message.Time = this.Time;
        }
        Messages[MessageCount] = message;
        MessageCount++;
        
    }
    
    public void PrintMessages(){
        System.out.println("Messages for process " + (ID+1));
        for (int i=0; i<MessageCount; i++){
            System.out.println(Messages[i].toString());
        }
    }
    
    public void SendMessage(Process[] processes, int RecipientID){
        Time++;
        Message MessageToSend = new Message(this.Time, this.ID);
        processes[RecipientID].RecieveMessage(MessageToSend);
    }

    @Override
    public String toString() {
        return "Process{" + "ID=" + ID + ", Time=" + Time + ", MessageCount=" + MessageCount + '}';
    }
    
    
    
}
