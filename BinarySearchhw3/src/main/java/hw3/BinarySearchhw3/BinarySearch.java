package hw3.BinarySearchhw3;


import java.util.List;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class BinarySearch{
	 
	public static int binarySearch( Comparable [ ] arr, Comparable key )
  {
      int low = 0;
      int high = arr.length - 1;
      int mid;

      while( low <= high )
      {
          mid = ( low + high ) / 2;

          if( arr[ mid ].compareTo( key ) < 0 )
              low = mid + 1;
          else if( arr[ mid ].compareTo( key ) > 0 )
              high = mid - 1;
          else
              return mid;
      }

      return -1;    
  }


public static void main(String[] args) throws Exception {
	
   
Options options = new Options();

Option type = new Option("type", "type", true, "data type ");
options.addOption(type);

Option key = new Option("key", "key", true, "key element");
options.addOption(key);

Option list = new Option("list", "list", true, "list");

options.addOption(list);

CommandLineParser commandLineParser = new DefaultParser();

CommandLine commandLine;
try{
commandLine = commandLineParser.parse(options, args);

String typeelement = commandLine.getOptionValue("type");
String keyelement = commandLine.getOptionValue("key");
String element = commandLine.getOptionValue("list");
List<String> listelements = commandLine.getArgList();


String [ ] arr = new String [listelements.size()+1];
arr[0]=element;

for (int i=1;i<listelements.size()+1;i++)
	  arr[i]=listelements.get(i-1);

if(typeelement.compareTo("s")==0){
	int c=binarySearch(arr,keyelement);
	if(c==-1)
	  System.out.println("0");
	else
	System.out.println("1")	;
}else if(typeelement.compareTo("i")==0){
	int c1=binarySearch(arr,keyelement);
	if(c1==-1)
	  System.out.println("0");
	else
	System.out.println("1")	;
	
}
}
catch( ParseException exp ) {
	    System.out.println( "Unexpected exception:" + exp.getMessage() );
	}




}

}

