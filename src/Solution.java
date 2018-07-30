import java.util.Stack;


public class Solution {

    public boolean isValid(String s){
        Stack<Character> stack =new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);
            if (c =='(' || c=='[' ||c=='{'){
                stack.push(c);
            }else{
                if (stack.isEmpty()){
                    return false;
                }

                char topChar=stack.pop();
                if (c== ')' && topChar !='('){
                    return  false;
                }

                if (c==']' && topChar !='['){
                    return  false;
                }

                if (c=='}' && topChar !='{'){
                    return  false;
                }



            }
        }

        return  stack.isEmpty();
    }








    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        for (int i = 0; i < nums1.length; i++) {
            System.out.println(nums1[i]);

            for (int s=0;s<nums2.length;s++){
                if (nums1[i] == nums2[s]){
                    System.out.println(s);
                    System.out.println("===========");
                }

            }


        }



        return  null;
    }


    public static void main(String[] args) {

        int a[] =new int[]{1,2,3};
        int b[]=new int[]{4,5,2,1,3,6};

        (new  Solution()).nextGreaterElement(a ,b);
    }


}
