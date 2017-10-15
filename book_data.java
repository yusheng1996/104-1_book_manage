public class book_data
{
	private String _book;
	private String _artist;
	private String _public;
	private String _number;
	private String _sort;
	private int _year;
	
	//設定 book_data 值
	
	//無輸入
	public book_data()
	{
		_book = "";
		_artist = "";
		_public = "";
		_number = "";
		_sort = "";
		_year = 0;
	}
	
	//分別輸入
	public book_data(String _book, String _artist, String _public, String _number, String _sort, int _year)
	{
		setBook(_book);
		setArtist(_artist);
		setPublic(_public);
		setNumber(_number);
		setSort(_sort);
		setYear(_year);
	}
	
	//一次性輸入
	public book_data(book_data newBook_data)
	{
		_book = newBook_data._book;
		_artist = newBook_data._artist;
		_public = newBook_data._public;
		_number = newBook_data._number;
		_sort = newBook_data._sort;
		_year = newBook_data._year;
	}
	
	//set 設定
	public boolean setBook(String _book)
	{
		if(_book != null) {
			this._book = _book;
			return true;
		}
		else {
			System.out.println("輸入錯誤！");
			return false;
		}
	}
	
	public boolean setArtist(String _artist)
	{
		if(_artist != null) {
			this._artist = _artist;
			return true;
		}
		else {
			System.out.println("輸入錯誤！");
			return false;
		}
	}
	
	public boolean setPublic(String _public)
	{
		if(_public != null) {
			this._public = _public;
			return true;
		}
		else {
			System.out.println("輸入錯誤！");
			return false;
		}
	}
	
	public boolean setNumber(String _number)
	{
		char num_check[] = _number.toCharArray();
		if(num_check.length == 6 && Character.isLetter(num_check[0]) && Character.isDigit(num_check[1]) && Character.isDigit(num_check[2]) &&
			Character.isDigit(num_check[3]) && Character.isDigit(num_check[4]) && Character.isDigit(num_check[5])) {
			this._number = _number;
			return true;
		}
		else {
			System.out.println("輸入錯誤！");
			return false;
		}
	}
	
	public boolean setSort(String _sort)
	{
		if(_sort != null) {
			this._sort = _sort;
			return true;
		}
		else {
			System.out.println("輸入錯誤！");
			return false;
		}
	}
	
	public boolean setYear(int _year)
	{
		if(_year >= 1000 && _year <= 2016) {
			this._year = _year;
			return true;
		}
		else {
			System.out.println("輸入錯誤！");
			return false;
		}
	}
	
	// 回傳值
	public String getBook()
	{
		return _book;
	}
	
	public String getArtist()
	{
		return _artist;
	}
	
	public String getPublic()
	{
		return _public;
	}
	
	public String getNumber()
	{
		return _number;
	}
	
	public String getSort()
	{
		return _sort;
	}
	
	public int getYear()
	{
		return _year;
	}
}