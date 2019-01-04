package interviewbit.programming.arrays;

public class CompareVersions {
	    public static int compareVersion(String A, String B) {
	        String[] strA = A.split("\\.");
	        String[] strB = B.split("\\.");
	        int length = Math.min(strA.length , strB.length);
	        for(int i = 0 ; i < length ; i++){
	            int result = new Long(strA[i]).compareTo(Long.parseLong(strB[i]));
	            System.out.println(result);
	            // int result = new Integer(strA[i].compareTo(Integer.parseInt(strB[i])));
	            if(result != 0)
	                return result;
	        }
	        return Integer.compare(strA.length , strB.length);
	    }
	public static void main(String[] args) {
		compareVersion("4444371174137455" , "5.168");
	}

}
