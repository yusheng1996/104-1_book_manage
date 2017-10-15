import java.util.Scanner;

public class Control
{
	public static Scanner sc = new Scanner(System.in);
	
	public String control_print = "111111";
	private boolean BigToSmall = true; 
	
	//顯示控制選項
	public void whichprint()
	{
		char control_code[] = control_print.toCharArray();
		String[] Sorts = {"書名","作者","出版社","編號","分類","出版年份"};
		
		System.out.println("請選擇欲修改顯示之選項");
		System.out.println("(1) 書名     (2) 作者     (3) 出版社");
		System.out.println("(4) 編號     (5) 分類     (6) 出版年份");
		
		int choose;
		for(;;) {
			choose = sc.nextInt();
			if(choose > 0 && choose < 7)
				break;
			System.out.println("輸入錯誤！請再試一次！");
		}
		
		System.out.println("是否要顯示 " + Sorts[--choose] + " ? (y/n)");
		
		char result;
		for(;;) {
			result = (char) sc.next().charAt(0);
			if(result == 'y' || result == 'n')
				break;
			System.out.println("輸入錯誤！請再試一次！");
		}
		if(result == 'y')
			control_code[choose] = '1';
		else
			control_code[choose] = '0';
		
		control_print = "";
		for(int i = 0;i < 6; i++)
				control_print += "" + control_code[i];
			
		System.out.println("設定成功！");
	}
	
	//由大到小 由小到大
	public void setBigToSmall()
	{
		System.out.println("請選擇排序方式");
		System.out.println("(1) 由大到小 (2) 由小到大");
		
		int choose;
		for(;;) {
			choose = sc.nextInt();
			if(choose == 1 || choose == 2)
				break;
			System.out.println("輸入錯誤！請再試一次！");
		}
		if(choose == 1)
			BigToSmall = true;
		else
			BigToSmall = false;
		
		System.out.println("設定成功！");
	}
	
	//回傳控制選項設定
	public String getControl_print()
	{
		return control_print;
	}
	
	//回傳排序設定
	public boolean getBigToSmall()
	{
		return BigToSmall;
	}
}