# URLScanner (HTMLParser) (Made and tested by NotePad)
## URL Scanner class is a class that Can parse URLs and links from any webpage given if exists 
URLScanner class have **Four _Overloaded_ Constructors**
-----
*One that Takes a URL String
*One that Takes a URL String & a Search Target String
*One that Takes a URL Object
*One that Takes a URL Object & a Search Target String

which initializes and parses the **_HTML Code_** for any **Hyper Links** in the given _URL_ Webpage in an **ArrayList of Strings** called **links**
using a private _**overloaded**_ method (for abstraction) called **storeLinks** validating the URLs before adding them and in case of inputing a **search target** it will add only the valid URLS that _contains_ that **search target** 

The user have the option to use two methods 
---
# openLinkAt(int index)
opening the **link** at chosen **index** in the arraylist in the default platform's Browser

# getLinks()
which returns a **String[]** of the arraylist of links so the information becomes **Immutable** and can't be changed for security reasons

Also the user have access to use a **_Static_** _Enumerated_ member of the class Called **Type** that has two options
*SEARCH_TARGET
*NO_SEARCH_TARGET
that can be used to specify if the object of the URLScanner has a search target or not.

## The TestURLScanner.java 
gives you **_Two Options_** 
Either to parse and add _**All**_ links in the given **URL** to the ArrayList
or to parse and add ***Specific*** links in the given **URL**
# Run me.bat file 
_**You can open the Program via the Run me.bat file which will open Command Prompt window and compiles the .java file automatically and executes the .class file automatically**_ 
![ScreenShot](https://github.com/hisham-maged10/URL-Scanner-Class/blob/master/Screenshot%20(2034).png)
# Which will Open
![ScreenShot](https://github.com/hisham-maged10/URL-Scanner-Class/blob/master/Screenshot%20(2027).png)
# ALL links Option
accepts 1, one, a, A, One, all, All as user inputs
and **Prompts** the user to give the needed _**URL**_ 
![ScreenShot](https://github.com/hisham-maged10/URL-Scanner-Class/blob/master/Screenshot%20(2028).png)
then the program starts parsing the url's HTML code and adding the valid urls in the Arraylist 
then lists the valid links enumerated by their number in the list by  Link#number at the end of the url
![ScreenShot](https://github.com/hisham-maged10/URL-Scanner-Class/blob/master/Screenshot%20(2029).png)
and asks you which link you want to open in your default browser automatically
following by a question loop if you want to open another link
if given yes, y, ye, one or 1 as user input then you will be permited to choose another link to open
until given n, no or 0 to terminate the program
# Specific-Link Option
accepts 2, two, s, S, spec or specific as user input
giving you the same prompt as the first option but then giving you a new option which is to specify a search target that must exist in the parsed url to be added to the arraylist
for example, using the same link as in the previous Screenshot but giving a search target as "geeksquiz"
the output will be:
![ScreenShot](https://github.com/hisham-maged10/URL-Scanner-Class/blob/master/Screenshot%20(2030).png)

### Command-Line Arguements
another option you have is to give only the link you want parsed via _command line args_ **While Executing**
for example:-
![ScreenShot](https://github.com/hisham-maged10/URL-Scanner-Class/blob/master/Screenshot%20(2031).png)
**Or giving the url and search target via command line arguements while executing**
for example:-
![ScreenShot](https://github.com/hisham-maged10/URL-Scanner-Class/blob/master/Screenshot%20(2032).png)

**In the end by choosing a link, for Example link#5**
![ScreenShot](https://github.com/hisham-maged10/URL-Scanner-Class/blob/master/Screenshot%20(2035).png)
**The program gives you a loop question if you want to open another link and at the same time opens the chosen link via default browser**
![ScreenShot](https://github.com/hisham-maged10/URL-Scanner-Class/blob/master/Screenshot%20(2036).png)


#### Exceptions
The class has its own exception called ***UnsupportedPlatformException*** which is thrown by _**OpenLinkAt()**_ method if accessing the browser is not supported on your current Platform.
