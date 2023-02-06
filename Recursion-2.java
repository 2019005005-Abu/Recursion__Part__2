import java.util.HashSet;

class Recursion_2{
    public static void Towet_Of_Hanoie(int n,String src,String helper,String destination) {
        //base case
        if(n==1){
            System.out.println("Transfer disk"+n+"from "+" "+src+" "+"to"+"  "+destination);
            return;
        }
        Towet_Of_Hanoie(n-1, src, destination, helper);
        System.out.println("Transfer disk"+n+"from"+src+"to"+destination);
        Towet_Of_Hanoie(n-1, helper, src, destination);
    }

    //Print a string in reverse
     public static void Print_Reverse(String str,int indx) {
          if(indx==0){
            System.out.println(str.charAt(indx));
            return;
          }
        System.out.println(str.charAt(indx));
        Print_Reverse(str, indx-1);
     }

    //question 3:Find the 1st & last occurance of an element in string
      public static int first=-1;
      public static int last=-1;
      public static void find_Occurance(String str,int idx,char element){
        //base case
        if(idx==str.length()){
            System.out.println(first);
            System.out.println(last);
            return;
        }
       char current_character=str.charAt(idx);
       if(current_character==element){
        if(first==-1){
            first=idx;
        }else{
            last=idx;
        }
       }
       find_Occurance(str,idx+1,element);
      }

      //question -3
      //Check if an array is sorted (Strictly Increasing)
      //{1,2,3,4,5}

      public static boolean isSorted(int arr[],int index){
        //base case true
         if(index==arr.length-1){
            return true;
         }
        if(arr[index]<arr[index+1]){
            //array is sorted til now
          return isSorted(arr,index+1);
        }else{
            return false;
        }
         
       // basecase false
    // if(index==arr.length-1){
    //     return true;
    //  }
    //  if(arr[index]>=arr[index+1]){
    //     //array is unsorted til now
    //     return false;
    // }else{
    //     return isSorted(arr,index+1);
    // }


    //question -4
    //Move all "x" to the end of the string
      }
      public static void Move_All_x(String str,int index,int count,String newString) {
        //base case
        if(index==str.length()){
            for(int i=0;i<count;i++){
                newString+='x';
            }
           System.out.println(newString);
           return;
        }
       char current_character=str.charAt(index);
       if(current_character=='x'){
        count++;
        Move_All_x(str,index+1,count,newString);
       }else{
         newString+=current_character;
         //newString=newString+current_character
         Move_All_x(str,index+1,count,newString);
       }
      }
      //Question 5:Remove duplicates in a  String
     //"abbccda"
     public static boolean [] map=new boolean[26];
     public static void removeDuplicates(String str,int index,String newString) {
      //base case
      if(index==str.length()){
        System.out.println(newString);
        return;
      }
      char current_character=str.charAt(index);
      if(map[current_character -'a']){
        removeDuplicates(str,index+1,newString);
      }else{
        newString+=current_character;
        map[current_character -'a']=true;
        removeDuplicates(str,index+1,newString);
      }
     }

    //Question-6:Print all the subsequences of a string
    //"abc"
    //Time complexity:
     public static void sub_Sequence(String str, 
     int index,String newString) {
        if(index==str.length()){
           System.out.println(newString);
           return;
        }
        char current_character=str.charAt(index);
       //to be
       sub_Sequence(str,index+1,newString+current_character);
       //not to be
       sub_Sequence(str,index+1,newString);
     }
    
      //Question-7 Print all the subsequence of a string using Hash set
      public static void sub_SequenceHashSet(String str, 
      int index,String newString,HashSet<String>set) {
         if(index==str.length()){
             if(set.contains(newString)){
              return;
             }else{
              System.out.println(newString);
              set.add(newString);
              return;
             }
         }
         char current_character=str.charAt(index);
        //to be
        sub_SequenceHashSet(str,index+1,newString+current_character,set);
        //not to be
        sub_SequenceHashSet(str,index+1,newString,set);
      }

      //question-8 Print Keypad combination
      public static String[]keypad={
       ".",
       "abc",
       "def",
       "ghi",
       "jkl",
       "mno",
       "pqrs",
       "tu",
       "vwx",
       "yz"
      };
      public static void printCombination(String str,int index,String combination) {
        //base case
        if(index==str.length()){
           System.out.println(combination);
           return;
        }
        char current_character=str.charAt(index);
        String mapping=keypad[current_character - '0'];
        for(int i=0;i<mapping.length();i++){
          printCombination(str,index+1,combination+mapping.charAt(i));
        }
      }

    public static void main(String[] args) {
        // Question 2:Tower of Hanoie
        //time complexity:O(2n-1) =O(2n)
        //Space complexity:
        int n=5;
         Towet_Of_Hanoie(n, "S", "H", "D");

         //question-2:Print  a string in reverse
         //"abcd"
          System.out.println();
          System.out.println("Reverse String:");
          String str="abcd";
          Print_Reverse(str, str.length()-1);
          //Time complexity:0(n)
          

          //question 3:Find the 1st & last occurance of an element in string
          //"abacccdaefaah"
          System.out.println();
          System.out.println("Find the 1st & last occurance of an element in string:");
          String str1="abaacdaefaah";
          find_Occurance(str1,0,'a');

          //question -3
          //Check if an array is sorted (Strictly Increasing)
          //{1,2,3,4,5}
          //Time complexity:O(n)
          System.out.println();
          System.out.println("Check if an array is sorted (Strictly Increasing:");
          int arr[]={1,2,3,4,5};
          System.out.println( isSorted(arr,0));

          //question -4
          //Move all "x" to the end of the string
          //"axbcxxd"
          //time  complexity-Big O(n)
          System.out.println();
          System.out.println("Move all 'x' to the end of the string");
           String str2="axbcxxd";
           Move_All_x(str2,0,0,"");

           //Question:5 Remove duplicates in a  String
           //"abbccda"
           //Time complexity:Big 0(n)
           System.out.println();
           System.out.println("Remove duplicates in a  String:");
           String str3="abbccda";
           removeDuplicates(str3,0,"");

           //Question-6:Print all the subsequences of a string
           //"abc"
           //Time complexity:0(2 to the power n)->0(2n)
           System.out.println();
           System.out.println("Print all the subsequences of a string:");
           String str__4="abc";
           sub_Sequence(str__4,0,"");

           //Question-7 Print all the unique subsequence of a string using Hash set
           //"aaa"
           System.out.println();
           System.out.println("Print all the subsequence of a string using Hash set:");
           String str_7="aaa";
           HashSet<String>set=new HashSet<>();
           sub_SequenceHashSet(str_7,0,"",set);
          
           //question-8 Print Keypad combination
           System.out.println();
           System.out.println("Print Keypad combination");
           String str_8="23";
           printCombination(str_8,0,"");
 
    }
}