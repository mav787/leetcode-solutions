package T500_699;

public class T672 {
	public int flipLights(int n, int m) {
//		There are three important observations:
//
//		For any operation, only odd or even matters, i.e. 0 or 1. Two same operations equal no operation.
//		The first 3 operations can be reduced to 1 or 0 operation. For example, flip all + flip even = flip odd. 
//		So the result of the first 3 operations is the same as either 1 operation or original.
//		The solution for n > 3 is the same as n = 3.
//		For example, 1 0 0 ....., I use 0 and 1 to represent off and on.
//		The state of 2nd digit indicates even flip; The state of 3rd digit indicates odd flip; And the 
//		state difference of 1st and 3rd digits indicates 3k+1 flip.
//		In summary, the question can be simplified as m <= 3, n <= 3. I am sure you can figure out the rest 
//		easily.
		if(n <= 0 || m < 0) return 0;
        if(m == 0) return 1;
        if(n == 1) return 2;
        if(n == 2) return (m == 1) ? 3 : 4;
        if(m == 1) return 4;
        return (m == 2) ? 7 : 8;
    }
}
