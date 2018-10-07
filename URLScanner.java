/**
 * @author ${hisham_maged10}
 *https://github.com/hisham-maged10
 * ${DesktopApps}
 */
import java.net.URL;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.IOException;
import java.net.MalformedURLException;
import java.awt.Desktop;
import java.awt.Desktop.Action;
public class URLScanner
{
	private ArrayList<String> links;
	public URLScanner(URL url)
	{
		this.links=storeLinks(url);
	}
	public URLScanner(String urlStr)
	{
		this.links=storeLinks(urlStr);
	}
	public URLScanner(URL url,String targetUrl)
	{
		this.links=storeLinks(url,targetUrl);
	}
	public URLScanner(String urlStr,String targetUrl)
	{
		this.links=storeLinks(urlStr,targetUrl);
	}
	private ArrayList<String> storeLinks(String urlStr)
	{
		ArrayList<String> links=new ArrayList<String>();
		String token;
		try(Scanner input=new Scanner(new URL(urlStr).openStream()))
		{
			int i=1,j=1;
			while(input.hasNextLine())
			{
				System.out.println("working parsed: "+(j++)+" item");
				if((token=input.nextLine()).toLowerCase().contains("href=\"") && validateTokenURL((token=token.substring(token.indexOf("\"")+1,token.indexOf("\"",token.indexOf("\"")+1)))))
				{
					
					links.add(token);
					System.out.println((i++)+" Links added..");
				}
				else continue;
			}
			System.out.println("Done parsing\n-------------\nLinks:-\n-------");
	
		}catch(MalformedURLException ex)
		{
			ex.printStackTrace();	
		}
		catch(IOException ex)
		{
			System.err.println("Error, A connection can't be opened with that link!");
		}
		return (links.size()>0)?links:null;
	}
	//overloaded
	private ArrayList<String> storeLinks(URL url)
	{
		ArrayList<String> links=new ArrayList<String>();
		String token;
		try(Scanner input=new Scanner(url.openStream()))
		{
			while(input.hasNextLine())
			{
				if((token=input.nextLine()).toLowerCase().contains("href=\"") && validateTokenURL((token=token.substring(token.indexOf("\"")+1,token.indexOf("\"",token.indexOf("\"")+1)))))
				{
					
					links.add(token);
				}
				else continue;
			}
			System.out.println("Done parsing\n-------------\nLinks:-\n-------");
	
		}catch(MalformedURLException ex)
		{
			ex.printStackTrace();	
		}
		catch(IOException ex)
		{
			System.err.println("Error, A connection can't be opened with that link!");
		}
		return (links.size()>0)?links:null;
	}
	//overloaded
	private ArrayList<String> storeLinks(String urlStr,String target)
	{
		ArrayList<String> links=new ArrayList<String>();
		String token;
		try(Scanner input=new Scanner(new URL(urlStr).openStream()))
		{
			while(input.hasNextLine())
			{
				if((token=input.nextLine()).toLowerCase().contains("href=\"") && validateTokenURL((token=token.substring(token.indexOf("\"")+1,token.indexOf("\"",token.indexOf("\"")+1)))))
				{
					
					links.add(token);
				}
				else continue;
			}
			System.out.println("Done parsing\n-------------\nLinks:-\n-------");
	
		}catch(MalformedURLException ex)
		{
			ex.printStackTrace();	
		}
		catch(IOException ex)
		{
			System.err.println("Error, A connection can't be opened with that link!");
		}
		return (links.size()>0)?links:null;	
	}
	//overloaded
	private ArrayList<String> storeLinks(URL url,String target)
	{
		ArrayList<String> links=new ArrayList<String>();
		String token;
		try(Scanner input=new Scanner(url.openStream()))
		{
			while(input.hasNextLine())
			{
				if((token=input.nextLine()).toLowerCase().contains("href=\"") && validateTokenURL((token=token.substring(token.indexOf("\"")+1,token.indexOf("\"",token.indexOf("\"")+1)))))
				{
					
					links.add(token);
				}
				else continue;
			}
			System.out.println("Done parsing\n-------------\nLinks:-\n-------");
	
		}catch(MalformedURLException ex)
		{
			ex.printStackTrace();	
		}
		catch(IOException ex)
		{
			System.err.println("a connection can't be opened with that link!");
		}
		return (links.size()>0)?links:null;	
	}
	private boolean validateTokenURL(String str)
	{
		try
		{
			URL url= new URL(str);
		}catch(MalformedURLException ex)
		{
			return false;
		}
		return true;
	}
	public String[] getLinks()
	{
		return (links!=null)?links.toArray(new String[links.size()]):null;
	}
	public boolean openLinkAt(int index)
	{
		if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)){
    		try{Desktop.getDesktop().browse(new URI(links.get(--index)));}
		catch(IndexOutOfBoundsException ex){return false;}
		catch(URISyntaxException | IOException ex) { ex.printStackTrace(); }
		catch(Exception ex){ex.printStackTrace();}
		return true;
		}
		else
		{
			throw new UnsupportedPlatformException("Platform doesn't support opening browser!");
		}
		
	}
	public static enum Type
	{
	SEARCH_TARGET,NO_SEARCH_TARGET;
	}
}