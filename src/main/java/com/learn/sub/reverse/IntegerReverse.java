package com.learn.sub.reverse;

public class IntegerReverse {

    public int reverse(int x) {

        String str = new StringBuilder(Integer.toString(x)).reverse().toString();

        if(x < 0){
            str = str.substring(0, str.length()-1);
        }
        int reversed;
        try{
             reversed = Integer.parseInt(str);

        }catch (Exception e){
            return 0;
        }

        if(x < 0)
            reversed = reversed * -1;

        if(reversed >= Math.pow(-2, 31) && reversed <= (Math.pow(2, 31)-1))
            return reversed;

        //System.out.println(str);
        return 0;
    }

    public static void main(String[] args) {
        IntegerReverse integerReverse = new IntegerReverse();
        int reversed = integerReverse.reverse(1534236469);
        System.out.println(reversed);


    }
}
