/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clock;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Alex
 */
public class Clock {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int MenuOption = -1;
        int ProcessCount = 0;
        
        Process[] processes = new Process[255];
        String InputBuffer = "0";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
                
        while (MenuOption != 0){
            
            System.out.println("Seleccione una Opción:");
            System.out.println("1 Nuevo Proceso");
            System.out.println("2 Ver lista de procesos");
            System.out.println("3 Enviar Mensaje");
            System.out.println("4 Mostrar mensajes ordenas de proceso");
            System.out.println("0 Terminar ejecución");

            try {
                InputBuffer = reader.readLine();
            } catch (IOException ex) {
                Logger.getLogger(Clock.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                MenuOption = Integer.parseInt(InputBuffer);
            }
            catch (NumberFormatException e){
                System.out.println("Porfavor ingrese un número entero");
                continue;
            }
            
            switch (MenuOption) {
                case 1:
                    processes[ProcessCount] = new Process(ProcessCount);
                    System.out.println("Nuevo proceso creado");
                    processes[ProcessCount].toString();
                    ProcessCount++;
                    break;
                case 2:
                    for (int i = 0; i<ProcessCount;i++){
                        System.out.println(processes[i].toString());
                    }
                    break;
                case 3:
                    int RecipientProcessID = 0;
                    int SenderProcessID = 0;
                    System.out.println("Hay " + ProcessCount + " procesos, escriba el numero de proceso desde el que desea mandar un mensaje");
                    try {
                        InputBuffer = reader.readLine();
                    } catch (IOException ex) {
                        Logger.getLogger(Clock.class.getName()).log(Level.SEVERE, null, ex);
                    }       
                    try {
                        SenderProcessID = Integer.parseInt(InputBuffer);
                    }
                        catch (NumberFormatException e){
                        System.out.println("Porfavor ingrese un número entero");
                        break;
                    }
                    
                    if (SenderProcessID > ProcessCount||SenderProcessID <=0){
                        System.out.println("El número de proceso especificado no existe");
                        break;
                    } else {
                        System.out.println("Escriba el número de proceso destino");
                        try {
                            InputBuffer = reader.readLine();
                        } catch (IOException ex) {
                            Logger.getLogger(Clock.class.getName()).log(Level.SEVERE, null, ex);
                        }       
                        try {
                            RecipientProcessID = Integer.parseInt(InputBuffer);
                        }
                        catch (NumberFormatException e){
                        System.out.println("Porfavor ingrese un número entero");
                        break;
                        }
                        if (RecipientProcessID > ProcessCount||RecipientProcessID <=0){
                            System.out.println("El número de proceso especificado no existe");
                            break;
                        } else {
                            processes[SenderProcessID-1].SendMessage(processes, RecipientProcessID-1);
                            System.out.println("Message sent");
                        }
                    }
                    break;
                case 4:
                    System.out.println("Hay " + ProcessCount + " procesos, escriba el numero de proceso para ver sus mensajes");
                    int ProcessID = 0;
                    try {
                        InputBuffer = reader.readLine();
                    } catch (IOException ex) {
                        Logger.getLogger(Clock.class.getName()).log(Level.SEVERE, null, ex);
                    }       
                    try {
                        ProcessID = Integer.parseInt(InputBuffer);
                    }
                        catch (NumberFormatException e){
                        System.out.println("Porfavor ingrese un número entero");
                        break;
                    }
                    
                    if (ProcessID > ProcessCount||ProcessID <=0){
                        System.out.println("El número de proceso especificado no existe");
                        break;
                    } else {
                        processes[ProcessID-1].PrintMessages();
                    }
                    break;
                default:
                    break;
            }   
        }
    }
}
