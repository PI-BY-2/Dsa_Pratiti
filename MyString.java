import java.util.ArrayList;

public class MyString {
	
		public static void main(String[] args) {
			MyString str = new MyString("Rushikesh");
			MyString str2 = new MyString("RUSHIKESHIKESHSDBVIIFKESH    ");
			MyString pattern = new MyString("KESH");
			
			System.out.println(str.charAt(5));
			System.out.println(str.length());
			System.out.println(str.concat(str));
			System.out.println(str.toUpperCaseUsingASCII());
			System.out.println(str.toLowerCaseUsingASCII());
			System.out.println(str2.substring(2, 8));
			System.out.println(str.equals(str2));
			System.out.println(str2.patternmatching(pattern));
			System.out.println(str2.patternmatchingUsingTwoPointer(pattern));
		}
	
	

        private char[] characters;
    
        public MyString(char[] chars) {
            this.characters = chars;
        }
    
        public MyString(String literal) {
            this.characters = literal.toCharArray();
        }
    
        public int length() {
            return characters.length;
        }
    
        public char charAt(int index) {
            return characters[index];
        }


        public MyString substring(int start, int end) {
            char[] subChars = new char[end - start];
            System.arraycopy(characters, start, subChars, 0, end - start);
            return new MyString(subChars);
        }


        public MyString concat(MyString other) {
            int totalLength = length() + other.length();
            char[] newChars = new char[totalLength];
            System.arraycopy(characters, 0, newChars, 0, length());
            System.arraycopy(other.characters, 0, newChars, length(), other.length());
            return new MyString(newChars);
        }

        public boolean equals(MyString other) {
            if (length() != other.length()) {
                return false;
            }
            for (int i = 0; i < length(); i++) {
                if (characters[i] != other.characters[i]) {
                    return false;
                }
            }
            return true;
        }

        public MyString toLowerCaseUsingASCII() {
            char[] lowerChars = new char[length()];
            for (int i = 0; i < length(); i++) {
            	if(characters[i] >= 65 && characters[i] <= 90){
            		lowerChars[i] = (char) (characters[i] + 32);
                }
            	else lowerChars[i]=characters[i];             
            }
            return new MyString(lowerChars);
        }
        
        public MyString toUpperCaseUsingASCII(){
            char[] upperChars = new char[length()];
            for (int i = 0; i < length(); i++) {
            	if(characters[i] >= 65 && characters[i] <= 90){
            		upperChars[i]=characters[i];
                }
            	else upperChars[i] = (char) (characters[i] - 32);               
            }
            return new MyString(upperChars);
        }
        
        public boolean patternmatching(MyString pattern){
            for(int i = 0; i < length(); i++){
                if(characters[i] == pattern.charAt(0)){
                    for(int j = 0; j < pattern.length(); j++){
                        if(characters[i+j] != pattern.charAt(j)){
                            break;
                        }
                        if(j == pattern.length()-1){
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        
        public ArrayList patternmatchingUsingTwoPointer(MyString pattern){
            ArrayList<Integer> result = new ArrayList<Integer>();
            for(int i = 0; i < length(); i++){
                if(characters[i] == pattern.charAt(0)){
                    int j = 0;
                    while(j < pattern.length() && characters[i+j] == pattern.charAt(j)){
                        j++;
                    }
                    if(j == pattern.length()){
                        result.add(i);
                    }
                }
            }
            return result;
        }
    
        @Override
        public String toString() {
            return new String(characters);
        }
    }