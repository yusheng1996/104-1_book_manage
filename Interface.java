import java.util.Scanner;

public class Interface{
	
	public static Scanner sc = new Scanner(System.in);
	public data_handle data_use = new data_handle();
	
	public static void main(String[] args) {
		Interface using = new Interface();
		using.login();
		using.read_data();
		using.main_page();
	}
	
	// 登入
	public void login()
	{
		String user = "", passwd = "";
		for(int _count = 4 ; _count >= 0 ; _count--) {
			System.out.printf("請輸入帳號：");
			user = sc.nextLine();
			System.out.printf("請輸入密碼：");
			passwd = sc.nextLine();
			
			if( user.equals("cis") && passwd.equals("1234") )
				break;
			
			else if(_count == 0) {
				System.out.println("發現惡意登入，請重新啟動程式");
				System.exit(0);
			}
							
			else
				System.out.println("帳號或密碼錯誤，請重新登入。　剩餘" + _count + "次機會");
			
		}
	}
	
	//讀檔
	public void read_data()
	{
		data_use.load_data();
	}
		
	//主頁面
	public void main_page()
	{
		for(;;) {
			System.out.println("請選擇使用介面");
			System.out.println("(1) 使用者   (2) 管理     (3)離開");
			int choose = sc.nextInt();
			if(choose == 1)
				User();
			else if(choose == 2)
				setting();
			else if(choose == 3) {
				System.out.println("即將結束程式，正在儲存資料...");
				data_use.store_data();
				System.exit(0);
			}
			else
				System.out.println("輸入錯誤，請重新輸入");
		}
	}
	
	//使用者介面
	public void User()
	{
		for(;;) {
			System.out.println("請選擇欲執行動作");
			System.out.println("(1) 顯示資料 (2) 查詢資料 (3) 新增資料 (4) 修改資料");
			System.out.println("(5) 刪除資料 (6) 儲存資料 (7) 回上一頁");
			int choose = sc.nextInt();
			if(choose == 1)
				display_data();
			else if(choose == 2)
				data_use.searchBook();
			else if(choose == 3) 
				data_use.addData();
			else if(choose == 4)
				data_use.modData();
			else if(choose == 5)
				data_use.delData();
			else if(choose == 6)
				data_use.store_data();
			else if(choose == 7)
				main_page();
			else
				System.out.println("輸入錯誤，請重新輸入");
		}
	}
	
	//管理介面
	public void setting()
	{
		for(;;) {
			System.out.println("請選擇欲執行動作");
			System.out.println("(1) 設定排序方式   (2) 控制顯示");
			System.out.println("(3) 資料重整並儲存 (4) 回上一頁");
			int choose = sc.nextInt();
			if(choose == 1)
				data_use.setBigToSmall();
			else if(choose == 2)
				data_use.whichprint();
			else if(choose == 3) 
				restore_data();
			else if(choose == 4)
				main_page();
			else
				System.out.println("輸入錯誤，請重新輸入");
		}
	}
	
	//顯示資料選單
	public void display_data()
	{
		for(;;) {
			System.out.println("請選擇欲執行動作");
			System.out.println("(1) 顯示全部資料 (2) 查詢分類顯示 (3) 回上一頁");
			int choose = sc.nextInt();
			if(choose == 1) {
				data_use.display_all_rep();
				data_use.display_all_nor();
				User();
			}
			else if(choose == 2) {
				data_use.display_all_rep();
				data_use.display_all_prt();
				User();
			}
			else if(choose == 3) 
				User();
			else
				System.out.println("輸入錯誤，請重新輸入");
		}
	}
	
	//資料重整並儲存
	public void restore_data()
	{
		data_use.display_all_rep();
		data_use.store_data();
	}
}