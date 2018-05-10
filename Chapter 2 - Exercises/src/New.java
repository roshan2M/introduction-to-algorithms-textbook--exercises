
public class New {
	/*
	public static void main(String[] args) {
	
		int[] a = {5, 11, 18, 11, 20, 19, 9, 18};
		
		for (int i = 1; i <= 128; i++) {
			a[(i-1)%8] = (a[(i-1)%8] + i) % 26;
		}
		
		for (int i = 0; i < 8; i++) {
			System.out.print(a[i] + ", ");
		}
	
	}
	*/
	
	public static boolean isPalindrome(String s) {
		for (int i = 0; i < s.length()/2; i++) {
			if (s.charAt(i) != s.charAt(s.length() - i - 1)) return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		String s = "smmaaggemgegmseeemaaemgmaaemaasasesmgmegaeaagmmegssggaammmaagseeamemeaeaaegsmseemmsesagaggeaagmgagma";
		String alpha = "abcdefghijklmnopqrstuvwxyz";
		char[] array = s.toCharArray();
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j < 26; j++) {
				 array[i] = alpha.charAt(j);
			}
		}
	}

}
