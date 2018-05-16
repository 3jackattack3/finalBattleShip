//============================================================================
// Name        : game.java
// Authors     : Yuval & Jack
// Block       : E
// Due Date    : April 2018
// Description : Experimenting with GUIs
//============================================================================

import java.awt.*;        // Using AWT container and component classes
import java.awt.event.*; 


//TODO: QUESTIONS: ask Mr. Harris about comments + Panel/Frame issue? 
// gridlayout? checking. 
public class game extends Frame implements ActionListener, WindowListener {
	
	private int row, col, pressedRow, pressedCol;
	
	private Label lblName, lblMyGrid, lblOtherGrid;    
	private TextField tfName, tfDisplay; 
	private Button btnSubmit;   
	private Button[][] myGrid, otherGrid;
	private String name;

	public game()  {
	setLayout(new FlowLayout());  
	
	setTitle("Me being silly thinking that can work");  // "super" Frame sets its title
    setSize(300, 420);        // "super" Frame sets its initial window size

	
	lblName = new Label("Enter name:");
	add(lblName);			//wait. what is the "this" here? the "app" itself? or "Frame"?
	
	//lblName.setText("bla"); text can be changed after "added"!
	 // xxx assigned by compiler ( <-- for anonymus label)
	
	tfName = new TextField(10);   
	add(tfName); // "this" Container adds the TextField
	tfName.setEditable(true);
	
	btnSubmit = new Button("save");
	btnSubmit.addActionListener(this);
	add(btnSubmit);
	
	tfDisplay = new TextField(25);                          
	tfDisplay.setEditable(false);
	add(tfDisplay);
	
	//add(tfName); //can display twice? <- no effect but location, as it seems 
	
	
	
	
	//-----SET DISPLAY-----//
	
	//lblMyGrid = new Label("--   -- Your Grid --   --");
	//add(lblMyGrid);
	
	myGrid = new Button[10][10];
	for( row = 0; row< 10; row++) {
		for( col = 0; col <10; col++) {
			myGrid[row][col] = new Button("  ");
			myGrid[row][col].addActionListener(this);
			add(myGrid[row][col]);
			
			myGrid[row][col].addActionListener(new ActionListener() {
		          @Override
		          public void actionPerformed(ActionEvent evt) {
		        	  pressedRow = row;
		        	  presseCol = col;
		          }
		       });
		}
	}

	/*lblOtherGrid = new Label("--   -- Oponent Grid --   --");
	add(lblOtherGrid);
	
	otherGrid = new Button[10][10];
	for(int row = 0; row< 10; row++) {
		for(int col = 0; col <10; col++) {
			otherGrid[row][col] = new Button("  ");
			otherGrid[row][col].addActionListener(this);
			add(otherGrid[row][col]);
		}
	}*/

	addWindowListener(this);
	
    setVisible(true); 
    
	}

	
	
  public static void main(String[] args) {
     game app = new game();
   }
		 
   // ActionEvent handler - Called back upon button-click.
   @Override
   public void actionPerformed(ActionEvent evt) {
     
	   //if(btnSubmit.action(evt, arg1))
	   //find out a way to separate events! 
	   
	  name =  tfName.getText();
      tfName.setText("");
	      
      String temp = tfDisplay.getText();
      if(name.isEmpty());
      
      else if (temp.isEmpty())
    	  tfDisplay.setText(name);
		      
      else 
    	  tfDisplay.setText(temp + ", " + name);
   }
   
   @Override
   public void windowClosing(WindowEvent evt) {
      System.exit(0);  // Terminate the program
   }
   
// Not Used, BUT need to provide an empty body to compile.
   @Override public void windowOpened(WindowEvent evt) { }
   @Override public void windowClosed(WindowEvent evt) { }
   @Override public void windowIconified(WindowEvent evt) {}
   @Override public void windowDeiconified(WindowEvent evt) {}
   @Override public void windowActivated(WindowEvent evt) {}
   @Override public void windowDeactivated(WindowEvent evt) {}
}

//"so I went, found the other one, and killed it!" ~Mr. Harris