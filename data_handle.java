import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class data_handle extends Control{
	
	public ArrayList<book_data> data = new ArrayList<book_data>();
	public static Scanner sc = new Scanner(System.in);
	
	//讀入資料
	public void load_data()
	{
		Scanner inputStream = null;
		try
		{
			inputStream = new Scanner(new FileInputStream("data.txt"));
		}
		catch (FileNotFoundException e)
		{
			System.out.println("File data.txt was not found.");
			System.out.println("or could not be opened.");
			System.exit(0);
		}
		
		while( inputStream.hasNext() ) {
			String _book     = inputStream.next();
			String _artist   = inputStream.next();
			String _public_co= inputStream.next();
			String _number   = inputStream.next();
			String _sort     = inputStream.next();
			int _year         = inputStream.nextInt();
			book_data temp   = new book_data(_book, _artist, _public_co, _number, _sort, _year);
			data.add(temp);
		}
		inputStream.close();
	}
	
	//儲存資料
	public void store_data()
	{
		PrintWriter outputStream = null;
		try
		{
			outputStream = new PrintWriter(new FileOutputStream("data.txt"));
		}
		catch (FileNotFoundException e)
		{
			System.out.println("File data.txt was not found.");
			System.out.println("or could not be opened.");
			System.exit(0);
		}
		
		book_data load_arraylist;
		
		for(int i = 0; i < data.size(); i++){
			load_arraylist = data.get(i);
			outputStream.printf("%-20s\t", load_arraylist.getBook());
			outputStream.printf("%-15s\t", load_arraylist.getArtist());
			outputStream.printf("%-12s\t", load_arraylist.getPublic());
			outputStream.printf("%6s\t", load_arraylist.getNumber());
			outputStream.printf("%-15s\t", load_arraylist.getSort());
			outputStream.printf("%4d", load_arraylist.getYear());
			outputStream.println();
		}
		
		outputStream.close();
	}
	
	//新增資料
	public void addData()
	{
		book_data add = new book_data();
		boolean check = false;
		
		System.out.printf("請輸入書名：");
		do {
			check = add.setBook(sc.next());
		}while(!check);
		
		System.out.printf("請輸入作者：");
		do {
			check = add.setArtist(sc.next());
		}while(!check);
		
		System.out.printf("請輸入出版社：");
		do {
			check = add.setPublic(sc.next());
		}while(!check);
		
		System.out.printf("請輸入編號：");
		do {
			check = add.setNumber(sc.next());
		}while(!check);
		
		System.out.printf("請輸入分類：");
		do {
			check = add.setSort(sc.next());
		}while(!check);
		
		System.out.printf("請輸入年分：");
		do {
			check = add.setYear(sc.nextInt());
		}while(!check);
		
		data.add(add);
		System.out.println("新增成功！");
	}

	//修改資料
	public void modData()
	{
		int modify_line;
		do {
			System.out.println("請輸入欲修改之資料行數，可輸入0觀看全部資料");
			modify_line = sc.nextInt();
			while(modify_line < 0 || modify_line > data.size()) {
				System.out.println("輸入數有誤，請重新輸入");
				modify_line = sc.nextInt();
			}
		
			if(modify_line == 0)
				display_all_nor();
		} while(modify_line == 0);
		book_data new_data = new book_data(data.get(modify_line-1));
		for(;;) {
			System.out.println("選擇要修改的欄位");
			System.out.println("(1) 書名     (2) 作者     (3) 出版社     (4) 編號");
			System.out.println("(5) 分類     (6) 出版年份 (7) 結束修改");
			
			boolean check;
			int choose;
			for(;;) {
				choose = sc.nextInt();
				if(choose > 0 && choose < 8)
					break;
				System.out.println("輸入錯誤！請再試一次！");
			}
			
			if(choose == 7)
				break;
			
			if(choose == 1) {
				do {
					System.out.println("輸入新書名：");
					check = new_data.setBook(sc.next());
				} while(!check);
			}
		
			if(choose == 2) {
				do {
					System.out.println("輸入新作者名：");
					check = new_data.setArtist(sc.next());
				} while(!check);
			}
		
			if(choose == 3) {
				do {
					System.out.println("輸入新出版社：");
					check = new_data.setPublic(sc.next());
				} while(!check);
			}
		
			if(choose == 4) {
				do {
					System.out.println("輸入新編號：");
					check = new_data.setNumber(sc.next());
				} while(!check);
			}
		
			if(choose == 5) {
				do {
					System.out.println("輸入新分類：");
					check = new_data.setSort(sc.next());
				} while(!check);
			}
		
			if(choose == 6) {
				do {
					System.out.println("輸入新年份：");
					check = new_data.setYear(sc.nextInt());
				} while(!check);
			}
		}
		
		System.out.println("舊資料為：");
		print_title();
		System.out.printf("       ");
		print_data(data.get(modify_line-1));
		System.out.println("新資料為：");
		System.out.printf("       ");
		print_data(new_data);
		
		System.out.println("\n確認修改? (y/n)");
		char dm;
		for(;;) {
				dm = (char) sc.next().charAt(0);;
				if(dm == 'y' || dm == 'n')
					break;
				System.out.println("輸入錯誤！請再試一次！");
			}
			
		if(dm == 'y') {
			data.set(modify_line-1, new_data);
			System.out.println("修改成功！");
		}
		else
			System.out.println("取消修改！");
	}
	
	//刪除資料
	public void delData()
	{
		int delete_line;
		do {
			System.out.println("請輸入欲修改之資料行數，可輸入0觀看全部資料");
			delete_line = sc.nextInt();
			while(delete_line < 0 || delete_line > data.size()) {
				System.out.println("輸入數有誤，請重新輸入");
				delete_line = sc.nextInt();
			}
		
			if(delete_line == 0)
				display_all_nor();
		} while(delete_line == 0);
		
		System.out.println("您欲刪除之資料如下");
		print_title();
		System.out.printf("       ");
		print_data(data.get(delete_line-1));
		
		System.out.println("確定刪除? (y/n)");
		char dm;
		for(;;) {
				dm = (char) sc.next().charAt(0);;
				if(dm == 'y' || dm == 'n')
					break;
				System.out.println("輸入錯誤！請再試一次！");
			}
			
		if(dm == 'y') {
			data.remove(delete_line-1);
			System.out.println("刪除成功！");
		}
		else
			System.out.println("取消刪除！");
	}
	
	//顯示一行資料
	public void print_data(book_data print)
	{
		char control_code[] = getControl_print().toCharArray();
		if(control_code[0] == '1')
			System.out.printf("%-20s\t", print.getBook());
		if(control_code[1] == '1')
			System.out.printf("%-15s\t", print.getArtist());
		if(control_code[2] == '1')
			System.out.printf("%-12s\t", print.getPublic());
		if(control_code[3] == '1')
			System.out.printf("%6s\t", print.getNumber());
		if(control_code[4] == '1')
			System.out.printf("%-15s\t", print.getSort());
		if(control_code[5] == '1')
			System.out.printf("%4d", print.getYear());
		System.out.println();
	}
	
	//顯示抬頭
	public void print_title()
	{
		char control_code[] = getControl_print().toCharArray();
		System.out.printf("行數   ");
		if(control_code[0] == '1')
			System.out.printf("書籍名稱            \t");
		if(control_code[1] == '1')
			System.out.printf("作者           \t");
		if(control_code[2] == '1')
			System.out.printf("出版社      \t");
		if(control_code[3] == '1')
			System.out.printf("編號  \t");
		if(control_code[4] == '1')
			System.out.printf("分類           \t");
		if(control_code[5] == '1')
			System.out.printf("年份");
		System.out.println("\n");
	}
	
	//顯示全部資料
	public void display_all_nor()
	{
		book_data _display = new book_data();
		print_title();
		for(int i = 0; i < data.size(); i++) {
			_display = data.get(i);
			System.out.printf("%-7d", i+1);
			print_data(_display);
		}
	}
	
	//顯示某一分類的所有資料
	public void display_all_prt()
	{
		System.out.println("(1) 以作者查詢其創作的全部書籍");
		System.out.println("(2) 以出版社查詢其出版的全部書籍");
		System.out.println("(3) 以分類查詢隸屬於該分類的全部書籍");
		System.out.println("(4) 查詢某一年份的所有書籍");
		
		int choose;
		for(;;) {
			choose = sc.nextInt();
			if(choose > 0 && choose < 5)
				break;
			System.out.println("輸入錯誤！請再試一次！");
		}
		
		book_data _display = new book_data();
		
		if(choose == 1) {
			System.out.printf("輸入作者：");
			String search = sc.next();
			int _count = 1;
			print_title();
			for(int i = 0; i < data.size(); i++) {
				_display = data.get(i);
				if(search.equals((_display.getArtist())) ) {
					System.out.printf("%-7d", _count++);
					print_data(_display);
				}
			}
		}
		
		if(choose == 2) {
			System.out.printf("輸入出版社：");
			String search = sc.next();
			int _count = 1;
			print_title();
			for(int i = 0; i < data.size(); i++) {
				_display = data.get(i);
				if(search.equals((_display.getPublic())) ) {
					System.out.printf("%-7d", _count++);
					print_data(_display);
				}
			}
		}
		
		if(choose == 3) {
			System.out.printf("輸入分類：");
			String search = sc.next();
			int _count = 1;
			print_title();
			for(int i = 0; i < data.size(); i++) {
				_display = data.get(i);
				if(search.equals((_display.getSort())) ) {
					System.out.printf("%-7d", _count++);
					print_data(_display);
				}
			}
		}
		
		if(choose == 4) {
			System.out.printf("輸入年份：");
			int search = sc.nextInt();
			int _count = 1;
			print_title();
			for(int i = 0; i < data.size(); i++) {
				_display = data.get(i);
				if(search == _display.getYear() ) {
					System.out.printf("%-7d", _count++);
					print_data(_display);
				}
			}
		}
	}
	
	//查詢書名 或 編號
	public void searchBook()
	{
		System.out.println("想查詢甚麼? (1) 書名 (2) 編號");
		int choose = sc.nextInt();
		int i;
		while(choose != 1 && choose != 2) {
			System.out.println("輸入錯誤！請再試一次！");
			choose = sc.nextInt();
		}
		
		if(choose == 1) {
			System.out.printf("請輸入書名：");
			String search = sc.next();
			book_data search_result = new book_data();

			
			for(i = 0; i < data.size(); i++) {
				search_result = data.get(i);
				if(search.equals(search_result.getBook()) ) {
					i = -1;
					break;
				}
			}
			
			if(i == -1) {
				System.out.println("搜尋結果：");
				print_title();
				System.out.printf("       ");
				print_data(search_result);
			}
			
			else
				System.out.println("找不到結果");
		}
		
		else {
			System.out.printf("請輸入編號：");
			String search = sc.next();
			book_data search_result = new book_data();
			
			for(i = 0; i < data.size(); i++) {
				search_result = data.get(i);
				if(search.equals(search_result.getNumber()) ) {
					i = -1;
					break;
				}
			}
			
			if(i == -1) {
				System.out.println("搜尋結果：");
				print_title();
				System.out.printf("       ");
				print_data(search_result);
			}
			
			else
				System.out.println("找不到結果");
		}
	}

	//選擇排序類別 (control)
	public void rearrange_small(int choose)
	{
		if(choose == 1)
			Collections.sort(data,
			new Comparator<book_data>() {
				public int compare(book_data o1, book_data o2) {
					return o1.getBook().compareTo(o2.getBook());
				}
			});
		else if(choose == 2)
			Collections.sort(data,
			new Comparator<book_data>() {
				public int compare(book_data o1, book_data o2) {
					return o1.getArtist().compareTo(o2.getArtist());
				}
			});
		else if(choose == 3)
			Collections.sort(data,
			new Comparator<book_data>() {
				public int compare(book_data o1, book_data o2) {
					return o1.getPublic().compareTo(o2.getPublic());
				}
			});
		else if(choose == 4)
			Collections.sort(data,
			new Comparator<book_data>() {
				public int compare(book_data o1, book_data o2) {
					return o1.getNumber().compareTo(o2.getNumber());
				}
			});
		else if(choose == 5)
			Collections.sort(data,
			new Comparator<book_data>() {
				public int compare(book_data o1, book_data o2) {
					return o1.getSort().compareTo(o2.getSort());
				}
			});
		else if(choose == 6) {
				Collections.sort(data,
				new Comparator<book_data>() {
					public int compare(book_data o1, book_data o2) {
						return o2.getYear() - o1.getYear();
					}
				});
				Collections.reverse(data);
		}
		else
			System.out.println("輸入錯誤！");
	}
	
	public void rearrange_large(int choose)
	{
		rearrange_small(choose);
		Collections.reverse(data);
	}

	//排列資料
	public void display_all_rep()
	{
		System.out.println("請選擇欄位用以排序");
		System.out.println("(1) 書名     (2) 作者     (3) 出版社");
		System.out.println("(4) 編號     (5) 分類     (6) 出版年份");
		
		int choose;
		for(;;) {
			choose = sc.nextInt();
			if(choose > 0 && choose < 7)
				break;
			else
				System.out.println("輸入錯誤！請再試一次！");
		}
		
		boolean BigToSmall = getBigToSmall();
		if(BigToSmall)
			rearrange_large(choose);
		else
			rearrange_small(choose);
	}
}