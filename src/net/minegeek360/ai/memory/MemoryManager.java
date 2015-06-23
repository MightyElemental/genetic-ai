package net.minegeek360.ai.memory;

public class MemoryManager {
	
	private static Memory[] memory = new Memory[9999];
	
	public static void addMemory(Memory mem){
		for(int i = 0; i < memory.length; i++){
			if(memory[i] == null){
				memory[i] = mem;
				return;
			}
		}
	}
	
	public static Memory[] getMemories(){
		return memory;
	}
	
}
