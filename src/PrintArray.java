public class PrintArray  {
    public static String printArray(int[] input)  {
        if(input.length < 1)  {
            return "[]";
        }
        String result = "[";
        for(int i = 0; i < input.length-1; i++)  {
            result += input[i] + ", ";
        }
        result += input[input.length-1] + "]";
        return result;
    }
    public static String printArray(String[] input)  {
        if(input.length < 1)  {
            return "[]";
        }
        String result = "[";
        for(int i = 0; i < input.length-1; i++)  {
            result += input[i] + ", ";
        }
        result += input[input.length-1] + "]";
        return result;
    }
}
