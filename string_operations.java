import java.util.Scanner;
// class to perform operations
public class string_operations {

	// method to convert to upper case
	public static String upper(String s){
		char[] c = s.toCharArray();
		for(int i=0; i<c.length; i++){
			if(c[i]>='a' && c[i]<='z') {
				c[i]=(char)(c[i]-32);
			}
			
			}
		return new String(c);
		}
	// method to convert to lower case
	public static String lower(String s){
		char[] c = s.toCharArray();
		for(int i=0; i<c.length; i++){
			if(c[i]>='A' && c[i]<='Z') {
				c[i]=(char)(c[i]+32);
			}
			
			}
		return new String(c);
		}

	// method to extract digits in string
	public static void extract(String str) {
		String r="";
		for(int i=0; i<str.length(); i++) {
			char ch= str.charAt(i);
			if(ch>='0' && ch<='9') {
				r=r+ch;
			}
		}
		System.out.println("Substring as numbers is: "+r);	
	}
	// method to reverse string
	public static String reverse(String st) {
		char[] chr= st.toCharArray();
		int i=0;
		int j= st.length()-1;
		while(i<j) {
			char temp= chr[i];
			chr[i]=chr[j];
			chr[j]=temp;
			i++;
			j--;
		}
		return new String(chr);
	}
	public static void compare(String s1, String s2) {      
    
    if(s1.length() != s2.length()) {
        System.out.println("Strings are not matching (different lengths).");
        return; 
    }
  
    for(int i = 0; i < s1.length(); i++) {
        if(s1.charAt(i) != s2.charAt(i)) {
            System.out.println("Strings are not matching (characters differ).");
            return; 
        }
    }
    
    System.out.println("Strings are matching!");
}

	public static void count(String s3) {
		int count=0;
		char[] ch= s3.toCharArray();
		for(int i=0; i<s3.length(); i++) {
			if(s3.charAt(i)==' ') {
				count++;
			}
		}
		count=count+1;
		System.out.println("Count is: "+ count);	
	}
	public static void substring(String s4, String s5) {
    int n1 = s4.length();
    int n2 = s5.length();
    boolean found = false;

    for (int i = 0; i <= n1 - n2; i++) {
        int j;
        for (j = 0; j < n2; j++) {
            if (s4.charAt(i + j) != s5.charAt(j)) {
                break; 
            }
        }
        
        if (j == n2) {
            found = true;
            break; 
        }
    }

    if (found) {
        System.out.println("Substring found");
    } else {
        System.out.println("Substring not found");
    }
}
	
	public static String replace(String s, char oldch, char newch) {
    char[] c = s.toCharArray();
    for (int i = 0; i < c.length; i++) {
        
        if (c[i] == oldch) {
            c[i] = newch;
        }
    }
    return new String(c);
}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);     
      int choice;
      do {
          System.out.println("\n--STRING OPERATIONS--\n1)To Upper Case\n2)Lower case\n3)Comparison\n4)Extract digits\n5)Reverse string\n6)Count words\n7)Substring\n8)Replace\n9)Exit");
          System.out.println("Enter your choice from above menu: ");
          choice = sc.nextInt();
          sc.nextLine();	
          System.out.print("Enter a text: ");
          String text = sc.nextLine();
          switch (choice) {
              case 1:
     
                  System.out.println("Uppercase: " + upper(text));
                  break;
              case 2:
                 
                  System.out.println("Lowercase: " + lower(text));
                  break;
              case 3:
                  System.out.print("Enter text 2: ");
                  String text2 = sc.nextLine();
                  compare(text, text2);
                  break;
                 
              case 4:
                  System.out.println("Extract digits: ");
                  extract(text);
                  break;
                 
              case 5:
                  System.out.println("Reversed string is: " + reverse(text));
                  break;
                 
              case 6:
           	   System.out.println("Count of string is: ");
           	   count(text);
           	   break;
           	  
              case 7:
           	   System.out.print("Enter text 2: ");
                  String text1 = sc.nextLine();
           	   System.out.println("Substring is: ");
           	   substring(text, text1);
           	   break;
           	  
           	  case 8:
    System.out.print("Enter character to replace: ");
    char oldc = sc.next().charAt(0);
    System.out.print("Enter replacement character: ");
    char newc = sc.next().charAt(0);
    System.out.println("Result: " + replace(text, oldc, newc));
    break;
           	  
              case 9:
           	   System.out.println("Exit");
           	   break;
              default:
                  System.out.println("Invalid choice! Try again.");
          }
      } while (choice != 9);
      sc.close();
}
