import javax.swing.*;
import java.awt.*;

public class TempConvert extends JFrame{

    private Container pane;
    private JTextField input;
    private JButton CtoF;
    private JButton FtoC;
    private JTextField output;

    
public TempConvert() {
    this.setTitle("RM Calculator");
     this.setSize(600,400);
     this.setLocation(100,100);
     this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    pane = this.getContentPane();
    pane.setLayout(new FlowLayout());
    input = new JTextField ("Input Temperature");
    CtoF = new JButton ("to F");
    CtoF.addActionListener(this);
    CtoF.addActionCommand(toF);
			
    FtoC = new JButton ("to C");
    output = new JTextField ("Output Temperature");
     pane.add(input);
     pane.add(CtoF);
     pane.add(FtoC);
     pane.add(output);
     
}
    
	public static double toF(double t){
	return (t * 1.8) + 32;
    }

	public static double toC(double t){
	return (t - 32) / 1.8;
    }


    public static void main(String[]aaaaaaargs){
	TempConvert a = new TempConvert();
	     a.setVisible(true);

    }

}
