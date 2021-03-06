package truc;

public class Question2 {
    public static void main(String[] args)
    {
        String number = "50E891";
        int originalBase = 16;
        int endBase = 8;

       // transformBase(number, originalBase, endBase);
    }

    // Function to convert number from base1 to base2 another base
    static String TransformBase(int base1, String number, int base2)
    {
        System.out.println(number);

        int num = toDecimalForm(number, base1);
        System.out.println(num);

        String ans = deciToFinalBase(base2, num);
        System.out.println(ans);

        System.out.print(ans);

        return ans;
    }

    // getting the value of a letter for base16
    static int val(char c)
    {
        if (c >= '0' && c <= '9'){
            return(int)c - '0';
        }
        else {
            return (int) c - 'A' + 10;
        }
    }

    // Function to convert a number from original base to decimal number
    static int toDecimalForm(String str, int baseOrigin)
    {
        int len = str.length();
        int power = 1;
        int num = 0;

        for(int i = len - 1; i >= 0; i--) {
            if (val(str.charAt(i)) >= baseOrigin)
            {
                System.out.printf("Invalid Number");
                return -1;
            }
            num = num + val(str.charAt(i)) * power;
            power = power * baseOrigin;
        }
        return num;
    }

    // Function to give the letter equivalent to a given value for base16
    static char equivCharVal(int num)
    {
        if (num >= 0 && num <= 9)
            return(char)(num + '0');
        else
            return(char)(num - 10 + 'A');
    }

    // Function to convert a decimal number to input base2(2-16)
    static String deciToFinalBase(int base2, int Number)
    {
        // Store the result
        String answer = "";
        while (Number > 0)
        {
            answer = (answer + equivCharVal(Number % base2));

            Number /= base2;
        }
        answer = invert(answer);
        return answer;
    }

    static String invert(String input) {
        char[] a = input.toCharArray();
        int l, r = a.length - 1;
        for (l = 0; l < r; l++, r--) {
            char temp = a[l];
            a[l] = a[r];
            a[r] = temp;

        }
        return String.valueOf(a);
    }
}

/*
PSEUDOCODE - Question 2

1. convert Number from Base1 to decimal value
	a) Store the length of the string
	b)  Initialize power of base to 1
	b) initialize num = 0;
	c) Decimal equivalent ;
			 for(int i = len - 1; i >= 0; i--) --> for integer i = length of the string-1 , when i is greater then or equal to 0, i going in descending order{
				     check ;  if (the value of the digit at index i is greater than or equal to the value of the base 10)
				                print that the number is invalid
	            cb)update number
	                 num = num + value of (character at index i) * power
	            cc) uppdate power
	               	power = power * base;
	               	}
	d) return the value of decimal in base 10

2. convert decimal to base2(as in new base)
	a) Store the result as an empty string
	b)Repeatedly divide Number by base2 and take remainder.
	    while(number is greater than 0)
	     result = result + (the equivalent character value)(number % base2 value)
	c)Reverse the main string to obtain the proper number
	d) then make the return result equal to the reversed value.
*/



