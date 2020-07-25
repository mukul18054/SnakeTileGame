package assignment5;

//import java.io.Serializable;
import java.io.*;
import java.util.*;
import static org.junit.Assert.*;

import org.junit.Test;


//import gameArchLegends.sidekick;

public class Game implements Serializable{
	String name;
abstract class tiles implements Serializable{
	protected String tilesName;
	protected int tileJumpValue;
	abstract public int shakeMe() throws Exception;
	
	tiles(String tilesName,int tileJumpValue){
		this.tilesName=tilesName;
		this.tileJumpValue=tileJumpValue;
	}
	
	@Override
	public boolean equals(Object o1) {
		
		if(o1 != null && getClass() == o1.getClass()) {
			tiles t=(tiles) o1;//type casting 
//			return (hp== s.hp && xp==s.xp);
			return true;
		}
		else
			return false;
	}
}

public static int noOfsnakeBite=0;
public static int noOfcricketBite=0;
public static int noOfvultureBite=0;
public static int noOftrampolines=0;

public	class	highExpectedValue	extends	Exception	{	
	public	highExpectedValue(String message)	{	
					super(message);	
	}	

}	
public	class	gameWinnerException	extends	Exception	{	
	public	gameWinnerException(String message)	{	
					super(message);	
	}	

}

public	class	SnakeBiteException	extends	Exception	{	
	public	SnakeBiteException()	{	
					super("SnakeBiteException thrown");	
	}	

}	
public	class	VultureBiteException	extends	Exception	{	
	public	VultureBiteException()	{	
					super("VultureBiteException thrown");	
	}	
}	
public	class	CricketBiteException	extends	Exception	{	
	public	CricketBiteException()	{	
					super("CricketBiteException thrown");	
	}	
}	
public	class	TrampolineException	extends	Exception	{	
	public	TrampolineException()	{	
					super("TrampolineException thrown");	
	}	
}	
//public class SnakeBiteExceptionTest {
//
//	@Test(expected	=	SnakeBiteException.class)
//	public void test() {
//		
//	}
//
//}

class snake extends tiles{
	private int noOfSnakeBite=0;
	snake(String tilesName, int tileJumpValue) {
		super("snake", tileJumpValue);
		// TODO Auto-generated constructor stub
	}
	snake(){
		super("snake",0);
	}

	@Override
	public int shakeMe() throws SnakeBiteException {
		try {
		System.out.println("          Hiss…! I am a Snake, you go back "+(-1*this.tileJumpValue)+" tiles!");
		this.updateNoOfSnakeBite();
		}
		finally {
			return this.tileJumpValue;
			
			
		}
	}
	private void updateNoOfSnakeBite() throws SnakeBiteException {
		this.noOfSnakeBite++;
		noOfsnakeBite++;
	}
	public int getNoOfBites() {
		return noOfsnakeBite;
//		return this.noOfSnakeBite;
	}
}
class vulture extends tiles{
	private int noOfVultureBite=0;
	
	vulture(String tilesName, int tileJumpValue) {
		super("vulture", tileJumpValue);
		// TODO Auto-generated constructor stub
	}
	vulture(){
		super("vulture",0);
	}
	@Override
	public int shakeMe() throws VultureBiteException {
		// TODO Auto-generated method stub
	try {
		System.out.println("          Yapping…! I am a Vulture, you go back "+(-1*this.tileJumpValue)+" tiles!");
		this.updateNoOfVultureBite();
		
	}
	finally {
		
		return this.tileJumpValue;
	}
	}
	private void updateNoOfVultureBite() throws VultureBiteException{
		this.noOfVultureBite++;
		noOfvultureBite++;
	}
	public int getNoOfBites() {
//		return this.noOfVultureBite;
		return noOfvultureBite;
	}
	
}
class cricket extends tiles{
	private int noOfCricketBite=0;
	cricket(String tilesName, int tileJumpValue) {
		super("cricket", tileJumpValue);
		// TODO Auto-generated constructor stub
	}
	cricket(){
		super("cricket",0);
	}
	@Override
	public int shakeMe() throws CricketBiteException{
		// TODO Auto-generated method stub
	try {
		System.out.println("          Chirp…! I am a Cricket, you go back "+(-1*this.tileJumpValue)+" tiles!");
		this.updateNoOfcricketBite();
		
	}
	finally {
		return this.tileJumpValue;
	}
	}
	private void updateNoOfcricketBite() throws CricketBiteException {
		this.noOfCricketBite++;
		noOfcricketBite++;
	}
	public int getNoOfBites() {
//		return this.noOfCricketBite;
		return noOfcricketBite;
	}
}
class white extends tiles{

