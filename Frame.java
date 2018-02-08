//本游戏是一个猜测游戏，用以帮助玩家考虑简单的利弊
//this is a test game

import java.util.Scanner;

public class Frame {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); 
		int count = 0;
		int[][] youranswer = new int[20][3];
		int[] oldjudge = new int[20];
		int judgement;
		
		while(count<20){
		
			System.out.println("请输入三个数");
			youranswer[count][0]= sc.nextInt();
			youranswer[count][1]= sc.nextInt();
			youranswer[count][2]= sc.nextInt();
			
			if(count == 0)
				oldjudge[count] = 6;
			else
				oldjudge[count] = judge(youranswer,count,oldjudge);
			
			switch(oldjudge[count]){
				
				case 0: System.out.println("恭喜你完全猜对了");	break;
				case 1: System.out.println("两对一错");		break;
				case 2: System.out.println("一对两错");		break;
				case 3: System.out.println("一对一错一误");		break;
				case 4: System.out.println("一对两误");		break;
				case 5: System.out.println("三错");			break;
				case 6: System.out.println("两错一误");		break;
				case 7: System.out.println("一错两误");		break;
				case 8: System.out.println("三误");			break;
				
			}
			
			count++;
		}
	}
	
	public static boolean kick(int[] oldanswer , int a , int b , int c , int oldjudge){
		
		switch(oldjudge){
		
			case 0:	return threeright(oldanswer, a, b, c);
			case 1:	return tworightonewrong(oldanswer, a, b, c);
			case 2:	return onerighttwowrong(oldanswer, a, b, c);
			case 3:	return onerightonewrongonemiss(oldanswer, a, b, c);
			case 4:	return onerighttwomiss(oldanswer, a, b, c);
			case 5:	return threewrong(oldanswer, a, b, c);
			case 6:	return twowrongonemiss(oldanswer, a, b, c);
			case 7:	return onewrongtwomiss(oldanswer, a, b, c);
			case 8:	return threemiss(oldanswer, a, b, c);
		}
		
		return false;
	}
	
	public static int searchmax(int[] a){
		
		int max = a[0];
		int id = 0;
		
		for(int i = 1 ; i < 9 ; i++)
			if(max <= a[i]){
				max = a[i];
				id = i;
			}
		
		return id;
	}
	
	public static int judge(int[][] youranswer , int count , int[] oldjudge){
		
		int[] leaveanswer = new int[9];
		int flag;
		/**
		 * 三个答案都是正确的情况
		 */
		for(int i = 0; i < 10; i++)
			for(int j = 0; j < 10; j++)
				for(int z = 0; z < 10; z++){
					if(i != j && i != z && j !=z){
						flag = 1;
						for(int k = 0; k < count; k++){
							if(!kick(youranswer[k] , i , j , z , oldjudge[k])){
								flag = 0;
							}
						}
						if(flag == 1 && threeright(youranswer[count], i, j, z)){
				//			System.out.println(i+" "+j+" "+z);
							leaveanswer[0]++;
						}
					}
				}
		
		//System.out.println("-------------------------------");
		
		/**
		 * 两对一错
		 */
		for(int i = 0; i < 10; i++)
			for(int j = 0; j < 10; j++)
				for(int z = 0; z < 10; z++){
					if(i != j && i != z && j !=z){
						flag = 1;
						for(int k = 0; k < count; k++){
							if(!kick(youranswer[k] , i , j , z , oldjudge[k])){
								flag = 0;
							}
						}
						if(flag == 1 && tworightonewrong(youranswer[count], i, j, z)){
							leaveanswer[1]++;
					//		System.out.println(i+" "+j+" "+z);
						}
					}
				}
		
		//System.out.println("-------------------------------");
		
		for(int i = 0; i < 10; i++)
			for(int j = 0; j < 10; j++)
				for(int z = 0; z < 10; z++){
					if(i != j && i != z && j !=z){
						flag = 1;
						for(int k = 0; k < count; k++){
							if(!kick(youranswer[k] , i , j , z , oldjudge[k])){
								flag = 0;
							}
						}
						if(flag == 1 && onerighttwowrong(youranswer[count], i, j, z)){
							leaveanswer[2]++;
						//	System.out.println(i+" "+j+" "+z);
						}
					}
				}
		
		//System.out.println("-------------------------------");
		
		
		for(int i = 0; i < 10; i++)
			for(int j = 0; j < 10; j++)
				for(int z = 0; z < 10; z++){
					if(i != j && i != z && j !=z){
						flag = 1;
						for(int k = 0; k < count; k++){
							if(!kick(youranswer[k] , i , j , z , oldjudge[k])){
								flag = 0;
							}
						}
						if(flag == 1 && onerightonewrongonemiss(youranswer[count], i, j, z)){
							leaveanswer[3]++;
							//System.out.println(i+" "+j+" "+z);
						}
					}
				}
		
		//System.out.println("-------------------------------");
		
		
		for(int i = 0; i < 10; i++)
			for(int j = 0; j < 10; j++)
				for(int z = 0; z < 10; z++){
					if(i != j && i != z && j !=z){
						flag = 1;
						for(int k = 0; k < count; k++){
							if(!kick(youranswer[k] , i , j , z , oldjudge[k])){
								flag = 0;
							}
						}
						if(flag == 1 && onerighttwomiss(youranswer[count], i, j, z)){
							leaveanswer[4]++;
						//	System.out.println(i+" "+j+" "+z);
						}
					}
				}
		
		//System.out.println("-------------------------------");
		
		
		for(int i = 0; i < 10; i++)
			for(int j = 0; j < 10; j++)
				for(int z = 0; z < 10; z++){
					if(i != j && i != z && j !=z){
						flag = 1;
						for(int k = 0; k < count; k++){
							if(!kick(youranswer[k] , i , j , z , oldjudge[k])){
								flag = 0;
							}
						}
						if(flag == 1 && threewrong(youranswer[count], i, j, z)){
							leaveanswer[5]++;
						//	System.out.println(i+" "+j+" "+z);
						}
					}
				}
		
		//System.out.println("-------------------------------");
		
		for(int i = 0; i < 10; i++)
			for(int j = 0; j < 10; j++)
				for(int z = 0; z < 10; z++){
					if(i != j && i != z && j !=z){
						flag = 1;
						for(int k = 0; k < count; k++){
							if(!kick(youranswer[k] , i , j , z , oldjudge[k])){
								flag = 0;
							}
						}
						if(flag == 1 && twowrongonemiss(youranswer[count], i, j, z)){
							leaveanswer[6]++;
						//	System.out.println(i+" "+j+" "+z);
						}
					}
				}
		
		//System.out.println("-------------------------------");
		
		
		for(int i = 0; i < 10; i++)
			for(int j = 0; j < 10; j++)
				for(int z = 0; z < 10; z++){
					if(i != j && i != z && j !=z){
						flag = 1;
						for(int k = 0; k < count; k++){
							if(!kick(youranswer[k] , i , j , z , oldjudge[k])){
								flag = 0;
							}
						}
						if(flag == 1 && onewrongtwomiss(youranswer[count], i, j, z)){
							leaveanswer[7]++;
						//	System.out.println(i+" "+j+" "+z);
						}
					}
				}
		
	//	System.out.println("-------------------------------");
		
		for(int i = 0; i < 10; i++)
			for(int j = 0; j < 10; j++)
				for(int z = 0; z < 10; z++){
					if(i != j && i != z && j !=z){
						flag = 1;
						for(int k = 0; k < count; k++){
							if(!kick(youranswer[k] , i , j , z , oldjudge[k])){
								flag = 0;
							}
						}
						if(flag == 1 && threemiss(youranswer[count], i, j, z)){
							leaveanswer[8]++;
						//	System.out.println(i+" "+j+" "+z);
						}
					}
				}
		
		//System.out.println("-------------------------------");
		
		
		//for(int i = 0; i < 9; i++)
			//System.out.println(leaveanswer[i]);
		
		
		
		return searchmax(leaveanswer);
	}
	
	public static boolean threeright(int[] answer , int a , int b , int c){
		if(a == answer[0] && b == answer[1] && c == answer[2])
			return true;
		
		return false;
	}

	public static boolean tworightonewrong(int[] answer , int a , int b , int c){
		if(a == answer[0] && b == answer[1] && c != answer[2])
			return true;
		if(a == answer[0] && b != answer[1] && c == answer[2])
			return true;
		if(a != answer[0] && b == answer[1] && c == answer[2])
			return true;
		
		return false;
	}
	
	public static boolean onerighttwowrong(int[] answer , int a , int b , int c){
		if(a == answer[0] && b != answer[1] && b != answer[2] && c != answer[1] && c != answer[2])
			return true;
		if(b == answer[1] && a != answer[0] && a != answer[2] && c != answer[0] && c != answer[2])
			return true;
		if(c == answer[2] && a != answer[0] && a != answer[1] && b != answer[0] && b != answer[1])
			return true;
		
		return false;
	}
	
	public static boolean onerightonewrongonemiss(int[] answer , int a , int b , int c){
		if(a == answer[0] && b != answer[1] && b == answer[2] && c != answer[1] && c != answer[2])
			return true;
		if(b == answer[1] && a != answer[0] && a == answer[2] && c != answer[0] && c != answer[2])
			return true;
		if(c == answer[2] && b != answer[1] && b == answer[0] && a != answer[0] && a != answer[1] )
			return true;
		
		return false;
	}
	
	public static boolean onerighttwomiss(int[] answer , int a , int b , int c){
		if(a == answer[0] && b == answer[2] && c == answer[1])
			return true;
		if(b == answer[1] && a == answer[2] && c == answer[0])
			return true;
		if(c == answer[2] && a == answer[1] && b == answer[0])
			return true;
		
		return false;
	}
	
	public static boolean threewrong(int[] answer , int a , int b , int c){
		if(a != answer[0] && a != answer[1] && a != answer[2] && b != answer[0] && b != answer[1] 
				&& b != answer[2] && c != answer[0] && c != answer[1] && c != answer[2])
			return true;
		
		return false;
	}
	
	public static boolean twowrongonemiss(int[] answer , int a , int b , int c){
		if(a == answer[1] && b != answer[0] && b != answer[2] && c != answer[0] && c != answer[2])
			return true;
		if(a == answer[2] && b != answer[0] && b != answer[1] && c != answer[0] && c != answer[1])
			return true;

		if(b == answer[0] && a != answer[1] && a != answer[2] && c != answer[1] && c != answer[2])
			return true;
		if(b == answer[2] && a != answer[0] && a != answer[1] && c != answer[0] && c != answer[1])
			return true;
		
		if(c == answer[0] && a != answer[1] && a != answer[2] && b != answer[1] && b != answer[2])
			return true;
		if(c == answer[1] && a != answer[0] && a != answer[2] && b != answer[0] && b != answer[2])
			return true;
		
		return false;
	}
	
	public static boolean onewrongtwomiss(int[] answer , int a , int b , int c){
		if(a == answer[1] && b == answer[0] && c != answer[2])
			return true;
		if(a == answer[2] && b == answer[0] && c != answer[1])
			return true;
		if(a == answer[1] && b == answer[2] && c != answer[0])
			return true;
		
		if(a == answer[1] && c == answer[0] && b != answer[2])
			return true;
		if(a == answer[2] && c == answer[0] && b != answer[1])
			return true;
		if(a == answer[2] && c == answer[1] && b != answer[0])
			return true;
		
		if(b == answer[0] && c == answer[1] && a != answer[2])
			return true;
		if(b == answer[2] && c == answer[0] && a != answer[1])
			return true;
		if(b == answer[2] && c == answer[1] && a != answer[0])
			return true;
		
		return false;
	}
	
	public static boolean threemiss(int[] answer , int a , int b , int c){
		if(a == answer[1] && b == answer[2] && c == answer[1])
			return true;
		if(a == answer[2] && b == answer[0] && c == answer[1])
			return true;

		return false;
	}
}
