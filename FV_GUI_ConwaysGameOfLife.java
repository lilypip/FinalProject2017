
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class FV_GUI_ConwaysGameOfLife implements MouseListener, ActionListener, Runnable{
	JFrame frame= new JFrame("GUI Game of Life");
	//[x][y]
	boolean[][] board= new boolean[60][60];
	JButton[][] button= new JButton[60][60];
	//Painting panel= new Painting(board);
	Container south= new Container ();
	Container north= new Container ();
	JButton runs = new JButton("runs");
	JButton step = new JButton("step");
	JButton stop = new JButton("stop");
	int[][] neighbors=new int[board[0].length+2][board.length+2];
	boolean run= false;
	
	ImageIcon dr1 = new ImageIcon("standoffishdeer.jpg"); 
    Image dr2 = dr1.getImage();
    Image dr3  = ((Image) dr2).getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);;
    ImageIcon dr = new ImageIcon(dr3);
    
    ImageIcon dd1 = new ImageIcon("deerskeletonCopy.jpg"); 
    Image dd2 = dd1.getImage();
    Image dd3  = ((Image) dd2).getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);;
    ImageIcon dd = new ImageIcon(dd3);
	
//	    ImageIcon ds1 = new ImageIcon("grass6.jpg"); 
//	    Image ds2 = ds1.getImage();
//	    Image ds3  = ((Image) ds2).getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);;
//	    ImageIcon ds = new ImageIcon(ds3);
	
    //all the grass
	ImageIcon gr11 = new ImageIcon("grass1.jpg"); 
    Image gr12 = gr11.getImage();
    Image gr13  = ((Image) gr12).getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);;
    ImageIcon gr0 = new ImageIcon(gr13);
	
    ImageIcon gr21 = new ImageIcon("grass2.jpg"); 
    Image gr22 = gr21.getImage();
    Image gr23  = ((Image) gr22).getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);;
    ImageIcon gr1 = new ImageIcon(gr23);
	
    ImageIcon gr31 = new ImageIcon("grass3.png"); 
    Image gr32 = gr31.getImage();
    Image gr33  = ((Image) gr32).getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);;
    ImageIcon gr2 = new ImageIcon(gr33);
	
    ImageIcon gr41 = new ImageIcon("grass4.jpg"); 
    Image gr42 = gr41.getImage();
    Image gr43  = ((Image) gr42).getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);;
    ImageIcon gr3 = new ImageIcon(gr43);
	
    ImageIcon gr51 = new ImageIcon("grass5.jpg"); 
    Image gr52 = gr51.getImage();
    Image gr53  = ((Image) gr52).getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);;
    ImageIcon gr4 = new ImageIcon(gr53);
	
    ImageIcon gr61 = new ImageIcon("grass6.jpg"); 
    Image gr62 = gr61.getImage();
    Image gr63  = ((Image) gr62).getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);;
    ImageIcon gr5 = new ImageIcon(gr63);
	
    ImageIcon gr71 = new ImageIcon("grass7.jpg"); 
    Image gr72 = gr71.getImage();
    Image gr73  = ((Image) gr72).getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);;
    ImageIcon gr6 = new ImageIcon(gr73);
	
    ImageIcon gr81 = new ImageIcon("grass8.jpg"); 
    Image gr82 = gr81.getImage();
    Image gr83  = ((Image) gr82).getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);;
    ImageIcon gr7 = new ImageIcon(gr83);
	
    ImageIcon gr91 = new ImageIcon("grass9.jpg"); 
    Image gr92 = gr91.getImage();
    Image gr93  = ((Image) gr92).getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);;
    ImageIcon gr8 = new ImageIcon(gr93);
	
    ImageIcon gr101 = new ImageIcon("grass10.png"); 
    Image gr102 = gr101.getImage();
    Image gr103  = ((Image) gr102).getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);;
    ImageIcon gr9 = new ImageIcon(gr103);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FV_GUI_ConwaysGameOfLife();
	}
	
	public FV_GUI_ConwaysGameOfLife(){
		frame.setSize(1000,1000);
		frame.setLayout(new BorderLayout());
		frame.add(north, BorderLayout.CENTER);
		north.setLayout(new GridLayout(button.length, button.length)); 
		
		for (int row = 0; row < button.length; row++) {
			for (int column = 0; column < button[0].length; column++) {
				 button[column][row]= new JButton(clearB()); 
				 north.add(button[column][row]);
				 button[column][row].addActionListener(this);
				 //button[column][row].setBackground(Color.white);
			}
			
		}
		//panel.addMouseListener(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		south.setLayout(new GridLayout(1,3)); 
		south.add(runs); 
		south.add(step); 
		south.add(stop);
		runs.addActionListener(this);
		step.addActionListener(this);
		stop.addActionListener(this);
		frame.add(south, BorderLayout.SOUTH);

	}

	@Override
	public void mouseClicked(MouseEvent e) {//full click can't move
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {//where enter panel; sides
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {//leave panel; sides
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {//Beginning of click
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {//end of click
		// TODO Auto-generated method stub
		for (int column=0; column<board[0].length; column++){
			for(int row=0; row< board.length; row++){
				if(e.getSource().equals(button[column][row])){
					button[column][row].setIcon(dr);
				}
			}
		}
		
		///board[column][row]= !board[column][row]; change to if statements
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {//for buttons run, stop, and step
		for (int column=0; column<board[0].length; column++){
			for(int row=0; row< board.length; row++){
				if(e.getSource().equals(button[column][row])){
					if (button[column][row].getIcon()!=(dr)){
						button[column][row].setIcon(dr);
					}
					else{
						button[column][row].setIcon(clearB());
					}
				}
			}
		}
		// TODO Auto-generated method stub
		if(e.getSource().equals(runs)){
			//if(run=false){
			run=true;
			Thread sleep = new Thread(this);
			sleep.start();
			//}
		}
		if(e.getSource().equals(step)){
			run=false;
			oneStep();
			
		}
		if(e.getSource().equals(stop)){
			run=false;
			//System.out.println("falseeee");
		}
	}

	public void oneStep(){//includes an array for neighbors and the behaviors of cells
		clearN();
		for (int column=0; column<board[0].length; column++){
			for(int row=0; row< board.length; row++){
					
					if(row<(button.length-1)){
						if(button[column][row+1].getIcon()==(dr)){//down
							neighbors[column][row]++;
							//System.out.println("down");
						}
					}
					if (column<(button[0].length-1)&&row<(button.length-1)){
						if(button[column+1][row+1].getIcon()==(dr)){//diagonal right down
							neighbors[column][row]++;
							//System.out.println("diagonal right down");
						}
					}			
					if (column>0&&row<(button.length-1)){
						//does not work
						if(button[column-1][row+1].getIcon()==(dr)){//diagonal left down
							neighbors[column][row]++;
						//	System.out.println("diagonal left down");
						}
					}
					if (column<(button[0].length-1)){
						//does not work
						if(button[column+1][row].getIcon()==(dr)){//right
							neighbors[column][row]++;
							//System.out.println("right");
						}
					}
					if (column>0){
						if(button[column-1][row].getIcon()==(dr)){//left
							neighbors[column][row]++;
							//System.out.println("left");
						}
					}
					if (row>0){
						if(button[column][row-1].getIcon()==(dr)){//up
							neighbors[column][row]++;
							//System.out.println("up");
						}
					}
					
					if(column<(button[0].length-1)&&row>0){
						if(button[column+1][row-1].getIcon()==(dr)){//diagonal up right
							neighbors[column][row]++;
							//System.out.println("diagonal up right");
						}
					}
					if(column>0&&row>0){
						if(button[column-1][row-1].getIcon()==(dr)){//diagonal up left
							neighbors[column][row]++;
							//System.out.println("diagonal up left");
						}
					}
			}
		}
		for (int column=0; column<button[0].length; column++){
			for(int row=0; row< button.length; row++){
//				if(neighbors[column][row]>=1){
//					System.out.println(column+","+row+" has "+neighbors[column][row]);
//				}
				if(button[column][row].getIcon()!=(dr)  && neighbors[column][row]==3){
					button[column][row].setIcon(dr);
					//System.out.println("make new");
				}
				if(button[column][row].getIcon()==(dd)){
					button[column][row].setIcon(clearB());
					//System.out.println("false");
				}
				if(button[column][row].getIcon()==(dr) && neighbors[column][row]!=3 &&  neighbors[column][row]!=2){
					button[column][row].setIcon(dd);
					//System.out.println("false");
				}
			}
		}
		//frame.repaint();
		
	}

	public ImageIcon clearB(){
		//sets imageicon array
		ImageIcon[] grassNames = new ImageIcon[10];
		grassNames[0]= gr0;
		grassNames[1]= gr1;
		grassNames[2]= gr2;
		grassNames[3]= gr3;
		grassNames[4]= gr4;
		grassNames[5]= gr5;
		grassNames[6]= gr6;
		grassNames[7]= gr7;
		grassNames[8]= gr8;
		grassNames[9]= gr9;
		
	
		 Random randomFactGenerator = new Random();
		 int grassNum = randomFactGenerator.nextInt(10);
		// System.out.println(grassNames[grassNum]);
		 
		 //grassNames[6&9] not working
		 return grassNames[grassNum];
	}
	public void clearN(){
		for (int row = 0; row < neighbors.length; row++) {
			for (int column = 0; column < neighbors[0].length; column++) {
				 neighbors[column][row]=0;
			}
		}
	}
	
	@Override
	public void run() {//for runs
		// TODO Auto-generated method stub
		while(run==true){
			oneStep();
			try{
				Thread.sleep(300);
			}
			catch (InterruptedException e){
				e.printStackTrace();
			}
		}
	}
}
