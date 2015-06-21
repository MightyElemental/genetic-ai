package net.minegeek360.ai.language;


public class Dictionary {
	
	/*public static String removePunc(String string){
		String[] temp = {",",".","!","/","\\","/",";",":","'","#",""};
		for(int i = 0; i < temp.length; i++){
			string = string.replaceAll(temp[i], "");
		}
		return string;
	}*/
	
	public static String removePunc(String string){
		string = string.toLowerCase();
		string = string.replaceAll("[^a-z]", "");
		return string;
	}
	
	public static int wordSeverity(String string){//scale 1-10; 0 - unrealistically abusive, 10 - unrealistically kind, 5 - neutral
		switch(removePunc(string)){
		case "stupid": return 4;
		case "awesome": return 6;
		case "super": return 6;
		case "cool": return 6;
		case "idiot": return 4;
		case "retard": return 3;
		case "hate": return 4;
		case "xd": return 6;
		case "love": return 7;
		case "beautiful": return 7;
		}
		return 5;
	}
	
}