	white(String tilesName, int tileJumpValue) {
		super("white", tileJumpValue);
		// TODO Auto-generated constructor stub
	}
	white(){
		super("white",0);
	}
	@Override
	public int shakeMe() {
		// TODO Auto-generated method stub
		System.out.println("          I am a white tile!");
		
		return this.tileJumpValue;
	}
	
}
class trampoline extends tiles{
private int noOfTrampolines=0;
	trampoline(String tilesName, int tileJumpValue) {
		super("trampoline", tileJumpValue);
		// TODO Auto-generated constructor stub
	}
	trampoline(){
		super("trampoline",0);
	}
	@Override
	public int shakeMe() throws TrampolineException{
		// TODO Auto-generated method stub
	try {
		System.out.println("          PingPong…! I am a trampoline, you advance "+(this.tileJumpValue)+" tiles!");
		this.updateNoOftrampolines();
		}
	finally {

		return this.tileJumpValue;
	}
	}
	private void updateNoOftrampolines()  throws TrampolineException{
		this.noOfTrampolines++;
		noOftrampolines++;
	}
	public int getNoOfBites() {
//		return this.noOfTrampolines;
		return noOftrampolines;
		
	}
}
class gamePlay implements Serializable{/////////this class can't be abstract as it is initiated in main class
	private static final long serialversionUID = 373737L; 
	private int index=0;
	private int roll=1;
	private ArrayList<tiles> alTiles;
	private String plName;
	gamePlay(int noOfTiles){
		alTiles=new ArrayList<tiles>(noOfTiles);
	}
	
	public void setName(String name) {
		this.plName=name;
	}
	public void createRoad(int noOfTiles) {
		System.out.println("Setting up race track...");
		int sd=randomBw(10);
		sd*=-1;
		int vd=randomBw(10);
		vd*=-1;
		int cd=randomBw(10);
		cd*=-1;
		int td=randomBw(10);
		System.out.println("road size: "+noOfTiles);
		for(int i=0;i<noOfTiles;i++) {
			int ch=randomBw(5);
			tiles tl;
			switch(ch) {
				case 1://SNAKE
					tl=new snake("snake", sd);
					break;
				case 2://VULTURE
					tl=new vulture("vulture", vd);
					break;
				case 3://CRICKET
					tl=new cricket("cricket", cd);
					break;
				case 4://WHITE
					tl=new white("white",1);
					break;
				case 5://TRAMPOLINE
					tl=new trampoline("trampoline", td);
					break;
				default://this line will never get executed
					System.out.println("this line wont get executed ever");
					tl=new snake("white",1);
					break;
			}
			this.alTiles.add(tl);
			
		}
	}
	public void printNews() {
		int t=0,x=0,y=0,z=0,a=0,b=0,c=0,d=0;
		snake sn=new snake();
		cricket cr=new cricket();
		vulture vl=new vulture();
//		white wh=new white();
		trampoline tp=new trampoline();
		for(int i=0;i<this.alTiles.size();i++) {
				if (this.alTiles.get(i).equals(sn)) {
					x++;
					a=this.alTiles.get(i).tileJumpValue;
					a*=-1;
				} else if (this.alTiles.get(i).equals(cr)) {
					y++;
					b=this.alTiles.get(i).tileJumpValue;
					b*=-1;
				} else if (this.alTiles.get(i).equals(vl)) {
					z++;
					c=this.alTiles.get(i).tileJumpValue;
					c*=-1;
				} else if (this.alTiles.get(i).equals(tp)){
					t++;
					d=this.alTiles.get(i).tileJumpValue;
				}
		}
		System.out.println("Danger: There are "+x+", "+y+", "+z+" numbers of Snakes, Cricket, and Vultures respectively on your track!"); 
		System.out.println("Danger: Each Snake, Cricket, and Vultures can throw you back by"+a+", "+b+", "+c+" number of Tiles respectively! ");
		System.out.println("Good News: There are "+t+" number of Trampolines on your track!");
		System.out.println("Good News: Each Trampoline can help you advance by "+d+" number of Tiles");
	}

