import java.util.Scanner; 
import java.awt.*;
import javax.swing.*;
import javax.swing.JButton;
import java.awt.event.*;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;

public class DynamicButton extends JFrame implements ActionListener{
    public static int clickedAmt =0;

    public DynamicButton(){
        super("Dynamic Buttons");
       // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(500, 500);
        AddButtons(10,10);
    }

    public void actionPerformed(ActionEvent event)
    {
    }

    
    public void AddButtons(int rows, int columns){

        JFrame frame=new JFrame("Dynamic Buttons");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900,900); 
        frame.setLayout(null);  
      

        int totalAmt = rows*columns;
        int xCoordinate = 50;
        int yCoordinate = 0;
        int NumRows =1;
        int NumCols =1;

       int finalXcd=0;
       int finalycd=0;
    
    
        //ArrayList<JButton> buttonsList = new ArrayList<JButton>(totalAmt);

        for (int i = 0; i<totalAmt; i++){
            if((i!=0)&&(i%columns ==0)){
                yCoordinate = yCoordinate+ 75;
                xCoordinate=50; 
                NumRows++;
                NumCols=1;
            }

            JButton btn = new CreateRoundButton(NumRows+"-"+NumCols);
           //JButton btn  = new JButton(NumRows+"-"+NumCols);
            btn.setBounds(xCoordinate,yCoordinate,75,75);
            btn.setOpaque(false);
            btn.setBackground(Color.LIGHT_GRAY);
           
            
            btn.addActionListener(new ActionListener(){

                int currentClick = 0;
                public void actionPerformed(ActionEvent e) {
                    if(currentClick>0){
                        btn.setEnabled(false);
                    } else{
                        clickedAmt++;
                        if(clickedAmt%2==0){
                            btn.setBackground(Color.BLACK);
                        } else{
                            btn.setBackground(Color.WHITE);
                        }
                    }
                    currentClick++;
                }
            });

            frame.add(btn);
            xCoordinate = xCoordinate+ 75;
            NumCols++;
            finalXcd=xCoordinate;
            finalycd=yCoordinate;
        }

        

       // frame.pack();

        JButton resetBtn = new JButton("Reset");
       resetBtn.setBounds(finalXcd/2,finalycd+100,100,50);
       resetBtn.setBackground(Color.gray);

       resetBtn.addActionListener(new ActionListener(){

        public void actionPerformed(ActionEvent e) {
            // for(int j =0; j>totalAmt; j++){
            //     //SetBackGnd(buttonsList.get(j));setActionCommand(String)
            // }
            resetBtn.setBackground(Color.YELLOW);


        }
    });



       frame.add(resetBtn); 
        frame.setVisible(true); 


       
    }

    public static void SetBackGnd(JButton bttn){
        bttn.setBackground(Color.RED);
    }
    
    public static void main(String[] args) {


        // Scanner inputRows = new Scanner(System.in);
        // System.out.println("Enter in how many rows you want for your buttons.");
        // String stringRows = inputRows.nextLine();
        // int numRows =0;
        // boolean isInt = true;
        // try{
        //     numRows = Integer.parseInt(stringRows);
        // }catch(NumberFormatException e){
        //     isInt = false;
        //     System.out.println("Not integer.");
        // }
        
        // Scanner inputCols = new Scanner(System.in);
        // System.out.println("Enter in how many columns you want for your buttons.");
        // String stringCols = inputCols.nextLine();
        // int numCols=0;
        // try{
        //     numCols = Integer.parseInt(stringCols);
        // }catch(NumberFormatException e){
        //     isInt=false;
        //     System.out.println("Not integer.");
        // }
        
        // if(isInt){
            
        //     DynamicButtonMethod(numRows,numCols);
            
        // }
        
        //DynamicButtonMethod(10,10);
        DynamicButton dybtn = new DynamicButton();
       // dybtn.DynamicButtonMethod(10,10);
        

        


    }
}
