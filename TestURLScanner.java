/**
 * @author ${hisham_maged10}
 *https://github.com/hisham-maged10
 * ${DesktopApps}
 */
import static java.lang.System.out;
import java.util.Scanner;
import java.net.URL;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
public class TestURLScanner
{
	public static void main(String[] args)
	{
		 gui();
		 doOperation(args);
	}
	public static void gui()
	{
		out.println();
		out.println("URL-Scanner Version 1.0\n------------------------");
		
	}
	public static void doOperation(String... args)
	{
		URLScanner input=null;
		switch(args.length)
		{
			default: if(args.length>2) input= new URLScanner(args[0],args[1]);break;
			case 0: input=doOperationType(getType()); break;
			case 1: input= new URLScanner(args[0]);break;
			case 2: input= new URLScanner(args[0],args[1]);break;
		}
		printLinks(input.getLinks());
		System.out.println();
		do
		{doOpenOperation(input);}while(checkIfAnotherTime());	
		System.out.println("Done!");
	}
	public static boolean checkIfAnotherTime()
	{
		System.out.println("Do you want to open another link? (y/n)");
		switch(new Scanner(System.in).nextLine().toLowerCase())
		{
			case "y":
			case "yes":
			case "ye":
			case "1": return true;
			case "n":
			case "no":
			case "0": return false;
		}
		return false;
	}
	public static void doOpenOperation(URLScanner input)
	{
		boolean check=false;
		do
		{
			check=open(input);	
		}while(!check);
	}
	public static boolean open(URLScanner input)
	{
		boolean check=false;
		int index=0;
		Scanner userInput=new Scanner(System.in);
		do{	
		System.out.print("Enter the number of link that exist in the list you want to open: ");
		try{check=input.openLinkAt(Integer.parseInt(userInput.nextLine()));}catch(InputMismatchException ex){ System.out.println("Please Enter a whole number "); return false;}
		}while(!check);
		return check;
	}
	public static void printLinks(String[] links)
	{
		int i=1;
		if(links!=null)
		for(String e: links)
		System.out.println(e+" Link#"+(i++));
		else
		{
			System.out.println("no Links were found!");
			System.exit(0);
		}
	}
	public static URLScanner doOperationType(URLScanner.Type type)
	{
		URLScanner input=null;
		Scanner userInput=new Scanner(System.in);
		String link="";
		switch(type)
		{
			case SEARCH_TARGET: System.out.print("Enter the Valid URL(including http) you want scanned: "); do{link=userInput.nextLine();}while(!validateLink(link)); 
					    System.out.print("Enter the specific link you want: "); String target=userInput.nextLine();
					    input=new URLScanner(link,target);
										break;
			case NO_SEARCH_TARGET: System.out.print("Enter the URL(including http) you want scanned: "); link=userInput.nextLine(); 
					       input=new URLScanner(link);
										break;
		}
		return input;
	}
	public static boolean validateLink(String str)
	{
		return (str.contains("www") || str.contains("http"))?true:false;
	}
	public static URLScanner.Type getType()
	{
		String choice;
		do
		{
			System.out.println("Choose what you need: (1/2)\n1.All links\n2.Specific links");
			switch((choice=new Scanner(System.in).nextLine()).toLowerCase())
			{
				case "a": 
				case "all links":
				case "1": 	
				case "one": return URLScanner.Type.NO_SEARCH_TARGET;
				case "s":
				case "specific links":	
				case "2": 	
				case "two": return URLScanner.Type.SEARCH_TARGET;
				default: if(choice.toLowerCase().contains("all")) return URLScanner.Type.NO_SEARCH_TARGET; 
					 else if(choice.toLowerCase().contains("spec")) return URLScanner.Type.SEARCH_TARGET;
					 else choice=null;
							break;
			}
		}while(choice==null);
		
		return URLScanner.Type.NO_SEARCH_TARGET;
	}

}