	public void serialize()	throws	IOException	{	
		
		ObjectOutputStream out = null;	
		try	{	
			String fileName=this.plName+".txt";
//			System.out.println(fileName);
			out = new	ObjectOutputStream (new FileOutputStream(fileName));	
			out.writeObject(this);	
		}
		finally	{	
			out.close();	
//			System.out.println("Obj serialized");
			System.out.println("Game Saved!");
		}	
	}

	public gamePlay	deserialize(String name) throws IOException, ClassNotFoundException {	
		ObjectInputStream in = null;
		name+=".txt";
		try	{	
			in = new ObjectInputStream (new FileInputStream(name));	
//			this=(gamePlay)in.readObject();
		}
		finally	{	
			in.close();	
			System.out.println("Obj DeSerialized");
		
			
		}
		gamePlay gmpl= (gamePlay)in.readObject();
		return 	gmpl;
	}

	public void startGame() throws Exception {
		System.out.println("Game Started ======================>\r\n");

		Scanner sc=new Scanner(System.in);
		boolean cp1=false;
		boolean cp2=false;
		boolean cp3=false;
		if(index>=(int)(0.24*alTiles.size()))
			cp1=true;
		if(index>=(int)(0.49*alTiles.size()))
			cp2=true;
		if(index>=(int)(0.74*alTiles.size()))
			cp3=true;
		
//			System.out.println(alTiles.size());
		while(index<=(this.alTiles.size()-1)) {
//			System.out.println("current tile:"+index);
			if(index>(int)(0.24*alTiles.size()) && cp1==false) {
					cp1=true;
					System.out.println("CheckPoint 1 reached");
					System.out.println("select one option:");
					System.out.println("1. SAVE");
					System.out.println("2. Continue");
					int op=sc.nextInt();
					if(op==1) {
						this.serialize();
						break;
					}
					
//				else {
//					System.out.println("CheckPoint 1 reached again");
//					System.out.println("select one option:");
//					System.out.println("1. SAVE");
//					System.out.println("2. Continue");
//					int op=sc.nextInt();
//					
//				}
			}
			else if(index>(int)(0.49*alTiles.size()) && cp2==false) {
					cp2=true;
					System.out.println("CheckPoint 2 reached");
					System.out.println("select one option:");
					System.out.println("1. SAVE");
					System.out.println("2. Continue");
					int op=sc.nextInt();
					if(op==1) {
						this.serialize();
						break;
					}
			
//				else {
//					System.out.println("CheckPoint 2 reached again");
//					System.out.println("select one option:");
//					System.out.println("1. SAVE");
//					System.out.println("2. Continue");
//					int op=sc.nextInt();
//					
//				}
			}
			else if(index>(int)(0.74*alTiles.size()) && cp3==false) {
					cp3=true;
					System.out.println("CheckPoint 3 reached");
					System.out.println("select one option:");
					System.out.println("1. SAVE");
					System.out.println("2. Continue");
					int op=sc.nextInt();
					if(op==1) {
						this.serialize();
						break;
					}
//				else {
//					System.out.println("CheckPoint 3 reached again");
//					System.out.println("select one option:");
//					System.out.println("1. SAVE");
//					System.out.println("2. Continue");
//					int op=sc.nextInt();
//					
//				}
			}
			
			if(index==this.alTiles.size()-1)
			{
				System.out.println("won");
				this.printWin(roll);
				break;
			}
			int diceValue=randomBw(6);
			if(index==0) {
				if(diceValue==6) {
					System.out.println("[Roll-"+roll+"]: "+this.plName+" rolled 6 at Tile-1. You are out of the cage! You get a free roll\r\n");
					roll++;
					diceValue=randomBw(6);
					System.out.println("[Roll-"+roll+"]: "+this.plName+" rolled "+diceValue+" at Tile-1, landed on tile "+(index+1+diceValue));
					index+=diceValue;
					roll++;
					System.out.println("          Trying to shake the tile-"+(index+1));
					int changeBy=this.alTiles.get(index).shakeMe();
					try {

//						changeBy=this.alTiles.get(index).shakeMe();
						index+=changeBy;
						if(index>=0)
						System.out.println("          "+this.plName+" moved to Tile-"+(index+1) );
						else {
							throw new ArrayIndexOutOfBoundsException();
						}
					}
					catch(ArrayIndexOutOfBoundsException	e){
						index=0;
//						changeBy=this.alTiles.get(index).shakeMe();
						System.out.println("          "+this.plName+" moved to Tile-"+(index+1)+" as it can't go back further" );
						
					}
					
				}
				else {
				System.out.println("[Roll-"+roll+"]: "+this.plName+"  rolled "+diceValue+" at Tile-1, OOPs you need 6 to start");
				roll++;
				}
			}
			else {
					if (index + diceValue + 1 == this.alTiles.size()) {//won
						System.out.println("[Roll-" + roll + "]: " + this.plName + " rolled " + diceValue + " at Tile-"
								+ (index + 1) + ", landed on tile " + (index + 1+diceValue));
						index+=diceValue;
						this.printWin(roll);
						break;
						
					} 
					else if (index + diceValue + 1 < this.alTiles.size()) {
//						index += diceValue;
						System.out.println("[Roll-" + roll + "]: " + this.plName + " rolled " + diceValue + " at Tile-"
								+ (index + 1) + ", landed on tile " + (index + 1+diceValue));
						index += diceValue;
						roll++;
						System.out.println("          Trying to shake the tile-" + (index + 1));
						int changeBy = this.alTiles.get(index).shakeMe();
						if (index + changeBy + 1 < this.alTiles.size()) {
							try {
//									changeBy=this.alTiles.get(index).shakeMe();
								index += changeBy;
								if (index >= 0)
									System.out.println("          " + this.plName + " moved to Tile-" + (index + 1));
								else {
									throw new ArrayIndexOutOfBoundsException();
								}
							} catch (ArrayIndexOutOfBoundsException e) {
								index = 0;
//									changeBy=this.alTiles.get(index).shakeMe();
								System.out.println("          " + this.plName + " moved to Tile-" + (index + 1)
										+ " as it can't go back further");

							}
						}
						else {
							try {

//								changeBy=this.alTiles.get(index).shakeMe();
							index += changeBy;
							if(index+1 == this.alTiles.size()) {//won
								System.out.println("          " + this.plName + " moved to Tile-" + (index + 1));
								
							}	
							else if (index+1 < this.alTiles.size())
								System.out.println("          " + this.plName + " moved to Tile-" + (index + 1));
							else {
								throw new ArrayIndexOutOfBoundsException();
							}
						} catch (ArrayIndexOutOfBoundsException e) {
							index -= changeBy;
//								changeBy=this.alTiles.get(index).shakeMe();
							System.out.println("          "+this.plName+ "is on tile "+(index+1)+" as it can't go ahead " );
//							roll++;

						}
						}
					} else if (index + diceValue > this.alTiles.size()) {

						System.out.println("[Roll-" + roll + "]: " + this.plName + " rolled " + diceValue + " at Tile-"
								+ (index + 1) + ", landed on tile " + (index + 1));
						roll++;

					}

				}

			}
		return;
		}

