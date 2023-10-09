package ra.bussinessImp;

import ra.bussiness.IBook;

import static ra.run.BookManagement.* ;

public class Book implements IBook {
    private static int nextId = 1 ;
    private int bookId ;
    private String bookName ;
    private String title;
    private int numberOfPages ;
    private float importPrice ;
    private float exportPrice ;
    private float interest ;
    private boolean bookStatus ;
    public Book() {
        this.bookId = nextId++ ;
    }

    public Book(int bookId, String bookName, String title, int numberOfPages, float importPrice, float exportPrice, float interest, boolean bookStatus) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.interest = interest;
        this.bookStatus = bookStatus;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Book.nextId = nextId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public boolean isBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
    }

    @Override
    public void inputData() {
        // ten sach
        while (true) {
            System.out.println("Nhập vào tên sách ");
            String name = sc.nextLine();
            if (name.trim().isEmpty()) {
                System.err.println("Ten sach khong the de rong. Vui long nhap lai ❤");
            } else {
                boolean isExist = false ;
                for (Book book : listBook) {
                    if (book.getBookName().equals(name)) {
                        System.err.println("Sach da co trong danh sach. Vui long nhap lai ");
                    } else {
                        isExist = true ;
                        break;
                    }
                }
                if (!isExist) {
                    this.bookName = name ;
                    break;
                }

            }
        }

        // tieu de
        while (true) {
            System.out.println("Nhap vao tieu de sach");
            String tieude = sc.nextLine();
            if (tieude.trim().isEmpty()) {
                System.err.println("Tieu de sach khong dc de rong. Vui long nhap lai ❤");
            } else {
                this.title = tieude;
                break;
            }
        }

        // so trang sach
       while (true) {
           System.out.println("Nhap vao so trang sach");
           int number = Integer.parseInt(sc.nextLine()) ;
           if (number <= 0 ) {
               System.err.println("So trang sach khong the nho hon 0 . Vui long nhap lai ❤");
           } else {
               this.numberOfPages = number ;
               break;
           }
       }

        // gia nhap vao
        while (true) {
            System.out.println("Gia nhap vao ");
            float priceImport = Float.parseFloat(sc.nextLine());
            if ( priceImport <= 0 ) {
                System.err.println("Gia nhap vao khong the nho hon 0 . Vui long nhap lai ❤");
            } else {
                this.importPrice = priceImport ;
                break;
            }
        }

        // gia ban ra
        while (true) {
            System.out.println("Gia ban ra ");
            float priceExport = Float.parseFloat(sc.nextLine()) ;
            if (priceExport <= this.importPrice) {
                System.err.println("Gia ban ra khong the nho hon gia nhap vao . Vui long nhap lai ❤");
            } else {
                this.exportPrice = priceExport ;
                break;
            }
        }

        while (true) {
            System.out.println("Trang thai ban hang : ( Co - Khong ) ");
            String trangthai = sc.nextLine();
            if (trangthai.equalsIgnoreCase("co")) {
                this.bookStatus = true ;
                break;
            } else if (trangthai.equalsIgnoreCase("khong")) {
                this.bookStatus = false ;
                break;
            } else {
                System.err.println("Trang thai ban hang khong dung dinh dang. Vui long nhap lai ❤");
            }
        }
        this.interest = this.exportPrice - this.importPrice ;

    }

    @Override
    public void displayData() {
        System.out.println("___________ THONG TIN SACH ____________");
        System.out.println("Id : " + bookId);
        System.out.println("Ten sach : " + bookName);
        System.out.println("Tieu de : " + title);
        System.out.println("So trang sasch : " + numberOfPages);
        System.out.println("Gia nhap vao : " + importPrice);
        System.out.println("Gia ban ra : " + exportPrice);
        System.out.println("Loi nhuan : " + interest);
        System.out.println("Trang thai ban hang : " + (bookStatus?"Co ban":"Khong ban"));

    }
}