	public void printWin(int noOfRolls) throws gameWinnerException {
		snake sn=new snake();
		vulture vl=new vulture();
		cricket cr=new cricket();
		trampoline tmp=new trampoline();
		System.out.println("                 "+this.plName+" wins the race in "+noOfRolls);
		System.out.println("                 Total Snake Bites "+sn.getNoOfBites());
		System.out.println("                 Total Vulture Bites "+vl.getNoOfBites());
		System.out.println("                 Total Cricket Bites "+cr.getNoOfBites());
		System.out.println("                 Total Trampolines "+tmp.getNoOfBites());
		
	}

}



	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		boolean done=false;
		int noOfTiles=0;
		Game g=new Game();
		
		String name="";
		while (!done) {
			System.out.println("Enter the Player Name");
			try {//////number is also string so need of ex. handling
//				Scanner sc = new Scanner(System.in);
				name = scan.nextLine();
				done=true;
				int asdf= Integer.parseInt(name);
				if(true) {
					done=false;
//					System.out.println("string");
					throw new InputMismatchException();
				}
			} catch (InputMismatchException inp) {
				System.out.println("name should be string");
				System.out.println("Try	again");
			}
			catch(NumberFormatException inp) {
//				System.out.println("name should be string ");
			done=true;	
			}
			finally {
//				System.out.println("Always	execute");
			}
		}	
		String nm=name+".txt";
		
//		class GameTest {
//
//			@Test(expected	=	NullPointerException.class)
//			public void test() throws ClassNotFoundException, IOException {
//				gamePlay gp=deserialize(nm);
//			}
//
//		}		
		try {
			gamePlay gp=deserialize(name);
//			System.out.println(gp.plName);
			gp.startGame();
//			System.out.println(gp.index);
//			System.out.println(gp.alTiles.size());
			if(gp.index+1>=gp.alTiles.size()) {
			new FileOutputStream(nm).close();
			System.out.println("Clearing your poreviously saved data");
			}
			
		}
		catch(NullPointerException ex) {
		System.out.println("No prev saved data Avl!!");
		System.out.println("Starting new game");
		done=false;
		while (!done) {
			System.out.println("Enter total number of tiles on the race track (length)");
			try {
				Scanner sc = new Scanner(System.in);
				noOfTiles = sc.nextInt();
				done = true;
				if(noOfTiles<20) {
					done=false;
					throw g.new highExpectedValue("higher no of tiles expected");
					
				}
				

			} catch (InputMismatchException inp) {
				System.out.println("Wrong	input:");
				System.out.println("Try	again \n");
			}
			catch(highExpectedValue e) {
				System.out.println(e.getMessage());
			}
			finally {
//				System.out.println("Always	execute");
			}
			
		}
		gamePlay gp=g.new gamePlay(noOfTiles);

		gp.createRoad(noOfTiles);
		gp.printNews();
//		String name = "";
		done=false;
//		while (!done) {
//			System.out.println("Enter the Player Name");
//			try {//////number is also string so need of ex. handling
////				Scanner sc = new Scanner(System.in);
//				name = scan.nextLine();
//				done=true;
//				int asdf= Integer.parseInt(name);
//				if(true) {
//					done=false;
////					System.out.println("string");
//					throw new InputMismatchException();
//				}
//			} catch (InputMismatchException inp) {
//				System.out.println("name should be string");
//				System.out.println("Try	again");
//			}
//			catch(NumberFormatException inp) {
////				System.out.println("name should be string ");
//			done=true;	
//			}
//			finally {
////				System.out.println("Always	execute");
//			}
//		}
		g.name=name;
		gp.setName(name);
		System.out.println("Starting the game with "+g.name+" at Tile-1");
		System.out.println("Control transferred to Computer for rolling the Dice for "+g.name); 
		System.out.println("Hit enter to start the game");
		String rdStrg = scan.nextLine();
		int temp=0;
		while(rdStrg!=null) {
			if (rdStrg.isEmpty() ) {
				
				if(temp==1) {
					gp.startGame();
				break;
				}
				temp++;
			}
			if (scan.hasNextLine()) {
	            rdStrg = scan.nextLine();
	        }
			else
				rdStrg=null;
		}
		}
}


	public static gamePlay	deserialize(String name) throws IOException, ClassNotFoundException {	
		ObjectInputStream in = null;
		name+=".txt";
		gamePlay gmpl=null;
		try	{	
			in = new ObjectInputStream (new FileInputStream(name));	
//			this=(gamePlay)in.readObject();
			gmpl= (gamePlay) in.readObject();			
		}
		finally	{	
			in.close();	
			System.out.println("Obj DeSerialized");
		
			
		}

		return 	(gamePlay) gmpl;
	}

public int randomBw(int i) {
	Random rnd=new Random();
	int ans=rnd.nextInt(i);
//	System.out.println("returning "+(ans+1));
	return ans+1;
}

}
